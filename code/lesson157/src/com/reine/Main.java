package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 17:10
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
        primaryStage.setTitle("ColorAdjust颜色调整");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    /**
     * 颜色调整
     *
     * @return
     */
    private Effect getEffect() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(1);// 设置色相
        colorAdjust.setSaturation(-0.5);// 设置饱和度
        colorAdjust.setBrightness(0.3);// 设置亮度
        colorAdjust.setContrast(0.5);// 设置对比度
        return colorAdjust;
    }
}
