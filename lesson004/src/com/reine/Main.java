package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

/**
 * stage简单设置2
 * @author reine
 * 2022/5/11 18:46
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 设置透明度
        // primaryStage.setOpacity(0.5);
        // 设置置顶窗口
        // primaryStage.setAlwaysOnTop(false);
        primaryStage.setTitle("stage简单设置2");
        // 设置窗口位置
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("x:" + newValue);
            }
        });
        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("y:" + newValue);
            }
        });
        primaryStage.show();
    }
}
