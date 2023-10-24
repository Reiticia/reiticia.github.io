package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * ColorPicker 颜色选择器
 *
 * @author reine
 * 2022/5/19 19:22
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:skyblue;");

        ColorPicker colorPicker = new ColorPicker(Color.RED);
        colorPicker.setOnAction(event -> {
            System.out.println("click the color picker");
        });

        colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " + oldValue);
            System.out.println("red = " + newValue.getRed());
            System.out.println("green = " + newValue.getGreen());
            System.out.println("blue = " + newValue.getBlue());

            String value = newValue.toString().substring(2);

            System.out.println("newValue.toString() = " + newValue);
            anchorPane.setStyle("-fx-background-color: #" + value + ";");
        });

        anchorPane.getChildren().add(colorPicker);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ColorPicker 颜色选择器");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
