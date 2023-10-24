package com.reine;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/5 8:39
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text("hello World");
        text.setFont(new Font(20));
        text.setX(100);
        text.setY(100);
        // 位置对齐方式：以左上角为观测点计算坐标(X,Y)
        text.setTextOrigin(VPos.TOP);
        // 位置对齐方式：以中间为观测点计算坐标(X,Y)
        text.setTextOrigin(VPos.CENTER);
        // 位置对齐方式：以左下角为观测点计算坐标(X,Y)
        text.setTextOrigin(VPos.BASELINE);
        // 位置对齐方式：以左下角为观测点计算坐标(X,Y)，相比上面一行文本会向上移动一点
        text.setTextOrigin(VPos.BOTTOM);


        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: red;");
        hBox.setPrefWidth(400);
        hBox.setPrefHeight(400);
        hBox.setLayoutX(100);
        hBox.setLayoutY(100);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox, text);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("text四种位置对齐方式");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
