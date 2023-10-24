package com.reine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 鼠标事件（拖拽）
 *
 * @author reine
 * 2022/5/31 21:49
 */
public class Main extends Application {
    int dragTime = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(10);
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        // button2.setDisable(true);
        hBox.setLayoutX(100);
        hBox.setLayoutY(100);
        hBox.getChildren().addAll(button1, button2);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("鼠标事件（拖拽）");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        // 鼠标拖拽（在button1上点击(左中右键)后进行拖拽，拖拽区域没有限制）
        button1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // System.out.println("鼠标拖拽，次数：" + (++dragTime));
            }
        });

        // 鼠标拖拽（当鼠标指针移除组件时，事件不会被触发）
        button1.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                // System.out.println("在组件内拖动，次数：" + (++dragTime) );
            }
        });

        // 拖拽检测（每次按下鼠标按键进行拖动，会触发事件，直到松开按键重新按下才会重新监听）
        button1.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // 设置全套拖拽动作，以触发组件内鼠标拖拽事件、鼠标拖拽进入、鼠标拖拽退出、鼠标拖拽释放事件
                button1.startFullDrag();
                System.out.println("拖拽检测，次数：" + (++dragTime));
            }
        });
        // 拖拽进入
        button1.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("拖拽进入");
            }
        });
        // 拖拽退出
        button1.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("拖拽退出");
            }
        });
        // 拖拽释放
        button1.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("拖拽释放");
            }
        });

        // 重置计数器
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dragTime = 0;
            }
        });

        /* 证明：在button1上开始拖拽，一直拖拽到button2上，依此触发button1拖拽进入->button1拖拽退出->button2拖拽进入，但只给button1设置了完整拖拽动作  */
        button2.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("拖拽进入Button2");
                // System.out.println("event.getSource() = " + event.getSource());
                // System.out.println("event.getTarget() = " + event.getTarget());

            }
        });

        button2.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                // 手势源
                System.out.println("event.getGestureSource() = " + event.getGestureSource());
                System.out.println("event.getSource() = " + event.getSource());
                System.out.println("event.getTarget() = " + event.getTarget());
            }
        });

    }
}
