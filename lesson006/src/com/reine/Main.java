package com.reine;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Screen类
 * @author reine
 * 2022/5/11 20:13
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen screen = Screen.getPrimary();
        double dpi = screen.getDpi();
        System.out.println("dpi: " + dpi);
        Rectangle2D rec = screen.getBounds();
        // 获取全部屏幕宽高和坐标
        System.out.println("left up x: " + rec.getMinX());
        System.out.println("left up y: " + rec.getMinY());
        System.out.println("right down x: " + rec.getMaxX());
        System.out.println("right down y: " + rec.getMaxY());
        System.out.println("width: " + rec.getWidth());
        System.out.println("height: " + rec.getHeight());
        // 获取可以看到屏幕宽高和坐标
        Rectangle2D rec2 = screen.getVisualBounds();
        System.out.println("left up x: " + rec2.getMinX());
        System.out.println("left up y: " + rec2.getMinY());
        System.out.println("right down x: " + rec2.getMaxX());
        System.out.println("right down y: " + rec2.getMaxY());
        System.out.println("width: " + rec2.getWidth());
        System.out.println("height: " + rec2.getHeight());

    }
}
