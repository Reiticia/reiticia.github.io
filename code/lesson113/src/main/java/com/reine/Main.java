package com.reine;

import com.reine.controller.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/9 11:34
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/hello.fxml"));
        Pane root = fxmlLoader.load();

        HelloController controller = fxmlLoader.getController();
        Button button = controller.getFxmlbtn();
        Label label = controller.getFxmllabel();

        // 覆盖Controller里面的方法
        button.setOnAction(event -> {
            label.setText(button.getText() + "!!!");
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("fxml的Controller");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
