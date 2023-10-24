package com.reine;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 10:39
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane box = new GridPane();
        box.setHgap(10);
        box.setVgap(10);
        // box.setOrientation(Orientation.VERTICAL);

        Circle circle = new Circle();
        // 圆心位置
        circle.setCenterX(0);
        circle.setCenterY(0);
        circle.setRadius(100);// 半径
        circle.setFill(Color.valueOf("#ff9999")); // 填充颜色
        box.add(circle, 0, 0);

        Circle circle1 = new Circle();
        circle1.setCenterX(0);
        circle1.setCenterY(0);
        circle1.setRadius(100);
        circle1.setFill(Color.valueOf("#ff9999"));
        circle1.setStrokeWidth(10);
        circle1.setStroke(Color.valueOf("#996699"));
        circle1.setSmooth(true);// 平滑
        box.add(circle1, 1, 0);

        Circle circle2 = new Circle();
        circle2.setCenterX(0);
        circle2.setCenterY(0);
        circle2.setRadius(100);
        circle2.setFill(Color.valueOf("#ff9999"));
        circle2.setStrokeWidth(3);
        circle2.setStroke(Color.valueOf("#996699"));
        circle2.setSmooth(true);
        circle2.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
        box.add(circle2, 2, 0);

        Circle circle3 = new Circle();
        // 被父组件约束了
        circle3.setCenterX(100);
        circle3.setCenterY(100);
        circle3.setRadius(100);
        circle3.setFill(Color.valueOf("#ff9999"));
        circle3.setStrokeWidth(3);
        circle3.setStroke(Color.valueOf("#996699"));
        circle3.setSmooth(true);
        circle3.getStrokeDashArray().addAll(10.0, 10.0);// 虚线
        box.add(circle3, 0, 1);

        Circle circle4 = new Circle();
        // 被父组件约束了
        circle4.setCenterX(0);
        circle4.setCenterY(0);
        circle4.setRadius(100);
        circle4.setFill(Color.valueOf("#ff9999"));
        circle4.setSmooth(true);
        circle4.setOnMouseClicked(event -> {
            if (event.getClickCount()>1){
                return;
            }
            System.out.println(circle4.getLayoutBounds());
            System.out.println(circle4.getBoundsInLocal());
            System.out.println(circle4.getBoundsInParent());
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box,circle4);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Circle圆形");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
