package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Label特性和ListCell
 *
 * @author reine
 * 2022/5/19 8:08
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        // label部分
        Label label = new Label();

        HBox hBox1 = new HBox(10);
        hBox1.setStyle("-fx-background-color: pink;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxWidth(200);
        hBox1.setMaxHeight(200);
        hBox1.getChildren().addAll(new Button("btn1"), new Button("btn2"));
        // 靠右
        label.setStyle("-fx-background-color: skyblue;");
        label.setPrefWidth(250);
        label.setPrefHeight(250);
        label.setAlignment(Pos.CENTER);
        label.setContentDisplay(ContentDisplay.CENTER);
        label.setGraphic(hBox1);

        // listCell部分
        ListCell<String> listCell = new ListCell<>();
        // 勘误：让ListCell在JDK8中不报NullPointerException
        // listCell.updateListView(new ListView<>());
        listCell.setStyle("-fx-background-color: yellow;");
        listCell.setPrefWidth(250);
        listCell.setPrefHeight(250);
        listCell.setAlignment(Pos.CENTER);
        listCell.setContentDisplay(ContentDisplay.CENTER);

        HBox hBox2 = new HBox(10);
        hBox2.setStyle("-fx-background-color: pink;");
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setMaxWidth(200);
        hBox2.setMaxHeight(200);
        hBox2.getChildren().addAll(new Button("btn1"), new Button("btn2"));

        listCell.setGraphic(hBox2);

        MyListCell1<String> myListCell = new MyListCell1<>();
        myListCell.updateItem("hello", true);


        anchorPane.getChildren().addAll(label, listCell, myListCell);
        AnchorPane.setTopAnchor(label, 100.0);
        AnchorPane.setLeftAnchor(label, 100.0);
        AnchorPane.setTopAnchor(listCell, 400.0);
        AnchorPane.setLeftAnchor(listCell, 100.0);
        AnchorPane.setTopAnchor(myListCell,100.0);
        AnchorPane.setLeftAnchor(myListCell,400.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Label特性和ListCell");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
}

class MyListCell1<T> extends ListCell<T> {

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        HBox hBox2 = new HBox(10);
        hBox2.setStyle("-fx-background-color: pink;");
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setMaxWidth(200);
        hBox2.setMaxHeight(200);
        hBox2.getChildren().addAll(new Button(item.toString()), new Button(item.toString()));

        this.setStyle("-fx-background-color: yellow;");
        this.setPrefWidth(250);
        this.setPrefHeight(250);
        this.setAlignment(Pos.CENTER);
        this.setContentDisplay(ContentDisplay.CENTER);
        this.setGraphic(hBox2);
    }
}