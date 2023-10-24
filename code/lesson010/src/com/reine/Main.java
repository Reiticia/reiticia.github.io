package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Button按钮事件触发
 * @author reine
 * 2022/5/12 8:29
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button();
        button.setText("btn0");
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setPrefWidth(100);
        button.setPrefHeight(50);

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getButton().name());
                System.out.println("鼠标单击事件");
                if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
                    System.out.println("鼠标双击事件");
                }
            }
        });

        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("按下：" + event.getCode().name());
                if (event.getCode().equals(KeyCode.ENTER)) {
                    System.out.println("按下ENTER键");
                }
            }
        });

        button.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("释放：" + event.getCode().name());
            }
        });

        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button按钮事件触发");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();

    }
}
