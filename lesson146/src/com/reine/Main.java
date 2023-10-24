package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 8:09
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

        AnchorPane root = new AnchorPane();
        root.getChildren().add(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DropShadow投影效果");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    /**
     * 投影效果
     *
     * @return
     */
    private Effect getEffect() {
        DropShadow dropShadow = new DropShadow();
        // 阴影颜色
        dropShadow.setColor(Color.valueOf("#00000055"));
        // 设置阴影面积（0~255）
        // dropShadow.setWidth(100);
        // dropShadow.setHeight(100);
        // 移动阴影区域
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(10);
        // 模糊效果
        // dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
        // 阴影半径
        dropShadow.setRadius(10);
        // 阴影模糊程度（0.0~1.0）
        dropShadow.setSpread(0.5);

        return dropShadow;
    }
}
