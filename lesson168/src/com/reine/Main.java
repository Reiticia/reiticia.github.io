package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 15:33
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);

        Arc arc = new Arc();
        arc.setCenterX(0);
        arc.setCenterY(0);
        arc.setRadiusX(100);
        arc.setRadiusY(100);
        arc.setFill(Color.valueOf("#ff9999"));
        arc.setLength(90);// 设置展开的角度
        arc.setStartAngle(30);// 逆时针旋转30度
        arc.setType(ArcType.ROUND);// 圆弧两端连接圆心类型
        // arc.setType(ArcType.OPEN);// 圆弧两端不相连类型
        // arc.setType(ArcType.CHORD);// 圆弧两端相连类型
        box.getChildren().add(arc);

        Arc arc1 = new Arc();
        arc1.setRadiusX(100);
        arc1.setRadiusY(100);
        arc1.setFill(Color.valueOf("#ff9999"));
        arc1.setLength(90);
        arc1.setStartAngle(60);
        arc1.setType(ArcType.ROUND);
        box.getChildren().add(arc1);

        Arc arc2 = new Arc();
        arc2.setRadiusX(100);
        arc2.setRadiusY(100);
        arc2.setFill(Color.valueOf("#ff9999"));
        arc2.setLength(90);
        arc2.setStartAngle(60);
        arc2.setType(ArcType.ROUND);
        arc2.setStrokeWidth(3);
        arc2.setStroke(Color.valueOf("#996699"));
        box.getChildren().add(arc2);

        Arc arc3 = new Arc();
        arc3.setRadiusX(200);
        arc3.setRadiusY(100);
        arc3.setFill(Color.valueOf("#ff9999"));
        arc3.setLength(90);
        arc3.setStartAngle(0);
        arc3.setType(ArcType.ROUND);
        arc3.setStrokeWidth(3);
        arc3.setStroke(Color.valueOf("#996699"));
        box.getChildren().add(arc3);

        Arc arc4 = new Arc();
        arc4.setRadiusX(100);
        arc4.setRadiusY(100);
        arc4.setFill(Color.valueOf("#ff9999"));
        arc4.setLength(90);
        arc4.setStartAngle(0);
        arc4.setType(ArcType.OPEN);// 有边框时，圆弧两端不以边框相连类型
        arc4.setStrokeWidth(3);
        arc4.setStroke(Color.valueOf("#996699"));
        box.getChildren().add(arc4);

        Arc arc5 = new Arc();
        arc5.setRadiusX(100);
        arc5.setRadiusY(100);
        arc5.setFill(Color.valueOf("#ff9999"));
        arc5.setLength(90);
        arc5.setStartAngle(0);
        arc5.setType(ArcType.CHORD);// 有边框时，圆弧两端以边框相连类型
        arc5.setStrokeWidth(3);
        arc5.setStroke(Color.valueOf("#996699"));
        box.getChildren().add(arc5);

        Arc arc6 = new Arc();
        arc6.setRadiusX(100);
        arc6.setRadiusY(100);
        arc6.setFill(Color.valueOf("#ff9999"));
        arc6.setLength(90);
        arc6.setStartAngle(0);
        arc6.setType(ArcType.CHORD);// 有边框时，圆弧两端以边框相连类型
        arc6.setStrokeWidth(3);
        arc6.setStroke(Color.valueOf("#996699"));
        arc6.setStrokeType(StrokeType.CENTERED);// 设置边框类型
        arc6.getStrokeDashArray().addAll(10.0, 10.0);// 设置虚线
        box.getChildren().add(arc6);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - Arc弧形");
        primaryStage.setWidth(1500);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
