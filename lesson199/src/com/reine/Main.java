package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.net.URLDecoder;

/**
 * @author reine
 * 2022/6/21 8:08
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String music = "file:/E:/VideoAndAudio/barentaindekkisu.mp3";
        Media media = new Media(music);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // System.out.println("url.toExternalForm() = " + url.toExternalForm());
        // String decode = URLDecoder.decode(url.toExternalForm(), "UTF-8");// 解码
        // System.out.println(decode);

        mediaPlayer.setAutoPlay(true);// 自动播放

        mediaPlayer.setOnReady(() -> {
            System.out.println("media.getDuration().toSeconds() = " + media.getDuration().toSeconds());// 获取音频时长
            System.out.println("mediaPlayer.getTotalDuration().toSeconds() = " + mediaPlayer.getTotalDuration().toSeconds());// 获取音频时长
        });

        mediaPlayer.setVolume(0.3);// 设置音量0~1
        // mediaPlayer.setRate(3);// 设置播放速率

        // mediaPlayer.setStartTime(Duration.seconds(10));// 设置开始时间
        // mediaPlayer.setStopTime(Duration.seconds(20));// 设置结束时间

        // mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);// 设置循环次数，无限循环
        // mediaPlayer.getCycleCount();// 获取循环次数

        Button play = new Button("play");
        Button stop = new Button("stop");
        Button mute = new Button("mute");
        Button pause = new Button("pause");
        Button status = new Button("status");
        HBox hBox = new HBox(100);
        hBox.getChildren().addAll(play, stop, mute, pause, status);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media MediaPlayer音频播放");
        primaryStage.show();

        play.setOnAction(event -> {
            mediaPlayer.setMute(false);// 取消静音
            mediaPlayer.play();
        });

        stop.setOnAction(event -> {
            mediaPlayer.stop();
        });

        mute.setOnAction(event -> {
            mediaPlayer.setMute(true);// 设置静音
        });

        pause.setOnAction(event -> {
            mediaPlayer.pause();
        });

        status.setOnAction(event -> {
            System.out.println("mediaPlayer.getCurrentTime().toSeconds() = " + mediaPlayer.getCurrentTime().toSeconds());// 获取当前播放时间
            mediaPlayer.dispose();// 注销音乐，释放资源
        });
    }
}
