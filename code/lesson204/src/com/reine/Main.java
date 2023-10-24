package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * TODO 音乐播放器
 *
 * @author reine
 * 2022/6/21 16:13
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 注意：加载操作系统中的本地音频文件时，需要在绝对路径前面加上“file:/”
        String music = "file:/E:/VideoAndAudio/バレンタインデーキッス.mp3";
        Media media = new Media(music);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.3);// 设置音量
        mediaPlayer.setAutoPlay(true);

        Button play = new Button("play");
        Button pause = new Button("pause");
        Button stop = new Button("stop");
        HBox root = new HBox(50);
        root.getChildren().addAll(play, pause, stop);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media 音乐播放器");
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
