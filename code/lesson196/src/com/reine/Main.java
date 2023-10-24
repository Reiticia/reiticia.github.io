package com.reine;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author reine
 * 2022/6/20 13:03
 */
public class Main extends Application {

    /**
     * 向左向右图片
     */
    private ImageView leftButton;
    private ImageView rightButton;

    /**
     * 三张图片x坐标，y坐标，z坐标
     */
    private List<Double> indexOfx = new ArrayList<>();
    private double indexOfy = 0.0;
    private double indexOfz = 0.0;
    /**
     * 动画时间
     */
    private Duration time = Duration.seconds(0.5);

    private List<ImageView> imgList = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane view = getView(700, 400);

        TilePane root = new TilePane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.getChildren().addAll(view);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Animation 轮播图");
        primaryStage.show();

        leftButton.setOnMouseClicked(event -> {
            System.out.println("向左");
            // 防抖
            if (event.getClickCount() > 1) {
                return;
            }
            rightToLeft();
        });

        rightButton.setOnMouseClicked(event -> {
            System.out.println("向右");
            // 防抖
            if (event.getClickCount() > 1) {
                return;
            }
            leftToRight();
        });
    }

    /**
     * 获取轮播图
     *
     * @param width  宽度
     * @param height 高度
     * @return 轮播图
     */
    private Pane getView(Integer width, Integer height) {
        leftButton = new ImageView("/images/left.png");
        leftButton.setPreserveRatio(true);
        leftButton.setPickOnBounds(true);// 图片边界内点击有效
        leftButton.setFitHeight(80);
        rightButton = new ImageView("/images/right.png");
        rightButton.setPreserveRatio(true);
        rightButton.setPickOnBounds(true);// 图片边界内点击有效
        rightButton.setFitHeight(80);

        // 左右按钮
        HBox hBox = new HBox();
        hBox.setSpacing(width - leftButton.prefWidth(-1) - rightButton.prefWidth(-1));// 设置间距
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(leftButton, rightButton);

        // 轮播图内容
        ImageView saren = new ImageView("/images/saren.png");
        ImageView kyouka = new ImageView("/images/kyouka.png");
        ImageView uzuki = new ImageView("/images/uzuki.png");

        AnchorPane ap = new AnchorPane();
        ap.getChildren().addAll(saren, kyouka, uzuki);
        // 每张图片通用设置
        ap.getChildren().forEach(node -> {
            ImageView iv = (ImageView) node;
            iv.setPreserveRatio(true);
            iv.setFitWidth(width / 1.5);
        });
        // 初始化图片坐标
        indexOfz = 100.0;
        indexOfy = (height - saren.prefHeight(-1)) / 2;
        indexOfx.add(0 - indexOfz);
        indexOfx.add((width - saren.getFitWidth()) / 2.0);
        indexOfx.add(width - saren.getFitWidth() + indexOfz);

        // 初始化图片位置
        // 左边图片
        saren.setTranslateX(indexOfx.get(0));
        saren.setTranslateY(indexOfy);
        saren.setTranslateZ(indexOfz);
        // 中间图片
        kyouka.setTranslateX(indexOfx.get(1));
        kyouka.setTranslateY(indexOfy);
        kyouka.setTranslateZ(0);
        // 右边图片
        uzuki.setTranslateX(indexOfx.get(2));
        uzuki.setTranslateY(indexOfy);
        uzuki.setTranslateZ(indexOfz);

        imgList.add(saren);// 左
        imgList.add(kyouka);// 中
        imgList.add(uzuki);// 右

        SubScene subScene = new SubScene(ap, width, height, true, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera();
        subScene.setCamera(camera);

        StackPane sp = new StackPane();
        sp.setStyle("-fx-background-color: #ccffff;");
        sp.getChildren().addAll(subScene, hBox);
        return sp;
    }

    /**
     * 向左移动
     */
    private void rightToLeft() {
        ParallelTransition parallelTransition = new ParallelTransition();
        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = imgList.get(i);
            Animation animation = toLeftAnimation(imageView);
            parallelTransition.getChildren().add(animation);
        }
        parallelTransition.play();
    }

    /**
     * 向右移动
     */
    private void leftToRight() {
        ParallelTransition parallelTransition = new ParallelTransition();
        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = imgList.get(i);
            Animation animation = toRightAnimation(imageView);
            parallelTransition.getChildren().add(animation);
        }
        parallelTransition.play();
    }

    /**
     * 向左动画
     *
     * @return
     */
    private Animation toLeftAnimation(ImageView iv) {
        double x = iv.getTranslateX();
        // 获取图片x坐标在数组中的索引
        int i = indexOfx.indexOf(x);
        // 索引前移一位，如果超出数组范围，则取模
        int newIndex = (i - 1) < 0 ? indexOfx.size() - 1 : (i - 1);
        double newX = indexOfx.get(newIndex);
        double translateZ = iv.getTranslateZ();
        double newTranslateZ = 0.0;
        if (newIndex == 1) {
            newTranslateZ = 0.0;
        } else {
            newTranslateZ = indexOfz;
        }
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(time);
        tt.setFromX(x);
        tt.setFromZ(translateZ);
        tt.setToX(newX);
        tt.setToZ(newTranslateZ);

        double oldFade = 0.0;
        double newFade = 0.0;
        if (newIndex == 1) {
            oldFade = 0.5;
            newFade = 1.0;
        } else {
            newFade = 0.5;
            oldFade = 1.0;
        }
        FadeTransition ft = new FadeTransition();
        ft.setDuration(time);
        ft.setFromValue(oldFade);
        ft.setToValue(newFade);

        ParallelTransition pt = new ParallelTransition();
        pt.setNode(iv);
        pt.getChildren().addAll(tt, ft);

        return pt;
    }

    /**
     * 向右动画
     *
     * @return
     */
    private Animation toRightAnimation(ImageView iv) {
        double x = iv.getTranslateX();
        // 获取图片x坐标在数组中的索引
        int i = indexOfx.indexOf(x);
        // 索引后移一位，如果超出数组范围，则取模
        int newIndex = (i + 1) % 3;
        double newX = indexOfx.get(newIndex);
        double translateZ = iv.getTranslateZ();
        double newTranslateZ = 0.0;
        if (newIndex == 1) {
            newTranslateZ = 0.0;
        } else {
            newTranslateZ = indexOfz;
        }
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(time);
        tt.setFromX(x);
        tt.setFromZ(translateZ);
        tt.setToX(newX);
        tt.setToZ(newTranslateZ);

        double oldFade = 0.0;
        double newFade = 0.0;
        if (newIndex == 1) {
            oldFade = 0.5;
            newFade = 1.0;
        } else {
            newFade = 0.5;
            oldFade = 1.0;
        }
        FadeTransition ft = new FadeTransition();
        ft.setDuration(time);
        ft.setFromValue(oldFade);
        ft.setToValue(newFade);

        ParallelTransition pt = new ParallelTransition();
        pt.setNode(iv);
        pt.getChildren().addAll(tt, ft);

        return pt;
    }
}
