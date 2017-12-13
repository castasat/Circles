package com.openyogaland.denis.circles;

// This class represents the game logic
class GameManager
{
  // fields
  private MainCircle mainCircle;   // главный круг, которым мы управляем
  private CanvasView canvasView;   // View, на котором "рисуем"
  private static int width;        // ширина экрана
  private static int height;       // высота экрана
  
  // constructor
  GameManager(CanvasView canvasView, int w, int h)
  {
    this.canvasView = canvasView;
    width = w;  // без this, поскольку переменная статическая
    height = h; // без this, поскольку переменная статическая
    initMainCircle();
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
  
  // This method draws game scene on CanvasView
  void onDraw()
  {
    canvasView.drawCircle(mainCircle);
  }
  
  // Если было касание к экрану и перемещение
  void onTouchEvent(int x, int y)
  {
    mainCircle.moveAt(x, y);
  }
}
