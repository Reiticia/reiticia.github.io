package com.reine;

import com.reine.entity.DataPro;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
 * 属性为Property数据类型的JavaBean数据类型
 * @author reine
 * 2022/6/3 15:48
 */
public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DataPro data1 = new DataPro("张三", 19);
        DataPro data2 = new DataPro("李四", 20);
        DataPro data3 = new DataPro("王五", 23);
        DataPro data4 = new DataPro("赵六", 22);
        DataPro data5 = new DataPro("钱七", 21);

        ObservableList<DataPro> list = FXCollections.observableArrayList(new Callback<DataPro, Observable[]>() {
            @Override
            public Observable[] call(DataPro param) {
                // 当对象中任意一个属性改变时都会检测到
                Observable[] observables = new Observable[2];
                observables[0] = param.nameProperty();
                observables[1] = param.ageProperty();
                return observables;
            }
        });

        // 使用自定义列表
        ListView<DataPro> listView = new ListView<>(list);
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        ObservableList<DataPro> observableList = listView.getItems();

        observableList.add(data1);
        observableList.add(data2);
        observableList.add(data3);
        observableList.add(data4);
        observableList.add(data5);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<DataPro>() {
            @Override
            public String toString(DataPro object) {
                return object.getName() + "-" + object.getAge();
            }

            @Override
            public DataPro fromString(String string) {
                return new DataPro(string, 0);
            }
        }));

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DataPro对象类型");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        observableList.addListener((InvalidationListener) observable -> {
            ObservableList<DataPro> data = (ObservableList<DataPro>) observable;
            data.forEach(item -> {
                System.out.println(item.getName() + "-" + item.getAge());
            });
        });

        observableList.addListener((ListChangeListener<DataPro>) c -> {
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
            // observableList.set(0,new DataPro("REINE",20));
            data1.setName("REINE");
        });
    }
}
