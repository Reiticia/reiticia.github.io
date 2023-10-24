package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author reine
 * 2022/6/21 9:08
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        String musicPath = this.getClass().getClassLoader().getResource("music/バレンタインデーキッス.mp3").toExternalForm();
        System.out.println(musicPath);
        Media media = new Media(musicPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(2);// 设置循环次数，2次

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
        primaryStage.setTitle("Media MediaPlayer音频播放生命周期");
        primaryStage.show();

        mediaPlayer.setOnReady(()->{
            System.out.println("setOnReady");
        });
        mediaPlayer.setOnError(()->{
            System.out.println("setOnError");
        });
        mediaPlayer.setOnHalted(()->{
            System.out.println("setOnHalted");
        });
        mediaPlayer.setOnPaused(()->{
            System.out.println("setOnPaused");
        });
        mediaPlayer.setOnPlaying(()->{
            System.out.println("setOnPlaying");
        });
        mediaPlayer.setOnStalled(()->{
            System.out.println("setOnStalled");
        });
        mediaPlayer.setOnStopped(()->{
            System.out.println("setOnStopped");
        });
        mediaPlayer.setOnEndOfMedia(()->{
            System.out.println("setOnEndOfMedia");
        });
    }
}
