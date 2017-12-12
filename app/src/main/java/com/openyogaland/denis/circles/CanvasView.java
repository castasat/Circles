package com.openyogaland.denis.circles;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

// This class is a View on which we can draw something
public class CanvasView extends View
{
  // fields
  private GameManager gameManager; // логика игры
  
  // constructor
  public CanvasView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    gameManager = new GameManager();
  }
  
  // method onDraw()
  @Override
  protected void onDraw(Canvas canvas)
  {
    super.onDraw(canvas);
    gameManager.onDraw(canvas);
  }
}
