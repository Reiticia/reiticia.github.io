package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 9:30
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane box = new FlowPane();
        box.setHgap(10);
        box.setVgap(10);
        Rectangle rectangle = new Rectangle();
        // 设置位置，如果父组件拥有对子组件的约束能力，则该设置无效
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(200);
        rectangle.setHeight(100);
        rectangle.setFill(Color.valueOf("#ff9999"));
        box.getChildren().add(rectangle);

        rectangle.setOnMouseClicked(event -> {
            if (event.getClickCount()>1){
                return;
            }
            // 这两个属性可以看出设置XY生效，但组件位置交由父组件管理，故效果没有呈现
            System.out.println(rectangle.getLayoutBounds());
            System.out.println(rectangle.getBoundsInLocal());
            System.out.println(rectangle.getBoundsInParent());
        });

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(200);
        rectangle1.setHeight(100);
        rectangle1.setFill(Color.valueOf("#ff9999"));
        // 可以将圆角看为¼椭圆，横轴为arcWidth，纵轴为arcHeight
        rectangle1.setArcWidth(30);// 设置圆角
        rectangle1.setArcHeight(30);// 设置圆角
        box.getChildren().add(rectangle1);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(200);
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.valueOf("#ff9999"));
        rectangle2.setArcWidth(30);
        rectangle2.setArcHeight(30);
        rectangle2.setStroke(Color.valueOf("#996699"));// 设置边框颜色
        rectangle2.setStrokeWidth(5);// 设置边框宽度
        rectangle2.setStrokeType(StrokeType.INSIDE);// 设置边框类型
        box.getChildren().add(rectangle2);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setWidth(200);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.valueOf("#ff9999"));
        rectangle3.setArcWidth(30);
        rectangle3.setArcHeight(30);
        rectangle3.setStroke(Color.valueOf("#996699"));
        rectangle3.setStrokeWidth(10);
        rectangle3.setStrokeType(StrokeType.OUTSIDE);
        rectangle3.getStrokeDashArray().addAll(10.0, 30.0);// 设置边框虚线
        box.getChildren().add(rectangle3);

        Rectangle rectangle4 = new Rectangle();
        // 设置位置，如果父组件拥有对子组件的约束能力，则该设置无效
        rectangle4.setX(500);
        rectangle4.setY(50);
        rectangle4.setWidth(200);
        rectangle4.setHeight(100);
        rectangle4.setFill(Color.valueOf("#ffcccc"));
        rectangle4.setOnMouseClicked(event -> {
            if (event.getClickCount()>1){
                return;
            }
            System.out.println(rectangle4.getLayoutBounds());
            System.out.println(rectangle4.getBoundsInLocal());
            System.out.println(rectangle4.getBoundsInParent());
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box, rectangle4);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Rectangle矩形");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
