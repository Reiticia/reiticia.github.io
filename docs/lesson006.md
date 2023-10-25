---
lang: zh-CN
title: Screen类
---

# Screen类

* 获取全部屏幕宽高和坐标
  
    ```java
    Rectangle2D rec = screen.getBounds();  
    System.out.println("left up x: " + rec.getMinX());  
    System.out.println("left up y: " + rec.getMinY());  
    System.out.println("right down x: " + rec.getMaxX());  
    System.out.println("right down y: " + rec.getMaxY());  
    System.out.println("width: " + rec.getWidth());  
    System.out.println("height: " + rec.getHeight());
    ```
  
    > left up x: 0.0  
    > left up y: 0.0  
    > right down x: 1920.0  
    > right down y: 1080.0  
    > width: 1920.0  
    > height: 1080.0  

* 获取可以看到屏幕宽高和坐标
  
    ```java
    Rectangle2D rec2 = screen.getVisualBounds();  
    System.out.println("left up x: " + rec2.getMinX());  
    System.out.println("left up y: " + rec2.getMinY());  
    System.out.println("right down x: " + rec2.getMaxX());  
    System.out.println("right down y: " + rec2.getMaxY());  
    System.out.println("width: " + rec2.getWidth());  
    System.out.println("height: " + rec2.getHeight());
    ```
      
    > left up x: 0.0  
    > left up y: 0.0  
    > right down x: 1920.0  
    > right down y: 1042.0  
    > width: 1920.0  
    > height: 1042.0  

* 获取屏幕dpi`screen.getDpi();`
