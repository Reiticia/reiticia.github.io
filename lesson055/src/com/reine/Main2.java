package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * 双向绑定实现数据同步
 *
 * @author reine
 * 2022/5/23 8:32
 */
public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: pink;");

        TextField text1 = new TextField();
        text1.setLayoutX(0);
        text1.setLayoutY(0);
        TextField text2 = new TextField();
        text2.setLayoutX(0);
        text2.setLayoutY(50);

        anchorPane.getChildren().addAll(text1, text2);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("双向绑定实现数据同步");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        // 双向绑定
        // text1.textProperty().bindBidirectional(text2.textProperty());
        // 单向绑定（会导致text1无法修改文本）
        // text1.textProperty().bind(text2.textProperty());
        text1.textProperty().bindBidirectional(text2.textProperty(), new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                if (string.contains("5")) {
                    return string.replace("5", "五");
                }
                return string;
            }
        });

    }
}
