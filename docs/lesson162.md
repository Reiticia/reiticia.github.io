### Effect效果叠加之后的宽高

* 创建组件并添加效果
  
```java
Rectangle rectangle = new Rectangle(100, 100);  
rectangle.setFill(Color.BLUE);  
DropShadow dropShadow = new DropShadow();  
dropShadow.setRadius(20);  
GaussianBlur gaussianBlur = new GaussianBlur(5);  
dropShadow.setInput(gaussianBlur);  
rectangle.setEffect(dropShadow);  
AnchorPane root = new AnchorPane();  
root.getChildren().addAll(rectangle);  
AnchorPane.setTopAnchor(rectangle, 100.0);  
AnchorPane.setLeftAnchor(rectangle, 100.0);
```

* 获取组件宽高
  
```java
rectangle.setOnMouseClicked(event -> {  
 // 防抖效果  
 if (event.getClickCount() == 1) {  
     // 设置效果不会改变宽高  
     System.out.println(rectangle.getWidth() + "-" + rectangle.getHeight());  
     System.out.println(rectangle.getLayoutBounds());  
     // 坐标改变，相较于布局边界，本地布局延申的宽高为所有效果的半径之和  
     System.out.println(rectangle.getBoundsInLocal());  
     // 父组件布局延申的宽高为所有效果的半径之和  
     System.out.println(rectangle.getBoundsInParent());  
 }  
});
```
  
> 100.0-100.0  
> BoundingBox [minX:0.0, minY:0.0, minZ:0.0, width:100.0, height:100.0, depth:0.0, maxX:100.0, maxY:100.0, maxZ:0.0]  
> BoundingBox [minX:-25.0, minY:-25.0, minZ:0.0, width:150.0, height:150.0, depth:0.0, maxX:125.0, maxY:125.0, maxZ:0.0]  
> BoundingBox [minX:75.0, minY:75.0, minZ:0.0, width:150.0, height:150.0, depth:0.0, maxX:225.0, maxY:225.0, maxZ:0.0]  