package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 11:26
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox box = new HBox();
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(0);
        ellipse.setCenterY(0);
        ellipse.setFill(Color.valueOf("#ff9999"));
        ellipse.setRadiusX(100);// 横半径
        ellipse.setRadiusY(50);// 纵半径
        box.getChildren().add(ellipse);

        Ellipse ellipse1 = new Ellipse();
        ellipse1.setCenterX(0);
        ellipse1.setCenterY(0);
        ellipse1.setFill(Color.valueOf("#ff9999"));
        ellipse1.setRadiusX(50);// 横半径
        ellipse1.setRadiusY(100);// 纵半径
        ellipse1.setStrokeWidth(10);
        ellipse1.setStroke(Color.valueOf("#996699"));
        ellipse1.setSmooth(true);// 平滑
        box.getChildren().add(ellipse1);

        Ellipse ellipse2 = new Ellipse();
        ellipse2.setCenterX(0);
        ellipse2.setCenterY(0);
        ellipse2.setFill(Color.valueOf("#ff9999"));
        ellipse2.setRadiusX(50);// 横半径
        ellipse2.setRadiusY(100);// 纵半径
        ellipse2.setStrokeWidth(3);
        ellipse2.setStroke(Color.valueOf("#996699"));
        ellipse2.setSmooth(true);// 平滑
        ellipse2.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
        box.getChildren().add(ellipse2);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Ellipse椭圆形");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
