package com.reine;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * ProgressBar和ProgressIndicator进度显示
 * @author reine
 * 2022/5/20 10:10
 */
public class Main extends Application {
    ScheduledService<Double> scheduledService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:pink;");

        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0.5);
        // 使用jdk11时会导致这两个设置无效
        progressBar.setPrefWidth(500);
        progressBar.setPrefHeight(10.0);
        progressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS); // 设置为不确定进度

        ProgressIndicator progressIndicator = new ProgressIndicator(0.5);
        progressIndicator.setPrefWidth(100);
        progressIndicator.setPrefHeight(100);
        progressIndicator.setProgress(ProgressBar.INDETERMINATE_PROGRESS); // 设置为不确定进度

        Button button = new Button("pause");
        button.setLayoutX(150.0);
        button.setLayoutY(150.0);
        button.setOnAction(event -> {
            if (scheduledService.isRunning()) {
                scheduledService.cancel();
                button.setText("start");
            } else {
                scheduledService.restart();
                button.setText("pause");
            }
        });

        anchorPane.getChildren().addAll(progressBar, progressIndicator, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ProgressBar和ProgressIndicator进度显示");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        progressBar.setLayoutX(anchorPane.getWidth() / 2 - progressBar.getPrefWidth() / 2);
        progressBar.setLayoutY(anchorPane.getHeight() / 2 - progressBar.getPrefHeight() / 2);

        scheduledService = new ScheduledService<Double>() {
            double i = 0.0;
            @Override
            protected Task<Double> createTask() {
                return new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return i += 0.0001;
                    }

                    @Override
                    protected void updateValue(Double value) {
                        super.updateValue(value);
                        progressBar.setProgress(value);
                        progressIndicator.setProgress(value);
                        if (value >= 1) {
                            scheduledService.cancel();
                            System.out.println("finish");
                        }
                    }
                };
            }
        };

        scheduledService.setDelay(Duration.millis(1));
        scheduledService.setPeriod(Duration.millis(1));
        scheduledService.start();

    }
}
