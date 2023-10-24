package com.reine;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 16:24
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(100);
        hBox.setAlignment(Pos.CENTER);
        Box box = new Box(150, 150, 150);
        Cylinder cylinder = new Cylinder(50, 200, 64);
        Point3D point3D = new Point3D(1, 0, 0);
        cylinder.setRotationAxis(point3D);
        cylinder.setRotate(60);

        Sphere sphere = new Sphere(100, 64);
        hBox.getChildren().addAll(box, cylinder, sphere);

        hBox.getChildren().forEach(node -> {
            Shape3D shape = (Shape3D) node;
            PhongMaterial phongMaterial = new PhongMaterial();
            phongMaterial.setDiffuseColor(Color.valueOf("#ff9966"));// 漫反射颜色
            phongMaterial.setSpecularColor(Color.WHITE);// 镜面反射颜色
            // phongMaterial.setSpecularPower(25);// 高光强度，越大高光面积越小
            // phongMaterial.setDiffuseMap(new Image("images/image.png"));
            // phongMaterial.setBumpMap(new Image("images/fxImage.png"));// 法线贴图

            phongMaterial.setSelfIlluminationMap(new Image("images/image.png"));// 自发光贴图
            shape.setMaterial(phongMaterial);
        });

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #ffffff00;");
        root.getChildren().addAll(hBox);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 75.0);
        Scene scene = new Scene(root, 800, 800, false, SceneAntialiasing.BALANCED);
        scene.setCamera(new PerspectiveCamera());
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D 材质");
        primaryStage.show();

    }
}
