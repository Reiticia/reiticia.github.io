package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 获取图片属性
 *
 * @author reine
 * 2022/5/28 15:48
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        Image image = new Image("images/shot.gif", 300, 500, true, true, true);
        // 加载进度显示
        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        anchorPane.getChildren().add(progressIndicator);

        // 错误通知
        image.errorProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("newValue.booleanValue() = " + newValue.booleanValue());
            }
        });

        // 进度通知（异步加载）
        image.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("newValue.doubleValue() = " + newValue.doubleValue());
                if (newValue.doubleValue() < 1.0) {
                    progressIndicator.setProgress(newValue.doubleValue());
                }else {
                    anchorPane.getChildren().remove(progressIndicator);
                }
            }
        });

        // 异常通知
        image.exceptionProperty().addListener(new ChangeListener<Exception>() {
            @Override
            public void changed(ObservableValue<? extends Exception> observable, Exception oldValue, Exception newValue) {
                System.out.println("newValue.getMessage() = " + newValue.getMessage());
            }
        });

        // 请求宽高
        System.out.println("image.getRequestedHeight() = " + image.getRequestedHeight());
        System.out.println("image.getRequestedWidth() = " + image.getRequestedWidth());

        // 使用异步加载时，下面两行1输出0
        // 实际宽高
        System.out.println("image.getHeight() = " + image.getHeight());
        System.out.println("image.getWidth() = " + image.getWidth());
        ImageView imageView = new ImageView(image);

        anchorPane.getChildren().addAll(imageView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("获取图片属性");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
