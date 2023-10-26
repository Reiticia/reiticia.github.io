---
lang: zh-CN
title: Slider进度条
---


# Slider进度条

* 创建进度条
  
  ```java
  // 最小值，最大值，初始值
  Slider slider = new Slider(0, 100, 50);
  ```

* 设置宽度==水平进度条使用==`slider.setPrefWidth(500);`

* 设置高度==垂直进度条使用==`slider.setPrefHeight(500);`

* 设置位置
  
  ```java
  slider.setLayoutX(150.0);  
  slider.setLayoutY(150.0);
  ```

* 显示刻度`slider.setShowTickMarks(true);`

* 显示刻度标签`slider.setShowTickLabels(true);`

* 主刻度间隔`slider.setMajorTickUnit(10);`

* 设置初始值`slider.setValue(0);`

* 设置方向（垂直）`slider.setOrientation(Orientation.VERTICAL);`

* 鼠标点击事件（没有单击事件的组件可以通过使用鼠标点击事件来监听）
  
  ```java
  slider.setOnMouseClicked(event -> {  
      if (event.getClickCount() == 1) {  
          System.out.println("once click");  
      }  
  });
  ```

* 刻度文字修改
  
  ```java
  slider.setLabelFormatter(new StringConverter<Double>() {  
      // 用于修改间距刻度标签的显示  
      @Override  
      public String toString(Double object) {  
          if (object == 0) {  
              return "0";  
          } else if (object == 100) {  
              return "100";  
          } else {  
              return "未知";  
          }  
      }  
      @Override  
      public Double fromString(String string) {  
          return null;  
      }  
  });
  ```

* 监听值的变化
  
  ```java
  slider.valueProperty().addListener((observable, oldValue, newValue) -> {  
      System.err.println("newValue = " + newValue);  
  });
  ```

* 监听值是否变化（如果使用键盘改变则不会触发）
  
  ```java
  slider.valueChangingProperty().addListener((observable, oldValue, newValue) -> {  
      System.out.println("newValue = " + newValue);  
  });
  ```

* 使进度条自动增加的几种方法
  
  1. 开启一个线程，修改属性值value（不推荐）
    
     ```java
     new Thread(() -> {  
         for (; ; ) {  
             Platform.runLater(() -> {  
                 if (slider.getValue() != 100) {  
                     slider.setValue(slider.getValue() + 1);  
                     System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());  
                 }  
             });  
             try {  
                 Thread.sleep(100);  
             } catch (InterruptedException e) {  
                 e.printStackTrace();  
             }  
             if (slider.getValue() == 100) {  
                 System.out.println("播放完毕");  
                 break;  
             }  
         }  
     }).start();
     ```
  
  2. 使用多任务修改
    
     ```java
     // 1. 创建自定义多任务类
     class My extends ScheduledService<Integer> {  
         int i = 0;  
         Slider slider;  
     
         public My(Slider slider) {  
             this.slider = slider;  
         }  
     
         @Override  
         protected Task<Integer> createTask() {  
             return new Task<Integer>() {  
                 @Override  
                 protected Integer call() throws Exception {  
                     return ++i;  
                 }  
                 @Override  
                 protected void updateValue(Integer value) {  
                     super.updateValue(value);  
                     slider.setValue(value);  
                 }  
             };  
         }  
     }
     // 2. 创建多任务
     My my = new My(slider);  
     my.setDelay(Duration.millis(0));  
     my.setPeriod(Duration.seconds(1));  
     my.start();
     // 3. 或者不在多任务内更新value，而在监听属性中更新value
     my.valueProperty().addListener((observable, oldValue, newValue) -> {  
         System.out.println("newValue = " + newValue);  
         System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());  
         if (newValue != null) {  
             slider.setValue(newValue);  
         }  
     });
     ```

![](../assets/VeryCapture_20220520095004.gif)