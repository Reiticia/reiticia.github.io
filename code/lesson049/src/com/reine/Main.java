package com.reine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ScrollBar滚动条
 * @author reine
 * 2022/5/21 13:14
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        Button button = new Button("button");
        button.setLayoutX(300);

        VBox vBox = new VBox(10);
        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("btn" + i));
        }
        ScrollBar scrollBar = new ScrollBar();
        // 设置方向：垂直
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setLayoutX(100);
        // 滚动条长度
        scrollBar.setVisibleAmount(50);
        // 设置初始滚动距离
        scrollBar.setValue(20);
        // 设置滚动条宽度
        // scrollBar.setPrefWidth(100);

        anchorPane.getChildren().addAll(vBox, scrollBar, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ScrollBar滚动条");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        scrollBar.setPrefHeight(vBox.getHeight());
        // 设置最大值，不设置默认为100
        scrollBar.setMax(vBox.getHeight());
        // 点击上下箭头每次滚动10
        scrollBar.setUnitIncrement(10);
        // 点击滚动条空白区域每次滚动100
        scrollBar.setBlockIncrement(100);

        // 属性监听
        scrollBar.valueProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        }));

        button.setOnAction(event -> {
            // scrollBar.increment();// 向下滚动
            scrollBar.decrement();// 向上滚动
        });
    }
}
