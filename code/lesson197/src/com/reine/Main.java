package com.reine;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author reine
 * 2022/6/20 18:46
 */
public class Main extends Application {

    /**
     * 动画集合
     */
    private List<ParallelTransition> animeList = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 背景音乐
        // URL music = this.getClass().getClassLoader().getResource("music/bgm.mp3");
        // Media media = new Media(music.toExternalForm());
        // MediaPlayer mediaPlayer = new MediaPlayer(media);
        // mediaPlayer.setVolume(0.5);

        // 背景
        ImageView bg = new ImageView("images/ayane.png");
        StackPane sp = new StackPane();

        AnchorPane root = new AnchorPane();
        // root.setStyle("-fx-background-color: #0066cc;");
        root.getChildren().add(sp);

        Scene scene = new Scene(root, bg.prefWidth(-1), bg.prefHeight(-1));
        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.setTitle("Animation 雪花飘落动画效果");
        primaryStage.show();

        Node snowflakes = getSnowflakes(40, scene.getWidth(), scene.getHeight(), 2000);
        sp.getChildren().addAll(bg, snowflakes);

        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.SPACE);
        scene.getAccelerators().put(keyCombination, () -> {
            animeList.forEach(ParallelTransition::play);// 播放飘雪动画
            // mediaPlayer.play();// 播放背景音乐
        });
    }

    /**
     * 雪花
     *
     * @return
     */
    private Node getSnowflakes(int number, double width, double height, double depth) {

        Random random = new Random();

        List<ImageView> imgList = new ArrayList<>();
        int locationX = 0;
        int locationY = 0;
        int locationZ = 0;

        for (int i = 0; i < number; i++) {
            ImageView iv = new ImageView("images/snowflake.png");
            iv.setPreserveRatio(true);
            iv.setFitHeight(100);
            if (random.nextBoolean()) {
                locationX = random.nextInt((int) width) + random.nextInt(300) + 300;
            } else {
                locationX = random.nextInt((int) width) - random.nextInt(300) - 300;
            }
            locationY = random.nextInt(50);
            locationZ = random.nextInt((int) depth);
            iv.setTranslateX(locationX);
            iv.setTranslateY(locationY);
            iv.setTranslateZ(locationZ);
            iv.setOpacity(0.0);
            imgList.add(iv);
        }

        imgList.forEach(imageView -> {
            // 随机时间，最大15s，最小5s
            double time = random.nextDouble() * 10 + 5;
            TranslateTransition tt = new TranslateTransition(Duration.seconds(time));
            tt.setByX(400);
            tt.setByY(1200);

            FadeTransition ft1 = new FadeTransition(Duration.seconds(time / 2));
            ft1.setFromValue(0);
            ft1.setToValue(1);
            FadeTransition ft2 = new FadeTransition(Duration.seconds(3));
            ft2.setFromValue(1);
            ft2.setToValue(0);

            RotateTransition rt = new RotateTransition(Duration.seconds(time));
            rt.setByAngle(360);

            SequentialTransition st = new SequentialTransition();
            st.getChildren().addAll(ft1, ft2);

            ParallelTransition pt = new ParallelTransition();
            pt.setNode(imageView);
            pt.getChildren().addAll(tt, st, rt);
            pt.setCycleCount(Timeline.INDEFINITE);
            animeList.add(pt);
        });

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #0066cc00;");
        ap.getChildren().addAll(imgList);
        SubScene subScene = new SubScene(ap, width, height, true, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera();
        subScene.setCamera(camera);
        return subScene;
    }
}
