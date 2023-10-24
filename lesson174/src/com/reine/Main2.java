package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 9:09
 */
public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(600, 600);
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();// 获取画笔

        Button button = new Button("paint");

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button, canvas);
        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 10.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Canvas画布");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        button.setOnAction(event -> {
            System.out.println("button clicked");
            // 超出画布部分会被裁切
            graphicsContext2D.setFill(Color.RED);// 设置画笔填充颜色
            graphicsContext2D.setStroke(Color.BLUE);// 设置画笔边框颜色
            graphicsContext2D.setLineWidth(4);// 设置画笔边框宽度
            // 图片绘制 图片路径，从图片(0,0)点开始取 宽100 高100 画到画布上(10,10)点画 宽200 高200的图片(缩放)
            graphicsContext2D.drawImage(new Image("file:E://Users//86158//图片//0ea0dc59c3c01450e33a1d2131f1c6f.jpg"),0,0,100,100,10,10,200,200);
            PixelWriter pixelWriter = graphicsContext2D.getPixelWriter();
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    pixelWriter.setColor(i, j, Color.BLACK);
                }
            }

        });
    }
}
