package com.reine;

import com.reine.entity.DataPro;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Comparator;

/**
 * @author reine
 * 2022/6/4 14:28
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DataPro data1 = new DataPro("鸢一折纸", 18);
        DataPro data2 = new DataPro("本条二亚", 25);
        DataPro data3 = new DataPro("时崎狂三", 16);
        DataPro data4 = new DataPro("冰芽川四糸乃", 18);
        DataPro data5 = new DataPro("五河琴里", 19);
        DataPro data6 = new DataPro("星宫六喰", 17);
        DataPro data7 = new DataPro("镜野七罪", 16);
        DataPro data8 = new DataPro("八舞夕弦", 18);
        DataPro data9 = new DataPro("八舞耶俱矢", 18);
        DataPro data10 = new DataPro("诱宵美九", 17);
        DataPro data11 = new DataPro("夜刀神十香", 19);
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
        // 使用自定义列表
        ListView<DataPro> listView = new ListView<>(observableList);


        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<DataPro>() {
            @Override
            public String toString(DataPro object) {
                return String.format("%s - %d", object.getName(), object.getAge());
            }

            @Override
            public DataPro fromString(String string) {
                return new DataPro(string, 0);
            }
        }));

        TextField textField = new TextField();
        textField.setLayoutX(100);
        textField.setLayoutY(50);
        textField.setPrefWidth(120);

        Button asc = new Button("asc");
        asc.setLayoutX(270);
        asc.setLayoutY(50);
        Button desc = new Button("desc");
        desc.setLayoutX(350);
        desc.setLayoutY(50);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, textField, asc,desc);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("过滤排序");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<DataPro> filtered = observableList.filtered(dataPro -> dataPro.getName().contains(newValue));
            listView.setItems(filtered);
        });

        asc.setOnAction(event -> {
            SortedList<DataPro> sorted = observableList.sorted((Comparator.comparingInt(DataPro::getAge)));
            listView.setItems(sorted);
            observableList.sort((Comparator.comparingInt(DataPro::getAge)));
        });

        desc.setOnAction(event -> {
            SortedList<DataPro> sorted = observableList.sorted((o1, o2) -> o2.getAge() - o1.getAge());
            listView.setItems(sorted);
        });


        anchorPane.setOnMouseClicked(event -> {
            listView.setItems(observableList);
        });
    }
}
