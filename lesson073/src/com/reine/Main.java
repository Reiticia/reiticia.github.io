package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 鼠标事件（点击）
 *
 * @author reine
 * 2022/5/31 20:02
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(10);
        Button button1 = new Button("button1");
        button1.setGraphic(new Button("btn1"));
        Button button2 = new Button("button2");
        // button2.setDisable(true);
        hBox.setLayoutX(100);
        hBox.setLayoutY(100);
        hBox.getChildren().addAll(button1, button2);

        // 鼠标点击事件
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // 获取相对于场景的鼠标指针坐标
                System.out.println("event.getSceneX() = " + event.getSceneX());
                System.out.println("event.getSceneX() = " + event.getSceneX());
                // 获取相对于整个屏幕的鼠标指针坐标
                System.out.println("event.getScreenX() = " + event.getScreenX());
                System.out.println("event.getScreenY() = " + event.getScreenY());
                // 获取相对于该组件内部的鼠标指针坐标
                System.out.println("event.getX() = " + event.getX());
                System.out.println("event.getY() = " + event.getY());
                // 事件源（事件发起者）
                System.out.println("event.getSource() = " + event.getSource());
                // 事件目标（点击的区域，一般是事件源或者事件源内部的组件）
                System.out.println("event.getTarget() = " + event.getTarget());
                // 事件类型
                System.out.println("event.getEventType() = " + event.getEventType());
                // 获取点击的按键
                System.out.println("event.getButton() = " + event.getButton());
                // 是否按下CTRL
                System.out.println("event.isControlDown() = " + event.isControlDown());
                // 连续点击次数
                System.out.println("event.getClickCount() = " + event.getClickCount());
                // 鼠标右键是否按下（先长按鼠标右键，然后同时单击鼠标左键（按下并释放），打印true）
                System.out.println("鼠标右键是否按下 = " + event.isSecondaryButtonDown());

                if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                    System.out.println("双击鼠标左键");
                }
            }
        });
        // 鼠标按下
        button1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标按下");
            }
        });

        // 鼠标释放
        button1.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标释放");
            }
        });

        // 鼠标进入
        button1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("event.getX() = " + event.getX());
                System.out.println("event.getY() = " + event.getY());
                System.out.println("鼠标进入");
            }
        });

        // 鼠标退出
        button1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标退出");
            }
        });

        // 鼠标移动
        button2.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标移动");
            }
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("鼠标事件（点击）");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
