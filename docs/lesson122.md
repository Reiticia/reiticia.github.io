### Translate位移

* 创建位移量`Translate translate = new Translate(100, 100);`
* xy位移取相反数`translate.createInverse()`
* 在该位移基础上再位移，转换为point2D
  
  ```java
  Point2D point2D = translate.transform(50, 50);  
  System.out.printf("point2D(%.2f,%.2f)\n", point2D.getX(), point2D.getY());
  ```
  
  > point2D(150.00,150.00)
* 通过传入的数据，直接转换为point2D
  
  ```java
  Point2D point2D1 = translate.deltaTransform(100, 100);  
  System.out.printf("point2D1(%.2f,%.2f)\n", point2D1.getX(), point2D1.getY());
  ```
  
  > point2D1(100.00,100.00)
* 位移会叠加，位移原点(LayoutX,LayoutY)
  
  ```java
  button2.getTransforms().addAll(translate, translate1);
  ```
* 获取偏移量
  
  ```java
  button2.setOnAction(event -> {  
      // 获取组件相对与父组件的位移量，输出的结果是变换后的
      System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());  
      // 获取组件相对与场景的位移量  
      System.out.printf("相对于场景的坐标：(%.2f,%.2f)\n", button2.getLocalToSceneTransform().getTx(), button2.getLocalToSceneTransform().getTy());  
      Bounds bounds = button2.getLayoutBounds();  
      Bounds localToParent = button2.localToParent(bounds);  
      System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", localToParent.getMinX(), localToParent.getMinY());  
      Bounds localToScreen = button2.localToScreen(bounds);  
      System.out.printf("相对于屏幕的坐标：(%.2f,%.2f)\n", localToScreen.getMinX(), localToScreen.getMinY());  
  });
  ```
  
  > 相对于父组件的坐标：(300.00,300.00)
  > 相对于场景的坐标：(400.00,400.00)
  > 相对于父组件的坐标：(300.00,300.00)
  > 相对于屏幕的坐标：(1444.00,520.00)