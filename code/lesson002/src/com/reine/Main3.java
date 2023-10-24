package com.reine;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/5/11 17:10
 */
public class Main3 extends Application {
    public static void main(String[] args) {
        System.out.println("main()="+Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init="+Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start="+Thread.currentThread().getName());
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop="+Thread.currentThread().getName());
        super.stop();
    }
}
