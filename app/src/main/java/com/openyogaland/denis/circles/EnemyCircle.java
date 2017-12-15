package com.openyogaland.denis.circles;


import java.util.Random;

public class EnemyCircle extends SimpleCircle
{
  // constants
  private static final int MIN_RADIUS = 10;
  private static final int MAX_RADIUS = 110;
  
  EnemyCircle(int x, int y, int radius)
  {
    super(x, y, radius);
  }
  
  public static EnemyCircle getRandomCircle()
  {
    Random random = new Random();
    int    x      = random.nextInt(GameManager.getWidth());
    int    y      = random.nextInt(GameManager.getHeight());
    int    radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS);
    return (new EnemyCircle(x, y, radius));
  }
}
