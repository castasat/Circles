package com.openyogaland.denis.circles;

// Interface to work from GameManager with
public interface ICanvasView
{
  void drawCircle(SimpleCircle circle);
  
  void redraw();
  
  void showMessage(String text); 
}
