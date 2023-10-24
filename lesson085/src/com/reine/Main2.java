package com.reine;

import com.reine.entity.Data;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * JavaBean数据类型
 * @author reine
 * 2022/6/3 15:48
 */
public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Data data1 = new Data("张三", 19);
        Data data2 = new Data("李四", 20);
        Data data3 = new Data("王五", 23);
        Data data4 = new Data("赵六", 22);
        Data data5 = new Data("钱七", 21);

        // 使用自定义列表
        ListView<Data> listView = new ListView<>();
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        ObservableList<Data> observableList = listView.getItems();

        observableList.add(data1);
        observableList.add(data2);
        observableList.add(data3);
        observableList.add(data4);
        observableList.add(data5);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.getName() + "-" + object.getAge();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string, 0);
            }
        }));

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data对象类型");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        observableList.addListener((InvalidationListener) observable -> {
            ObservableList<Data> data = (ObservableList<Data>) observable;
            data.forEach(item -> {
                System.out.println(item.getName() + "-" + item.getAge());
            });
        });

        observableList.addListener((ListChangeListener<Data>) c -> {
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
            // observableList.add(new Data("reine",20));
            // observableList.remove(0);
            // observableList.set(0, new Data(observableList.get(0).getName(), 100));
            // data1.setName("REINE");
            // listView.refresh();
        });
    }
}
