package com.reine;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Platform类使用
 * @author reine
 * 2022/5/11 19:34
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start: " + Thread.currentThread().getName());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("runLater: " + Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i = " + i);
                }
            }
        });
        primaryStage.setTitle("Platform类使用");
        primaryStage.show();
    }
}
