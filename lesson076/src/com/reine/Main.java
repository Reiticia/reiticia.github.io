package com.reine;

import com.reine.event.MyEvent;
import com.reine.utils.ConsoleColor;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 事件触发
 *
 * @author reine
 * 2022/6/1 7:10
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
        Text text = new Text("hello world");
        hBox.getChildren().addAll(button1, button2, circle);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("事件触发");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        MyEvent myEvent = new MyEvent(text);

        button1.setOnMouseClicked(event -> {
            System.out.println("button1.setOnMouseClicked");
            // 触发组件的响应事件
            Event.fireEvent(text, myEvent);

            KeyEvent keyEvent = new KeyEvent(button2, button2, KeyEvent.KEY_PRESSED, "a", "a", KeyCode.A, false, false, false, false);
            Event.fireEvent(button2, keyEvent);

            // 事件拷贝
            MouseEvent mouseEvent = event.copyFor(button2, button2);
            // 重新指定事件类型（鼠标拖动）
            MouseEvent mouseEvent1 = event.copyFor(button2, button2, MouseEvent.MOUSE_DRAGGED);
            Event.fireEvent(button2, mouseEvent1);
        });

        button2.setOnMouseClicked(event -> System.out.println("button2.setOnMouseClicked"));

        button2.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.A)) {
                System.out.println("button2 pressed A on KeyBoard");
            } else {
                System.out.println("button2 pressed other");
            }
        });

        button2.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("button2.setOnMouseDragged");
            }
        });

        text.setOnMouseClicked(myEvent);
    }
}

// 自定义事件
