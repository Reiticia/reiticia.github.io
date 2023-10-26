---
lang: zh-CN
title: Shear斜切
---


# Shear斜切

* 创建斜切`Shear shear = new Shear(0.5, 0.5, 0, 0);`

  斜切前不动点对角线的组件局部坐标

  $x_1 = 200, y_1 = 100$

  斜切后不动点对角线的组件局部坐标

  $x_2 = pivotX + (x_1 - pivotX) + x * (y_1 - pivotY) = 250$

  $y_2 = pivotY + (y_1 - pivotY) + y * (x_1 - pivotX) = 200$

* 设置斜切`button2.getTransforms().add(shear);`

* 获取宽高
  
  ```java
    // 输出原始组件的宽高  
    System.out.println(button2.getPrefWidth());  
    System.out.println(button2.getPrefHeight());  
    // 获取组件相对与父组件的位移量，获取到的是原始组件左上角变换后的坐标  
    System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());  
    Bounds bounds = button2.getLayoutBounds();  
    Bounds localToParent = button2.localToParent(bounds);  
    // 输出目视宽高  
    System.out.println("宽度：" + localToParent.getWidth());  
    System.out.println("高度：" + localToParent.getHeight());  
    // 输出边框坐标  
    System.out.printf("右下角边框相对于自身坐标为(%.2f,%.2f)\n", localToParent.getMaxX() - localToParent.getMinX(), localToParent.getMaxY() - localToParent.getMinY());
  ```
    
  > 200.0  
  > 100.0  
  > 相对于父组件的坐标：(100.00,100.00)  
  > 宽度：250.0  
  > 高度：200.0  
  > 右下角边框相对于自身坐标为(250.00,200.00)  