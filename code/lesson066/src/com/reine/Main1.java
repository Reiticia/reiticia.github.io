package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author reine
 * 2022/5/27 16:00
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        Tooltip tooltip = new Tooltip();
        // 设置白色透明
        tooltip.setStyle("-fx-background-color:#ffffff00;");
        tooltip.setPrefWidth(100);
        tooltip.setPrefHeight(100);

        VBox vBox = new VBox();
        // 背景颜色，圆角，外边距
        vBox.setStyle("-fx-background-color: pink; -fx-background-radius: 20;-fx-background-insets: 0");
        // 不能完全覆盖
        vBox.setPrefWidth(100);
        vBox.setPrefHeight(100);
        vBox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView("images/logo.png");
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        vBox.getChildren().addAll(imageView);
        tooltip.setGraphic(vBox);

        Button button = new Button("btn");
        button.setTooltip(tooltip);
        button.setLayoutX(100);
        button.setLayoutY(100);

        anchorPane.getChildren().addAll(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
