---
lang: zh-CN
title: 2D图形  Polyline折线
---

# 2D图形  Polyline折线

* 创建折线`Polyline polyline = new Polyline(0, 0, 100, 100, 200, 100);`

* 设置线宽`polyline.setStrokeWidth(5);`

* 设置线条颜色`polyline.setStroke(Color.valueOf("#ff6666"));`

* 设置线条区域填充`polyline.setFill(Color.valueOf("#ffcccc"));`

* 设置线段连接方式（让线段连接处形成角度）`polyline1.setStrokeLineJoin(StrokeLineJoin.MITER);`

* 设置转角弧度（越大越尖）`polyline1.setStrokeMiterLimit(0);`

* 设置边框在外`polyline3.setStrokeType(StrokeType.OUTSIDE);`

* 点击事件
  
    ```java
    // 点击四周线段和中间区域有效，如果不设置颜色填充，则点击中间区域无效  
    polyline4.setOnMouseClicked(event -> {  
        System.out.println("点击了polyline4");  
    });
    ```
    
    ![](../assets/Pasted%20image%2020220617090936.png)