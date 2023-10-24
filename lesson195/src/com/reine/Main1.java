package com.reine;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/20 9:41
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");

        StackPane sp = new StackPane();
        sp.setPrefSize(400, 400);
        sp.setStyle("-fx-border-color: #996699; -fx-border-style: solid; -fx-border-width: 3;");

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        String background = "-fx-background-color: linear-gradient(from 0.0% 0.0% to 100.0% 0.0%, #bb96e1ff 0.0%, #5c56bbff 100.0%);";
        String border = "-fx-border-color: #ffffcc; -fx-border-width: 3; -fx-border-style: solid;";
        hBox.setStyle(background + border);
        sp.getChildren().add(hBox);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        String background1 = "-fx-background-color: linear-gradient(from 0.0% 0.0% to 100.0% 0.0%, #23d0f3ff 0.0%, #d791f9ff 50.0%, #fe7b84ff 100.0%);";
        String border1 = "-fx-border-color: #ccffff; -fx-border-width: 3; -fx-border-style: solid;";
        hBox1.setStyle(background1 + border1);
        sp.getChildren().add(hBox1);

        // 置换效果
        DisplacementMap displacementMap = new DisplacementMap();
        // displacementMap.setWrap(true);
        // displacementMap.setOffsetX(-0.5);
        hBox1.setEffect(displacementMap);

        // 模拟位移组件
        Button simulation = new Button("simulation");
        // 位移动画
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(3));
        tt.setNode(simulation);
        // tt.setByX(400);
        // tt.setCycleCount(Animation.INDEFINITE);// 循环播放
        // tt.setInterpolator(Interpolator.LINEAR);// 动画插值器，匀速

        // 播放完成
        tt.setOnFinished(event -> {
        });

        simulation.translateXProperty().addListener((observable, oldValue, newValue) -> {
            double x = newValue.doubleValue();
            displacementMap.setOffsetX(-(x / sp.getWidth()));
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button1, button2, sp);
        AnchorPane.setTopAnchor(button1, 10.0);
        AnchorPane.setLeftAnchor(button1, 10.0);
        AnchorPane.setTopAnchor(button2, 10.0);
        AnchorPane.setLeftAnchor(button2, 100.0);
        AnchorPane.setTopAnchor(sp, 200.0);
        AnchorPane.setLeftAnchor(sp, 200.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Animation 跑马灯效果");
        primaryStage.show();

        button1.setOnAction(event -> {
            System.out.println("button1");
            tt.setFromX(0);
            tt.setToX(400);
            tt.play();
        });

        button2.setOnAction(event -> {
            System.out.println("button2");
            tt.setFromX(400);
            tt.setToX(0);
            tt.play();
        });

        hBox.setOnMouseClicked(event -> {
            System.out.println("hBox mouse click");
        });

        hBox1.setOnMouseClicked(event -> {
            System.out.println("hBox1 mouse click");
        });
    }
}
