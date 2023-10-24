### 2D图形 Line线

* 创建线段`Line line = new Line(0, 0, 100, 100);`
  
* 设置线条颜色`line.setStroke(Color.valueOf("#ff9999"));`
  
* 设置线条宽度`line.setStrokeWidth(5);`
  
* 设置线条端点形状（圆角）`line.setStrokeLineCap(StrokeLineCap.ROUND);`
  
* 设置线条平滑`line.setSmooth(true);`
  
* 设置线条虚线（线段长度，线段距离，线段长度，线段距离……）参数不足则循环使用`line.getStrokeDashArray().addAll(5.0, 10.0, 5.0, 20.0);`

* 设置线条虚线偏移量`line.setStrokeDashOffset(4);`
  
* 线段连接的效果
  
```java
AnchorPane otherBox = new AnchorPane();  
Line otLine = new Line(0, 0, 100, 0);  
otLine.setStroke(Color.valueOf("#ff9999"));  
otLine.setStrokeWidth(10);  
otLine.setStrokeLineCap(StrokeLineCap.ROUND);  
otherBox.getChildren().add(otLine);  
Line otLine1 = new Line(100, 0, 100, 100);  
otLine1.setStroke(Color.valueOf("#996699"));  
otLine1.setStrokeWidth(10);  
otLine1.setStrokeLineCap(StrokeLineCap.BUTT);// 两条线段之间衔接后会有空隙  
otherBox.getChildren().add(otLine1);  
Line otLine2 = new Line(100, 100, 200, 100);  
otLine2.setStroke(Color.valueOf("#ffcccc"));  
otLine2.setStrokeWidth(10);  
otLine2.setStrokeLineCap(StrokeLineCap.SQUARE);// 默认值  
otherBox.getChildren().add(otLine2);
```

![](../assets/Pasted%20image%2020220617081158.png)