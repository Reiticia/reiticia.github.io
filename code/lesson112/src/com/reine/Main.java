package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/9 8:59
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        Button button = new Button("JavaButton");
        button.setId("btn1");
        button.setPrefWidth(100);
        button.setPrefHeight(100);
        anchorPane.getChildren().add(button);
        AnchorPane.setTopAnchor(button,100.0);
        AnchorPane.setLeftAnchor(button,100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Java");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        Button btn = (Button) anchorPane.lookup("#btn1");
        btn.setOnAction(event -> {
            System.out.println("btn.getText() = " + btn.getText());
        });
    }
}
