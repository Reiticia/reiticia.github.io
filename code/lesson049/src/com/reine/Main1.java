package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ScrollPane滚动面板
 * @author reine
 * 2022/5/21 13:14
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        HBox hBox = new HBox(10);
        for (int i = 0; i < 10; i++) {
            hBox.getChildren().add(new Button("Hbtn" + i));
        }

        VBox vBox = new VBox(10);
        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("Vbtn" + i));
        }

        VBox box = new VBox(10, hBox, vBox);

        // 滚动面板
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(300);
        scrollPane.setPrefHeight(300);
        scrollPane.setContent(box);

        anchorPane.getChildren().addAll(scrollPane);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        scrollPane.hvalueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        });

        scrollPane.setHmin(0);
        scrollPane.setHmax(10);
    }
}
