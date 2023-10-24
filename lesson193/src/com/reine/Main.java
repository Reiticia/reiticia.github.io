package com.reine;

import javafx.animation.*;
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
 * 2022/6/20 8:25
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
        primaryStage.setTitle("Animation ParallelTransition并行动画&SequentialTransition串行动画");
        primaryStage.show();

        // 位移动画
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(3));
        tt.setByX(400);

        // 旋转动画
        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(3));
        rt.setByAngle(360);

        // 填充动画
        FillTransition ft = new FillTransition();
        ft.setDuration(Duration.seconds(3));
        ft.setFromValue(Color.RED);
        ft.setToValue(Color.YELLOW);

        // 并行动画
        ParallelTransition pt = new ParallelTransition();
        // pt.setNode(rectangle);// 设置动画的节点
        pt.getChildren().addAll(tt, rt); // 将动画添加到并行动画中
        // pt.setAutoReverse(true);// 设置动画反向播放
        // pt.setCycleCount(Animation.INDEFINITE);// 设置动画循环次数

        // 串行动画
        SequentialTransition st = new SequentialTransition();
        st.setNode(rectangle);// 设置动画的节点
        st.getChildren().addAll(ft, pt); // 将动画添加到并行动画中
        st.setAutoReverse(true);// 设置动画反向播放
        st.setCycleCount(Animation.INDEFINITE);// 设置动画循环次数


        play.setOnAction(e -> {
            st.play();
        });
    }
}
