package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * SplitPane 分割面板
 * @author reine
 * 2022/5/20 13:25
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:orange;");

        // 创建4个按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");

        SplitPane splitPane = new SplitPane(); // 创建一个分割面板
        splitPane.setPrefWidth(800);
        splitPane.setPrefHeight(800);

        // 创建4个StackPane
        StackPane stackPane1 = new StackPane();// 创建一个堆栈面板
        stackPane1.setMinWidth(100);
        splitPane.setMaxWidth(200);
        stackPane1.getChildren().add(button1);

        StackPane stackPane2 = new StackPane();
        stackPane2.setStyle("-fx-background-color:blue;");
        stackPane2.getChildren().add(button2);

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().add(button3);

        StackPane stackPane4 = new StackPane();
        stackPane4.getChildren().add(button4);

        splitPane.getItems().addAll(stackPane1, stackPane2, stackPane3, stackPane4);
        // splitPane.setOrientation(Orientation.VERTICAL);// 设置为垂直方向
        splitPane.setDividerPosition(0,0.25);// 设置分割位置
        splitPane.setDividerPosition(1,0.5);// 设置分割位置
        splitPane.setDividerPosition(2,0.75);// 设置分割位置
        splitPane.setDividerPosition(3,1.0);// 设置分割位置

        anchorPane.getChildren().add(splitPane);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SplitPane 分割面板");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
