package com.reine;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/21 17:05
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 注意：加载操作系统中的本地音频文件时，需要在绝对路径前面加上“file:/”
        String music = "file:/C:/Users/86158/桌面/2ada3de244a02335936a408e8efff631.mp4";
        Media media = new Media(music);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);// 设置音量
        MediaView mediaView = new MediaView(mediaPlayer);// 创建一个MediaView对象，用于显示视频
        // mediaView.setPreserveRatio(false);// 不保持宽高比，默认为true
        // mediaView.setFitWidth(200);
        // mediaView.setFitHeight(200);
        mediaView.setSmooth(true);// 设置是否平滑播放
        Rectangle2D rectangle2D = new Rectangle2D(0, 0, 200, 200);
        mediaView.setViewport(rectangle2D);// 截取视频中200*200的区域，位置从(0,0)开始
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(-0.5);
        mediaView.setEffect(colorAdjust);// 设置视频效果

        mediaPlayer.setOnReady(() -> {
            System.out.println(media.getWidth());
            System.out.println(media.getHeight());
        });

        Button play = new Button("play");
        Button pause = new Button("pause");
        Button stop = new Button("stop");
        HBox btnGroup = new HBox(50);
        btnGroup.getChildren().addAll(play, pause, stop);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(btnGroup, mediaView);
        AnchorPane.setTopAnchor(mediaView, 50.0);
        AnchorPane.setLeftAnchor(mediaView, 50.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media MediaView视频播放");
        primaryStage.show();

        play.setOnAction(event -> {
            mediaPlayer.play();
        });
        pause.setOnAction(event -> {
            mediaPlayer.pause();
        });
        stop.setOnAction(event -> {
            mediaPlayer.stop();
        });
    }
}
