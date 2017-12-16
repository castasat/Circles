package com.openyogaland.denis.circles;

import android.graphics.Color;
import java.util.Random;

class EnemyCircle extends SimpleCircle
{
  // constants
  private static final int MIN_RADIUS         = 10;
  private static final int MAX_RADIUS         = 110;
  private static final int MAX_RANDOM_SPEED   = 5;
  private static final int ENEMY_CIRCLE_COLOR = Color.RED;
  private static final int FOOD_CIRCLE_COLOR  = Color.GREEN;
  
  // fields
  private int dx; // смещение по оси X
  private int dy; // смещение по оси Y
  
  private EnemyCircle(int x, int y, int radius, int dx, int dy)
  {
    super(x, y, radius);
    this.dx = dx;
    this.dy = dy;
  }
  
  static EnemyCircle getRandomCircle()
  {
    Random random = new Random();
    int    x      = random.nextInt(GameManager.getWidth());
    int    y      = random.nextInt(GameManager.getHeight());
    int    dx     = random.nextInt(MAX_RANDOM_SPEED * 2) - MAX_RANDOM_SPEED; // random direction
    int    dy     = random.nextInt(MAX_RANDOM_SPEED * 2) - MAX_RANDOM_SPEED; // random direction
    int    radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS);
    return (new EnemyCircle(x, y, radius, dx, dy));
  }
  
  // Если радиус данного круга меньше радиуса переданного круга
  void setEnemyOrFoodColorDependsOn(SimpleCircle circle)
  {
    if(isSmallerThan(circle))
    {
      setColor(FOOD_CIRCLE_COLOR);  // Food color
    }
    else
    {
      setColor(ENEMY_CIRCLE_COLOR); // Enemy color
    }
  }
  
  // возвращает true, если наш круг меньше, чем заданный круг
  boolean isSmallerThan(SimpleCircle circle)
  {
    return radius < circle.radius;
  }
  
  // перемещение кругов на один шаг
  void moveOneStep()
  {
    x += dx;
    y += dy;
    checkBounds();
  }
  
  // проверка границ с учетом радиуса круга
  private void checkBounds()
  {
    if (x + radius > GameManager.getWidth() || x - radius < 0)
    {
      dx = - dx;
    }
    if (y + radius > GameManager.getHeight() || y - radius < 0)
    {
      dy = - dy;
    }
  }
}
