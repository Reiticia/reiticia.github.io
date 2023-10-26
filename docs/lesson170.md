---
lang: zh-CN
title: 2D图形 QuadCurve二次曲线方程&CubicCurve三次曲线方程
---


# 2D图形 QuadCurve二次曲线方程&CubicCurve三次曲线方程

## QuadCurve二次曲线方程

```java
AnchorPane anchorPane = new AnchorPane();  
anchorPane.setPrefSize(200, 200);  
anchorPane.setStyle("-fx-background-color: #ff9999");  
QuadCurve quadCurve = new QuadCurve();  
// 起点坐标  
quadCurve.setStartX(0);  
quadCurve.setStartY(100);  
// 终点坐标  
quadCurve.setEndX(200);  
quadCurve.setEndY(100);  
// 控制点坐标  
quadCurve.setControlX(100);  
quadCurve.setControlY(0);  
// quadCurve.setFill(Color.valueOf("#996699"));  
quadCurve.setFill(Color.TRANSPARENT);// 填充颜色：透明  
quadCurve.setStrokeWidth(3);// 边框宽度  
quadCurve.setStroke(Color.valueOf("#ffcccc"));// 边框颜色  
quadCurve.getStrokeDashArray().addAll(10.0, 10.0);// 虚线  
anchorPane.getChildren().add(quadCurve);  
box.getChildren().add(anchorPane);
```

## CubicCurve三次曲线方程

```java
AnchorPane anchorPane2 = new AnchorPane();  
anchorPane2.setPrefSize(200, 200);  
anchorPane2.setStyle("-fx-background-color: #ff9999");  
CubicCurve cubicCurve = new CubicCurve();  
// 起点坐标  
cubicCurve.setStartX(0);  
cubicCurve.setStartY(100);  
// 终点坐标  
cubicCurve.setEndX(200);  
cubicCurve.setEndY(100);  
// 控制点坐标  
cubicCurve.setControlX1(50);  
cubicCurve.setControlY1(0);  
cubicCurve.setControlX2(150);  
cubicCurve.setControlY2(200);  
// cubicCurve.setFill(Color.valueOf("#996699"));  
cubicCurve.setFill(Color.TRANSPARENT);// 填充颜色：透明  
cubicCurve.setStrokeWidth(3);// 边框宽度  
cubicCurve.setStroke(Color.valueOf("#ffcccc"));// 边框颜色  
cubicCurve.getStrokeDashArray().addAll(10.0, 10.0);// 虚线  
anchorPane2.getChildren().add(cubicCurve);  
box.getChildren().add(anchorPane2);
```

![](../assets/Pasted%20image%2020220617174014.png)