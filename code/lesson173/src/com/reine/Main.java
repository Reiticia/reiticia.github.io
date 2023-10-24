package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 8:40
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Circle circle = new Circle(0, 0, 100);
        ImageView imageView = new ImageView("file:E://Users//86158//图片//110300202.jpg");
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(400);
        imageView.setClip(circle);// 裁切图片

        Circle cir = new Circle(100);
        cir.setFill(Color.RED);
        cir.setCenterX(100);
        cir.setCenterY(100);
        cir.setStroke(Color.BLACK);
        cir.setStrokeWidth(5);
        cir.getStrokeDashArray().addAll(10d, 10d);
        Rectangle rectangle = new Rectangle(200, 100);
        rectangle.setFill(Color.BLUE);
        rectangle.setX(100);
        rectangle.setY(50);
        Shape shape = Shape.intersect(cir, rectangle);// 取交集，如果原来的图形有边框，则获得的图形对应位置会有原来图形的边框
        shape.setFill(Color.GREEN);
        Shape shape1 = Shape.subtract(cir, rectangle);// 取差集，如果原来的图形有边框，则获得的图形对应位置会有原来图形的边框
        shape1.setFill(Color.GREEN);
        Shape shape2 = Shape.union(cir, rectangle);// 取并集，如果原来的图形有边框，则获得的图形对应位置会有原来图形的边框
        shape2.setFill(Color.GREEN);

        HBox root = new HBox();
        root.getChildren().addAll(imageView, shape, shape1, shape2);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - 图形计算");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
