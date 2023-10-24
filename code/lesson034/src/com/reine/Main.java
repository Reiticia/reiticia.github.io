package com.reine;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 单行文本与多行文本搜索排序小案例
 * @author reine
 * 2022/5/16 19:27
 */
public class Main extends Application {

    /**
     * 当前光标所在位置
     */
    private int index = 0;
    /**
     * 此步骤剩余字符串
     */
    private String subStr = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color:lightyellow;");
        gridPane.setAlignment(Pos.CENTER);

        TextField findStr = new TextField();
        Label indexOf = new Label("-1");
        Button select = new Button("select");
        Button sort = new Button("sort");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(findStr, indexOf, select, sort);
        hBox.setAlignment(Pos.CENTER);

        TextArea textArea = new TextArea();
        // 设置自动换行
        textArea.setWrapText(true);
        textArea.setFont(Font.font(16));
        textArea.setText("fgffsdasdagfdghfghsdsfdrdfsdfweasdaddada");
        VBox vBox = new VBox(10);
        vBox.setPrefSize(400, 300);
        vBox.getChildren().addAll(hBox, textArea);

        gridPane.getChildren().addAll(vBox);
        GridPane.setMargin(vBox,new Insets(10));

        // 选择按钮单选事件
        select.setOnAction(event -> {
            // 获取段落内容
            textArea.getParagraphs().forEach(text -> {
                // 多行文本里面的内容
                String value = text.toString();
                // 单行文本里面的内容
                String findStrText = findStr.getText();
                // 从索引为index的位置截取字符串
                subStr = value.substring(index);
                // 获取多行文本中单行文本内容的位置
                int res = subStr.indexOf(findStrText);
                if (res != -1) {
                    // 如果获取到，则聚焦多行文本框
                    textArea.requestFocus();
                    // 在剩余字符串中获取到的匹配文本的位置
                    int temp = res + index;
                    // 获取单行文本内容的长度
                    index = temp + findStrText.length();
                    // 多行文本内容从res位置到index位置的文本选中
                    textArea.selectRange(temp, index);
                    indexOf.setText(String.valueOf(temp));
                } else if (index != 0) {
                    index = 0;
                    select.fire();
                } else {
                    indexOf.setText("-1");
                    System.out.println("未找到文本");
                }
            });
        });

        // 排序按钮点击事件
        sort.setOnAction(event -> {
            char[] chars = textArea.getText().toCharArray();
            // 冒泡排序
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (chars[j] > chars[i]) {
                        char temp = chars[j];
                        chars[j] = chars[i];
                        chars[i] = temp;
                    }
                }
            }
            textArea.setText(String.valueOf(chars));
        });
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("单行文本与多行文本搜索排序小案例");
        primaryStage.setWidth(450);
        primaryStage.setHeight(350);
        primaryStage.show();
    }
}
