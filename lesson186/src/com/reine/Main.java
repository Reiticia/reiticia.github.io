package com.reine;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/19 20:02
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button play = new Button("play");
        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(play, rectangle);
        AnchorPane.setTopAnchor(play, 10.0);
        AnchorPane.setLeftAnchor(play, 10.0);
        AnchorPane.setTopAnchor(rectangle, 100.0);
        AnchorPane.setLeftAnchor(rectangle, 100.0);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation TranslateTransition位移动画");
        primaryStage.show();

        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(3));// 设置动画持续时间
        tt.setNode(rectangle);// 设置动画的节点

        tt.setFromX(0);// 起始位置
        tt.setFromY(0);
        tt.setToX(500);// 终止位置
        tt.setToY(500);
        // tt.setByX(100);// 偏移量
        tt.setAutoReverse(true);// 设置动画反向播放
        tt.setCycleCount(Animation.INDEFINITE);// 设置动画循环播放
        // tt.setInterpolator(Interpolator.LINEAR);// 设置插值器，默认是匀速

        play.translateXProperty().bind(rectangle.translateXProperty());
        play.translateYProperty().bind(rectangle.translateYProperty());

        play.setOnAction(e -> {
            tt.play();
        });

    }
}
