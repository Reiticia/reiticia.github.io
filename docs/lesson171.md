---
lang: zh-CN
title: 2D图形 Path路径
---


# 2D图形 Path路径

* 创建path`Path path = new Path();`

* path中的元素（其中所有元素均可重复添加到path的元素中）
      
    ```java
    // 抬起画笔移动至 (0,0)然后放下画笔
    MoveTo moveTo = new MoveTo(0, 0);  
    // 沿直线移动到(100,0)  
    LineTo lineTo = new LineTo(100, 0);  
    // 二次曲线  
    QuadCurveTo quadCurveTo = new QuadCurveTo(50, 0, 100, 100);  
    quadCurveTo.setAbsolute(false);// 设置为相对路径，则以(100,0)为起点  
    // 水平线  
    HLineTo hLineTo = new HLineTo(100);  
    hLineTo.setAbsolute(false);// 设置为相对路径，则以(100,100)为起点  
    // 三次曲线  
    CubicCurveTo cubicCurveTo = new CubicCurveTo(50, -50, 150, 100, 200, 0);  
    cubicCurveTo.setAbsolute(false);// 设置为相对路径，则以(300,100)为起点  
    // 垂直线  
    VLineTo vLineTo = new VLineTo(-100);  
    vLineTo.setAbsolute(false);// 设置为相对路径，则以(500,100)为起点  
    // 弧线  
    ArcTo arcTo = new ArcTo(100, 100, 0, 100, 100, true, true);  
    arcTo.setAbsolute(false);// 设置为相对路径，则以(500,0)为起点  
    // 闭合  
    ClosePath closePath = new ClosePath();  
    path.setFill(Color.valueOf("#ff9999"));// 设置填充颜色  
    path.setStroke(Color.valueOf("#996699"));// 设置边框颜色  
    path.setStrokeWidth(2);// 设置边框宽度    
    path.setStrokeLineJoin(StrokeLineJoin.ROUND);// 设置边框连接点为圆角
    path.getStrokeDashArray().addAll(10d, 10d);// 设置边框虚线  
    // 添加的元素可以重复使用  
    path.getElements().addAll(moveTo, lineTo, quadCurveTo, hLineTo, cubicCurveTo, vLineTo, arcTo, closePath);
    ```
  
## 实例：“回”字
  
```java
// 画一个回  
Path path = new Path();  
// 起点  
MoveTo moveTo = new MoveTo(0, 0);  
HLineTo hLineTo = new HLineTo(100);  
hLineTo.setAbsolute(false);  
VLineTo vLineTo = new VLineTo(100);  
vLineTo.setAbsolute(false);  
HLineTo hLineTo1 = new HLineTo(-100);  
hLineTo1.setAbsolute(false);  
VLineTo vLineTo1 = new VLineTo(-100);  
vLineTo1.setAbsolute(false);  
MoveTo moveToIn = new MoveTo(25, 25);  
HLineTo hLineToIn = new HLineTo(50);  
hLineToIn.setAbsolute(false);  
VLineTo vLineToIn = new VLineTo(50);  
vLineToIn.setAbsolute(false);  
HLineTo hLineTo1In = new HLineTo(-50);  
hLineTo1In.setAbsolute(false);  
VLineTo vLineTo1In = new VLineTo(-50);  
vLineTo1In.setAbsolute(false);  
path.getElements().addAll(moveTo, hLineTo, vLineTo, hLineTo1, vLineTo1, moveToIn, hLineToIn, vLineToIn, hLineTo1In, vLineTo1In);  
path.setFill(Color.RED);  
// 重叠部分不填充颜色
path.setFillRule(FillRule.EVEN_ODD);
```

![](../assets/Pasted%20image%2020220617211051.png)