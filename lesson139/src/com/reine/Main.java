package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/15 7:18
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load("https://www.baidu.com");

        // 网页字体大小
        webView.setFontScale(0.5);
        // 网页缩放
        webView.setZoom(0.5);

        // 加载HTML文本
        String html = "<html>" +
                "<head>" +
                "<title>JavaFX WebView</title>" +
                "</head>" +
                "<body>" +
                "<h1>Hello World</h1>" +
                "</body>" +
                "</html>";
        // engine.loadContent(html, "text/html");

        // 关闭右键菜单功能
        webView.setContextMenuEnabled(false);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(webView);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WebView");
        primaryStage.setWidth(1920 / 2);
        primaryStage.setHeight(1080 / 2);
        primaryStage.show();

        webView.prefHeightProperty().bind(root.heightProperty());
        webView.prefWidthProperty().bind(root.widthProperty());

    }
}
