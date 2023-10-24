package com.reine;

import dorkbox.systemTray.MenuItem;
import dorkbox.systemTray.SystemTray;
import dorkbox.systemTray.util.WindowsSwingUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author reine
 * 2022/6/22 10:38
 */
public class Main1 extends Application {
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

        minimize.setOnAction(event -> {
            primaryStage.hide();
            SystemTray systemTray = SystemTray.get();
            systemTray.setImage("E:\\Users\\86158\\图片\\pngicon\\file_type_audio.png");
            // systemTray.setTooltip("JavaFX系统托盘");
            JMenu menu = new JMenu();
            JMenuItem item1 = new JMenuItem("显示");
            item1.addActionListener(e -> {
                Platform.runLater(primaryStage::show);
                systemTray.shutdown();
            });
            JMenuItem item2 = new JMenuItem("退出");
            item2.addActionListener(e -> {
                Platform.runLater(() -> {
                    systemTray.shutdown();
                    Platform.setImplicitExit(true);
                    primaryStage.close();
                });
            });
            menu.add(item1);
            menu.add(item2);
            systemTray.setMenu(menu);
        });
    }
}
