package com.reine;

import com.reine.utils.Color;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * 单行文本和多行文本
 * @author reine
 * 2022/5/15 14:01
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(20);
        TextField textField = new TextField();
        TextArea textArea = new TextArea();
        vBox.getChildren().addAll(textField, textArea);
        vBox.setAlignment(Pos.CENTER);

        // 用户每次输入文本时触发事件
        textField.setTextFormatter(new TextFormatter<String>(change -> {
            System.out.println(change.getText());
            // 限制用户单次输入的字符类型
            if (change.getText().matches("[a-z]*")) {
                return change;
            }
            return null;
        }));

        // textArea.setTextFormatter(new TextFormatter<>(new StringConverter<String>() {
        //     @Override
        //     public String toString(String object) {
        //         if (object == null) {
        //             return "";
        //         }
        //         System.out.println(Color.RED+"toString = " + object);
        //         System.out.println(Color.RED+"==================");
        //         return object;
        //     }
        //     @Override
        //     public String fromString(String string) {
        //         System.out.println(Color.BLUE+"fromString = " + string);
        //         System.out.println(Color.BLUE+"==================");
        //         return string;
        //     }
        // }));

        // 文本框文本内容变更监听事件
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            // 监听输入的文字内容，对输入的内容进行操作
            textArea.setTextFormatter(new TextFormatter<>(new StringConverter<String>() {
                @Override
                public String toString(String object) {
                    if (object == null) {
                        return "";
                    }
                    System.out.println(Color.RED+"toString = " + object);
                    System.out.println(Color.RED+"==================");
                    return object;
                }
                @Override
                public String fromString(String string) {
                    System.out.println(Color.BLUE+"fromString = " + string);
                    System.out.println(Color.BLUE+"==================");
                    // 当检测到输入的字符串中含有"5"时，将其替换成"五"，返回给界面进行显示
                    if (string.contains("5")) {
                        return string.replace("5", "五");
                    }
                    return string;
                }
            }));
            textArea.commitValue();
        });

        // textArea.textProperty().addListener((observable, oldValue, newValue) -> {
        //     System.out.println("oldValue = " + oldValue);
        //     System.out.println("newValue = " + newValue);
        //     textArea.commitValue();
        // });

        // textArea.commitValue();// 提交值

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("单行文本和多行文本");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
        textArea.setFocusTraversable(true);

    }
}
