package com.reine;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFx入门程序
 * @author reine
 * 2022/5/11 16:47
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The first JavaFx Application");
        primaryStage.show();
    }
}
