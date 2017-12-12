package com.openyogaland.denis.circles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

// This class represents the game logic
class GameManager
{
  // fields
  private MainCircle mainCircle;   // главный круг, которым мы управляем
  private CanvasView canvasView;   // холст, на котором "рисуем"
  private static int width;        // ширина экрана
  private static int height;       // высота экрана
  private Paint      paint;        // "кисточка" для рисования
  
  // constructor
  GameManager(CanvasView canvasView, int w, int h)
  {
    this.canvasView = canvasView;
    width = w;  // без this, поскольку переменная статическая
    height = h; // без this, поскольку переменная статическая
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
    mainCircle = new MainCircle(width/2, height/2);
  }
  
  void onDraw(Canvas canvas)
  {
    canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
  }
}
