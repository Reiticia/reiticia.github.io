package com.reine;

import com.reine.entity.Data;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.util.Optional;

/**
 * ListView
 *
 * @author reine
 * 2022/6/2 14:02
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Data> observableList = FXCollections.observableArrayList();
        Data a = new Data("A");
        Data b = new Data("B");
        Data c = new Data("C");
        Data d = new Data("D");
        Data e = new Data("E");

        observableList.add(a);
        observableList.add(b);
        observableList.add(c);
        observableList.add(d);
        observableList.add(e);

        ListView<Data> listView = new ListView<>(observableList);
        listView.setPlaceholder(new Label("无数据"));
        listView.setPrefWidth(300);
        listView.setPrefHeight(200);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        listView.setEditable(true);

        Callback<ListView<Data>, ListCell<Data>> cell = TextFieldListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                if (object == null) {
                    return "";
                }
                return object.getName();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string);
            }
        });
        listView.setCellFactory(cell);

        Button button = new Button("修改列表");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listView.edit(2);
            }
        });

        // 开始修改监听
        listView.setOnEditStart(new EventHandler<ListView.EditEvent<Data>>() {
            @Override
            public void handle(ListView.EditEvent<Data> event) {
                System.out.println("开始编辑");
                System.out.println("event.getIndex() = " + event.getIndex());
                System.out.println("event.getNewValue() = " + event.getNewValue());
            }
        });

        // 取消编辑监听
        listView.setOnEditCancel(event -> {
            System.out.println("取消编辑");
        });

        // 完成编辑监听
        listView.setOnEditCommit(event -> {
            System.out.println("完成编辑");
            System.out.println("event.getNewValue().getName() = " + event.getNewValue().getName());
            // 设置新数据
            observableList.set(event.getIndex(), event.getNewValue());
        });

    }
}
