package com.reine;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/19 22:56
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button play = new Button("play");
        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        // 设置起始时中心点与路径对齐
        rectangle.setTranslateX(-50);
        rectangle.setTranslateY(50);
        Path path = getPath();

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(rectangle, path, play);
        AnchorPane.setTopAnchor(play, 10.0);
        AnchorPane.setLeftAnchor(play, 10.0);
        AnchorPane.setTopAnchor(rectangle, 100.0);
        AnchorPane.setLeftAnchor(rectangle, 100.0);
        AnchorPane.setTopAnchor(path, 100.0);
        AnchorPane.setLeftAnchor(path, 100.0);
        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation PathTransition路径动画");
        primaryStage.show();

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(5));// 设置动画持续时间
        pt.setNode(rectangle);// 设置动画节点
        pt.setPath(path);// 设置动画路径
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// 设置动画方向，图形方向与路径方向一致
        pt.setAutoReverse(true);// 设置动画循环播放
        pt.setCycleCount(PathTransition.INDEFINITE);// 设置动画循环播放次数

        play.setOnAction(event -> {
            pt.play();
        });
    }

    /**
     * 获取路径（绝对路径）
     *
     * @return
     */
    private Path getPath() {
        Path path = new Path();
        // 起点
        MoveTo moveTo = new MoveTo(0, 0);
        // 沿直线移动到(100,0)
        LineTo lineTo = new LineTo(100, 0);
        // 二次曲线
        QuadCurveTo quadCurveTo = new QuadCurveTo(100, 0, 200, 200);
        // 闭合
        ClosePath closePath = new ClosePath();
        path.setStroke(Color.valueOf("#996699"));// 设置边框颜色
        path.setStrokeWidth(1);// 设置边框宽度
        path.setStrokeLineJoin(StrokeLineJoin.BEVEL);// 设置边框连接点为圆角
        path.setStrokeLineCap(StrokeLineCap.ROUND);// 设置边框连接点为圆角
        path.getElements().addAll(moveTo, lineTo, quadCurveTo, closePath);
        return path;
    }

}
