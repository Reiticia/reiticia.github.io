package com.reine;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 13:35
 */
public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(50);
        ObservableList<Node> children = hBox.getChildren();
        for (int i = 0; i < 5; i++) {
            // 创建一个球形
            Sphere sphere = new Sphere(50, 64);
            children.add(sphere);
        }

        Sphere node = (Sphere) hBox.getChildren().get(0);
        node.setTranslateZ(100);// 沿z轴平移100
        node.setRotationAxis(new Point3D(1, 0, 0));// 沿x轴旋转
        node.setRotate(45);// 沿x轴旋转45度

        Sphere node1 = (Sphere) hBox.getChildren().get(1);
        node1.setOnMouseClicked(event -> {
            System.out.println(node1);
            System.out.println(node1.getDivisions());
        });

        Sphere node2 = (Sphere) hBox.getChildren().get(2);
        node2.setRotationAxis(new Point3D(1, 0, 0));// 沿x轴旋转
        node2.setRotate(45);// 沿x轴旋转45度
        node2.setDrawMode(DrawMode.LINE);// 线框模式
        node2.setCullFace(CullFace.BACK);// 只显示前面的部分
        // node2.setCullFace(CullFace.FRONT);// 只显示后面的部分

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #ffffff00;");
        root.getChildren().addAll(hBox);
        AnchorPane.setTopAnchor(hBox, 200.0);
        AnchorPane.setLeftAnchor(hBox, 50.0);
        Scene scene = new Scene(root, 800, 800, false, SceneAntialiasing.BALANCED);  // 启用3d渲染效果, 并且启用抗锯齿，如果需要实现点击效果，则要禁用深度缓冲区标志
        scene.setCamera(new PerspectiveCamera());
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D shape");
        primaryStage.show();
    }
}
