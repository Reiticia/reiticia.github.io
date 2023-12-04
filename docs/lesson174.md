---
lang: zh-CN
title: Canvas画布
---


# Canvas画布

* 创建画布`Canvas canvas = new Canvas(600, 600);`

* 获取画笔(画布内描述物体超出画布部分会被裁切)`GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();`

* 设置画笔填充颜色`graphicsContext2D.setFill(Color.RED);`

* 设置画笔边框颜色`graphicsContext2D.setStroke(Color.BLUE);`

* 设置画笔边框宽度`graphicsContext2D.setLineWidth(4);`

* 画矩形`graphicsContext2D.fillRect(100, 100, 100, 100);`

* 画矩形边框`graphicsContext2D.strokeRect(200, 200, 100, 100);`

* 画线`graphicsContext2D.strokeLine(300, 200, 300, 100);`

* 画多边形`graphicsContext2D.fillPolygon(new double[]{400, 300, 500}, new double[]{100, 300, 300}, 3);`

* 设置字体大小`graphicsContext2D.setFont(Font.font(20));`

* 画文字`graphicsContext2D.fillText("Hello World", 200, 350);`

* 画带边框文字`graphicsContext2D.strokeText("Hello World", 100, 350);`

* 清除画布`graphicsContext2D.clearRect(0,0,200,200);`

* 旋转画布`graphicsContext2D.rotate(45);`

* 开始绘制`graphicsContext2D.beginPath();`

* 设置路径`graphicsContext2D.appendSVGPath("m100,100 c50,-50,150,50,200,0 z");`

* 设置线条连接点为圆形`graphicsContext2D.setLineJoin(StrokeLineJoin.ROUND);`

* 绘制边框`graphicsContext2D.stroke();`

* 绘制填充`graphicsContext2D.fill();`

* 绘制二次贝塞尔曲线`graphicsContext2D.quadraticCurveTo(200, 300, 300, 200);`

* 图片绘制（图片路径，从图片(0,0)点开始取 宽100 高100 画到画布上(10,10)点画 宽200 高200的图片(缩放)）
  
```java
graphicsContext2D.drawImage(new Image("file:E://Users//86158//图片//0ea0dc59c3c01450e33a1d2131f1c6f.jpg"),0,0,100,100,10,10,200,200);
```

* 像素绘制
  
```java
PixelWriter pixelWriter = graphicsContext2D.getPixelWriter();  
for (int i = 0; i < 100; i++) {  
    for (int j = 0; j < 100; j++) {  
        pixelWriter.setColor(i, j, Color.BLACK);  
    }  
}
```
* 设置画笔透明度`graphicsContext2D.setGlobalAlpha(0.5);`

* 保存画布状态`graphicsContext2D.save();`

* 设置画笔阴影`graphicsContext2D.setEffect(new DropShadow());`

* 恢复画布状态`graphicsContext2D.restore();`
