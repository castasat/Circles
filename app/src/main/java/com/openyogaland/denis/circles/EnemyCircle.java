package com.openyogaland.denis.circles;

import android.graphics.Color;
import java.util.Random;

class EnemyCircle extends SimpleCircle
{
  // constants
  private static final int MIN_RADIUS         = 10;
  private static final int MAX_RADIUS         = 110;
  private static final int ENEMY_CIRCLE_COLOR = Color.RED;
  private static final int FOOD_CIRCLE_COLOR  = Color.GREEN;
  
  private EnemyCircle(int x, int y, int radius)
  {
    super(x, y, radius);
  }
  
  static EnemyCircle getRandomCircle()
  {
    Random random = new Random();
    int    x      = random.nextInt(GameManager.getWidth());
    int    y      = random.nextInt(GameManager.getHeight());
    int    radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS);
    return (new EnemyCircle(x, y, radius));
  }
  
  // Если радиус данного круга меньше радиуса MainCircle
  void setEnemyOrFoodColorDependsOn(int mainCircleRadius)
  {
    if(radius < mainCircleRadius)
    {
      setColor(FOOD_CIRCLE_COLOR);  // Food color
    }
    else
    {
      setColor(ENEMY_CIRCLE_COLOR); // Enemy color
    }
  }
}
