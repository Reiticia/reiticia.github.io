package com.reine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author reine
 * 2022/6/11 10:16
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getClassLoader().getResource("fxml/sample.fxml"));
        AnchorPane root = fxmlLoader.load();

        // root.setStyle("-fx-background-color: linear-gradient(to bottom right, yellow, black);" +
        //         "-fx-border-color: green;-fx-border-width: 10,20,30,40;");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getClassLoader().getResource("css/samplecss.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("CSS");
        primaryStage.show();
    }
}
