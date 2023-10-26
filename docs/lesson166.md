---
lang: zh-CN
title: 2D图形 Circle圆形
---


# 2D图形 Circle圆形

* 创建圆形`Circle circle = new Circle();`

* 设置圆心
  
    ```java
    circle.setCenterX(0);  
    circle.setCenterY(0);
    ```

* 设置半径`circle.setRadius(100);`

* 其他设置
  
    ```java
    Circle circle2 = new Circle();  
    circle2.setCenterX(0);  
    circle2.setCenterY(0);  
    circle2.setRadius(100);  
    circle2.setFill(Color.valueOf("#ff9999"));  
    circle2.setStrokeWidth(3);  
    circle2.setStroke(Color.valueOf("#996699"));  
    circle2.setSmooth(true);  
    circle2.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
    ```

* 获取坐标
      
    ```java
    // 将该组件添加到根节点上
    Circle circle4 = new Circle();  
    circle4.setCenterX(0);  
    circle4.setCenterY(0);  
    circle4.setRadius(100);  
    circle4.setFill(Color.valueOf("#ff9999"));  
    circle4.setSmooth(true);  
    circle4.setOnMouseClicked(event -> {  
        if (event.getClickCount()>1){  
            return;  
        }  
        System.out.println(circle4.getLayoutBounds());  
        System.out.println(circle4.getBoundsInLocal());  
        System.out.println(circle4.getBoundsInParent());  
    });
    ```
    
    > BoundingBox [minX:-100.0, minY:-100.0, minZ:0.0, width:200.0, height:200.0, depth:0.0, maxX:100.0, maxY:100.0, maxZ:0.0]  
    > BoundingBox [minX:-100.0, minY:-100.0, minZ:0.0, width:200.0, height:200.0, depth:0.0, maxX:100.0, maxY:100.0, maxZ:0.0]  
    > BoundingBox [minX:-100.0, minY:-100.0, minZ:0.0, width:200.0, height:200.0, depth:0.0, maxX:100.0, maxY:100.0, maxZ:0.0]  

![](../assets/Pasted%20image%2020220617112520.png)