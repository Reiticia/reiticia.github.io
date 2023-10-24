package com.reine;

import com.reine.utils.ColorConsole;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaMarkerEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/21 10:39
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
        mediaPlayer.setVolume(0.5);// 设置音量
        mediaPlayer.setOnReady(() -> {
            media.getTracks().forEach(System.out::println);// 获取曲目
            media.getMetadata().forEach((s, o) -> System.out.println(s + ":" + o));// 获取元数据
            media.getMarkers().put("a", Duration.seconds(5));// 添加标记
            media.getMarkers().put("b", Duration.seconds(10));// 添加标记
            media.getMarkers().put("c", Duration.seconds(15));// 添加标记
        });

        mediaPlayer.setOnMarker(event -> {
            System.out.println("" + ColorConsole.BLUE + event.getMarker() + ColorConsole.RESET);// 打印标记
            if (event.getMarker().getKey().equals("a")){
                primaryStage.setTitle("a");
            }
        });

        Button play = new Button("play");
        Button pause = new Button("pause");
        Button stop = new Button("stop");
        HBox root = new HBox(50);
        root.getChildren().addAll(play, pause, stop);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media MediaPlayer获取文件信息");
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
