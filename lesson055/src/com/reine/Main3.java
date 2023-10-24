package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 单向绑定，按钮位置随进度条改变
 * @author reine
 * 2022/5/23 8:54
 */
public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: pink;");
        Button button = new Button("button");
        Slider slider = new Slider(0, 500, 0);
        slider.setPrefWidth(500);
        slider.setLayoutY(100);

        anchorPane.getChildren().addAll(button, slider);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("单向绑定，按钮位置随进度条改变");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        // 单向绑定（使用translateXProperty，而不是LayoutXProperty）
        button.translateXProperty().bind(slider.valueProperty());
    }
}
