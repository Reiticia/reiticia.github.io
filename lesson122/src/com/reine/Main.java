package com.reine;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/12 15:15
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("BUTTON1");
        button.setPrefWidth(100);
        button.setPrefHeight(100);
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setTranslateX(-200);

        // 创建位移量
        Translate translate = new Translate(100, 100);
        Translate translate1 = new Translate(100, 100);
        // xy位移取相反数
        System.out.println(translate.createInverse());
        // 在该位移基础上再位移，转换为point2D
        Point2D point2D = translate.transform(50, 50);
        System.out.printf("point2D(%.2f,%.2f)\n", point2D.getX(), point2D.getY());

        // 通过传入的数据，直接转换为point2D
        Point2D point2D1 = translate.deltaTransform(100, 100);
        System.out.printf("point2D1(%.2f,%.2f)\n", point2D1.getX(), point2D1.getY());


        Button button2 = new Button("BUTTON2");
        button2.setPrefWidth(100);
        button2.setPrefHeight(100);
        button2.setLayoutX(100);
        button2.setLayoutY(100);
        // 位移会叠加，位移原点(LayoutX,LayoutY)
        button2.getTransforms().addAll(translate, translate1);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #ff9999;");
        anchorPane.setPrefWidth(400);
        anchorPane.setPrefHeight(400);
        anchorPane.setLayoutX(100);
        anchorPane.setLayoutY(100);
        anchorPane.getChildren().addAll(button, button2);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(anchorPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Translate位移");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button2.setOnAction(event -> {
            // 获取组件相对与父组件的位移量 ，输出的结果是变换后的
            System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", button2.getLocalToParentTransform().getTx(), button2.getLocalToParentTransform().getTy());
            // 获取组件相对与场景的位移量
            System.out.printf("相对于场景的坐标：(%.2f,%.2f)\n", button2.getLocalToSceneTransform().getTx(), button2.getLocalToSceneTransform().getTy());

            Bounds bounds = button2.getLayoutBounds();
            Bounds localToParent = button2.localToParent(bounds);
            System.out.printf("相对于父组件的坐标：(%.2f,%.2f)\n", localToParent.getMinX(), localToParent.getMinY());
            Bounds localToScreen = button2.localToScreen(bounds);
            System.out.printf("相对于屏幕的坐标：(%.2f,%.2f)\n", localToScreen.getMinX(), localToScreen.getMinY());
        });

    }
}
