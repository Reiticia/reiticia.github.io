package com.reine;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/19 20:33
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
        primaryStage.setTitle("Animation RotateTransition旋转动画");
        primaryStage.show();

        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(3));// 设置动画持续时间
        rt.setNode(rectangle);// 设置动画的节点
        // rt.setFromAngle(0);// 起始角度
        // rt.setToAngle(360);// 终止角度
        rt.setByAngle(360);// 偏移角度
        rt.setAxis(new Point3D(0,0,1));// 设置旋转轴
        rt.setInterpolator(Interpolator.LINEAR);// 设置插值器，默认是匀速

        play.setOnAction(e -> {
            rt.play();
        });

    }
}
