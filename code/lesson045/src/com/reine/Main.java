package com.reine;

import com.reine.job.My;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * Slider 进度条
 * @author reine
 * 2022/5/20 8:08
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:pink;");

        Slider slider = new Slider(0, 100, 50);// 最小值，最大值，初始值
        slider.setPrefWidth(500);
        slider.setLayoutX(150.0);
        slider.setLayoutY(150.0);

        slider.setShowTickMarks(true);  // 显示刻度
        slider.setShowTickLabels(true); // 显示刻度标签
        slider.setMajorTickUnit(10);    // 主刻度间隔

        slider.setValue(0);// 设置初始值
        // slider.setOrientation(Orientation.VERTICAL);// 设置方向:垂直

/*        // 鼠标点击事件（没有单击事件的组件可以通过使用鼠标点击事件来监听）
        slider.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                System.out.println("once click");
            }
        });

        slider.setLabelFormatter(new StringConverter<Double>() {
            // 用于修改间距刻度标签的显示
            @Override
            public String toString(Double object) {
                if (object == 0) {
                    return "0";
                } else if (object == 100) {
                    return "100";
                } else {
                    return "未知";
                }
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });

        // 监听值的变化
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.err.println("newValue = " + newValue);
        });

        // 监听值是否变化（如果使用键盘改变则不会触发）
        slider.valueChangingProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
        });*/

/*        new Thread(() -> {
            for (; ; ) {
                Platform.runLater(() -> {
                    if (slider.getValue() != 100) {
                        slider.setValue(slider.getValue() + 1);
                        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    }
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (slider.getValue() == 100) {
                    System.out.println("播放完毕");
                    break;
                }
            }
        }).start();*/

        My my = new My(slider);
        my.setDelay(Duration.millis(0));
        my.setPeriod(Duration.seconds(1));
        my.start();

        my.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue = " + newValue);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            if (newValue != null && newValue.intValue() != 100) {
                slider.setValue(newValue);
            }
        });

        anchorPane.getChildren().add(slider);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider 进度条");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
