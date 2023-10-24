package com.reine;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * ChoiceBox 下拉列表
 *
 * @author reine
 * 2022/5/17 12:20
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        ObservableList<String> list = FXCollections.observableArrayList("number", "character");
        ObservableList<Character> list1 = FXCollections.observableArrayList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        ObservableList<Character> list2 = FXCollections
                .observableArrayList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        Button button = new Button("sort");
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.setPrefWidth(100);
        ChoiceBox<Character> choiceBox2 = new ChoiceBox<>();
        choiceBox2.setPrefWidth(100);

        choiceBox1.setItems(list);
        // 监听choiceBox1选中项变化
        choiceBox1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("number")) {
                choiceBox2.setItems(list1);
            } else if (newValue.equals("character")){
                choiceBox2.setItems(list2);
            }
            choiceBox2.show();
        });

        // 按钮点击事件
        button.setOnAction(event -> {
            list1.sort((o1, o2) -> {
                // 倒序排序
                return o2 - o1;
            });
            list2.sort((o1, o2) -> {
                // 倒序排序
                return o2 - o1;
            });
        });


        AnchorPane.setTopAnchor(choiceBox1, 100.0);// 设置位置
        AnchorPane.setLeftAnchor(choiceBox1, 100.0);// 设置位置
        AnchorPane.setTopAnchor(choiceBox2, 100.0);// 设置位置
        AnchorPane.setLeftAnchor(choiceBox2, 300.0);// 设置位置

        anchorPane.getChildren().addAll(choiceBox1, choiceBox2,button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceBox 下拉列表");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}