package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 判断两个组件之间是否接触到
 * @author reine
 * 2022/5/21 16:59
 */
public class Main2 extends Application {

    double x = 0;
    double y = 0;
    int times = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        Button button1 = new Button("btn1");
        Button button2 = new Button("btn2");

        AnchorPane.setTopAnchor(button2, 100.0);
        AnchorPane.setLeftAnchor(button2, 100.0);
        anchorPane.getChildren().addAll(button2, button1);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("判断两个组件之间是否接触到");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        Bounds bounds2 = button2.getLayoutBounds();
        // 获取控件左上角在父组件内的坐标
        // button2左上角坐标
        Point2D point2DMin2 = button2.localToParent(bounds2.getMinX(), bounds2.getMinY());
        // button2右下角坐标
        Point2D point2DMax2 = button2.localToParent(bounds2.getMaxX(), bounds2.getMaxY());

        System.out.println("point2DMin2 = " + point2DMin2);
        System.out.println("point2DMax2 = " + point2DMax2);

        Bounds bounds1 = button1.getLayoutBounds();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            // Button1左上角坐标
            Point2D point2DMin1 = null;
            // Button1右下角坐标
            Point2D point2DMax1 = null;

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.D) {
                    x += 10.0;
                    button1.setLayoutX(x);
                } else if (event.getCode() == KeyCode.A) {
                    x -= 10.0;
                    button1.setLayoutX(x);
                } else if (event.getCode() == KeyCode.W) {
                    y -= 10.0;
                    button1.setLayoutY(y);
                } else if (event.getCode() == KeyCode.S) {
                    y += 10.0;
                    button1.setLayoutY(y);
                }
                point2DMin1 = button1.localToParent(bounds1.getMinX(), bounds1.getMinY());
                point2DMax1 = button1.localToParent(bounds1.getMaxX(), bounds1.getMaxY());
                // 左上角小于右下角并且右下角大于左上角
                if (point2DMin1.getX() <= point2DMax2.getX() && point2DMin1.getY() <= point2DMax2.getY() && point2DMax1.getX() >= point2DMin2.getX() && point2DMax1.getY() >= point2DMin2.getY()) {
                    System.out.println("Button1 与 Button2 接触" + times++);
                }
            }
        });
    }
}
