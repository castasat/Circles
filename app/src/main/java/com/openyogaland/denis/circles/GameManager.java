package com.openyogaland.denis.circles;

import java.util.ArrayList;
import java.util.Iterator;

// This class represents the game logic
class GameManager
{
  // constants
  private static final int       MAX_CIRCLES_NUMBER = 10;
  
  // fields
  private MainCircle             mainCircle; // главный круг, которым мы управляем
  private ArrayList<EnemyCircle> circles;    // коллекция вражеских кругов
  private CanvasView             canvasView; // View, на котором "рисуем"
  private static int             width;      // ширина экрана
  private static int             height;     // высота экрана
  
  // constructor
  GameManager(CanvasView canvasView, int w, int h)
  {
    this.canvasView = canvasView;
    width = w;  // без this, поскольку переменная статическая
    height = h; // без this, поскольку переменная статическая
    initMainCircle();
    initEnemyCircles();
  }
  
  // getter
  static int getWidth()
  {
    return width;
  }
  
  // getter
  static int getHeight()
  {
    return height;
  }
  
  // инициализируем главный круг, которым мы управляем
  private void initMainCircle()
  {
    mainCircle = new MainCircle(width/2, height/2);
  }
  
  // инициализируем коллекцию вражеских кругов
  private void initEnemyCircles()
  {
    circles = new ArrayList<EnemyCircle>();
    for(int i = 0; i < MAX_CIRCLES_NUMBER; i++)
    {
      circles.add(EnemyCircle.getRandomCircle());
    }
  }
  
  // This method draws game scene on CanvasView
  void onDraw()
  {
    canvasView.drawCircle(mainCircle);
    for (EnemyCircle circle : circles)
    {
      canvasView.drawCircle(circle);
    }
  }
  
  // Если было касание к экрану и перемещение
  void onTouchEvent(int x, int y)
  {
    mainCircle.moveAt(x, y);
  }
}
