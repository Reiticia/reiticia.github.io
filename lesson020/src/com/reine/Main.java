package com.reine;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * TextFlow 文本布局
 * @author reine
 * 2022/5/12 18:22
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text("Hello JavaFX");
        Text text1 = new Text("Hello World");
        text.setFont(Font.font(20));//设置字体大小
        text.setFill(Color.YELLOW);//设置字体颜色
        text1.setFont(Font.font("Times New Roman", 20));//设置字体

        // 特点：支持多行文本，自动识别单词间的空格，在调整窗口大小时自动调整文本位置
        TextFlow textFlow = new TextFlow();
        textFlow.setStyle("-fx-background-color: #336699;");
        textFlow.setPadding(new Insets(10));//设置文本内边距
        textFlow.setTextAlignment(TextAlignment.CENTER);//设置文本对齐方式
        textFlow.setLineSpacing(50);//设置行间距
        textFlow.getChildren().addAll(text, text1,new Button("Button"));

        AnchorPane anchorPane = new AnchorPane(textFlow);
        AnchorPane.setLeftAnchor(textFlow, 10.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TextFlow 文本布局");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();

        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            // textFlow特性放置到其他组件上会失去其特性，其无法监听到窗口大小的变化
            System.out.println("anchorPane width: " + anchorPane.getWidth());
            System.out.println("textFlow width:" + textFlow.getWidth());
        });
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            textFlow.setPrefWidth(newValue.doubleValue()-textFlow.getLayoutX());
        });
        anchorPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            textFlow.setPrefHeight(newValue.doubleValue()-textFlow.getLayoutY());
        });
    }
}
