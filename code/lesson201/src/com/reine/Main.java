package com.reine;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author reine
 * 2022/6/21 9:32
 */
public class Main extends Application {

    /**
     * 音乐列表
     */
    private List<Media> list = new ArrayList<>();
    /**
     * 当前音乐
     */
    private int index = 0;
    /**
     * 音量控制
     */
    private Slider volume;

    /**
     * 当前播放进度
     */
    private Slider progress;
    /**
     * 当前音乐播放器
     */
    private MediaPlayer mediaPlayer;

    /**
     * 鼠标是否按下进度条
     */
    private boolean mousePressed = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("music/バレンタインデーキッス.mp3");
        URL url1 = classLoader.getResource("music/Windows Notify Messaging.wav");
        URL url2 = classLoader.getResource("music/Windows Notify System Generic.wav");
        URL url3 = classLoader.getResource("music/Windows Proximity Connection.wav");
        URL url4 = classLoader.getResource("music/Windows Proximity Notification.wav");

        list.add(new Media(url.toExternalForm()));
        list.add(new Media(url1.toExternalForm()));
        list.add(new Media(url2.toExternalForm()));
        list.add(new Media(url3.toExternalForm()));
        list.add(new Media(url4.toExternalForm()));

        // MediaPlayer mediaPlayer = new MediaPlayer(list.get(0));
        // mediaPlayer.setAutoPlay(true);

        volume = new Slider(0, 1, 0.2);
        volume.setOrientation(Orientation.VERTICAL);
        progress = new Slider(0, 1, 0);
        progress.setPrefWidth(300);

        HBox sliderHBox = new HBox(50);
        sliderHBox.getChildren().addAll(volume, progress);

        Button play = new Button("play");
        Button stop = new Button("stop");
        Button pause = new Button("pause");
        Button previous = new Button("previous");
        Button next = new Button("next");
        HBox hBox = new HBox(50);
        hBox.getChildren().addAll(play, stop, pause, previous, next);

        VBox vBox = new VBox(50);
        vBox.getChildren().addAll(hBox, sliderHBox);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(vBox);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media MediaPlayer:Volume音量控制&Progress进度条");
        primaryStage.show();

        play.setOnAction(e -> {
            initMusic(0);
        });
        stop.setOnAction(e -> {
            mediaPlayer.stop();
        });
        pause.setOnAction(e -> {
            mediaPlayer.pause();
        });
        previous.setOnAction(e -> {
            initMusic(-1);
        });
        next.setOnAction(event -> {
            initMusic(1);
        });

        progress.setOnMousePressed(event -> {
            mousePressed = true;
        });

        progress.setOnMouseReleased(event -> {
            mediaPlayer.seek(Duration.seconds(progress.getValue()));
            mousePressed = false;
        });

    }

    private void initMusic(int type) {
        switch (type) {
            case 1:
                index = (index + 1) % list.size();
                break;
            case -1:
                index = (index - 1 + list.size()) % list.size();
                break;
            default:
        }
        Media media = list.get(index);
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.setVolume(0.3);
            mediaPlayer.volumeProperty().bind(volume.valueProperty());
            progress.setValue(0);
            progress.setMin(0);
            progress.setMax(mediaPlayer.getTotalDuration().toSeconds());
            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                if (mousePressed) {
                    return;
                }
                progress.setValue(newValue.toSeconds());
            });

            mediaPlayer.play();
        });
    }
}
