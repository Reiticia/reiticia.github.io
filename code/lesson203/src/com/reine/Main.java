package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;

/**
 * @author reine
 * 2022/6/21 14:42
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
        mediaPlayer.setOnReady(() -> {

        });

        mediaPlayer.setOnMarker(event -> {

        });

        // mediaPlayer.setAudioSpectrumInterval(1.0);// 频谱刷新频率，默认为0.1s
        // mediaPlayer.setAudioSpectrumThreshold(-100);// 频谱阈值，设置为-100dB
        // mediaPlayer.setAudioSpectrumNumBands(50);// 频谱绘制的频率带数量，默认为128
        mediaPlayer.setAudioSpectrumListener(new AudioSpectrumListener() {
            @Override
            public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
                // System.out.println(timestamp + " " + duration);
                // System.out.println(magnitudes.length);// 音乐频谱变化幅度（128）
                // System.out.println(magnitudes[46]);// 振幅

                System.out.println(phases[44]);

            }
        });

        Button play = new Button("play");
        Button pause = new Button("pause");
        Button stop = new Button("stop");
        HBox root = new HBox(50);
        root.getChildren().addAll(play, pause, stop);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media MediaPlayer获取音乐频谱数据");
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

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Application init");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Application stop");
    }
}
