package com.reine;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/13 8:39
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("button1");
        button1.setPrefWidth(200);
        button1.setPrefHeight(100);

        Button button2 = new Button("button2");
        button2.setStyle("-fx-background-color: #ff9999;");
        button2.setPrefWidth(200);
        button2.setPrefHeight(100);
        button2.setOpacity(0.5);
        // 上下颠倒，通过负数设置是否翻转
        Scale scale = new Scale(1, -1, 100, 50);
        Translate translate = new Translate(0, 100);
        // 效果叠加：先上下翻转（坐标系也翻转），再沿y轴平移100（由于坐标系翻转，故原本的向下移动变成向上移动）
        // button2.getTransforms().addAll(scale, translate);

        Translate translate1 = new Translate(0, -100);
        // button2.getTransforms().addAll(scale, translate1);

        Scale scale1 = new Scale(1.5, 1.5, 100, 50);
        button2.getTransforms().addAll(scale1);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button1, button2);

        AnchorPane.setTopAnchor(button1, 100.0);
        AnchorPane.setLeftAnchor(button1, 100.0);
        AnchorPane.setTopAnchor(button2, 100.0);
        AnchorPane.setLeftAnchor(button2, 100.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Affine仿射");
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
