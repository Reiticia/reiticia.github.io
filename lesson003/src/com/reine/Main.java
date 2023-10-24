package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * stage简单设置
 * @author reine
 * 2022/5/11 17:32
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 设置标题
        primaryStage.setTitle("stage简单设置");
        primaryStage.setWidth(250);
        primaryStage.setHeight(250);
        // 设置图标
        primaryStage.getIcons().add(new Image("/images/logo.png"));
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("高度变化了");
            }
        });
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("宽度变化了");
            }
        });
        // 设置全屏
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(new Group()));
        primaryStage.show();

    }
}
