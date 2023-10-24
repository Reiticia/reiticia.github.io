package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/5/12 11:22
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        // 设置四个按钮
        Button button = new Button("btn0");
        Button button1 = new Button("btn1");
        Button button2 = new Button("btn2");
        Button button3 = new Button("btn3");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: green;");
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setStyle("-fx-background-color: yellow;");

        anchorPane1.getChildren().add(button);
        anchorPane1.setBottomAnchor(button, 0.0);
        anchorPane1.setRightAnchor(button, 0.0);

        button.setManaged(false); // 设置按钮不受管理
        button.setVisible(false); // 设置按钮不可见
        button.setOpacity(1); // 设置按钮不透明
        button.setOnAction(event -> {
            System.out.println("click");
        });

        anchorPane.getChildren().add(anchorPane1);
        primaryStage.setScene(new Scene(anchorPane));
        primaryStage.setTitle("JavaFx");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();
        anchorPane.setTopAnchor(anchorPane1, 0.0);
        anchorPane.setBottomAnchor(anchorPane1, anchorPane.getHeight() / 2 - anchorPane1.getHeight() / 2);
        anchorPane.setLeftAnchor(anchorPane1, 0.0);
        anchorPane.setRightAnchor(anchorPane1, anchorPane.getWidth() / 2 - anchorPane1.getWidth() / 2);

        anchorPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                anchorPane.setBottomAnchor(anchorPane1, anchorPane.getHeight() / 2);
            }
        });
        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                anchorPane.setRightAnchor(anchorPane1, anchorPane.getWidth() / 2);
            }
        });
    }
}
