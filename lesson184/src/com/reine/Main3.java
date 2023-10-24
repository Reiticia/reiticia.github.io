package com.reine;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Key;

/**
 * @author reine
 * 2022/6/19 14:02
 */
public class Main3 extends Application {
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
        AnchorPane.setTopAnchor(rectangle, 200.0);
        AnchorPane.setLeftAnchor(rectangle, 200.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Animation TimeLine使用自定义缩放点");
        primaryStage.show();

        Timeline timeline = new Timeline();
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        Scale scale = new Scale(1, 1, 100, 100);
        rectangle.getTransforms().add(scale);
        KeyValue scale1x = new KeyValue(scale.xProperty(), 2);
        KeyValue scale1y = new KeyValue(scale.yProperty(), 2);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0), scale1x, scale1y);
        KeyValue scale2x = new KeyValue(scale.xProperty(), 0.5);
        KeyValue scale2y = new KeyValue(scale.yProperty(), 0.5);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(1), scale2x, scale2y);
        timeline.getKeyFrames().addAll(kf1, kf2);

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
