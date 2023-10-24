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
 * 2022/6/19 9:54
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

        Button button = new Button("button");

        Rectangle rectangle = new Rectangle(300, 100);
        rectangle.setFill(Color.RED);

        KeyValue keyValue1 = new KeyValue(button.translateXProperty(), 0);// 要改变的监视属性，改变后的属性值
        KeyValue keyValue1y = new KeyValue(button.translateYProperty(), 0);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0), "kf1", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("kf1");
            }
        }, keyValue1, keyValue1y);// 动画开始时间、动画名称、动画完成回调函数、动画改变的监视属性
        KeyValue keyValue2 = new KeyValue(button.translateXProperty(), 300, Interpolator.EASE_BOTH);// 要改变的监视属性，改变后的属性值，缓慢进入与离开
        KeyValue keyValue2y = new KeyValue(button.translateYProperty(), 0);// 要改变的监视属性，改变后的属性值
        KeyFrame kf2 = new KeyFrame(Duration.seconds(5), "kf2", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("kf2");
            }
        }, keyValue2, keyValue2y);
        KeyValue keyValue3 = new KeyValue(button.translateYProperty(), 100);// 要改变的监视属性，改变后的属性值
        KeyFrame ke3 = new KeyFrame(Duration.seconds(8), "ke3", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("kf4");
            }
        }, keyValue3);

        Timeline timeline = new Timeline(60);// 定义一个时间线动画，帧率为60（默认）
        timeline.getKeyFrames().addAll(kf1, kf2, ke3);
        // timeline.setDelay(Duration.seconds(1));// 动画延迟时间
        // timeline.setCycleCount(Timeline.INDEFINITE);// 动画循环次数（无限循环）
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);// 动画是否自动反向播放，循环次数最少为2次
        // timeline.setRate(3);// 动画播放速率，1为正常速率
        // 动画完成回调函数
        timeline.setOnFinished(event -> {
            System.out.println("timeline finished");
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, rectangle, button);
        AnchorPane.setTopAnchor(rectangle, 50.0);
        AnchorPane.setTopAnchor(button, 50.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Animation TimeLine");
        primaryStage.show();

        print.setOnAction(event -> {
            // toggleGroup.getToggles().forEach(toggle -> {
            //     System.out.println(toggle + "-" + toggle.isSelected());// 是否被选中
            // });
            System.out.println("print");
            System.out.println("timeline.getTargetFramerate() = " + timeline.getTargetFramerate());// 获取动画的目标帧速率
            System.out.println("timeline.getTotalDuration().toSeconds() = " + timeline.getTotalDuration().toSeconds());// 获取动画的总时长，单位秒
            System.out.println("timeline.getCurrentTime().toSeconds() = " + timeline.getCurrentTime().toSeconds());// 获取动画当前时间，单位秒
        });

        play.setOnAction(event -> {
            System.out.println("play");
            timeline.setRate(1);// 设置动画播放速率，1为正常速率
            timeline.play();
        });

        pause.setOnAction(event -> {
            System.out.println("pause");
            timeline.pause();
        });

        stop.setOnAction(event -> {
            System.out.println("stop");
            timeline.stop();
        });

        action.setOnAction(event -> {
            System.out.println("action");
            // timeline.jumpTo("kf2");// 跳转到指定的动画时间点
            // timeline.jumpTo(Duration.seconds(5));// 跳转到指定的动画时间点
            // timeline.playFromStart();// 从动画开始时间点开始播放
            // timeline.getCuePoints().put("aa",Duration.seconds(2));// 添加动画时间点
            // timeline.jumpTo("aa");
            // timeline.playFrom(Duration.seconds(5));// 从指定时间点开始播放
            timeline.setRate(-1);// 设置动画播放速率，-1为倒放
        });

        // 状态监听
        timeline.statusProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("status = " + newValue.toString());
        });

    }
}
