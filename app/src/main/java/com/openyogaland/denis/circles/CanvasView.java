package com.openyogaland.denis.circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

// This class is a View on which we can draw something
public class CanvasView extends View implements ICanvasView
{
  // fields
  private static int  width;        // ширина экрана
  private static int  height;       // высота экрана
  private GameManager gameManager;  // логика игры
  private Paint       paint;        // "кисточка" для рисования
  private Canvas      canvas;       // "холст" для рисования
  
  // constructor
  public CanvasView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    initWidthAndHeight(context);
    initPaint(); // инициализируем "кисточку"
    gameManager = new GameManager(this, width, height);
  }
  
  private void initWidthAndHeight(Context context)
  {
    WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    if (windowManager != null)
    {
      Display display = windowManager.getDefaultDisplay();
      Point point = new Point();
      display.getSize(point); // точка приобретает координаты правой нижней точки экрана
      width = point.x;
      height = point.y;
    }
  }
  
  // инициализируем "кисточку"
  private void initPaint()
  {
    paint = new Paint();
    paint.setAntiAlias(true);   // сглаживание
    paint.setStyle(Style.FILL); // заливка
  }
  
  // method onDraw()
  @Override
  protected void onDraw(Canvas canvas)
  {
    super.onDraw(canvas);
    this.canvas = canvas;
    gameManager.onDraw();
  }
  
  // Метод интерфейса ICanvasView
  @Override
  public void drawCircle(SimpleCircle circle)
  {
    paint.setColor(circle.getColor());
    canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
  }
  
  // Метод для обработки прикосновения к экрану
  @Override
  public boolean onTouchEvent(MotionEvent motionEvent)
  {
    // получаем координаты касания
    int x = (int) motionEvent.getX();
    int y = (int) motionEvent.getY();
    
    if(motionEvent.getAction() == MotionEvent.ACTION_MOVE)
    {
      gameManager.onTouchEvent(x, y);
      invalidate(); // нужно, чтобы у объекта View обновилось положение
    }
    return true;
  }
}
