package com.reine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author reine
 * 2022/6/10 19:27
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale locale = Locale.getDefault();
        // System.out.println(locale.getLanguage() + "-" + locale.getCountry());

        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i = 0; i < availableLocales.length; i++) {
            System.out.println(availableLocales[i]);
        }

        // 设置国家和语言
        Locale.setDefault(new Locale("en", "US"));

        FXMLLoader fxmlLoader = new FXMLLoader();
        URL fxmlPath = Main.class.getClassLoader().getResource("fxml/sample.fxml");
        fxmlLoader.setLocation(fxmlPath);
        ResourceBundle bundle = ResourceBundle.getBundle("i18n/language");
        fxmlLoader.setResources(bundle);
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("国际化");
        primaryStage.show();
    }
}
