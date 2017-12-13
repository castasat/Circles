package com.openyogaland.denis.circles;

// This class represents the main circle, which we can play with
class MainCircle extends SimpleCircle
{
  // constants
  private static final int INIT_RADIUS = 50;
  private static final int MAIN_SPEED  = 50;

  // constructor
  MainCircle(int x, int y)
  {
    super(x, y, INIT_RADIUS);
  }
  
  // Moving MainCircle at target coordinates
  void moveAt(int moveX, int moveY)
  {
    // чем дальше касаемся от кружка, тем быстрее он перемещается
    int dx = (moveX - x) * MAIN_SPEED / GameManager.getWidth();
    int dy = (moveY - y) * MAIN_SPEED / GameManager.getHeight();
    x += dx;
    y += dy;
  }
}