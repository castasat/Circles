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
}
