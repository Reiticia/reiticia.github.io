package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * MenuBar菜单栏及其子组件（续）
 *
 * @author reine
 * 2022/5/13 16:35
 */
public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: skyblue;");
        Button button = new Button("Button");
        anchorPane.getChildren().add(button);

        // 右键菜单栏
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("MenuItem1");
        MenuItem menuItem2 = new MenuItem("MenuItem2");
        MenuItem menuItem3 = new MenuItem("MenuItem3");
        contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);

        // 把右键菜单绑定到按钮
        button.setContextMenu(contextMenu);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MenuBar菜单栏及其子组件（续）");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();

        // 右键菜单弹出事件
        button.setOnContextMenuRequested(event->{
            System.out.println("右键菜单被点击了");
        });

    }
}
