package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Pagination
 * @author reine
 * 2022/5/20 7:08
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        group.setStyle("-fx-background-color: skyblue;");

        Pagination pagination = new Pagination();
        pagination.setStyle("-fx-background-color: yellow;");
        pagination.setPrefWidth(200);
        pagination.setPrefHeight(200);
        pagination.setLayoutX(100);
        pagination.setLayoutY(100);

        pagination.setPageCount(10);  // 设置最大页数
        pagination.setMaxPageIndicatorCount(5); // 设置最大页码数量
        // pagination.setPageCount(Pagination.INDETERMINATE);  // 设置最大页数为无限大
        pagination.setCurrentPageIndex(3);  // 设置当前页码
        // pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);  // 设置样式

        // 设置当前页码变化监听器
        pagination.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue.intValue());
        });

        pagination.setPageFactory(param -> {
            if (param == 0){
                HBox hBox = new HBox();
                hBox.setMaxWidth(100);
                hBox.setMaxHeight(100);
                hBox.setAlignment(Pos.CENTER);
                hBox.setStyle("-fx-background-color: brown;");
                hBox.getChildren().add(new Label("第一页"));
                return hBox;
            }
            return new Button("Page " + param);
        });

        group.getChildren().add(pagination);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pagination");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
