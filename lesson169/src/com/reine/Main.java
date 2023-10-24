package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 16:10
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);

        double[] points = {
                0.0, 0.0,
                100.0, 0.0,
                100.0, 100.0
        };// 三个点坐标
        Polygon polygon = new Polygon(points);
        box.getChildren().add(polygon);

        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(0.0, 0.0, 100.0, 0.0, 100.0, 100.0, 0.0, 100.0);
        box.getChildren().add(polygon1);

        double[] points2 = {
                0.0, 0.0,
                100.0, 0.0,
                100.0, 100.0,
                200.0, 150.0,
                100.0, 200.0
        };
        Polygon polygon2 = new Polygon(points2);
        polygon2.setFill(Color.valueOf("#ff9999"));
        polygon2.setStrokeWidth(3);
        polygon2.setStroke(Color.valueOf("#996699"));
        polygon2.getStrokeDashArray().addAll(10.0, 10.0);
        box.getChildren().add(polygon2);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Polygon多边形");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
