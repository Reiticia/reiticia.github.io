package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author reine
 * 2022/6/15 15:54
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                Rectangle rectangle = new Rectangle(100, 100);
                rectangle.setFill(Paint.valueOf("#cccccc"));
                grid.add(rectangle, j, i);
            }
        }

        List<Paint> list = new ArrayList<>();

        List<Stop> stops = new ArrayList<>();
        stops.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops.add(new Stop(0.5, Color.valueOf("#ccffff")));
        stops.add(new Stop(1, Color.valueOf("#ffcccc")));
        // 线性渐变（对角线渐变）
        LinearGradient lg = new LinearGradient(0, 0, 200, 200, false, CycleMethod.NO_CYCLE, stops);
        list.add(lg);

        List<Stop> stops1 = new ArrayList<>();
        stops1.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops1.add(new Stop(0.3, Color.valueOf("#ccffff")));
        stops1.add(new Stop(0.6, Color.valueOf("#ffcccc")));
        stops1.add(new Stop(1, Color.valueOf("#99cccc")));
        // 线性渐变（对角线渐变）
        LinearGradient lg1 = new LinearGradient(0, 0, 200, 200, false, CycleMethod.NO_CYCLE, stops1);
        list.add(lg1);

        List<Stop> stops2 = new ArrayList<>();
        stops2.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops2.add(new Stop(0.3, Color.valueOf("#ccffff")));
        stops2.add(new Stop(0.6, Color.valueOf("#ffcccc")));
        stops2.add(new Stop(1, Color.valueOf("#99cccc")));
        // 线性渐变（水平渐变）
        LinearGradient lg2 = new LinearGradient(0, 100, 200, 100, false, CycleMethod.NO_CYCLE, stops2);
        list.add(lg2);

        List<Stop> stops3 = new ArrayList<>();
        stops3.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops3.add(new Stop(0.3, Color.valueOf("#ccffff")));
        stops3.add(new Stop(0.6, Color.valueOf("#ffcccc")));
        stops3.add(new Stop(1, Color.valueOf("#99cccc")));
        // 线性渐变（水平渐变）（百分比方式定位）
        LinearGradient lg3 = new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE, stops3);
        list.add(lg3);

        List<Stop> stops4 = new ArrayList<>();
        stops4.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops4.add(new Stop(1, Color.valueOf("#99cccc")));
        // 线性渐变（水平渐变）（百分比方式定位）
        LinearGradient lg4 = new LinearGradient(0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops4);
        list.add(lg4);

        List<Stop> stops5 = new ArrayList<>();
        stops5.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops5.add(new Stop(1, Color.valueOf("#99cccc")));
        // 线性渐变（水平渐变）（百分比方式定位）（对称效果）
        LinearGradient lg5 = new LinearGradient(0, 0.5, 0.5, 0.5, true, CycleMethod.REFLECT, stops5);
        list.add(lg5);

        List<Stop> stops6 = new ArrayList<>();
        stops6.add(new Stop(0, Color.valueOf("#ffffcc")));
        stops6.add(new Stop(1, Color.valueOf("#99cccc")));
        // 线性渐变（水平渐变）（百分比方式定位）（复制效果）
        LinearGradient lg6 = new LinearGradient(0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, stops6);
        list.add(lg6);

        List<Stop> stops7 = new ArrayList<>();
        stops7.add(new Stop(0, Color.valueOf("#ff9999")));
        stops7.add(new Stop(0.5, Color.valueOf("#99669900")));
        stops7.add(new Stop(1, Color.valueOf("#ffcccc")));
        // 线性渐变（水平渐变）（百分比方式定位）（中间部分完全透明）
        LinearGradient lg7 = new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE, stops7);
        list.add(lg7);

        List<Stop> stops8 = new ArrayList<>();
        stops8.add(new Stop(0, Color.valueOf("#ff9999")));
        stops8.add(new Stop(0.5, Color.valueOf("#99669900")));
        stops8.add(new Stop(1, Color.valueOf("#ffcccc")));
        // 线性渐变（水平渐变）（百分比方式定位）（中间部分完全透明）（从右到左填充）
        LinearGradient lg8 = new LinearGradient(1, 0.5, 0, 0.5, true, CycleMethod.NO_CYCLE, stops8);
        list.add(lg8);

        for (int i = 0; i < list.size(); i++) {
            Rectangle node = (Rectangle) grid.getChildren().get(i);
            node.setFill(list.get(i));
        }

        Label label = new Label("线性渐变（水平渐变）");
        label.setTextFill(lg4);
        label.setFont(new Font(30));

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setBottom(label);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LinearGradient线性渐变");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
}
