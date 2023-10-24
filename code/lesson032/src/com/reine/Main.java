package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 多行文本
 *
 * @author reine
 * 2022/5/15 11:41
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        // 多行文本
        TextArea textArea = new TextArea();
        textArea.setFont(Font.font(20));
        // 允许自动换行
        // textArea.setWrapText(true);

        // 设置初始几行几列
        textArea.setPrefRowCount(5);
        textArea.setPrefColumnCount(5);

        // 设置宽高，会导致设置初始几行几列无效
        textArea.setPrefWidth(600);
        textArea.setPrefHeight(300);

        Label label = new Label();
        label.setTextFill(Color.BLUE);
        label.setText("???");

        Button button = new Button("Click Me");
        button.setOnAction(event -> {
            // textArea.appendText("Hello World!\n");
            // 删除索引从6开始到索引11（不包含）的字符
            // textArea.deleteText(6,11);
            // 替换
            // textArea.replaceText(6,11,"JavaFx");
            // 选中全部
            // textArea.selectAll();
            // 选择光标后面一个字符
            // textArea.selectForward();
            // 选中从索引为4的位置到光标位置的字符
            // textArea.selectPositionCaret(4);
            // 获取文本长度
            // int length = textArea.getLength();
            // label.setText(length + "");
            // textArea.selectRange(3,7);
            // textArea.setEditable(false);// 设置不可编辑
            // textArea.clear();// 清空

        });

        // 文本变化监听事件
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 10) {
                textArea.setText(oldValue);
                return;
            }
            label.setText(newValue);
        });

        // 选择的文本发生变化监听事件
        textArea.selectedTextProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        // 左右滚动监听事件
        textArea.scrollLeftProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        anchorPane.getChildren().addAll(textArea, button, label);
        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane.setBottomAnchor(label, 10.0);
        AnchorPane.setLeftAnchor(label, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("多行文本");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
}
