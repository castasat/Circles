package com.openyogaland.denis.circles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

// This class represents the game logic
class GameManager
{
  // fields
  private MainCircle mainCircle;   // главный круг, которым мы управляем
  private Paint      paint;             // "кисточка" для рисования
  
  // constructor
  GameManager()
  {
    initMainCircle();
    initPaint();
  }
  
  // инициализируем "кисточку"
  private void initPaint()
  {
    paint = new Paint();
    paint.setAntiAlias(true);   // сглаживание
    paint.setStyle(Style.FILL); // заливка
  }
  
  // инициализируем главный круг, которым мы управляем
  private void initMainCircle()
  {
    mainCircle = new MainCircle(200, 500);
  }
  
  void onDraw(Canvas canvas)
  {
    canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
  }
}
