### 2D图形 Arc弧形

* 设置圆心
  
```java
arc.setCenterX(0);  
arc.setCenterY(0);
```

* 设置横纵半径
  
```java
arc.setRadiusX(100);  
arc.setRadiusY(100);
```

* 设置展开角度`arc.setLength(90);`

* 逆时针旋转30度`arc.setStartAngle(30);`

* 设置类型
  
```java
arc.setType(ArcType.ROUND);// 圆弧两端连接圆心类型  
arc.setType(ArcType.OPEN);// 圆弧两端不相连类型  
arc.setType(ArcType.CHORD);// 圆弧两端相连类型
```

* 其他设置
  
```java
Arc arc6 = new Arc();  
arc6.setRadiusX(100);  
arc6.setRadiusY(100);  
arc6.setFill(Color.valueOf("#ff9999"));  
arc6.setLength(90);  
arc6.setStartAngle(0);  
arc6.setType(ArcType.CHORD);// 有边框时，圆弧两端以边框相连类型  
arc6.setStrokeWidth(3);  
arc6.setStroke(Color.valueOf("#996699"));  
arc6.setStrokeType(StrokeType.CENTERED);// 设置边框类型  
arc6.getStrokeDashArray().addAll(10.0, 10.0);// 设置虚线  
box.getChildren().add(arc6);
```
  
![](../assets/Pasted%20image%2020220617160929.png)