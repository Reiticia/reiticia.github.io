package com.reine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Button按钮
 * @author reine
 * 2022/5/12 7:50
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button();
        button.setText("btn0");
        button.setTextFill(Color.RED);
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setPrefWidth(100);
        button.setPrefHeight(50);
        button.setStyle("-fx-background-color: #eeff00;-fx-background-radius: 20;-fx-text-fill: blue;");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button btn = (Button) event.getSource();
                System.out.println("btn.getText(): " + btn.getText());
            }
        });

        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button按钮");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();
    }
}
