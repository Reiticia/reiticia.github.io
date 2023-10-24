package com.reine;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * HBox和VBox
 * @author reine
 * 2022/5/12 12:41
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        // 创建水平布局容器
        HBox hBox = new HBox();
        hBox.setStyle("-fx-border-color: skyblue");
        hBox.setPrefSize(500, 200);
        // 创建3个按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        // hBox.getChildren().addAll(button1, button2, button3);
        VBox vBox = new VBox();
        vBox.setStyle("-fx-border-color: pink");
        vBox.setPrefSize(200, 200);
        // 将3个按钮添加到容器中
        vBox.getChildren().addAll(button1, button2, button3);
        vBox.setPadding(new Insets(50)); // 设置内边距
        vBox.setSpacing(10); // 设置间距
        vBox.setMargin(button1, new Insets(10)); // 设置按钮1的内边距
        vBox.setAlignment(Pos.CENTER); // 设置水平居中


        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HBox和VBox");
        primaryStage.show();
    }
}
