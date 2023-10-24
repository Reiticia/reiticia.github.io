package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/15 6:53
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefSize(800, 600);

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        HBox btnBox = new HBox(20);
        btnBox.getChildren().addAll(button1, button2);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(btnBox, htmlEditor);
        AnchorPane.setTopAnchor(htmlEditor, 50.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HTMLEditor");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button1.setOnAction(event -> {
            // htmlEditor.setHtmlText("<h1>Hello World</h1>");
            htmlEditor.setHtmlText("<img src=\"file:E:\\Users\\86158\\图片\\110300202.jpg\" width=\"800\"/>");
        });

        button2.setOnAction(event -> {
            System.out.println(htmlEditor.getHtmlText());
        });
    }
}
