package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 获取图片颜色值
 * @author reine
 * 2022/5/29 20:20
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        // 加载一张3*3像素的图片
        String path = "images/rgb.png";
        Image image = new Image(path);

        PixelReader pixelReader = image.getPixelReader();
        // 获取那个位置的像素
        int argb = pixelReader.getArgb(2, 0); // FFFE090A  ARGB
        System.out.println("argb = " + argb);

        // 获取图片格式
        System.out.println("pixelReader.getPixelFormat().getType() = " + pixelReader.getPixelFormat().getType());

        // 获取透明度
        int alpha = argb >> 24 & 0xff;
        int red = argb >> 16 & 0xff;
        int green = argb >> 8 & 0xff;
        int blue = argb & 0xff;

        System.out.println("alpha = " + alpha);
        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);

        System.out.println("----------------------------------------------");
        Color color = pixelReader.getColor(2, 0);
        System.out.println("color = " + color);  // RGBA

        System.out.println("color.getOpacity() = " + color.getOpacity() * 255);
        System.out.println("color.getRed() = " + color.getRed() * 255);
        System.out.println("color.getGreen() = " + color.getGreen() * 255);
        System.out.println("color.getBlue() = " + color.getBlue() * 255);

        // 将16进制转10进制
        System.out.println("Integer.parseInt(\"ff\",16) = " + Integer.parseInt("ff", 16));

        // 将10进制转16进制
        System.out.println("Integer.toHexString(255) = " + Integer.toHexString(255));
        System.out.println("----------------------------------------------");
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
        System.out.println("----------------------------------------------");
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

        ImageView imageView = new ImageView(image);
        anchorPane.getChildren().addAll(imageView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("获取图片颜色值");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}