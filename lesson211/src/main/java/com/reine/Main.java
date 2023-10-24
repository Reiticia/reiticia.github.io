package com.reine;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;

/**
 * @author reine
 * 2022/6/22 9:45
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Platform.setImplicitExit(false);// 窗口关闭时，程序不结束

        String music = "file:/E:/VideoAndAudio/バレンタインデーキッス.mp3";
        Media media = new Media(music);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        Button play = new Button("播放");
        Button minimize = new Button("最小化到系统托盘");

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(play, minimize);
        AnchorPane.setTopAnchor(play, 100.0);
        AnchorPane.setLeftAnchor(play, 200.0);
        AnchorPane.setTopAnchor(minimize, 100.0);
        AnchorPane.setLeftAnchor(minimize, 300.0);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("如何制作系统托盘");
        primaryStage.show();
        play.setOnAction(event -> {
            mediaPlayer.play();
        });

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                minimize.fire();
            }
        });

        // 系统托盘
        minimize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SystemTray systemTray = SystemTray.getSystemTray();

                Image image = Toolkit.getDefaultToolkit().getImage("images/audio.png");
                String tip = "JavaFX系统托盘";
                PopupMenu menu = new PopupMenu();
                MenuItem item1 = new MenuItem("显示");
                MenuItem item2 = new MenuItem("退出");
                menu.add(item1);
                menu.add(item2);

                TrayIcon trayIcon = new TrayIcon(image, tip, menu);
                trayIcon.setImageAutoSize(true);
                try {
                    systemTray.add(trayIcon);
                } catch (AWTException e) {
                    throw new RuntimeException(e);
                }
                primaryStage.hide();

                item1.addActionListener(e -> {
                    Platform.runLater(() -> {
                        primaryStage.show();
                        systemTray.remove(trayIcon);
                    });
                });
                item2.addActionListener(e -> {
                    systemTray.remove(trayIcon);
                    Platform.exit();
                });
            }
        });

    }
}
