package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 19:34
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox box = new HBox(10);

        // 画一个回
        Path path = new Path();
        // 起点
        MoveTo moveTo = new MoveTo(0, 0);
        HLineTo hLineTo = new HLineTo(100);
        hLineTo.setAbsolute(false);
        VLineTo vLineTo = new VLineTo(100);
        vLineTo.setAbsolute(false);
        HLineTo hLineTo1 = new HLineTo(-100);
        hLineTo1.setAbsolute(false);
        VLineTo vLineTo1 = new VLineTo(-100);
        vLineTo1.setAbsolute(false);

        MoveTo moveToIn = new MoveTo(25, 25);
        HLineTo hLineToIn = new HLineTo(50);
        hLineToIn.setAbsolute(false);
        VLineTo vLineToIn = new VLineTo(50);
        vLineToIn.setAbsolute(false);
        HLineTo hLineTo1In = new HLineTo(-50);
        hLineTo1In.setAbsolute(false);
        VLineTo vLineTo1In = new VLineTo(-50);
        vLineTo1In.setAbsolute(false);

        path.getElements().addAll(moveTo, hLineTo, vLineTo, hLineTo1, vLineTo1, moveToIn, hLineToIn, vLineToIn, hLineTo1In, vLineTo1In);
        path.setFill(Color.RED);
        path.setFillRule(FillRule.EVEN_ODD);
        box.getChildren().add(path);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Path路径");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
