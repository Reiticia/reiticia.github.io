package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author reine
 * 2022/6/15 9:49
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

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle rectangle = new Rectangle(100, 100);
                rectangle.setFill(Paint.valueOf("#cccccc"));
                grid.add(rectangle, j, i);
            }
        }

        List<Color> list = new ArrayList<>();

        list.add(Color.valueOf("#ffcccc"));
        list.add(Color.valueOf("#ffcccc55"));
        list.add(Color.valueOf("0xffcccc"));
        list.add(Color.CADETBLUE);
        list.add(Color.MEDIUMAQUAMARINE);
        list.add(new Color(58.0 / 255, 95.0 / 255, 85.0 / 255, 1.0));
        list.add(new Color(58.0 / 255, 95.0 / 255, 85.0 / 255, 0.5));
        list.add(new Color(58.0 / 255, 95.0 / 255, 85.0 / 255, 0));
        list.add(Color.rgb(199, 84, 80, 1));
        list.add(Color.hsb(205, 0.55, 0.96, 1));
        Color color = Color.rgb(255, 102, 102);
        list.add(color.deriveColor(-100, 1, 1, 1));
        list.add(Color.web("rgb(102,51,102)", 0.5));
        list.add(Color.gray(0.5, 1));
        list.add(Color.grayRgb(128, 1));
        list.add(Color.rgb(54, 105, 198, 1));
        list.add(Color.rgb(54, 105, 198, 1).brighter()); // 更亮
        list.add(Color.rgb(54, 105, 198, 1).darker()); // 更暗
        list.add(Color.rgb(54, 105, 198, 1).saturate()); // 更饱和
        list.add(Color.rgb(54, 105, 198, 1).desaturate()); // 更淡
        list.add(Color.rgb(54, 105, 198, 1).grayscale()); // 更灰
        list.add(Color.rgb(54, 105, 198, 1).invert()); // 更反色
        System.out.printf("red:%.2f green:%.2f blue:%.2f\n", color.getRed() * 255, color.getGreen() * 255, color.getBlue() * 255);
        System.out.println("opacity:" + color.getOpacity());
        System.out.printf("hue:%.2f saturation:%.2f brightness:%.2f\n", color.getHue(), color.getSaturation(), color.getBrightness());
        System.out.println(color.isOpaque());// 是否不透明

        for (int i = 0; i < list.size(); i++) {
            Rectangle node = (Rectangle) grid.getChildren().get(i);
            node.setFill(list.get(i));
        }

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Color");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
