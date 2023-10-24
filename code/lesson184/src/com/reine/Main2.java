package com.reine;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jfr.events.TLSHandshakeEvent;

/**
 * @author reine
 * 2022/6/19 14:02
 */
public class Main2 extends Application {
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
        primaryStage.setTitle("Animation TimeLine动画拆分");
        primaryStage.show();


        Timeline timeline = new Timeline();
        KeyValue rotate0 = new KeyValue(rectangle.rotateProperty(), 0);// 旋转
        KeyFrame kf0 = new KeyFrame(Duration.seconds(0), rotate0);
        KeyValue rotate1 = new KeyValue(rectangle.rotateProperty(), 360);// 旋转
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), rotate1);
        timeline.getKeyFrames().addAll(kf0, kf1);
        Timeline timeline1 = new Timeline();
        KeyValue translateX0 = new KeyValue(rectangle.translateXProperty(), 0);// x轴平移
        KeyFrame kf2 = new KeyFrame(Duration.seconds(0), translateX0);
        KeyValue translateX1 = new KeyValue(rectangle.translateXProperty(), 300);// x轴平移
        KeyFrame kf3 = new KeyFrame(Duration.seconds(1), translateX1);
        timeline1.getKeyFrames().addAll(kf2, kf3);


        timeline.setOnFinished(event -> {
            timeline1.play();
        });
        timeline1.setOnFinished(event -> {

        });


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
