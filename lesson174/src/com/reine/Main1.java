package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 9:09
 */
public class Main1 extends Application {
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
            graphicsContext2D.beginPath();// 开始绘制
            graphicsContext2D.appendSVGPath("m100,100 c50,-50,150,50,200,0 z");// 设置路径
            graphicsContext2D.setLineJoin(StrokeLineJoin.ROUND);// 设置线条连接点为圆形
            graphicsContext2D.stroke();// 绘制边框
            graphicsContext2D.fill();// 绘制填充

            // graphicsContext2D.moveTo(100, 200);
            // graphicsContext2D.quadraticCurveTo(200, 300, 300, 200);
            // graphicsContext2D.stroke();
            // graphicsContext2D.fill();

        });
    }
}
