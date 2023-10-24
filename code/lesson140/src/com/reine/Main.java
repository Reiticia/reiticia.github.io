package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/15 7:43
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("首页");
        label.setPrefWidth(200);
        TextField textField = new TextField();
        textField.setPrefWidth(200);
        Button forward = new Button("前进");
        Button back = new Button("后退");
        Button info = new Button("信息");
        HBox btnBox = new HBox(20);
        btnBox.getChildren().addAll(label, textField, forward, back, info);
        btnBox.setAlignment(Pos.CENTER);

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load("https://www.baidu.com");
        webView.setZoom(0.8);
        webView.setContextMenuEnabled(false);
        WebHistory history = engine.getHistory(); // 获取历史记录
        ObservableList<WebHistory.Entry> list = history.getEntries();

        BorderPane root = new BorderPane();
        root.setCenter(webView);
        root.setTop(btnBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WebHistory浏览记录");
        primaryStage.setWidth(810);
        primaryStage.setHeight(540);
        primaryStage.show();

        history.currentIndexProperty().addListener((observable, oldValue, newValue) -> {
            int index = newValue.intValue();
            String title = list.get(index - 1).getTitle();
            label.setText(title);
        });

        info.setOnAction(e -> {
            System.out.println("当前页面索引：" + history.getCurrentIndex());
            System.out.println("最大页面索引：" + history.getMaxSize());
            System.out.println("当前页面数量：" + list.size());
            history.getEntries().forEach(entry -> {
                System.out.println(entry.getTitle() + "-" + entry.getUrl());
            });
        });
        forward.setOnAction(e -> {
            if (history.getCurrentIndex() >= list.size() - 1) {
                System.out.println("已经是最后一页了");
                return;
            }
            history.go(1);
        });
        back.setOnAction(e -> {
            if (history.getCurrentIndex() <= 0) {
                System.out.println("已经是第一页了");
                return;
            }
            history.go(-1);
        });

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                engine.load("https://" + textField.getText());
            }
        });
    }
}
