---
lang: zh-CN
title: Image的像素解析
---


# Image的像素解析

* 加载一张3*3像素的图片
  
  ```java
  String path = "images/rgb.png";  
  Image image = new Image(path);
  ```
  
* 创建像素解析器
  
  ```java
  PixelReader pixelReader = image.getPixelReader();
  ```
  
* 十六进制转十进制`Integer.parseInt("ff", 16)`
* 十进制转十六进制`Integer.toHexString(255)`
* 像素解析器操作，通过`getArgb`获取某个像素点的argb
  1. 解析位置(2,0)的像素**返回16进制整数，格式为ARGB**
    
     ```java
     int argb = pixelReader.getArgb(2, 0);   
     System.out.println("argb = " + argb);
     ```
     
  2. 获取图片格式
    
     ```java
     System.out.println("pixelReader.getPixelFormat().getType() = " + pixelReader.getPixelFormat().getType());
     ```
     
  3. 获取ARGB
    
     ```java
     int alpha = argb >> 24 & 0xff;  
     int red = argb >> 16 & 0xff;  
     int green = argb >> 8 & 0xff;  
     int blue = argb & 0xff;  
     System.out.println("alpha = " + alpha);  
     System.out.println("red = " + red);  
     System.out.println("green = " + green);  
     System.out.println("blue = " + blue);
     ```
     
     > argb = -128758
     > pixelReader.getPixelFormat().getType() = BYTE_BGRA_PRE
     > alpha = 255
     > red = 254
     > green = 9
     > blue = 10

* 像素解析器操作，通过`getColor`获取某个像素点的Color
  1. 获取color
    
     ```java
     Color color = pixelReader.getColor(2, 0);  
     System.out.println("color = " + color);  // RGBA
     ```
     
  2. 获取RGBA
    
     ```java
     System.out.println("color.getOpacity() = " + color.getOpacity() * 255);  
     System.out.println("color.getRed() = " + color.getRed() * 255);  
     System.out.println("color.getGreen() = " + color.getGreen() * 255);  
     System.out.println("color.getBlue() = " + color.getBlue() * 255);
     ```
     
     > color = 0xfe090aff
     > color.getOpacity() = 255.0
     > color.getRed() = 254.00000005960464
     > color.getGreen() = 9.000000413507223
     > color.getBlue() = 10.000000353902578

* 像素解析器操作，通过`getPixels`获取所有像素点的argb，通过byte数组操作
  
    ```java
    WritablePixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteBgraPreInstance();  
    // byte 8bit  
    byte[] bytes = new byte[3 * 3 * 4];  
    /*  
    x - 要读取的矩形区域的 X 坐标  
    y - 要读取的矩形区域的 Y 坐标  
    w - 要读取的矩形区域的宽度  
    h - 要读取的矩形区域的高度  
    pixelformat – PixelFormat<ByteBuffer>对象定义字节格式以将像素存储到缓冲区中  
    buffer – 一个字节数组，用于存储返回的像素数据  
    offset – buffer中用于存储第一个像素数据的偏移量  
    scanlineStride – 缓冲区中一行数据开头的像素数据到下一行数据开头的距离  
    */  
    pixelReader.getPixels(0, 0, 3, 3, pixelFormat, bytes, 0, 3 * 4);  
    // 每次4个字节，即32位，十六进制表示为(0x00000000 ~ 0xffffffff)，打印每个像素的argb值  
    for (int i = 0; i < bytes.length; i += 4) {  
        int b = bytes[i] & 0xff;  
        int g = bytes[i + 1] & 0xff;  
        int r = bytes[i + 2] & 0xff;  
        int a = bytes[i + 3] & 0xff;  
        System.out.printf("A = %d, R = %d, G = %d, B = %d\n", a, r, g, b);  
    }
    ```
    
    > A = 255, R = 8, G = 255, B = 8
    > A = 255, R = 18, G = 25, B = 248
    > A = 255, R = 254, G = 9, B = 10
    > A = 255, R = 27, G = 16, B = 243
    > A = 45, R = 45, G = 0, B = 0
    > A = 255, R = 7, G = 7, B = 255
    > A = 255, R = 254, G = 3, B = 4
    > A = 253, R = 49, G = 22, B = 226
    > A = 255, R = 10, G = 255, B = 10
* 像素解析器操作，通过`getPixels`获取所有像素点的argb，通过int数组操作
  
    ```java
    WritablePixelFormat<IntBuffer> pixelFormat1 = PixelFormat.getIntArgbPreInstance();  
    // int 32bit  
    int[] ints = new int[3 * 3];  
    pixelReader.getPixels(0, 0, 3, 3, pixelFormat1, ints, 0, 3);  
    //  
    // 十六进制表示为(0x00000000 ~ 0xffffffff)，打印每个像素的argb值  
    for (int anInt : ints) {  
        // int b = ints[i] & 0xff000000;  
        // int g = ints[i] & 0x00ff0000;  
        // int r = ints[i] & 0x0000ff00;  
        // int a = ints[i] & 0x000000ff;  
        int b = (anInt & 0xff);  
        int g = ((anInt >> 8) & 0xff);  
        int r = ((anInt >> 16) & 0xff);  
        int a = ((anInt >> 24) & 0xff);  
        System.out.print("该像素点上16位ARGB值 = 0x" + Integer.toHexString(anInt) + " ");  
        System.out.printf("A = %3d, R = %3d, G = %3d, B = %3d\n", a, r, g, b);  
    }
    ```
    
    > 该像素点上16位ARGB值 = 0xff08ff08 A = 255, R =   8, G = 255, B =   8
    > 该像素点上16位ARGB值 = 0xff1219f8 A = 255, R =  18, G =  25, B = 248
    > 该像素点上16位ARGB值 = 0xfffe090a A = 255, R = 254, G =   9, B =  10
    > 该像素点上16位ARGB值 = 0xff1b10f3 A = 255, R =  27, G =  16, B = 243
    > 该像素点上16位ARGB值 = 0x2d2d0000 A =  45, R =  45, G =   0, B =   0
    > 该像素点上16位ARGB值 = 0xff0707ff A = 255, R =   7, G =   7, B = 255
    > 该像素点上16位ARGB值 = 0xfffe0304 A = 255, R = 254, G =   3, B =   4
    > 该像素点上16位ARGB值 = 0xfd3116e2 A = 253, R =  49, G =  22, B = 226
    > 该像素点上16位ARGB值 = 0xff0aff0a A = 255, R =  10, G = 255, B =  10
