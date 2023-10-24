### Rotate旋转

* 以组件(100,100)的位置为中心，顺时针旋转45°`Rotate rotate = new Rotate(45, 100, 100);`
* 以组件(0,0)的位置为中心(即左上角)，逆时针旋转45°`Rotate rotate = new Rotate(-45, 0, 0);`
* 设置旋转`button2.getTransforms().add(rotate);`
* 设置旋转45°`button2.setRotate(45);`
* 获取宽高
  
```java
button2.setOnAction(event -> {  
    // 输出原始组件的宽高  
    System.out.println(button2.getPrefWidth());  
    System.out.println(button2.getPrefHeight());  
    // 获取组件相对与父组件的位移量，获取到的是原始组件左上角变换后的坐标  
    System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());  
    Bounds bounds = button2.getLayoutBounds();  
    Bounds localToParent = button2.localToParent(bounds);  
    // 输出目视宽高  
    System.out.println("宽度：" + localToParent.getWidth());  
    System.out.println("高度：" + localToParent.getHeight());  
    // 输出边框坐标  
    System.out.printf("右下角边框相对于自身坐标为(%.2f,%.2f)\n", localToParent.getMaxX() - localToParent.getMinX(), localToParent.getMaxY() - localToParent.getMinY());  
});
```

> 200.0
> 200.0
> 相对于父组件的坐标：(200.00,58.58)
> 宽度：282.84271240234375
> 高度：282.84271240234375
> 右下角边框相对于自身坐标为(282.84,282.84)