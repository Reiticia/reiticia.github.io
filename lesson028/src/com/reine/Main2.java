package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * MenuBar菜单栏及其子组件（续）
 *
 * @author reine
 * 2022/5/13 16:35
 */
public class Main2 extends Application {
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

        SplitMenuButton splitMenuButton = new SplitMenuButton();// 创建分割菜单按钮
        splitMenuButton.setText("SplitMenuButton");
        AnchorPane.setTopAnchor(splitMenuButton, 50.0);
        // 创建三个菜单项
        MenuItem mb1 = new MenuItem("MenuItem1");
        MenuItem mb2 = new MenuItem("MenuItem2");
        MenuItem mb3 = new MenuItem("MenuItem3");
        mb3.setAccelerator(KeyCombination.valueOf("Ctrl+Alt+Q"));
        splitMenuButton.getItems().addAll(mb1, mb2, mb3);
        splitMenuButton.setMinWidth(150);
        splitMenuButton.setMaxWidth(150);


        // 将菜单项和分隔线和子菜单添加到菜单中
        MENU1.getItems().addAll(M1I1, M1I2, M1I3, M1I4);
        // 设置菜单禁用状态
        MENU4.setDisable(true);
        menuBar.getMenus().addAll(MENU1, MENU2, MENU3, MENU4);
        anchorPane.getChildren().addAll(menuBar, splitMenuButton);

        primaryStage.setScene(scene);
        primaryStage.setTitle("MenuBar菜单栏及其子组件（续）");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> menuBar.setPrefWidth(newValue.doubleValue()));
    }
}
