package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/16 8:57
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
        primaryStage.setTitle("InnerShadow内投影效果");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    /**
     * 内投影效果
     *
     * @return
     */
    private Effect getEffect() {
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.valueOf("#00000055"));
        // 设置阴影面积（0~255）
        // innerShadow.setWidth(100);
        // innerShadow.setHeight(100);
        // 移动阴影区域
        innerShadow.setOffsetX(10);
        innerShadow.setOffsetY(10);
        // 模糊效果
        innerShadow.setBlurType(BlurType.GAUSSIAN);
        // 阴影半径
        innerShadow.setRadius(10);
        // 半透明程度
        innerShadow.setChoke(0.5);


        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#00000055"));
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(10);
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setRadius(10);
        dropShadow.setSpread(0.5);

        // 叠加效果
        innerShadow.setInput(dropShadow);

        return innerShadow;
    }
}
