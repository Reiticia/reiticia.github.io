package com.reine;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/5/23 15:20
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SimpleIntegerProperty random = new SimpleIntegerProperty((int) (Math.random() * 10));
        SimpleIntegerProperty input = new SimpleIntegerProperty(0);

        BooleanBinding iEr = input.isEqualTo(random);
        Button button = new Button("判断");
        TextField textField = new TextField();
        textField.setMaxWidth(300);
        Label label = new Label();

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(textField, label, button);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("绑定判断");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();

        button.setOnAction(event -> {
            int i = Integer.parseInt(textField.getText());
            input.set(i);
            if (iEr.get()) {
                label.setText("猜对了");
            } else {
                label.setText("猜错了");
            }
        });
    }
}
