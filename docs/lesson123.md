### Scale缩放

* 创建缩放

**将x轴长度缩小为原来的0.5，将y轴长度缩小为原来的0.5 ；缩放操作执行后左上角坐标为(pivotX*x, pivotY*y)**

```java
Scale scale = new Scale(0.5, 0.5, 100, 100);
Scale scale1 = new Scale(2, 2, 100, 100);
```

* xy缩放比例取倒数`scale.createInverse()`

* 在该位移基础上再缩放，转换为point2D
  
```java
Point2D point2D = scale.transform(0.5, 0.5);  
System.out.printf("point2D(%.2f,%.2f)\n", point2D.getX(), point2D.getY());
```

> point2D(50.25,50.25)

* 多次进行缩放`button2.getTransforms().addAll(scale,scale1)`

* 以原组件中心点向四周进行缩放，x轴，y轴各缩小0.5倍
  
```java
button2.setScaleX(0.5);  
button2.setScaleY(0.8);
```

* 获取宽高
  
```java
// 仅进行一次缩放操作
Scale scale = new Scale(0.5, 0.5, 100, 100);
button2.getTransforms().addAll(scale);
button2.setOnAction(event -> {  
    // 输出原始组件的宽高  
    System.out.println(button2.getPrefWidth());  
    System.out.println(button2.getPrefHeight());  
    // 获取组件相对与父组件的位移量 ，输出的结果是变换后的
    System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());  
    Bounds bounds = button2.getLayoutBounds();  
    Bounds localToParent = button2.localToParent(bounds);  
    // 输出目视宽高  
    System.out.println("宽度：" + localToParent.getWidth());  
    System.out.println("高度：" + localToParent.getHeight());  
});
```

> 200.0
> 200.0
> 相对于父组件的坐标：(50.00,50.00)
> 宽度：100.0
> 高度：100.0