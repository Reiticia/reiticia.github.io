package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 使用滚动面板实现图片移动
 * @author reine
 * 2022/5/29 19:44
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        String path = "images/logo.png";
        Image image = new Image(path);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(100,100);
        scrollPane.setContent(imageView);

        AnchorPane anchorPane = new AnchorPane(scrollPane);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("使用滚动面板实现图片移动");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
