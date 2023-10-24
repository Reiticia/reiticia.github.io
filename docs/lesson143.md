### ImagePattern

```java
// 第一种方式，直接加载图片，会将图片缩放为当前区域的宽高
Rectangle rec0 = (Rectangle) grid.getChildren().get(0);  
rec0.setFill(new ImagePattern(image));  
// 第二种方式，将区域进行x轴取0.5倍，y轴取0.5倍，平铺图片
Rectangle rec1 = (Rectangle) grid.getChildren().get(1);  
rec1.setFill(new ImagePattern(image, 0, 0, 0.5, 0.5, true));  
// 取宽高50，50的图片进行平铺
Rectangle rec2 = (Rectangle) grid.getChildren().get(2);  
rec2.setFill(new ImagePattern(image, 0, 0, 50, 50, false));  
// 水平方向从25开始平铺，未能平铺到的区域将图片进行截取后平铺
Rectangle rec3 = (Rectangle) grid.getChildren().get(3);  
rec3.setFill(new ImagePattern(image, 25, 0, 50, 50, false));  
// 水平方向从25，垂直方向50开始平铺，未能平铺到的区域将图片进行截取后平铺
Rectangle rec4 = (Rectangle) grid.getChildren().get(4);  
rec4.setFill(new ImagePattern(image, 25, 50, 50, 50, false));  
Circle circle = (Circle) box.getChildren().get(0);  
circle.setFill(new ImagePattern(image, 0, 0, 50, 50, false));  
Polygon polygon = (Polygon) box.getChildren().get(1);  
polygon.setFill(new ImagePattern(image, 0, 0, 50, 50, false));
```

![](../assets/Pasted%20image%2020220615154921.png)