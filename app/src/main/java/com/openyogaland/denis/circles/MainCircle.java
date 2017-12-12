package com.openyogaland.denis.circles;

// This class represents the main circle, which we can play with
class MainCircle
{
  // constants
  private static final int INIT_RADIUS = 50;
  
  // fields of the circle
  private int x;
  private int y;
  private int radius;

  // constructor
  MainCircle(int x, int y)
  {
    this.x = x;
    this.y = y;
    this.radius = INIT_RADIUS;
  }
  
  // getter getX()
  int getX()
  
  {
    return x;
  }
  
  // getter getY()
  int getY()
  {
    return y;
  }
  
  // getter getRadius()
  int getRadius()
  {
    return radius;
  }
}