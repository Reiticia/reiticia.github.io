package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 鼠标事件（点击）阻止事件传递，获取属性
 * @author reine
 * 2022/6/1 6:34
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: yellow;");
        hBox.setLayoutX(100);
        hBox.setLayoutY(100);
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Circle circle = new Circle(50, Color.BLUE);
        // 使其边界内部所有区域都具有事件监听效果
        // circle.setPickOnBounds(true);
        // 阻止事件传递（父传子）
        circle.setMouseTransparent(true);
        hBox.getChildren().addAll(button1,button2,circle);


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("鼠标事件（点击）阻止事件传递，获取属性");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        // 鼠标按下
        button1.setOnMousePressed(event -> {
            System.out.println("鼠标按下");
            // 此次点击位置和上次是否一致
            System.out.println("event.isStillSincePress() = " + event.isStillSincePress());
        });

        // 拖拽检测
        button1.setOnDragDetected(event -> System.out.println("拖拽检测"));

        circle.setOnMouseClicked(event -> System.out.println("circle mouse clicked"));

        // 测试事件传递
        hBox.setOnMouseClicked(event -> {
            System.out.println("hBox mouse clicked");
            // 获取点击属性
            System.out.println("event.getPickResult() = " + event.getPickResult());
        });
    }
}
