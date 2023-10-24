package com.reine;

import com.reine.entity.Person;
import com.reine.utils.factory.PersonBuilderFactory;
import com.reine.utils.factory.PersonBuilderFactoryMap;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author reine
 * 2022/6/9 20:10
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/data.fxml"));
        fxmlLoader.setBuilderFactory(new PersonBuilderFactory());
        HashMap root = fxmlLoader.load();
        System.out.println("root = " + root);
        Platform.exit();
    }
}
