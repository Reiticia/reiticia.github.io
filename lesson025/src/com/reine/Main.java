package com.reine;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hyperlink
 * @author reine
 * 2022/5/13 14:36
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);
        // 超链接样式，但点击不会跳转链接
        Hyperlink hyperlink = new Hyperlink("www.baidu.com",new Button("百度"));
        vBox.getChildren().addAll(hyperlink);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hyperlink");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();
        hyperlink.setOnAction(event -> {
            HostServices hostServices = Main.this.getHostServices();
            hostServices.showDocument(hyperlink.getText());
        });
    }
}
