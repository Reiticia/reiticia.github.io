package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Dragboard 鼠标拖拽结合剪贴板
 *
 * @author reine
 * 2022/6/1 21:05
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: yellow;");
        hBox.setLayoutX(0);
        hBox.setLayoutY(0);
        hBox.setPrefWidth(300);
        hBox.setPrefHeight(300);

        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(300);
        hBox.getChildren().addAll(imageView);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("鼠标拖拽结合剪贴板");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        // 拖拽进入到hBox
        hBox.setOnDragEntered(event -> {
            hBox.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));
            // System.out.println("setOnDragEntered:event.getTransferMode() = " + event.getTransferMode());  // MOVE

        });

        // 拖拽退出到hBox外
        hBox.setOnDragExited(event -> {
            hBox.setBorder(null);
        });

        hBox.setOnDragOver(event -> {
            // System.out.println("setOnDragOver:event.getTransferMode() = " + event.getTransferMode());  // MOVE
            event.acceptTransferModes(event.getTransferMode());
        });

        // 拖拽释放
        hBox.setOnDragDropped(event -> {
            // 获取拖拽面板
            Dragboard dragboard = event.getDragboard();
            // 加载URL
            if (dragboard.hasUrl()) {
                imageView.setImage(new Image(dragboard.getUrl()));
            }
        });

    }
}
