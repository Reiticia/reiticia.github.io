package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 9:09
 */
public class Main extends Application {
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
            graphicsContext2D.fillRect(100, 100, 100, 100);// 画矩形
            graphicsContext2D.strokeRect(200, 200, 100, 100);// 画矩形边框
            graphicsContext2D.setStroke(Color.YELLOW);// 设置画笔边框颜色
            graphicsContext2D.strokeLine(300, 200, 300, 100);// 画线
            graphicsContext2D.setFill(Color.PURPLE);// 设置画笔填充颜色
            graphicsContext2D.fillPolygon(new double[]{400, 300, 500}, new double[]{100, 300, 300}, 3);// 画多边形
            graphicsContext2D.setFont(Font.font(20));// 设置字体大小
            graphicsContext2D.setFill(Color.BLACK);// 设置画笔填充颜色
            graphicsContext2D.fillText("Hello World", 200, 350);// 画文字
            graphicsContext2D.setStroke(Color.PINK);// 设置画笔边框颜色
            graphicsContext2D.strokeText("Hello World", 100, 350);// 画带边框文字
            graphicsContext2D.clearRect(0,0,200,200);// 清除画布
            graphicsContext2D.rotate(45);// 旋转画布
        });
    }
}
