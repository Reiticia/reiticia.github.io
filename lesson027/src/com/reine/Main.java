package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
        // 创建5个菜单项
        ImageView imageView = new ImageView("images/logo.png");
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        // 创建菜单项同时设置图标
        MenuItem M1I1 = new MenuItem("M1I1", imageView);
        MenuItem M1I2 = new MenuItem("M1I2");
        MenuItem M1I3 = new MenuItem("M1I3");
        MenuItem M1I4 = new MenuItem("M1I4");

        // 设置分隔线
        SeparatorMenuItem separ1 = new SeparatorMenuItem();
        SeparatorMenuItem separ2 = new SeparatorMenuItem();

        // 设置菜单项子菜单
        Menu M1M5 = new Menu("M1M5");
        MenuItem M1M5I1 = new MenuItem("M1M5I1");
        MenuItem M1M5I2 = new MenuItem("M1M5I2");
        M1M5.getItems().addAll(M1M5I1, M1M5I2);

        ToggleGroup toggleGroup = new ToggleGroup();
        // 设置三个单选项
        RadioMenuItem radio1 = new RadioMenuItem("Radio1");
        RadioMenuItem radio2 = new RadioMenuItem("Radio2");
        RadioMenuItem radio3 = new RadioMenuItem("Radio3");
        // 设置单选组
        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        radio3.setToggleGroup(toggleGroup);
        // 设置单选项2默认勾选
        radio2.setSelected(true);

        // 创建4个复选项
        CheckMenuItem check1 = new CheckMenuItem("Check1");
        CheckMenuItem check2 = new CheckMenuItem("Check2");
        CheckMenuItem check3 = new CheckMenuItem("Check3");
        CheckMenuItem check4 = new CheckMenuItem("Check4");

        // 将菜单项和分隔线和子菜单添加到菜单中
        MENU1.getItems().addAll(M1I1, separ1, M1I2, separ2, M1I3, M1I4, M1M5);
        MENU2.getItems().addAll(radio1, radio2, radio3);
        MENU3.getItems().addAll(check1, check2, check3, check4);
        // 设置菜单禁用状态
        MENU4.setDisable(true);
        menuBar.getMenus().addAll(MENU1, MENU2, MENU3, MENU4);
        anchorPane.getChildren().add(menuBar);

        primaryStage.setScene(scene);
        primaryStage.setTitle("MenuBar菜单栏及其子组件（续）");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> menuBar.setPrefWidth(newValue.doubleValue()));

        // 单选按钮点击事件
        radio1.setOnAction(event -> {
            RadioMenuItem source = (RadioMenuItem) event.getSource();
            System.out.println("radio选中状态：" + source.isSelected());
            System.out.println(((RadioMenuItem)toggleGroup.getSelectedToggle()).getText());
        });
        radio2.setOnAction(event -> {
            RadioMenuItem source = (RadioMenuItem) event.getSource();
            System.out.println("radio选中状态：" + source.isSelected());
            System.out.println(((RadioMenuItem)toggleGroup.getSelectedToggle()).getText());
        });
        radio3.setOnAction(event -> {
            RadioMenuItem source = (RadioMenuItem) event.getSource();
            System.out.println("radio选中状态：" + source.isSelected());
            System.out.println(((RadioMenuItem)toggleGroup.getSelectedToggle()).getText());
        });
        // 复选按钮点击事件
        check1.setOnAction(event -> {
            CheckMenuItem source = (CheckMenuItem) event.getSource();
            System.out.println("check1选中状态：" + source.isSelected());
        });
        check2.setOnAction(event -> {
            CheckMenuItem source = (CheckMenuItem) event.getSource();
            System.out.println("check2选中状态：" + source.isSelected());
        });
        check3.setOnAction(event -> {
            CheckMenuItem source = (CheckMenuItem) event.getSource();
            System.out.println("check3选中状态：" + source.isSelected());
        });
        check4.setOnAction(event -> {
            CheckMenuItem source = (CheckMenuItem) event.getSource();
            System.out.println("check4选中状态：" + source.isSelected());
        });
    }
}
