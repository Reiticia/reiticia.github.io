package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * setManaged(false)、setVisible(false)、setOpacity(0)区别
 * @author reine
 * 2022/5/12 13:37
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建4个按钮
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        // 再创建3个按钮
        Button button5 = new Button("button3.setManaged(false);");
        Button button6 = new Button("button3.setVisible(false);");
        Button button7 = new Button("button3.setOpacity(0);");
        // 再创建一个按钮重置button3的状态
        Button button8 = new Button("button3.setManaged(true);button3.setVisible(true);button3.setOpacity(1);");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1, button2, button3, button4);
        hBox.setSpacing(10);
        button5.setOnAction(e -> {
            button3.setManaged(false);
            Print.print(hBox);
        });
        button6.setOnAction(e -> {
            button3.setVisible(false);
            Print.print(hBox);
        });
        button7.setOnAction(e -> {
            button3.setOpacity(button3.getOpacity() - 0.1);
            Print.print(hBox);
        });
        button8.setOnAction(e -> {
            button3.setManaged(true);
            button3.setVisible(true);
            button3.setOpacity(1);
            Print.print(hBox);
        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(button5, button6, button7, button8);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: pink;");
        anchorPane.getChildren().addAll(hBox, vBox);
        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("setManaged(false)、setVisible(false)、setOpacity(0)区别");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}

class Print {

    public static void print(HBox hBox) {
        System.out.println(hBox.getChildren().size());
    }
}
