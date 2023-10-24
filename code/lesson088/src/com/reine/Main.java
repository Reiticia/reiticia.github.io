package com.reine;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 鼠标悬空与滚轮事件
 * @author reine
 * 2022/6/4 17:32
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> observableList = FXCollections.observableArrayList();

        observableList.add("鸢一折纸");
        observableList.add("本条二亚");
        observableList.add("时崎狂三");
        observableList.add("冰芽川四糸乃");
        observableList.add("五河琴里");
        observableList.add("星宫六喰");
        observableList.add("镜野七罪");
        observableList.add("八舞夕弦");
        observableList.add("八舞耶俱矢");
        observableList.add("诱宵美九");
        observableList.add("夜刀神十香");

        ListView<String> listView = new ListView<>(observableList);
        listView.setPrefWidth(300);
        listView.setPrefHeight(330);
        listView.setLayoutX(100);
        listView.setLayoutY(100);

        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

            int position = 0;

            @Override
            public ListCell<String> call(ListView<String> param) {
                Label label = new Label();
                label.setFont(new Font(15));
                ListCell<String> cell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            return;
                        }
                        label.setText(item);
                        this.setGraphic(label);
                    }
                };
                cell.setPrefHeight(30);

                // 鼠标悬空监听
                cell.hoverProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue && !label.getText().equals("")) {
                        label.setFont(new Font(20));
                        position = param.getItems().indexOf(label.getText());
                        param.getFocusModel().focus(position);
                        label.setStyle("-fx-background-color: pink;");
                        cell.setStyle("-fx-background-color: green;");
                    } else {
                        label.setStyle("-fx-background-color: none;");
                        cell.setStyle("-fx-background-color: none;");
                        label.setFont(new Font(15));
                    }
                });

                return cell;
            }
        });

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("鼠标悬空与滚轮事件");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 鼠标滚轮事件
        listView.setOnScroll(event -> {
            System.out.println("event.getDeltaX() = " + event.getDeltaX());
            System.out.println("event.getDeltaY() = " + event.getDeltaY());
        });

    }
}
