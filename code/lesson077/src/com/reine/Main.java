package com.reine;

import com.reine.event.MyEventHandler;
import com.reine.utils.ConsoleColor;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/1 8:54
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: pink;");
        hBox.setAlignment(Pos.CENTER);
        hBox.setLayoutX(100);
        hBox.setLayoutY(100);
        hBox.setPrefWidth(400);
        hBox.setPrefHeight(400);
        Button button = new Button("button");
        Label label = new Label("Hello World");
        label.setFont(new Font(20));
        label.setStyle("-fx-background-color: lightyellow;");
        hBox.getChildren().addAll(button, label);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: skyblue;");
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("事件传递和事件冒泡");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        MyEventHandler hBoxHandler = new MyEventHandler(ConsoleColor.YELLOW);
        MyEventHandler anchorPaneHandler = new MyEventHandler(ConsoleColor.RED);
        MyEventHandler sceneHandler = new MyEventHandler(ConsoleColor.GREEN);
        MyEventHandler stageHandler = new MyEventHandler(ConsoleColor.CYAN);

        // 监听鼠标点击事件，参数1为事件类型（键鼠事件）
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.print(ConsoleColor.BLUE);
            System.out.println("event.getEventType() = " + event.getEventType());
            System.out.println("event.getSource() = " + event.getSource());
            System.out.println("event.getTarget() = " + event.getTarget());
            System.out.print(ConsoleColor.RESET);
        });

        // 验证调用顺序，由父到子（事件传递）
        // hBox.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
        //     System.out.print(ConsoleColor.YELLOW);
        //     System.out.println("event.getEventType() = " + event.getEventType());
        //     System.out.println("event.getSource() = " + event.getSource());
        //     System.out.println("event.getTarget() = " + event.getTarget());
        //     System.out.print(ConsoleColor.RESET);
        //     // 阻止事件传递
        //     // event.consume();
        // });
        // anchorPane.addEventFilter(MouseEvent.MOUSE_CLICKED, anchorPaneHandler);
        // scene.addEventFilter(MouseEvent.MOUSE_CLICKED, sceneHandler);
        // primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, stageHandler);

        // ---------------------------------------------------------------------------------------

        label.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.print(ConsoleColor.BLUE);
            System.out.println("event.getEventType() = " + event.getEventType());
            System.out.println("event.getSource() = " + event.getSource());
            System.out.println("event.getTarget() = " + event.getTarget());
            System.out.print(ConsoleColor.RESET);
            // 阻止事件冒泡
            event.consume();
            System.out.println("event.isConsumed() = " + event.isConsumed());
        });
        // 验证调用顺序，由子到父（事件冒泡）
        hBox.addEventHandler(MouseEvent.MOUSE_CLICKED, hBoxHandler);
        anchorPane.addEventHandler(MouseEvent.MOUSE_CLICKED, anchorPaneHandler);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, sceneHandler);
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, stageHandler);

        // button本身无法进行事件冒泡
        // button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        //     @Override
        //     public void handle(MouseEvent event) {
        //         System.out.println("button.addEventHandler");
        //         // 手动传递
        //         Event.fireEvent(hBox, event);
        //     }
        // });

        // 验证先执行addEventHandler再执行setOnMouseClicked，setOnMouseClicked的底层实现方式为addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent);
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("label.setOnMouseClicked");
            }
        });

    }
}
