package com.openyogaland.denis.circles;

// parent for MainCircle and EnemyCircle
class SimpleCircle
{
  // fields of the circle
  protected int x;
  protected int y;
  protected int radius;
  
  // constructor
  SimpleCircle(int x, int y, int radius)
  {
    this.x = x;
    this.y = y;
    this.radius = radius;
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
