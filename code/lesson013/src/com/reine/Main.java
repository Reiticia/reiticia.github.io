package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * AnchorPane 绝对布局
 * @author reine
 * 2022/5/12 10:43
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AnchorPane 绝对布局");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        Group group = new Group();
        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: red;");
        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("click");
            }
        });
        Button button = new Button("btn0");
        Button button1 = new Button("btn1");
        Group group1 = new Group();
        group.getChildren().add(button);
        group1.getChildren().add(button1);
        ap.getChildren().addAll(group, group1);
        AnchorPane.setTopAnchor(group, 10.0);
        AnchorPane.setBottomAnchor(group1, 10.0);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
