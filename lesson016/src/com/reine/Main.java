package com.reine;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * BorderPane 方位布局
 * @author reine
 * 2022/5/12 14:28
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建5个AnchorPane布局，并设置不同颜色，并设置相同大小
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setStyle("-fx-background-color: red;");
        anchorPane1.setPrefWidth(100);
        anchorPane1.setPrefHeight(100);
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setStyle("-fx-background-color: green;");
        anchorPane2.setPrefWidth(100);
        anchorPane2.setPrefHeight(100);
        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setStyle("-fx-background-color: blue;");
        anchorPane3.setPrefWidth(100);
        anchorPane3.setPrefHeight(100);
        AnchorPane anchorPane4 = new AnchorPane();
        anchorPane4.setStyle("-fx-background-color: yellow;");
        anchorPane4.setPrefWidth(100);
        anchorPane4.setPrefHeight(100);
        AnchorPane anchorPane5 = new AnchorPane();
        anchorPane5.setStyle("-fx-background-color: pink;");
        anchorPane5.setPrefWidth(100);
        anchorPane5.setPrefHeight(100);
        // 创建一个BorderPane方位布局
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color:#1899c0;");
        pane.setTop(anchorPane1);
        pane.setLeft(anchorPane2);
        pane.setRight(anchorPane3);
        pane.setBottom(anchorPane4);
        pane.setCenter(anchorPane5);
        pane.setPadding(new Insets(10));
        BorderPane.setMargin(anchorPane1, new Insets(10));
        System.out.println(pane.getTop());
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("BorderPane 方位布局");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}
