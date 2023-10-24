package com.reine;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/12 21:57
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 设置变形
        /*
         * x1和y1是不动点对角线的组件局部坐标
         * x1 = 200, y1 = 100
         * x2 = pivotX + (x1 - pivotX) + x * (y1 - pivotY) = 250
         * y2 = pivotY + (y1 - pivotY) + y * (x1 - pivotX) = 200
         * 变换后不动点对角线的组件局部坐标(250,200)
         *
         * */
        Shear shear = new Shear(0.5, 0.5, 0, 0);
        // Shear shear = new Shear(0.5, 0.5, 200, 100);

        Button button1 = new Button("button1");
        button1.setPrefWidth(200);
        button1.setPrefHeight(100);

        Button button2 = new Button("button2");
        button2.setStyle("-fx-background-color: #ff9999;");
        button2.setPrefWidth(200);
        button2.setPrefHeight(100);
        button2.setOpacity(0.5);

        Button button3 = new Button("button3");
        button3.setPrefWidth(200);
        button3.setPrefHeight(100);
        button2.getTransforms().add(shear);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button1, button2, button3);

        AnchorPane.setTopAnchor(button1, 100.0);
        AnchorPane.setLeftAnchor(button1, 100.0);
        AnchorPane.setTopAnchor(button2, 100.0);
        AnchorPane.setLeftAnchor(button2, 100.0);
        AnchorPane.setTopAnchor(button3, 300.0);
        AnchorPane.setLeftAnchor(button3, 350.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shear斜切");
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
