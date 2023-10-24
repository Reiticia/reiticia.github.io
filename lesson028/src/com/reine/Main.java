package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * MenuBar菜单栏及其子组件（续）
 *
 * @author reine
 * 2022/5/13 16:35
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: skyblue;");
        Scene scene = new Scene(anchorPane);

        // 创建菜单栏
        MenuBar menuBar = new MenuBar();
        // 创建菜单
        Menu MENU1 = new Menu("MENU1");
        Menu MENU2 = new Menu("MENU2");
        Menu MENU3 = new Menu("MENU3");
        Menu MENU4 = new Menu("MENU4");
        // 创建菜单项
        MenuItem M1I1 = new MenuItem("M1I1");
        MenuItem M1I2 = new MenuItem("M1I2");
        MenuItem M1I3 = new MenuItem("M1I3");
        MenuItem M1I4 = new MenuItem("M1I4");

        CustomMenuItem cmi1 = new CustomMenuItem();// 自定义菜单项
        Button button = new Button("button");
        cmi1.setContent(button);
        CustomMenuItem cmi2 = new CustomMenuItem();
        ProgressBar progressBar = new ProgressBar(0.5);// 进度条
        cmi2.setContent(progressBar);
        CustomMenuItem cmi3 = new CustomMenuItem();
        HBox hBox = new HBox();
        hBox.setPrefWidth(200);
        hBox.setPrefHeight(200);
        hBox.setStyle("-fx-background-color: blue");
        hBox.getChildren().addAll(new Button("btn1"),new Button("btn2"),new Button("btn3"));
        cmi3.setContent(hBox);




        // 将菜单项和分隔线和子菜单添加到菜单中
        MENU1.getItems().addAll(M1I1, M1I2, M1I3, M1I4,cmi1,cmi2,cmi3);
        // 设置菜单禁用状态
        MENU4.setDisable(true);
        menuBar.getMenus().addAll(MENU1, MENU2, MENU3, MENU4);
        anchorPane.getChildren().add(menuBar);

        primaryStage.setScene(scene);
        primaryStage.setTitle("MenuBar菜单栏及其子组件（续）");
        primaryStage.setWidth(500);
        primaryStage.setHeight(800);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> menuBar.setPrefWidth(newValue.doubleValue()));
    }
}
