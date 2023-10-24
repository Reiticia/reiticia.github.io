package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 17:08
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(200, 200);
        anchorPane.setStyle("-fx-background-color: #ff9999");
        QuadCurve quadCurve = new QuadCurve();
        // 起点坐标
        quadCurve.setStartX(0);
        quadCurve.setStartY(100);
        // 终点坐标
        quadCurve.setEndX(200);
        quadCurve.setEndY(100);
        // 控制点坐标
        quadCurve.setControlX(100);
        quadCurve.setControlY(0);
        // quadCurve.setFill(Color.valueOf("#996699"));
        quadCurve.setFill(Color.TRANSPARENT);// 填充颜色：透明
        quadCurve.setStrokeWidth(3);// 边框宽度
        quadCurve.setStroke(Color.valueOf("#ffcccc"));// 边框颜色
        quadCurve.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
        anchorPane.getChildren().add(quadCurve);
        box.getChildren().add(anchorPane);

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(200, 200);
        anchorPane1.setStyle("-fx-background-color: #ff9999");
        QuadCurve quadCurve1 = new QuadCurve();
        // 起点坐标
        quadCurve1.setStartX(0);
        quadCurve1.setStartY(100);
        // 终点坐标
        quadCurve1.setEndX(200);
        quadCurve1.setEndY(100);
        // 控制点坐标
        quadCurve1.setControlX(50);
        quadCurve1.setControlY(150);
        // quadCurve1.setFill(Color.valueOf("#996699"));
        quadCurve1.setFill(Color.TRANSPARENT);// 填充颜色：透明
        quadCurve1.setStrokeWidth(3);// 边框宽度
        quadCurve1.setStroke(Color.valueOf("#ffcccc"));// 边框颜色
        quadCurve1.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
        anchorPane1.getChildren().add(quadCurve1);
        box.getChildren().add(anchorPane1);

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(200, 200);
        anchorPane2.setStyle("-fx-background-color: #ff9999");
        CubicCurve cubicCurve = new CubicCurve();
        // 起点坐标
        cubicCurve.setStartX(0);
        cubicCurve.setStartY(100);
        // 终点坐标
        cubicCurve.setEndX(200);
        cubicCurve.setEndY(100);
        // 控制点坐标
        cubicCurve.setControlX1(50);
        cubicCurve.setControlY1(0);
        cubicCurve.setControlX2(150);
        cubicCurve.setControlY2(200);
        // cubicCurve.setFill(Color.valueOf("#996699"));
        cubicCurve.setFill(Color.TRANSPARENT);// 填充颜色：透明
        cubicCurve.setStrokeWidth(3);// 边框宽度
        cubicCurve.setStroke(Color.valueOf("#ffcccc"));// 边框颜色
        cubicCurve.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
        anchorPane2.getChildren().add(cubicCurve);
        box.getChildren().add(anchorPane2);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - QuadCurve二次曲线方程&CubicCurve三次曲线方程");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
