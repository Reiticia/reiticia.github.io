package com.reine;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 键盘事件（点击）
 * @author reine
 * 2022/5/31 15:26
 */
public class Main extends Application {
    // slider用
    SimpleIntegerProperty iTime = new SimpleIntegerProperty(0);
    // progressBar用
    SimpleDoubleProperty dTime = new SimpleDoubleProperty(0.0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Slider slider = new Slider(0, 100, 0);
        slider.valueProperty().bind(iTime);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0);
        progressBar.progressProperty().bind(dTime);

        HBox hBox = new HBox(10);

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        TextField textField = new TextField();
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.RED);
        hBox.getChildren().addAll(button1, button2, textField, rectangle);

        // 按键按下（多次）
        button1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("event.getCharacter() = " + event.getCharacter());
                // 事件类型
                System.out.println("event.getEventType() = " + event.getEventType());
                // 事件源
                System.out.println("event.getSource() = " + event.getSource());
                // 事件目标
                System.out.println("event.getTarget() = " + event.getTarget());
                // 获得按下的按键名称
                System.out.println("event.getText() = " + event.getText());
                System.out.println("event.isControlDown() = " + event.isControlDown());
                // 判断按下的按键
                if (event.getCode() == KeyCode.SPACE) {
                    if (iTime.get() <= 100) {
                        iTime.set(iTime.get() + 1);
                    }
                    if (dTime.get() <= 1) {
                        dTime.set(dTime.get() + 0.01);
                    }
                }
                System.out.println("按下了" + event.getCode().getName());
            }
        });

        // 按键释放（一次）
        button1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("释放了" + event.getCode().getName());
                if (event.getCode() == KeyCode.SPACE) {
                    iTime.set(0);
                    dTime.set(0);
                }
            }
        });

        // 作用于有输入焦点的组件，如输入框
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("event.getCharacter() = " + event.getCharacter());
            }
        });

        rectangle.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("event.getCode().getName() = " + event.getCode().getName());
                System.out.println("event.getCode().impl_getCode() = " + event.getCode().impl_getCode());
            }
        });
        // 鼠标单击事件使组件获取焦点
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.requestFocus();
            }
        });
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox, slider, progressBar);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("键盘事件（点击）");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        AnchorPane.setTopAnchor(slider, button1.getHeight() + 10);
        AnchorPane.setTopAnchor(progressBar, button1.getHeight() + 10);
        AnchorPane.setLeftAnchor(progressBar, slider.getWidth() + 10);
    }
}
