package com.reine;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/20 9:14
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button play = new Button("play");
        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(play, rectangle);
        AnchorPane.setTopAnchor(play, 10.0);
        AnchorPane.setLeftAnchor(play, 10.0);
        AnchorPane.setTopAnchor(rectangle, 100.0);
        AnchorPane.setLeftAnchor(rectangle, 100.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation AnimationTimer动画计时器");
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            int i = 0;

            /**
             * @param now 当前动画时间，单位：纳秒
             */
            @Override
            public void handle(long now) {
                Duration duration = new Duration(now / 1000 / 1000);
                System.out.println(duration.toSeconds());
                System.out.println(Thread.currentThread().getName());
                System.out.println("i = " + i++);
                rectangle.setRotate(rectangle.getRotate() + 1);
            }
        };

        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(1));
        tt.setNode(rectangle);
        tt.setByX(400);

        tt.setOnFinished(event -> {
            timer.stop();
        });

        play.setOnAction(event -> {
            tt.play();
            timer.start();
        });
    }
}
