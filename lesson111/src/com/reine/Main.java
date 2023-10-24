package com.reine;

import com.reine.job.MyScheduledService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;

/**
 * @author reine
 * 2022/6/9 7:57
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        // 进度条
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(200);

        // 开始和取消按钮
        Button start = new Button("start");
        Button cancel = new Button("cancel");
        Button restart = new Button("restart");
        Button reset = new Button("reset");

        // 状态
        Label state = new Label("state");
        Label value = new Label("value");
        Label title = new Label("title");
        Label message = new Label("message");

        // 将进度条和按钮添加到HBox中
        hBox.getChildren().addAll(start, cancel, restart, reset, progressBar, state, value, title, message);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setPadding(new Insets(20));
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("多任务ScheduledService");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        MyScheduledService myScheduledService = new MyScheduledService();
        // 多久之后启动
        myScheduledService.setDelay(Duration.seconds(5));
        // 1s运行一次
        myScheduledService.setPeriod(Duration.seconds(1));
        // 任务失败是否重新启动
        myScheduledService.setRestartOnFailure(true);
        // 失败重试次数
        myScheduledService.setMaximumFailureCount(4);

        start.setOnAction(event -> {
            myScheduledService.start();
        });

        cancel.setOnAction(event -> {
            myScheduledService.cancel();
        });

        restart.setOnAction(event -> {
            myScheduledService.restart();
        });

        reset.setOnAction(event -> {
            myScheduledService.reset();
            progressBar.setProgress(0);
        });

        myScheduledService.valueProperty().addListener(((observable, oldValue, newValue) -> {
            Optional.ofNullable(newValue).ifPresent(number -> message.setText(String.valueOf(number.intValue())));
        }));

        myScheduledService.lastValueProperty().addListener(((observable, oldValue, newValue) -> {
            Optional.ofNullable(newValue).ifPresent(number -> System.out.println("newValue.intValue() = " + number.intValue()));
        }));

    }
}