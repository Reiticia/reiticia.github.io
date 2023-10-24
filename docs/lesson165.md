### 2D图形 Rectangle矩形

* 创建矩形`Rectangle rectangle = new Rectangle();`
* 设置位置**如果父组件拥有对子组件的约束能力，则该设置无效**
  
```java
rectangle.setX(100);  
rectangle.setY(100);
```

* 设置宽高
  
```java
rectangle.setWidth(200);  
rectangle.setHeight(100);
```

* 设置填充色`rectangle.setFill(Color.valueOf("#ff9999"));`

* 获取宽高
  
```java
rectangle.setOnMouseClicked(event -> {  
    if (event.getClickCount()>1){  
        return;  
    }  
    // 这两个属性可以看出设置XY生效，但组件位置交由父组件管理，故效果没有呈现  
    System.out.println(rectangle.getLayoutBounds());  
    System.out.println(rectangle.getBoundsInLocal());  
    System.out.println(rectangle.getBoundsInParent());  
});
```

> BoundingBox [minX:100.0, minY:100.0, minZ:0.0, width:200.0, height:100.0, depth:0.0, maxX:300.0, maxY:200.0, maxZ:0.0]  
> BoundingBox [minX:100.0, minY:100.0, minZ:0.0, width:200.0, height:100.0, depth:0.0, maxX:300.0, maxY:200.0, maxZ:0.0]  
> BoundingBox [minX:0.0, minY:0.0, minZ:0.0, width:200.0, height:100.0, depth:0.0, maxX:200.0, maxY:100.0, maxZ:0.0]

* 设置圆角**可以将圆角看为¼椭圆，横轴为arcWidth，纵轴为arcHeight**
  
```java
rectangle1.setArcWidth(30); 
rectangle1.setArcHeight(30);
```

* 设置边框属性
  
```java
rectangle2.setStroke(Color.valueOf("#996699"));// 设置边框颜色  
rectangle2.setStrokeWidth(5);// 设置边框宽度  
rectangle2.setStrokeType(StrokeType.INSIDE);// 设置边框类型  
rectangle3.getStrokeDashArray().addAll(10.0, 30.0);// 设置边框虚线
```

![](../assets/Pasted%20image%2020220617102007.png)