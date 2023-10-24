package com.reine;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/19 14:02
 */
public class Main4 extends Application {
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
        Group group = new Group(rectangle);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, group);
        AnchorPane.setTopAnchor(group, 200.0);
        AnchorPane.setLeftAnchor(group, 200.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Animation TimeLine使用自定义旋转点");
        primaryStage.show();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(5);
        Rotate rotate = new Rotate(0, 50, 50);
        rectangle.getTransforms().add(rotate);
        KeyValue angle1 = new KeyValue(rotate.angleProperty(), 0);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0), angle1);
        KeyValue angle2 = new KeyValue(rotate.angleProperty(), 360);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(1), angle2);
        timeline.getKeyFrames().addAll(kf1, kf2);

        Timeline timeline1 = new Timeline();
        timeline1.setCycleCount(1);
        Rotate rotateOut = new Rotate(0, 200, 200);
        group.getTransforms().add(rotateOut);
        KeyValue angle1Out = new KeyValue(rotateOut.angleProperty(), 0);
        KeyFrame kf3 = new KeyFrame(Duration.seconds(0), angle1Out);
        KeyValue angle2Out = new KeyValue(rotateOut.angleProperty(), 360);
        KeyFrame kf4 = new KeyFrame(Duration.seconds(5), angle2Out);
        timeline1.getKeyFrames().addAll(kf3, kf4);

        print.setOnAction(event -> {

        });

        play.setOnAction(event -> {
            timeline.play();
            timeline1.play();
        });

        pause.setOnAction(event -> {
            timeline.pause();
            timeline1.pause();
        });

        stop.setOnAction(event -> {
            timeline.stop();
            timeline1.stop();
        });

        action.setOnAction(event -> {
        });

        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                timeline.play();
                timeline1.play();
            }
        });

    }
}
