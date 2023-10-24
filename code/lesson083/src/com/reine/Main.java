package com.reine;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * ListView
 * @author reine
 * 2022/6/2 14:02
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("data - c");
        observableList.add("data - e");
        observableList.add("data - g");
        observableList.add("data - a");
        observableList.add("data - x");
        observableList.add("data - q");
        observableList.add("data - r");
        observableList.add("data - w");

        ListView<String> listView = new ListView<>(observableList);
        listView.setPlaceholder(new Label("无数据"));
        listView.setPrefWidth(300);
        listView.setPrefHeight(200);
        listView.setLayoutX(100);
        listView.setLayoutY(100);
        // 设置每一个单元格的高度
        listView.setFixedCellSize(50);
        // 阻止获得焦点
        // listView.setFocusTraversable(false);
        listView.getSelectionModel().select(0);
        // 索引为2的元素默认获取焦点（可以和设置选中效果共存）
        listView.getFocusModel().focus(2);

        // 获取当前焦点指向位置的内容
        System.out.println("listView.getFocusModel().getFocusedItem() = " + listView.getFocusModel().getFocusedItem());




        Button button = new Button("修改列表");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();


        button.setOnAction(event -> {
            listView.requestFocus();
            listView.getFocusModel().focus(2);
        });

        listView.getFocusModel().focusedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        });
    }
}
