package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author reine
 * 2022/6/20 20:22
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button play = new Button("play");
        Button stop = new Button("stop");
        Button status = new Button("status");
        HBox hBox = new HBox(100);
        hBox.getChildren().addAll(play, stop, status);

        URL url = this.getClass().getClassLoader().getResource("music/Ring01.wav");

        AudioClip ac = new AudioClip(url.toExternalForm());// 加载音频文件
        // ac.setBalance(1);// 左声道
        // ac.setBalance(-1);// 右声道
        ac.setBalance(0);// 左右声道均衡
        // ac.setPan(1);
        ac.setPriority(1);// 设置优先级
        ac.setRate(3);// 设置播放速率
        // ac.setCycleCount(AudioClip.INDEFINITE);// 设置循环次数
        ac.setVolume(1);// 设置音量0~1

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media AudioClip短音频播放");
        primaryStage.show();

        play.setOnAction(event -> {
            ac.play();
        });

        stop.setOnAction(event -> {
            ac.stop();
        });

        status.setOnAction(event -> {
            System.out.println("ac.isPlaying() = " + ac.isPlaying());
        });

    }
}
