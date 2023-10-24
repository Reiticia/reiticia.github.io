package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * MenuBar菜单栏及其子组件
 *
 * @author reine
 * 2022/5/13 14:47
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
        // 设置快捷键
        M1I1.setAccelerator(KeyCombination.valueOf("Ctrl+Alt+0"));
        MenuItem M1I2 = new MenuItem("M1I2");
        MenuItem M1I3 = new MenuItem("M1I3");
        MenuItem M2I1 = new MenuItem("M2I1");
        MenuItem M2I2 = new MenuItem("M2I2");

        // 将菜单项添加到菜单中
        MENU1.getItems().addAll(M1I1, M1I2, M1I3);
        MENU2.getItems().addAll(M2I1, M2I2);
        menuBar.getMenus().addAll(MENU1, MENU2, MENU3, MENU4);
        anchorPane.getChildren().add(menuBar);

        primaryStage.setScene(scene);
        primaryStage.setTitle("MenuBar菜单栏及其子组件");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> menuBar.setPrefWidth(newValue.doubleValue()));
        M1I1.setOnAction(event -> System.out.println("M1I1.setOnAction"));
        MENU1.setOnHidden(event -> System.out.println("MENU1.setOnHidden"));
        MENU1.setOnHiding(event -> System.out.println("MENU1.setOnHiding"));
        MENU1.setOnShowing(event -> System.out.println("MENU1.setOnShowing"));
        MENU1.setOnShown(event -> System.out.println("MENU1.setOnShown"));
    }
}
