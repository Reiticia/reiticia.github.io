package com.reine;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Separator 分隔符
 * @author reine
 * 2022/5/21 13:14
 */
public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: blue;");

        HBox hBox = new HBox(10);
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");

        Separator separator = new Separator();
        separator.setPrefWidth(300);
        separator.setPrefHeight(300);

        separator.setHalignment(HPos.LEFT);
        // separator.setValignment(VPos.BOTTOM);
        separator.setOrientation(Orientation.VERTICAL);
        hBox.getChildren().addAll(button1,separator,button2);

        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
}
