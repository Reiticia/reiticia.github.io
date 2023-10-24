package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * DatePicker 日期选择器
 * @author reine
 * 2022/5/19 19:34
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:skyblue;");

        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);

        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                if (object == null) {
                    return null;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return object.format(formatter);
            }

            @Override
            public LocalDate fromString(String string) {
                return null;
            }
        });

        datePicker.setDayCellFactory(param -> {
            DateCell dateCell = new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        ImageView imageView = new ImageView("/images/logo.png");
                        imageView.setFitWidth(20);
                        imageView.setFitHeight(20);
                        this.setText("");
                        this.setGraphic(imageView);
                    }
                }
            };
            return dateCell;
        });

        datePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
            System.out.println("newValue.getYear() = " + newValue.getYear());
            System.out.println("newValue.getMonth() = " + newValue.getMonth().getValue());
            System.out.println("newValue.getDayOfMonth() = " + newValue.getDayOfMonth());
            System.out.println("newValue.getDayOfWeek() = " + newValue.getDayOfWeek().getValue());
            System.out.println("newValue.getDayOfYear() = " + newValue.getDayOfYear());
        }));

        anchorPane.getChildren().add(datePicker);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DatePicker 日期选择器");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
