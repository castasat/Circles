package com.openyogaland.denis.circles;

// parent for MainCircle and EnemyCircle
class SimpleCircle
{
  // fields of the circle
  int x;
  int y;
  int radius;
  private int color;
  
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
  
  // getter getColor()
  public int getColor()
  {
    return color;
  }
  
  // setter setColor()
  public void setColor(int color)
  {
    this.color = color;
  }
  
  // This methods returns a bigger circle area around this circle
  SimpleCircle getCircleArea()
  {
    return new SimpleCircle(x, y, radius *3);
  }
  
  // Checks if this circle isIntersecting with the circle in parameter
  boolean isIntersecting(SimpleCircle circle)
  {
    return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
  }
}
