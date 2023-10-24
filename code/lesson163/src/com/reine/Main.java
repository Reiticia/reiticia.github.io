package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 21:51
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox lineBox = new HBox();

        // 起点坐标(0,0)->终点坐标(100,100)
        Line line = new Line(0, 0, 100, 100);
        line.setStroke(Color.valueOf("#ff9999"));// 设置线条颜色
        line.setStrokeWidth(5);// 设置线条宽度
        line.setStrokeLineCap(StrokeLineCap.ROUND);// 设置线条端点形状（圆角）
        line.setSmooth(true);// 设置线条平滑
        line.getStrokeDashArray().addAll(5.0, 10.0, 5.0, 20.0);// 设置线条虚线（线段长度，线段距离，线段长度，线段距离……）参数不足则循环使用
        line.setStrokeDashOffset(4);// 设置线条虚线偏移量
        lineBox.getChildren().add(line);
        Line line1 = new Line(0, 0, 100, 0);
        line1.setStroke(Color.valueOf("#996699"));
        line1.setStrokeWidth(5);
        lineBox.getChildren().add(line1);
        Line line2 = new Line(0, 100, 100, 0);
        line2.setStroke(Color.valueOf("#ffcccc"));
        line2.setStrokeWidth(5);
        lineBox.getChildren().add(line2);

        // 当端点形状设置不同时，只有首尾相接才能看出效果
        AnchorPane otherBox = new AnchorPane();
        Line otLine = new Line(0, 0, 100, 0);
        otLine.setStroke(Color.valueOf("#ff9999"));
        otLine.setStrokeWidth(10);
        otLine.setStrokeLineCap(StrokeLineCap.ROUND);
        otherBox.getChildren().add(otLine);
        Line otLine1 = new Line(100, 0, 100, 100);
        otLine1.setStroke(Color.valueOf("#996699"));
        otLine1.setStrokeWidth(10);
        otLine1.setStrokeLineCap(StrokeLineCap.BUTT);// 两条线段之间衔接后会有空隙
        otherBox.getChildren().add(otLine1);
        Line otLine2 = new Line(100, 100, 200, 100);
        otLine2.setStroke(Color.valueOf("#ffcccc"));
        otLine2.setStrokeWidth(10);
        otLine2.setStrokeLineCap(StrokeLineCap.SQUARE);// 默认值
        otherBox.getChildren().add(otLine2);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(/*lineBox,*/ otherBox);
        AnchorPane.setTopAnchor(lineBox, 100.0);
        AnchorPane.setLeftAnchor(lineBox, 100.0);
        AnchorPane.setTopAnchor(otherBox, 300.0);
        AnchorPane.setLeftAnchor(otherBox, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Line线");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
