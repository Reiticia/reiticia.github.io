package com.reine;

import com.reine.entity.DataPro;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.*;

/**
 * 自定义单元格
 *
 * @author reine
 * 2022/6/3 15:48
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建10个DataPro
        DataPro data1 = new DataPro("鸢一折纸", 18);
        DataPro data2 = new DataPro("本条二亚", 19);
        DataPro data3 = new DataPro("时崎狂三", 20);
        DataPro data4 = new DataPro("冰芽川四糸乃", 18);
        DataPro data5 = new DataPro("五河琴里", 18);
        DataPro data6 = new DataPro("星宫六喰", 18);
        DataPro data7 = new DataPro("镜野七罪", 18);
        DataPro data8 = new DataPro("八舞夕弦", 18);
        DataPro data9 = new DataPro("八舞耶俱矢", 18);
        DataPro data10 = new DataPro("诱宵美九", 18);
        DataPro data11 = new DataPro("夜刀神十香", 18);

        ObservableList<DataPro> observableList = FXCollections.observableArrayList(param -> {
            // 当对象中任意一个属性改变时都会检测到
            Observable[] observables = new Observable[2];
            observables[0] = param.nameProperty();
            observables[1] = param.ageProperty();
            return observables;
        });

        observableList.add(data1);
        observableList.add(data2);
        observableList.add(data3);
        observableList.add(data4);
        observableList.add(data5);
        observableList.add(data6);
        observableList.add(data7);
        observableList.add(data8);
        observableList.add(data9);
        observableList.add(data10);
        observableList.add(data11);

        // 拷贝一份可观察列表的数据，用于重新填充listView
        List<DataPro> listBackup = new ArrayList<>(observableList);

        // 使用自定义列表
        ListView<DataPro> listView = new ListView<>(observableList);
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);
        listView.setStyle("-fx-background-color: pink;");

        listView.setEditable(true);

        listView.setCellFactory(new Callback<ListView<DataPro>, ListCell<DataPro>>() {

            /**
             * 当前选中的索引、数据、数据栏格式
             */
            int index = 0;
            DataPro temp = new DataPro();
            ListCell<DataPro> cell;


            @Override
            public ListCell<DataPro> call(ListView<DataPro> param) {
                // 当双击编辑时获得编辑项的索引和内容
                param.setOnEditStart(event -> {
                    // 获得当前选中编辑的数据
                    index = event.getIndex();
                    temp = param.getItems().get(index);
                });

                ListCell<DataPro> listCell = new ListCell<DataPro>() {
                    // 展示数据
                    @Override
                    protected void updateItem(DataPro item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            return;
                        }
                        ImageView imageView = new ImageView("images/logo.png");
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(25);
                        Label name = new Label(item.getName());
                        Label age = new Label(String.valueOf(item.getAge()));
                        HBox hBox = new HBox(10, name, age);
                        hBox.setAlignment(Pos.CENTER);
                        BorderPane borderPane = new BorderPane(hBox, null, null, null, imageView);
                        this.setGraphic(borderPane);
                    }

                    // 双击编辑
                    @Override
                    public void startEdit() {
                        cell = this;
                        super.startEdit();
                        ImageView imageView = new ImageView("images/logo.png");
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(25);
                        TextField name = new TextField(temp.getName());
                        name.setPrefWidth(120);
                        TextField age = new TextField(String.valueOf(temp.getAge()));
                        age.setPrefWidth(40);
                        HBox hBox = new HBox(10, name, age);
                        hBox.setAlignment(Pos.CENTER);
                        BorderPane borderPane = new BorderPane(hBox, null, null, null, imageView);
                        this.setGraphic(borderPane);

                        // 修改了姓名
                        name.setOnKeyPressed(event -> {
                            if (event.getCode().equals(KeyCode.ENTER)) {
                                if (!name.getText().trim().equals("")) {
                                    temp.setName(name.getText());
                                    temp.setAge(Integer.parseInt(age.getText()));
                                }
                                cell.commitEdit(temp);
                            }
                        });
                        // 修改了年龄
                        age.setOnKeyPressed(event -> {
                            if (event.getCode().equals(KeyCode.ENTER)) {
                                if (!age.getText().trim().equals("")) {
                                    temp.setName(name.getText());
                                    temp.setAge(Integer.parseInt(age.getText()));
                                }
                                cell.commitEdit(temp);
                            }
                        });
                    }

                    @Override
                    public void cancelEdit() {
                        super.cancelEdit();
                        ImageView imageView = new ImageView("images/logo.png");
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(25);
                        Label name = new Label(temp.getName());
                        Label age = new Label(String.valueOf(temp.getAge()));
                        HBox hBox = new HBox(10, name, age);
                        hBox.setAlignment(Pos.CENTER);
                        BorderPane borderPane = new BorderPane(hBox, null, null, null, imageView);
                        this.setGraphic(borderPane);
                    }

                    @Override
                    public void commitEdit(DataPro newValue) {
                        super.commitEdit(newValue);
                        System.err.println("提交编辑");
                    }

                };
                return listCell;
            }

        });

        Button reset = new Button("重置数据");

        Button snapshot = new Button("截图");
        snapshot.setLayoutX(100);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, reset, snapshot);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("自定义单元格");
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

        reset.setOnAction(event -> {
            // 重置列表
            System.out.println("listBackup.size() = " + listBackup.size());
            listView.getItems().clear();
            listView.getItems().addAll(listBackup);
            listView.getItems().forEach(item -> {
                System.out.println(item.getName() + "-" + item.getAge());
            });
            System.out.println("------------------------");

        });

        snapshot.setOnAction(event -> {
            WritableImage writableImage = new WritableImage((int) listView.getWidth(), (int) listView.getHeight());
            listView.snapshot(new SnapshotParameters(), writableImage);
            Clipboard clipboard = Clipboard.getSystemClipboard();
            clipboard.setContent(Collections.singletonMap(DataFormat.IMAGE, writableImage));
        });
    }
}
