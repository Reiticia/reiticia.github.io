package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 17:43
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("button");
        button.setPrefSize(200, 200);
        ImageView imageView = new ImageView("file:E://Users//86158//图片//110300202.jpg");
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(400);
        HBox box = new HBox(20);
        box.getChildren().addAll(button, imageView);

        Button button1 = new Button("button");
        button1.setPrefSize(200, 200);
        ImageView imageView1 = new ImageView("file:E://Users//86158//图片//110300202.jpg");
        imageView1.setPreserveRatio(true);
        imageView1.setFitHeight(400);
        HBox box1 = new HBox(20);
        box1.getChildren().addAll(button1, imageView1);
        box1.setEffect(getEffect());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(box, box1);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(stackPane);
        AnchorPane.setTopAnchor(stackPane, 100.0);
        AnchorPane.setLeftAnchor(stackPane, 20.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blend图层混合");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    /**
     * 图层混合
     *
     * @return
     */
    private Effect getEffect() {
        Blend blend = new Blend();
        // 设置混合模式
        blend.setMode(BlendMode.HARD_LIGHT);
        blend.setOpacity(0.5);
        return blend;
    }
}
