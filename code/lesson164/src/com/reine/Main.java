package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeLineJoin;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 8:12
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane lineBox = new FlowPane();
        lineBox.setHgap(10);
        lineBox.setVgap(10);
        Polyline polyline = new Polyline(0, 0, 100, 100, 200, 100);
        polyline.setStrokeWidth(5);
        polyline.setStroke(Color.valueOf("#ff6666"));
        polyline.setFill(Color.valueOf("#ffcccc"));
        lineBox.getChildren().add(polyline);
        // 线段闭合
        Polyline polyline1 = new Polyline();
        polyline1.getPoints().addAll(0.0, 0.0, 100.0, 100.0, 200.0, 100.0, 0.0, 0.0);
        polyline1.setStrokeWidth(5);
        polyline1.setStrokeLineJoin(StrokeLineJoin.MITER);// 线段连接方式（让线段连接处形成角度）
        polyline1.setStrokeMiterLimit(0);// 转角弧度（越大越尖）
        polyline1.setStroke(Color.valueOf("#ffff66"));
        polyline1.setFill(Color.valueOf("#ffcccc"));
        lineBox.getChildren().add(polyline1);

        double[] points = {0.0, 0.0, 100.0, 0.0, 0.0, 100.0, 100.0, 100.0, 0.0, 0.0};
        Polyline polyline2 = new Polyline(points);
        polyline2.setStrokeWidth(5);
        polyline2.setStroke(Color.valueOf("#99cc66"));
        polyline2.setFill(Color.valueOf("#ffcccc"));
        lineBox.getChildren().add(polyline2);

        Polyline polyline3 = new Polyline(points);
        polyline3.setStrokeWidth(5);
        polyline3.setStrokeLineJoin(StrokeLineJoin.ROUND);// 线段连接方式（让线段连接更加自然）
        // polyline3.setStrokeType(StrokeType.OUTSIDE);// 边框在外
        polyline3.setStroke(Color.valueOf("#99cc66"));
        polyline3.setFill(Color.valueOf("#ffcccc"));
        lineBox.getChildren().add(polyline3);

        Polyline polyline4 = new Polyline(points);
        polyline4.setStrokeWidth(2);
        polyline4.setStrokeLineJoin(StrokeLineJoin.ROUND);
        polyline4.setStroke(Color.valueOf("#99cc66"));
        // polyline4.setFill(Color.valueOf("#ffcccc"));
        polyline4.getStrokeDashArray().addAll(10.0, 5.0);// 虚线
        lineBox.getChildren().add(polyline4);
        // 点击四周线段和中间区域有效，如果不设置颜色填充，则点击中间区域无效
        polyline4.setOnMouseClicked(event -> {
            System.out.println("点击了polyline4");
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().add(lineBox);
        AnchorPane.setTopAnchor(lineBox, 100.0);
        AnchorPane.setLeftAnchor(lineBox, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Polyline折线");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
