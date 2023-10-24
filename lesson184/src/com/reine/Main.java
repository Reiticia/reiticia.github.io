package com.reine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/19 14:02
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleButton play = new ToggleButton("play");
        ToggleButton pause = new ToggleButton("pause");
        ToggleButton stop = new ToggleButton("stop");
        ToggleButton action = new ToggleButton("action");
        ToggleButton print = new ToggleButton("print");
        ToggleGroup toggleGroup = new ToggleGroup();
        play.setToggleGroup(toggleGroup);
        pause.setToggleGroup(toggleGroup);
        stop.setToggleGroup(toggleGroup);
        action.setToggleGroup(toggleGroup);
        print.setToggleGroup(toggleGroup);
        HBox hBox = new HBox(30);
        hBox.getChildren().addAll(play, pause, stop, action, print);
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setStyle("-fx-fill: linear-gradient(from 0.0% 0.0% to 100.0% 0.0%, #7ee8ecff 0.0%, #4a4ae3ff 100.0%);");

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, rectangle);
        AnchorPane.setTopAnchor(rectangle, 100.0);
        AnchorPane.setLeftAnchor(rectangle, 100.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Animation TimeLine多属性组合");
        primaryStage.show();

        Timeline timeline = new Timeline();
        KeyValue translateX0 = new KeyValue(rectangle.translateXProperty(), 0);// x轴位移
        KeyValue rotate0 = new KeyValue(rectangle.rotateProperty(), 0); // 旋转
        KeyValue scaleX0 = new KeyValue(rectangle.scaleXProperty(), 1); // x轴缩放
        KeyValue scaleY0 = new KeyValue(rectangle.scaleYProperty(), 1); // y轴缩放
        KeyValue opacity0 = new KeyValue(rectangle.opacityProperty(), 1); // 透明度
        KeyFrame kf0 = new KeyFrame(Duration.seconds(0), translateX0, rotate0, scaleX0, scaleY0, opacity0);
        KeyValue translateX1 = new KeyValue(rectangle.translateXProperty(), 300);
        KeyValue rotate1 = new KeyValue(rectangle.rotateProperty(), 360);
        KeyValue scaleX1 = new KeyValue(rectangle.scaleXProperty(), 2);
        KeyValue scaleY1 = new KeyValue(rectangle.scaleYProperty(), 2);
        KeyValue opacity1 = new KeyValue(rectangle.opacityProperty(), 0);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(3), translateX1, rotate1, scaleX1, scaleY1, opacity1);
        timeline.getKeyFrames().addAll(kf0, kf1);
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);

        print.setOnAction(event -> {

        });

        play.setOnAction(event -> {
            timeline.play();
        });

        pause.setOnAction(event -> {
            timeline.pause();
        });

        stop.setOnAction(event -> {
            timeline.stop();
        });

        action.setOnAction(event -> {
        });

    }
}
