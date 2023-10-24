package com.reine;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
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
 * 2022/6/19 22:28
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
        primaryStage.setTitle("Animation FadeTransition渐变动画");
        primaryStage.show();

        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.seconds(1));// 设置动画持续时间
        ft.setNode(rectangle);// 设置动画的节点
        // ft.setFromValue(1);// 起始透明度
        // ft.setToValue(0);// 终止透明度
        ft.setByValue(-1);// 每次渐变的透明度，如果和setTo同时存在，则该设置无效
        ft.setAutoReverse(true);// 设置动画反向播放
        ft.setCycleCount(2);// 设置动画循环次数

        play.setOnAction(e -> {
            ft.play();
        });

    }
}
