package com.reine;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/12 17:15
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        /* 缩放，将x轴长度缩小为原来的0.5，将y轴长度缩小为原来的0.5
         * 缩放操作执行后左上角坐标为(pivotX*x, pivotY*y)
         * */
        Scale scale = new Scale(0.5, 0.5, 100, 100);
        Scale scale1 = new Scale(2, 2, 100, 100);

        // xy缩放比例取倒数
        Scale inverse = scale.createInverse();

        Point2D point2D = scale.transform(0.5, 0.5);
        System.out.printf("point2D(%.2f,%.2f)\n", point2D.getX(), point2D.getY());

        Button button1 = new Button("button1");
        button1.setPrefWidth(200);
        button1.setPrefHeight(200);

        Button button2 = new Button("button2");
        button2.setStyle("-fx-background-color: #ff9999;");
        button2.setPrefWidth(200);
        button2.setPrefHeight(200);
        // 缩放2次
        button2.getTransforms().addAll(scale);
        // 以原组件中心点向四周进行缩放，x轴，y轴各缩小0.5倍，
        // button2.setScaleX(0.5);
        // button2.setScaleY(0.8);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button1, button2);
        // AnchorPane.setTopAnchor(button1, 100.0);
        // AnchorPane.setLeftAnchor(button1, 100.0);
        // AnchorPane.setTopAnchor(button2, 100.0);
        // AnchorPane.setLeftAnchor(button2, 100.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scale缩放");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button2.setOnAction(event -> {
            // 输出原始组件的宽高
            System.out.println(button2.getPrefWidth());
            System.out.println(button2.getPrefHeight());
            // 获取组件相对与父组件的位移量 ，输出的结果是变换后的
            System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());

            Bounds bounds = button2.getLayoutBounds();
            Bounds localToParent = button2.localToParent(bounds);
            // 输出目视宽高
            System.out.println("宽度：" + localToParent.getWidth());
            System.out.println("高度：" + localToParent.getHeight());
        });
    }
}
