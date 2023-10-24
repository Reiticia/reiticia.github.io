package com.reine;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 运行JavaFx程序的几种方法
 * @author reine
 * 2022/5/11 16:57
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }
}
