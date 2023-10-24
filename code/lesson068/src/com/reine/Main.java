package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * ImageView
 * @author reine
 * 2022/5/29 18:28
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        String path = "images/shot.gif";
        /* 如果在新建image对象时设置了请求宽高，然后imageView又再次设置了宽高，则会在image获取到的图片宽高基础上再进行一次修改*/
        // Image image = new Image(path,20,20,true,true);
        Image image = new Image(path);
        ImageView imageView = new ImageView(image);
        // 设置图片
        imageView.setImage(new Image("images/logo.png"));
        // 保持宽高比
        imageView.setPreserveRatio(true);
        // 保持较好图片压缩质量
        imageView.setSmooth(true);
        // 设置宽高（如果设置了保持宽高比，则会以第一个设置为准）
        imageView.setFitWidth(100);
        // imageView.setFitHeight(100);
        Rectangle rectangle = new Rectangle(100, imageView.prefHeight(-1));
        // 圆弧水平直径
        rectangle.setArcWidth(50);
        // 圆弧垂直直径
        rectangle.setArcHeight(50);
        // 将图片剪切到rectangle图形上
        imageView.setClip(rectangle);

        // 图片截取，在图片距左上角(25,25)开始往右截75，再往下截75，此大小相对于原始图片尺寸而言
        // Rectangle2D rectangle2D = new Rectangle2D(0, 0, 30, 30);
        // imageView.setViewport(rectangle2D);

        // 如果不进行设置则显示为0
        System.out.println("imageView.getFitWidth() = " + imageView.getFitWidth());
        System.out.println("imageView.getFitHeight() = " + imageView.getFitHeight());

        // 获取节点布局调整方向
        System.out.println("imageView.getContentBias() = " + imageView.getContentBias());
        // 返回实际宽高
        System.out.println("imageView.prefHeight(-1) = " + imageView.prefWidth(-1));

        // 鼠标拖动事件
        imageView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getSceneX() >= 100 || event.getSceneY() >= 100) {
                    return;
                }
                if (event.getSceneX() < 0 || event.getSceneY() < 0) {
                    return;
                }
                Rectangle2D rectangle2D = new Rectangle2D(event.getSceneX(), event.getSceneY(), 30, 30);
                imageView.setViewport(rectangle2D);
            }
        });

        anchorPane.getChildren().addAll(imageView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ImageView");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
