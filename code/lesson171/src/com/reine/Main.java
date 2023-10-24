package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 19:34
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox box = new HBox(10);

        Path path = new Path();
        // 起点
        MoveTo moveTo = new MoveTo(0, 0);
        // 沿直线移动到(100,0)
        LineTo lineTo = new LineTo(100, 0);
        // 二次曲线
        QuadCurveTo quadCurveTo = new QuadCurveTo(50, 0, 100, 100);
        quadCurveTo.setAbsolute(false);// 设置为相对路径，则以(100,0)为起点
        // 水平线
        HLineTo hLineTo = new HLineTo(100);
        hLineTo.setAbsolute(false);// 设置为相对路径，则以(100,100)为起点
        // 三次曲线
        CubicCurveTo cubicCurveTo = new CubicCurveTo(50, -50, 150, 100, 200, 0);
        cubicCurveTo.setAbsolute(false);// 设置为相对路径，则以(300,100)为起点
        // 垂直线
        VLineTo vLineTo = new VLineTo(-100);
        vLineTo.setAbsolute(false);// 设置为相对路径，则以(500,100)为起点
        // 弧线
        ArcTo arcTo = new ArcTo(100, 100, 0, 100, 100, true, true);
        arcTo.setAbsolute(false);// 设置为相对路径，则以(500,0)为起点
        // 闭合
        ClosePath closePath = new ClosePath();
        path.setFill(Color.valueOf("#ff9999"));// 设置填充颜色
        path.setStroke(Color.valueOf("#996699"));// 设置边框颜色
        path.setStrokeWidth(5);// 设置边框宽度
        path.setStrokeLineJoin(StrokeLineJoin.ROUND);// 设置边框连接点为圆角
        // path.getStrokeDashArray().addAll(10d, 10d);// 设置边框虚线
        // 添加的元素可以重复使用
        path.getElements().addAll(moveTo, lineTo, quadCurveTo, hLineTo, cubicCurveTo, vLineTo, arcTo, closePath);
        box.getChildren().add(path);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 50.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Path路径");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
