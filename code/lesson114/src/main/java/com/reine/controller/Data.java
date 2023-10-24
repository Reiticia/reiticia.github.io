package com.reine.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author reine
 * 2022/6/9 16:01
 */
public class Data {
    @FXML
    private Button button;
    @FXML
    private ListView<String> listview;

    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("张三", "李四", "王五", "赵六");
        listview.setItems(list);

        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        });
    }

    public void showNewStage(ActionEvent actionEvent) {
        System.out.println("click");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(loader.getClassLoader().getResource("fxml/other.fxml"));
        Scene scene = null;
        try {
            BorderPane pane = loader.load();
            scene = new Scene(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取按钮所在的窗口
        Stage originStage = (Stage) button.getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(300);
        // 设置模态
        stage.initOwner(originStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
