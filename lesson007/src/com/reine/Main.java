package com.reine;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Scene类
 *
 * @author reine
 * 2022/5/11 20:47
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // HostServices hostServices = getHostServices();
        // hostServices.showDocument("https://www.baidu.com");

        Button button = new Button("Hello World");
        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        // 设置鼠标放置上的样式
        URL resource = getClass().getClassLoader().getResource("images/p.png");
        if (resource != null) {
            String cursor = resource.toExternalForm();
            scene.setCursor(Cursor.cursor(cursor));
        }
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scene类");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
