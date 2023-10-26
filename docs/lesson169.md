---
lang: zh-CN
title: 2D图形 Polygon多边形
---


# 2D图形 Polygon多边形

* 创建多边形
  
    ```java
    double[] points = {  
          0.0, 0.0,  
          100.0, 0.0,  
          100.0, 100.0  
    };// 三个点坐标  
    // 通过构造方法创建
    Polygon polygon = new Polygon(points);
    // 通过对象方法创建
    polygon1.getPoints().addAll(0.0, 0.0, 100.0, 0.0, 100.0, 100.0, 0.0, 100.0);
    ```

* 其他设置
  
    ```java
    double[] points2 = {  
          0.0,0.0,  
          100.0,0.0,  
          100.0,100.0,  
          200.0,150.0,  
          100.0,200.0  
    };  
    Polygon polygon2 = new Polygon(points2);  
    polygon2.setFill(Color.valueOf("#ff9999"));  
    polygon2.setStrokeWidth(3);  
    polygon2.setStroke(Color.valueOf("#996699"));  
    polygon2.getStrokeDashArray().addAll(10.0, 10.0);  
    box.getChildren().add(polygon2);
    ```

![](../assets/Pasted%20image%2020220617170241.png)