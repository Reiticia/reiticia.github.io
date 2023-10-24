package com.reine;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 关于坐标
 *
 * @author reine
 * 2022/5/21 16:59
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        Button button = new Button("btn");

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color:lightgreen;");
        hBox.setPrefWidth(200);
        hBox.setPrefHeight(200);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button);

        anchorPane.getChildren().addAll(hBox);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("关于坐标");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 获得控件左上角在父组件内的坐标
        System.out.println("button.getLayoutX() = " + button.getLayoutX());
        System.out.println("button.getLayoutY() = " + button.getLayoutY());

        // 相较于本身坐标系的坐标
        Bounds bounds = button.getLayoutBounds();
        System.out.println("左上角坐标：(" + bounds.getMinX() + "," + bounds.getMinY() + ")");
        System.out.println("右下角坐标：(" + bounds.getMaxX() + "," + bounds.getMaxY() + ")");
        System.out.println("宽度：" + bounds.getWidth());
        System.out.println("高度：" + bounds.getHeight());

        // 将坐标转换为相对于父组件的坐标
        Point2D point1 = button.localToParent(bounds.getMinX(), bounds.getMinY());
        System.out.println("在父组件中按钮的左上角坐标为 " + point1);

        // 将坐标转换为相对于整个场景的坐标
        Point2D point2 = button.localToScene(bounds.getMinX(), bounds.getMinY());
        System.out.println("在整个场景中按钮的左上角坐标为 " + point2);

        // 将坐标转换为相对于整个屏幕的坐标
        Point2D point3 = button.localToScreen(bounds.getMinX(), bounds.getMinY());
        System.out.println("在整个屏幕中按钮的左上角坐标为 " + point3);

        // 将相对于父组件的坐标转换为相对于本身的右下角坐标
        Point2D point4 = button.parentToLocal(point1.getX(), point1.getY());
        System.out.println("在按钮中按钮的右下角坐标为 " + "(" + (point4.getX() + button.getWidth()) + "," + (point4.getY() + button.getHeight()) + ")");

        // 将相对于整个场景的坐标转换为相对于本身的右下角坐标
        Point2D point5 = button.sceneToLocal(point2.getX(), point2.getY());
        System.out.println("在按钮中按钮的右下角坐标为 " + "(" + (point5.getX() + button.getWidth()) + "," + (point5.getY() + button.getHeight()) + ")");

        // 判断是否包含某个点
        System.out.println("bounds.contains(10, 10) = " + bounds.contains(10, 10));
    }
}
