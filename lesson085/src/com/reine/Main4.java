package com.reine;

import com.reine.entity.DataNP;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
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
 * 属性既有普通数据类型又有Property的JavaBean数据类型
 *
 * @author reine
 * 2022/6/3 15:48
 */
public class Main4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DataNP data1 = new DataNP("张三", 19);
        DataNP data2 = new DataNP("李四", 20);
        DataNP data3 = new DataNP("王五", 23);
        DataNP data4 = new DataNP("赵六", 22);
        DataNP data5 = new DataNP("钱七", 21);

        ObservableList<DataNP> list = FXCollections.observableArrayList(new Callback<DataNP, Observable[]>() {
            @Override
            public Observable[] call(DataNP param) {
                // 将参数中所有Property属性返回（1个）
                return new SimpleIntegerProperty[]{param.ageProperty()};
            }
        });

        // 使用自定义列表
        ListView<DataNP> listView = new ListView<>(list);
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        ObservableList<DataNP> observableList = listView.getItems();

        observableList.add(data1);
        observableList.add(data2);
        observableList.add(data3);
        observableList.add(data4);
        observableList.add(data5);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<DataNP>() {
            @Override
            public String toString(DataNP object) {
                return object.getName() + "-" + object.getAge();
            }

            @Override
            public DataNP fromString(String string) {
                return new DataNP(string, 0);
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
            ObservableList<DataNP> data = (ObservableList<DataNP>) observable;
            data.forEach(item -> {
                System.out.println(item.getName() + "-" + item.getAge());
            });
        });

        observableList.addListener((ListChangeListener<DataNP>) c -> {
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
            // observableList.set(0,new DataNP("REINE",20));
            // 只修改普通属性界面不会更新
            // data1.setName("REINE");
            // 修改了监视属性会界面更新，会将之前进行修改的普通属性一并更新到界面
            // data1.setAge(30);
            listView.getItems().remove(0);
        });
    }
}
