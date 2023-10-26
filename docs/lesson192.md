---
lang: zh-CN
title: Animation PathTransition路径动画
---


# Animation PathTransition路径动画

1. 描绘路径
  
   ```java
   /**  
   * 获取路径（相对路径）  
   *  
   * @return  
   */  
   private Path getPath() {  
       Path path = new Path();  
       // 起点  
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
       path.setStroke(Color.valueOf("#996699"));// 设置边框颜色  
       path.setStrokeWidth(1);// 设置边框宽度  
       path.setStrokeLineJoin(StrokeLineJoin.BEVEL);// 设置边框连接点为圆角  
       path.setStrokeLineCap(StrokeLineCap.ROUND);// 设置边框连接点为圆角  
       path.getElements().addAll(moveTo, lineTo, quadCurveTo, hLineTo, cubicCurveTo, vLineTo, arcTo, closePath);  
       return path;  
   }
   ```
   
2. 获取路径，将路径添加到布局中，便于观察
  
   ```java
   Path path = getPath();  
   // 这里必须使用布局类将路径进行包裹，否则节点运动时不会按照指定路径运动
   StackPane stackPane = new StackPane();  
   stackPane.getChildren().add(path);
   root.getChildren().add(stackPane);
   ```
   
3. 调整起始中心点与路径对齐
  
   ```java
   rectangle.setTranslateX(-50);  
   rectangle.setTranslateY(50);
   ```
   
4. 创建路径动画
  
   ```java
   PathTransition pt = new PathTransition();  
   pt.setDuration(Duration.seconds(5));// 设置动画持续时间  
   pt.setNode(rectangle);// 设置动画节点  
   pt.setPath(path);// 设置动画路径  
   pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// 设置动画方向，图形方向与路径方向一致  
   pt.setAutoReverse(true);// 设置动画循环播放  
   pt.setCycleCount(PathTransition.INDEFINITE);// 设置动画循环播放次数
   ```
5. 播放动画
  
   ```java
   play.setOnAction(event -> {  
       pt.play();  
   });
   ```
   

![](../assets/VeryCapture_20220620081443.gif)