package com.reine;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author reine
 * 2022/5/11 19:16
 */
public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        stage.setTitle("stage0");
        stage.show();
        Stage stage1 = new Stage();
        stage1.setTitle("stage1");
        stage1.initOwner(stage);
        stage1.initModality(Modality.WINDOW_MODAL);
        stage1.show();
        Stage stage2 = new Stage();
        stage2.setTitle("stage2");
        // stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.show();
    }
}
