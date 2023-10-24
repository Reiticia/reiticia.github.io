package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 9:47
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

        // button.setEffect(getEffect());

        HBox box = new HBox(50);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(button, label, rectangle, circle);

        /* 当父组件没有设置背景颜色时，则通过该设置可以正常显示每个子组件的效果*/
        box.getChildren().forEach(node -> {
            node.setEffect(getEffect());
        });
        // 使用两个图层叠加产生阴影效果
        Button button1 = new Button("button");
        Label label1 = new Label("this is text.你好！");
        Rectangle rectangle1 = new Rectangle(100, 100);
        rectangle1.setFill(Color.valueOf("#ff9999"));
        Circle circle1 = new Circle(50);
        circle1.setFill(Color.valueOf("#996699"));
        HBox box1 = new HBox(50);
        box1.setAlignment(Pos.CENTER);
        box1.getChildren().addAll(button1, label1, rectangle1, circle1);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box, box1);
        AnchorPane.setTopAnchor(box, 110.0);
        AnchorPane.setLeftAnchor(box, 110.0);
        AnchorPane.setTopAnchor(box1, 100.0);
        AnchorPane.setLeftAnchor(box1, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shadow阴影效果");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    /**
     * 阴影效果
     *
     * @return
     */
    private Effect getEffect() {
        Shadow shadow = new Shadow();
        // shadow.setColor(Color.DEEPPINK);
        // shadow.setWidth(100);
        // shadow.setHeight(100);
        // shadow.setBlurType(BlurType.GAUSSIAN);
        // shadow.setRadius(20);
        return shadow;
    }
}
