package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
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
        listView.getItems().add("data - u");
        // 水平方向
        // listView.setOrientation(Orientation.HORIZONTAL);
        // 设置多选
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // 选择第0个
        // listView.getSelectionModel().select(0);

        // 设置可编辑
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());

        Button button = new Button("修改列表");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        listView.requestFocus();

        button.setOnAction(event -> {

            // 选择索引为2和4
            // listView.getSelectionModel().selectIndices(2, 4);
            // listView.requestFocus();
            // 添加元素
            // observableList.add("data - add");
            // listView.getSelectionModel().selectLast();
            // 滚动条滚动到指定位置
            // listView.scrollTo(listView.getItems().size()-1);
            // listView.scrollTo("data - add");
            //
            // listView.scrollTo(3);
            //
            // System.out.println(listView.getSelectionModel().getSelectedIndex());
            // listView.getSelectionModel().getSelectedItems().forEach(System.out::println);

            observableList.forEach(System.out::println);
        });

        // 点击选项内容改变监听
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        });
        // 点击选项索引改变监听
        listView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        });
        // 滚动监听（必须通过调用scrollTo方法才会触发监听）
        listView.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
            @Override
            public void handle(ScrollToEvent<Integer> event) {
                listView.getItems().remove(0);
            }
        });
    }
}
