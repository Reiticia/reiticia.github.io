package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/5/18 15:47
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        Button button = new Button("Button");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("str1","str2","str3","str4","str5");
        comboBox.setEditable(true);// 设置可编辑（相较于ChoiceBox的特点）
        comboBox.setPromptText("请输入");// 设置提示文字
        comboBox.setPlaceholder(new Label("无元素"));// 设置占位符
        comboBox.setVisibleRowCount(3);// 设置可见行数

        anchorPane.getChildren().addAll(comboBox,button);
        AnchorPane.setLeftAnchor(button,250.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 选择事件
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });
        // 单击事件
        comboBox.setOnAction(event -> {
            System.out.println(comboBox.getValue());
        });
    }
}
