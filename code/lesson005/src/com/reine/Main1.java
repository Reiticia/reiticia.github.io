package com.reine;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/5/11 19:47
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean supported = Platform.isSupported(ConditionalFeature.SCENE3D);
        System.out.println("supported = " + supported);
        primaryStage.show();

    }
}
