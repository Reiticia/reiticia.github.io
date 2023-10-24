package com.reine;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
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
 * 2022/6/19 22:39
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
        primaryStage.setTitle("Animation FillTransition颜色过渡动画");
        primaryStage.show();

        FillTransition ft = new FillTransition();
        ft.setDuration(Duration.seconds(3));// 设置动画持续时间
        ft.setShape(rectangle);// 设置动画的图形
        ft.setFromValue(Color.RED);// 起始颜色
        ft.setToValue(Color.BLUE);// 终止颜色
        ft.setAutoReverse(true);// 设置动画反向播放
        ft.setCycleCount(Animation.INDEFINITE);// 设置动画循环次数

        play.setOnAction(e -> {
            ft.play();
        });

    }
}
