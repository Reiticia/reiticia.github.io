package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 15:37
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("button");
        Label label = new Label("this is text.你好！");
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.valueOf("#ff9999"));
        Circle circle = new Circle(50);
        circle.setFill(Color.valueOf("#996699"));
        ImageView imageView = new ImageView("emoji/1f605.png");

        // button.setEffect(getEffect());

        HBox box = new HBox(50);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(button, label, rectangle, circle, imageView);

        /* 当父组件没有设置背景颜色时，则通过该设置可以正常显示每个子组件的效果*/
        box.getChildren().forEach(node -> {
            node.setEffect(getEffect());
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 50.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DisplacementMap位移图");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.show();

    }

    private Effect getEffect() {
        DisplacementMap displacementMap = new DisplacementMap();
        // displacementMap.setOffsetX(0.5); // 从左到右50%的图形不可见，如果为负数，则从右到左
        // displacementMap.setOffsetY(0.5); // 从上到下50%的图形不可见，如果为负数，则从下到上

        displacementMap.setWrap(true); // 如果为true，则图形不可见区域会被可见区域平铺填充
        int w = 100;
        int h = 100;
        FloatMap floatMap = new FloatMap(w, h);
        float value = 0.5f; // 错位距离，越大越远
        for (int i = 0; i < floatMap.getWidth(); i++) {
            for (int j = 0; j < floatMap.getHeight(); j++) {
                float tmp;
                if (j < h / 2) {
                    tmp = value;
                } else {
                    tmp = value * -1;
                }
                floatMap.setSamples(i, j, tmp, 0);
            }
        }
        displacementMap.setMapData(floatMap); // 设置图形错位
        // displacementMap.setScaleX(0.5); // 图形缩放比例
        // displacementMap.setScaleY(0.5); // 图形缩放比例
        return displacementMap;
    }
}
