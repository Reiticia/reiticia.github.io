package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 9:09
 */
public class Main3 extends Application {
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
            graphicsContext2D.setGlobalAlpha(0.5);// 设置画笔透明度
            graphicsContext2D.setStroke(Color.BLUE);// 设置画笔边框颜色
            graphicsContext2D.setLineWidth(4);// 设置画笔边框宽度
            graphicsContext2D.save();// 保存画布状态
            graphicsContext2D.setEffect(new DropShadow());// 设置画笔阴影
            graphicsContext2D.strokeLine(100,100,200,200);
            graphicsContext2D.restore();// 恢复画布状态
            graphicsContext2D.strokeLine(100,300,200,300);
        });
    }
}
