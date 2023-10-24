package com.reine;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Comparator;

/**
 * 普通数据类型
 * @author reine
 * 2022/6/3 15:48
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ListView<String> listView = new ListView<>();
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        ObservableList<String> observableList = listView.getItems();
        observableList.add("data - a");
        observableList.add("data - v");
        observableList.add("data - s");
        observableList.add("data - e");
        observableList.add("data - x");
        observableList.add("data - n");

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("普通字符串类型");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        observableList.addListener((InvalidationListener) observable -> {
            System.out.println("observable = " + observable);
        });

        observableList.addListener((ListChangeListener<String>) c -> {
            System.out.println("change = " + c);
            while (c.next()) {
                if (c.wasUpdated()) {
                    System.out.println("更新操作");
                }
                if (c.wasReplaced()) {
                    System.out.println("替换操作");
                }
                if (c.wasRemoved()) {
                    System.out.println("删除操作");
                }
                if (c.wasAdded()) {
                    System.out.println("添加操作");
                }
                if (c.wasPermutated()) {
                    System.out.println("排序操作");
                }
            }
        });

        button.setOnAction(event -> {
            observableList.set(0,"dasdasda");
            // observableList.add(0, "dadasdasd");
            // observableList.remove(0 + 1);
            // 顺序
            // observableList.sort(String::compareTo);
            // observableList.sort(Comparator.naturalOrder());
            // 倒序
            // observableList.sort(Comparator.reverseOrder());
        });
    }
}
