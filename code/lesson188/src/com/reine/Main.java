package com.reine;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
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
 * 2022/6/19 21:56
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
        primaryStage.setTitle("Animation ScaleTransition缩放动画");
        primaryStage.show();

        ScaleTransition st = new ScaleTransition();
        st.setDuration(Duration.seconds(3));// 设置动画持续时间
        st.setNode(rectangle);// 设置动画的节点
        // st.setFromX(1);// 起始比例
        // st.setFromY(1);
        // st.setToX(2);// 终止比例
        // st.setToY(0.5);
        st.setByX(1);// 每次缩放的比例，如果和setTo同时存在，则该设置无效
        st.setByY(-0.5);
        st.setInterpolator(Interpolator.LINEAR);// 设置动画插值器

        play.setOnAction(e -> {
            st.play();
        });

        st.setOnFinished(event -> {
            System.out.println("rectangle.getBoundsInParent() = " + rectangle.getBoundsInParent());
        });

    }
}
