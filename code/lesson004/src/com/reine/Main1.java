package com.reine;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author reine
 * 2022/5/11 18:59
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        stage.setTitle("stage0");
        // 默认样式
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
        Stage stage1 = new Stage();
        stage1.setTitle("stage1");
        // 透明样式
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.show();
        Stage stage2 = new Stage();
        stage2.setTitle("stage2");
        // 纯白色背景，没有装饰
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.show();
        Stage stage3 = new Stage();
        stage3.setTitle("stage3");
        stage3.initStyle(StageStyle.UTILITY);
        stage3.show();
        Stage stage4 = new Stage();
        stage4.setTitle("stage4");
        stage4.initStyle(StageStyle.UNIFIED);
        stage4.show();
    }
}
