package com.reine;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/12 20:01
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 以组件(100,100)的位置为中心，顺时针旋转45°
        // Rotate rotate = new Rotate(45, 100, 100);
        // 以组件(0,0)的位置为中心(即左上角)，逆时针旋转45°
        Rotate rotate = new Rotate(-45, 0, 0);

        Button button1 = new Button("button1");
        button1.setPrefWidth(200);
        button1.setPrefHeight(200);

        Button button2 = new Button("button2");
        button2.setStyle("-fx-background-color: #ff9999;");
        button2.setPrefWidth(200);
        button2.setPrefHeight(200);
        // 设置旋转
        // button2.getTransforms().add(rotate);
        button2.setRotate(45);
        AnchorPane root = new AnchorPane();
        // 以组件中心点为中心，旋转45°
        // root.setRotate(45);
        root.getChildren().addAll(button1, button2);
        AnchorPane.setTopAnchor(button1, 100.0);
        AnchorPane.setLeftAnchor(button1, 100.0);
        AnchorPane.setTopAnchor(button2, 100.0);
        AnchorPane.setLeftAnchor(button2, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotate旋转");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button2.setOnAction(event -> {
            // 输出原始组件的宽高
            System.out.println(button2.getPrefWidth());
            System.out.println(button2.getPrefHeight());
            // 获取组件相对与父组件的位移量，获取到的是原始组件左上角变换后的坐标
            System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());
            Bounds bounds = button2.getLayoutBounds();
            Bounds localToParent = button2.localToParent(bounds);
            // 输出目视宽高
            System.out.println("宽度：" + localToParent.getWidth());
            System.out.println("高度：" + localToParent.getHeight());
            // 输出边框坐标
            System.out.printf("右下角边框相对于自身坐标为(%.2f,%.2f)\n", localToParent.getMaxX() - localToParent.getMinX(), localToParent.getMaxY() - localToParent.getMinY());

        });
    }
}
