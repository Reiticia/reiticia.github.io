package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.Stage;

/**
 * 文本框、密码框、标签
 * @author reine
 * 2022/5/12 9:34
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("文本框、密码框、标签");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        Group group = new Group();
        Scene scene = new Scene(group);
        // 创建输入框
        TextField textField = new TextField();
        textField.setPrefWidth(200);
        textField.setPrefHeight(30);
        textField.setLayoutX(primaryStage.getWidth() / 2 - textField.getPrefWidth() / 2);
        textField.setLayoutY(primaryStage.getHeight() / 2 - textField.getPrefHeight() / 2);

        // 设置提示
        // textField.setTooltip(new Tooltip("这是一个输入框"));
        textField.setPromptText("请输入7个字符");
        textField.setFocusTraversable(false);

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 7) {
                    textField.setText(oldValue);
                }
            }
        });

        textField.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        // 创建密码框
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("请输入7个字符");
        passwordField.setFocusTraversable(false);

        // 创建标签
        Label label = new Label("I'm a label");
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("label clicked");
            }
        });
        group.getChildren().add(passwordField);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

