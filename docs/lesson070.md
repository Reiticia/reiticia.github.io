---
lang: zh-CN
title: 图片编辑
---

# 图片编辑

## 基础编辑功能

1. 创建可编辑图片`WritableImage wi = new WritableImage(100, 100);`

2. 获取像素编辑器`PixelWriter pixelWriter = wi.getPixelWriter();`

3. 向每一个像素写入颜色，并在某些区域追加其他颜色
  
   ```java
   for (int i = 0; i < 100; i++) {  
       for (int j = 0; j < 100; j++) {  
           pixelWriter.setColor(i, j, Color.YELLOW);  
       }  
   }  
   for (int i = 0; i < 100; i++) {  
       pixelWriter.setColor(i, 100 - i - 1, Color.RED);  
   }
   ```
   
## 传入图片的PixelReader对该图片进行编辑

1. 获取图片`Image image = new Image("file:E:\\Users\\86158\\图片\\110300202.jpg", 600, 600, true, true);`

2. 通过图片PixelReader创建可编辑图片
  
   ```java
   // 图片PixelReader，从(0,0)开始截取图片宽度，图片高度
   WritableImage wi1 = new WritableImage(image.getPixelReader(), 600, (int) image.getHeight());
   ```
   
3. 获取像素编辑器`PixelWriter pixelWriter1 = wi1.getPixelWriter();`

4. 向100*100的区域填充颜色
  
   ```java
   for (int i = 0; i < 100; i++) {  
       for (int j = 0; j < 100; j++) {  
           pixelWriter1.setColor(i, j, Color.YELLOW);  
       }  
   }
   ```
   
## 传入图片的PixelReader对该图片进行编辑，再通过另一张图片的像素点进行图片修改

1. 获取将被修改的图片`Image image1 = new Image("file:E:\\Users\\86158\\图片\\110300202.jpg", 600, 600, true, true);`

2. 通过图片PixelReader创建可编辑图片
  
   ```java
   // 图片PixelReader，从(0,0)开始截取图片宽度，图片高度
   WritableImage wi2 = new WritableImage(image1.getPixelReader(), 200, 200, 600 - 200, (int) image1.getHeight() - 200);
   ```
   
3. 获取像素编辑器`PixelWriter pixelWriter2 = wi1.getPixelWriter();`

4. 获取修改图片`Image data = new Image("images/empty.png");`

5. 获取修改图片的PixelReader`PixelReader pixelReader = data.getPixelReader();`

6. 将对应区域颜色进行覆盖
  
   ```java
   for (int i = 0; i < 100; i++) {  
       for (int j = 0; j < 100; j++) {  
           int x = pixelReader.getArgb(i, j);  
           pixelWriter2.setArgb(i, j, x);  
       }  
   }
   ```
    
## 传入图片的PixelReader对该图片进行编辑，再通过另一张图片的像素点进行图片修改，使用getPixels和setPixels修改
    
**前四步与上一节相同**

1. 创建int类型argb的像素格式化工具`WritablePixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbPreInstance();`

2. 创建ints数组`int[] ints = new int[1920 / 2 * 1080];`

3. 填充数组`pixelReader1.getPixels(0, 0, 1920 / 2, 1080, pixelFormat, ints, 0, 1920 / 2);`

4. 写入像素颜色数据`pixelWriter3.setPixels(0, 0, 1920 / 2, 1080, pixelFormat, ints, 0, 1920 / 2);`

5. （另一种写法）`pixelWriter3.setPixels(0, 0, 1920 / 2, 1080, pixelReader1, 400, 0);`
  
## 保存图片

1. 将内存中的图片转换成缓冲图像`BufferedImage bufferedImage = SwingFXUtils.fromFXImage(wi3, null);`

2. 转写为图片文件`ImageIO.write(bufferedImage, "png", new File("E:\\Code\\JavaFx\\Aimls-lesson-study\\lesson70\\resources\\images\\result.png"));`
  
## 节点的截图

1. 获取节点快照`WritableImage snapshot = iv.snapshot(null, null);`

2. 转换成缓冲图像`BufferedImage bufferedImage1 = SwingFXUtils.fromFXImage(snapshot, null);`

3. 转写为图片文件`ImageIO.write(bufferedImage1, "png", new File("E:\\Code\\JavaFx\\Aimls-lesson-study\\lesson70\\resources\\images\\snapshot.png"));`