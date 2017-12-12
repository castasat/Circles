package com.openyogaland.denis.circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

// This class is a View on which we can draw something
public class CanvasView extends View
{
  // fields
  private static int width;        // ширина экрана
  private static int height;       // высота экрана
  private GameManager gameManager; // логика игры
  
  // constructor
  public CanvasView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    initWidthAndHeight(context);
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
  
  // method onDraw()
  @Override
  protected void onDraw(Canvas canvas)
  {
    super.onDraw(canvas);
    gameManager.onDraw(canvas);
  }
}
