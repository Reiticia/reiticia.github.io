package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/17 21:43
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox box = new HBox(10);
        SVGPath svgPath = new SVGPath();
        // 与path类似（(0,0)开始 画直线到(100,100) 垂直100 水平-100 闭合）
        svgPath.setContent("m0,0 l100,100 v100 h-100 z");
        svgPath.setStroke(Color.RED);
        box.getChildren().add(svgPath);

        SVGPath svgPath1 = new SVGPath();
        // 与path类似（(0,0)开始 画三次贝塞尔曲线控制(50,-50)和(150,50)到(200,200)）
        svgPath1.setContent("m0,0 c50,-50,150,50,200,0 ");
        svgPath1.setStroke(Color.RED);
        box.getChildren().add(svgPath1);

        SVGPath svgPath2 = new SVGPath();
        // 与path类似（(0,0)开始 画简化贝塞尔曲线控制(50,-50)到(100,100)）
        svgPath2.setContent("m0,0 s50,-50,100,0");
        svgPath2.setStroke(Color.RED);
        box.getChildren().add(svgPath2);

        SVGPath svgPath3 = new SVGPath();
        // 与path类似（(0,0)开始 画二次贝塞尔曲线控制(50,-50)到(100,100)）
        svgPath3.setContent("m0,0 q50,-50,100,0");
        svgPath3.setStroke(Color.RED);
        box.getChildren().add(svgPath3);

        SVGPath svgPath4 = new SVGPath();
        // 与path类似（(0,0)开始 画二次贝塞尔曲线控制(50,-50)到(100,100) 以二次贝塞尔曲线控制点(50,-50)的中心对称点为控制点画到(100,0)）
        svgPath4.setContent("m0,0 q50,-50,100,0 t100,0 ");
        svgPath4.setStroke(Color.RED);
        box.getChildren().add(svgPath4);

        SVGPath svgPath5 = new SVGPath();
        // 与path类似（(0,0)开始 画弧线从以100为横半径100为纵半径横轴旋转0°取长边顺时针到(100,100)）
        svgPath5.setContent("m0,0 a100,100,0,1,1,100,100 ");
        svgPath5.setStroke(Color.RED);
        box.getChildren().add(svgPath5);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D shape - SVGPath矢量图路径");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
