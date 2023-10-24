package com.reine;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;

/**
 * 图片编辑
 * @author reine
 * 2022/5/30 10:30
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        System.out.println("--------------------------可编辑图片基础编辑---------------------------");
        WritableImage wi = new WritableImage(100, 100);
        PixelWriter pixelWriter = wi.getPixelWriter();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                pixelWriter.setColor(i, j, Color.YELLOW);
            }
        }
        for (int i = 0; i < 100; i++) {
            pixelWriter.setColor(i, 100 - i - 1, Color.RED);
        }

        System.out.println("--------------------------传入PixelReader生成可编辑图片进行编辑---------------------------");
        Image image = new Image("file:E:\\Users\\86158\\图片\\110300202.jpg", 600, 600, true, true);
        WritableImage wi1 = new WritableImage(image.getPixelReader(), 300, (int) image.getHeight());
        PixelWriter pixelWriter1 = wi1.getPixelWriter();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                pixelWriter1.setColor(i, j, Color.YELLOW);
            }
        }

        System.out.println("--------------------------传入PixelReader生成可编辑图片进行编辑，再通过另一张图片的像素点进行图片修改---------------------------");
        Image image1 = new Image("file:E:\\Users\\86158\\图片\\110300202.jpg", 600, 600, true, true);
        WritableImage wi2 = new WritableImage(image1.getPixelReader(), 200, 200, 600 - 200, (int) image1.getHeight() - 200);
        PixelWriter pixelWriter2 = wi2.getPixelWriter();
        Image data = new Image("images/empty.png");
        PixelReader pixelReader = data.getPixelReader();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int x = pixelReader.getArgb(i, j);
                pixelWriter2.setArgb(i, j, x);
            }
        }

        System.out.println("--------------------------传入PixelReader生成可编辑图片进行编辑，再通过另一张图片的像素点进行图片修改，通过getPixels和setPixels修改---------------------------");
        Image image2 = new Image("file:E:\\Users\\86158\\图片\\110300202.jpg", 1920, 1080, true, true);
        WritableImage wi3 = new WritableImage(image2.getPixelReader(), (int) image2.getWidth(), (int) image2.getHeight());
        PixelWriter pixelWriter3 = wi3.getPixelWriter();
        Image data1 = new Image("file:E:\\Users\\86158\\图片\\シノブ.png");
        PixelReader pixelReader1 = data1.getPixelReader();

        WritablePixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbPreInstance();
        int[] ints = new int[1920 / 2 * 1080];
        pixelReader1.getPixels(0, 0, 1920 / 2, 1080, pixelFormat, ints, 0, 1920 / 2);

        // pixelWriter3.setPixels(0, 0, 1920 / 2, 1080, pixelFormat, ints, 0, 1920 / 2);
        pixelWriter3.setPixels(0, 0, 1920 / 2, 1080, pixelReader1, 400, 0);

        System.out.println("--------------------------保存图片---------------------------");

        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(wi3, null);
        ImageIO.write(bufferedImage, "png", new File("E:\\Code\\JavaFx\\Aimls-lesson-study\\lesson70\\resources\\images\\result.png"));

        ImageView iv = new ImageView(wi1);

        // anchorPane.getChildren().addAll(iv);
        Button a = new Button("A");
        Button b = new Button("B");
        b.setLayoutX(50);
        anchorPane.getChildren().addAll(iv);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("图片编辑");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        a.setOnAction(event -> {
            // 截图
            WritableImage snapshot = anchorPane.snapshot(null, null);
            BufferedImage bufferedImage1 = SwingFXUtils.fromFXImage(snapshot, null);
            try {
                ImageIO.write(bufferedImage1, "png", new File("E:\\Code\\JavaFx\\Aimls-lesson-study\\lesson70\\resources\\images\\anchorPane.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 截图
        WritableImage snapshot = iv.snapshot(null, null);
        BufferedImage bufferedImage1 = SwingFXUtils.fromFXImage(snapshot, null);
        ImageIO.write(bufferedImage1, "png", new File("E:\\Code\\JavaFx\\Aimls-lesson-study\\lesson70\\resources\\images\\snapshot.png"));
    }
}
