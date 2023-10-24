package com.reine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/9 9:16
 */
public class LoadFxml extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("com/reine/fxml/myfxml.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("fxml");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        Button btn = (Button) root.lookup("#fxmlbtn");
        btn.setOnAction(event -> {
            System.out.println("btn.getText() = " + btn.getText());
        });
    }
}
