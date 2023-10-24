### 2D图形 Ellipse椭圆形

* 设置圆心位置
  
```java
ellipse.setCenterX(0);  
ellipse.setCenterY(0);
```

* 设置半径
  
```java
ellipse.setRadiusX(100);// 横半径  
ellipse.setRadiusY(50);// 纵半径
```

* 其他设置
  
```java
HBox box = new HBox();
Ellipse ellipse = new Ellipse();  
ellipse.setCenterX(0);  
ellipse.setCenterY(0);  
ellipse.setFill(Color.valueOf("#ff9999"));  
ellipse.setRadiusX(100);// 横半径  
ellipse.setRadiusY(50);// 纵半径  
box.getChildren().add(ellipse);  
Ellipse ellipse1 = new Ellipse();  
ellipse1.setCenterX(0);  
ellipse1.setCenterY(0);  
ellipse1.setFill(Color.valueOf("#ff9999"));  
ellipse1.setRadiusX(50);// 横半径  
ellipse1.setRadiusY(100);// 纵半径  
ellipse1.setStrokeWidth(10);  
ellipse1.setStroke(Color.valueOf("#996699"));  
ellipse1.setSmooth(true);// 平滑  
box.getChildren().add(ellipse1);  
Ellipse ellipse2 = new Ellipse();  
ellipse2.setCenterX(0);  
ellipse2.setCenterY(0);  
ellipse2.setFill(Color.valueOf("#ff9999"));  
ellipse2.setRadiusX(50);// 横半径  
ellipse2.setRadiusY(100);// 纵半径  
ellipse2.setStrokeWidth(3);  
ellipse2.setStroke(Color.valueOf("#996699"));  
ellipse2.setSmooth(true);// 平滑  
ellipse2.getStrokeDashArray().addAll(10.0, 10.0);// 虚线  
box.getChildren().add(ellipse2);
```
  
![](../assets/Pasted%20image%2020220617150857.png)