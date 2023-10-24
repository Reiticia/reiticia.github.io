package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 22:09
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 800, 800, false, SceneAntialiasing.BALANCED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D 导入模型文件");
        primaryStage.show();
    }
}
