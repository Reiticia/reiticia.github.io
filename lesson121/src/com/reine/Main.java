package com.reine;

import com.reine.node.MyButton;
import com.reine.node.MyListView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/12 11:01
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MyButton button = new MyButton("button");
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        button.setStyle("-fx-background-color: #ccffff;");

        MyButton node = button.clone();
        /* 浅拷贝，只复制对象，但对于对象内的属性，拷贝的对象会持有原对象属性的引用
           即当拷贝对象中的属性发生变化是，原对象对应属性也会改变*/
        node.setText("btn2");

        ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");

        MyListView<String> listView = new MyListView<>(list);
        MyListView<String> listViewClone = listView.clone();

        HBox root = new HBox(10);
        root.getChildren().addAll(button,node,listView,listViewClone);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Java中clone方法");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            System.out.println(button);
            System.out.println(node);
            System.out.println(button.equals(node));
            System.out.println(button == node);
            System.out.println(((Button) event.getSource()).getText());
        });
    }
}

