package com.reine;

import com.reine.job.MyService;
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

/**
 * @author reine
 * 2022/6/8 19:48
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
        primaryStage.setTitle("多任务Service");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        MyService myService = new MyService();

        start.setOnAction(event -> {
            myService.start();
        });

        cancel.setOnAction(event -> {
            myService.cancel();
        });

        restart.setOnAction(event -> {
            myService.restart();
        });

        reset.setOnAction(event -> {
            myService.reset();
            progressBar.setProgress(0);
        });

        myService.progressProperty().addListener((observable, oldValue, newValue) -> {
            progressBar.setProgress(newValue.doubleValue());
        });

        myService.messageProperty().addListener(((observable, oldValue, newValue) -> {
            message.setText(newValue);
        }));
    }
}
