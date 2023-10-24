package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 组件拖动
 *
 * @author reine
 * 2022/6/1 15:07
 */
public class Main extends Application {
    double sceneOfX = 0;
    double sceneOfY = 0;

    double screenOfX = 0;
    double screenOfY = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        // 背景设置
        String style = "-fx-background-color: pink; -fx-background-radius: 30; -fx-background-insets: 0;" +
                // 边框设置
                "-fx-border-color: white; -fx-border-style: SOLID; -fx-border-width: 20; -fx-border-radius: 30; -fx-border-insets: 0;";

        anchorPane.setStyle(style);
        anchorPane.getChildren().add(button);
        Scene scene = new Scene(anchorPane);
        // 设置背景白色透明
        scene.setFill(Paint.valueOf("#ffffff00"));

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("按钮拖动");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        button.setOnMouseDragged(event -> {
            // 不减则为左上角坐标
            button.setLayoutX(event.getSceneX() - sceneOfX);
            button.setLayoutY(event.getSceneY() - sceneOfY);
        });

        button.setOnAction(event -> primaryStage.close());

        // 获取鼠标在按钮内部的坐标
        button.setOnMousePressed(event -> {
            sceneOfX = event.getX();
            sceneOfY = event.getY();
        });

        // 获得鼠标相对于窗口的坐标
        scene.setOnMousePressed(event -> {
            screenOfX = event.getScreenX() - primaryStage.getX();
            screenOfY = event.getScreenY() - primaryStage.getY();
        });

        scene.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - screenOfX);
            primaryStage.setY(event.getScreenY() - screenOfY);
        });

    }
}
