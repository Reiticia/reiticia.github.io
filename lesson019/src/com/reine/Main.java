package com.reine;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * StackPane 栈布局
 * @author reine
 * 2022/5/12 17:49
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建5个按钮
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        // 创建栈布局
        StackPane pane = new StackPane();
        pane.setStyle("-fx-background-color: #336699;");
        pane.getChildren().addAll(button1, button2, button3, button4, button5);

        pane.setPadding(new Insets(10.0));
        pane.setAlignment(Pos.CENTER);
        StackPane.setMargin(button1, new Insets(10.0));



        pane.getChildren().forEach(node -> {
            Button btn = (Button) node;
            System.out.println(btn.getText());
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("StackPane 栈布局");
        primaryStage.show();
    }
}
