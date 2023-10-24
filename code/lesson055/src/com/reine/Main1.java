package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 单向绑定实现按钮大小随界面大小改变而改变
 * @author reine
 * 2022/5/23 8:16
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: pink;");

        Button button = new Button("button");

        anchorPane.getChildren().add(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("单向绑定实现按钮大小随界面大小改变而改变");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 单向绑定（使用prefWidthProperty，而不是widthProperty）
        button.prefWidthProperty().bind(anchorPane.widthProperty());
        button.prefHeightProperty().bind(anchorPane.heightProperty());
    }
}
