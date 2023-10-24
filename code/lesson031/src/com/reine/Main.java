package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 单选按钮
 *
 * @author reine
 * 2022/5/15 9:33
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: skyblue;");

        HBox hBox = new HBox(10);

        // 单选按钮组
        ToggleGroup toggleGroup = new ToggleGroup();
        // 单选按钮
        RadioButton rb1 = new RadioButton("rb1");
        RadioButton rb2 = new RadioButton("rb2");
        RadioButton rb3 = new RadioButton("rb3");
        RadioButton rb4 = new RadioButton("rb4");
        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);
        rb3.setToggleGroup(toggleGroup);
        rb4.setToggleGroup(toggleGroup);
        // 或者用下面一行代替上面四行
        // toggleGroup.getToggles().addAll(rb1, rb2, rb3, rb4);
        toggleGroup.selectToggle(rb2);// 默认选中第二个

        // 监听单选按钮组的选中状态
        rb1.selectedProperty().addListener((observable, oldValue, newValue) -> System.out.println("rb1.selectedProperty(): " + newValue));

        // 改变选中的单选按钮监听事件
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> System.out.println("toggleGroup.selectedToggleProperty(): " + newValue));

        hBox.getChildren().addAll(rb1, rb2, rb3, rb4);
        anchorPane.getChildren().add(hBox);

        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("单选按钮");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
