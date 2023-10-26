---
lang: zh-CN
title: Animation AnimationTimer动画计时器
---


# Animation AnimationTimer动画计时器

* 创建动画计时器
  
  ```java
  AnimationTimer timer = new AnimationTimer() {  
      int i = 0;  
      /**  
     * @param now 当前动画时间，单位：纳秒  
     */  
      @Override  
      public void handle(long now) {  
          Duration duration = new Duration(now / 1000 / 1000);  
          System.out.println(duration.toSeconds());  
          System.out.println(Thread.currentThread().getName());  
          System.out.println("i = " + i++);  
          rectangle.setRotate(rectangle.getRotate() + 1);  
      }  
  };
  ```
  
* 创建动画
  
  ```java
  TranslateTransition tt = new TranslateTransition();  
  tt.setDuration(Duration.seconds(1));  
  tt.setNode(rectangle);  
  tt.setByX(400);  
  tt.setOnFinished(event -> {  
      timer.stop();  
  });
  ```
  
* 播放动画和启动计时器
  
  ```java
  play.setOnAction(event -> {  
      tt.play();  
      timer.start();  
  });
  ```
  

![](../assets/VeryCapture_20220620094033.gif)