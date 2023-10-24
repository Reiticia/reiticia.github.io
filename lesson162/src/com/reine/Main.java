package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 20:09
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.BLUE);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(20);
        GaussianBlur gaussianBlur = new GaussianBlur(5);
        dropShadow.setInput(gaussianBlur);
        rectangle.setEffect(dropShadow);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(rectangle);
        AnchorPane.setTopAnchor(rectangle, 100.0);
        AnchorPane.setLeftAnchor(rectangle, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Effect效果叠加");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        rectangle.setOnMouseClicked(event -> {
            // 防抖效果
            if (event.getClickCount() == 1) {
                // 设置效果不会改变宽高
                System.out.println(rectangle.getWidth() + "-" + rectangle.getHeight());
                System.out.println(rectangle.getLayoutBounds());
                // 坐标改变，相较于布局边界，本地布局延申的宽高为所有效果的半径之和
                System.out.println(rectangle.getBoundsInLocal());
                // 父组件布局延申的宽高为所有效果的半径之和
                System.out.println(rectangle.getBoundsInParent());
            }
        });
    }
}
