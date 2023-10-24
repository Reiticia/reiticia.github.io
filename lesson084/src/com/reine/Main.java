package com.reine;

import com.reine.entity.Data;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * ListView
 *
 * @author reine
 * 2022/6/2 14:02
 */
public class Main extends Application {
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

        // listView.setEditable(true);

        Callback<ListView<Data>, ListCell<Data>> cell = CheckBoxListCell.forListView(param -> {
            // 不是B就是true
            if (!param.getName().equals("B")) {
                param.setSelected(true);
            }
            return param.selectedProperty();
        }, new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
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

        button.setOnAction(event -> {

        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("名称 = " + newValue.getName() + " 是否选中 = " + newValue.isSelected());
        });


    }
}
