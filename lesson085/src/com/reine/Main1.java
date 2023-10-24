package com.reine;

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
 * Property数据类型
 * @author reine
 * 2022/6/3 15:48
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 创建可观察列表，当列表中的元素内容发送改变时，会通知数据更新
        ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println("初始化数据");
                return new SimpleStringProperty[]{param};
            }
        });
        // 使用自定义列表
        ListView<SimpleStringProperty> listView = new ListView<>(list);
        // ListView<SimpleStringProperty> listView = new ListView<>();
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        SimpleStringProperty dataAProperty = new SimpleStringProperty("data - a");
        SimpleStringProperty dataVProperty = new SimpleStringProperty("data - v");
        SimpleStringProperty dataSProperty = new SimpleStringProperty("data - s");
        SimpleStringProperty dataEProperty = new SimpleStringProperty("data - e");
        SimpleStringProperty dataXProperty = new SimpleStringProperty("data - x");
        SimpleStringProperty dataNProperty = new SimpleStringProperty("data - n");

        // 获得listView创建的默认可观察列表
        ObservableList<SimpleStringProperty> observableList = listView.getItems();
        observableList.add(dataAProperty);
        observableList.add(dataVProperty);
        observableList.add(dataSProperty);
        observableList.add(dataEProperty);
        observableList.add(dataXProperty);
        observableList.add(dataNProperty);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<SimpleStringProperty>() {
            @Override
            public String toString(SimpleStringProperty object) {
                return object.get();
            }

            @Override
            public SimpleStringProperty fromString(String string) {
                return new SimpleStringProperty(string);
            }
        }));

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("监视属性类型");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();


        observableList.addListener((InvalidationListener) observable -> {
            ObservableList<SimpleStringProperty> data = (ObservableList<SimpleStringProperty>) observable;
            data.forEach(System.out::println);
        });

        observableList.addListener((ListChangeListener<SimpleStringProperty>) c -> {
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
            // observableList.add(new SimpleStringProperty("data - o"));
            // 界面会更新
            // observableList.set(0,new SimpleStringProperty("data - u"));
            // 使用listView生成的observerList的数据进行数据内容更新时，界面不会更新，但数据被修改了；而当使用传入callback的observerList时，此方法能通知界面修改数据
            dataAProperty.set("data - u");
            // System.out.println("dataAProperty.get() = " + dataAProperty.get());
            // 刷新listView，强制更新界面
            // listView.refresh();
        });
    }
}
