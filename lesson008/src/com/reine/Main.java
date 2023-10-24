package com.reine;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Group容器的使用
 * @author reine
 * 2022/5/11 21:22
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("btn0");
        // 设置按钮在布局中的位置
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setPrefWidth(100);
        button.setPrefHeight(100);
        Button button1 = new Button("btn1");
        // 设置按钮在布局中的位置
        button1.setLayoutX(100);
        button1.setLayoutY(150);
        button1.setPrefWidth(100);
        button1.setPrefHeight(100);
        Button button2 = new Button("btn2");
        // 设置按钮在布局中的位置
        button2.setLayoutX(100);
        button2.setLayoutY(200);
        button2.setPrefWidth(100);
        button2.setPrefHeight(100);

        Group group = new Group();
        group.getChildren().addAll(button, button1, button2);
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println(c.getList().size());
            }
        });
        group.getChildren().remove(button);
        group.getChildren().removeAll(button1, button2);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Group容器的使用");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();
    }
}
