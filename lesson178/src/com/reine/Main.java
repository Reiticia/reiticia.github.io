package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 17:24
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(50);
        hBox.setStyle("-fx-background-color: #ffffff00;");
        hBox.setAlignment(Pos.CENTER);
        Box box = new Box(150, 150, 150);
        box.setMaterial(new PhongMaterial(Color.valueOf("#ffffcc")));
        Box box1 = new Box(150, 150, 150);
        box1.setMaterial(new PhongMaterial(Color.valueOf("#ccffff")));
        Box box2 = new Box(150, 150, 150);
        box2.setMaterial(new PhongMaterial(Color.valueOf("#ffcccc")));
        hBox.getChildren().addAll(box, box1, box2);

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #ffff9955;");
        root.getChildren().add(hBox);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);
        SubScene subScene = new SubScene(root, 800, 800, false, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera();
        // camera.setTranslateX(300);
        // camera.setTranslateZ(-500);
        camera.setRotationAxis(Rotate.Y_AXIS);// 旋转轴设置为Y轴
        camera.setRotate(60);// 旋转60°
        // camera.setFieldOfView(100);// 视野设置为100°
        // camera.setNearClip(1.2);// 设置近野裁切面为1.2
        // camera.setFarClip(100);// 设置远野裁切面为100
        subScene.setCamera(camera);

        AnchorPane node = new AnchorPane();
        node.setStyle("-fx-background-color: #ffffff;");
        Button rotateCamera = new Button("旋转");
        node.getChildren().addAll(subScene,rotateCamera);

        Scene scene = new Scene(node);

        primaryStage.setScene(scene);
        primaryStage.setTitle("3D Camera摄像机（透视相机）");
        primaryStage.show();

        rotateCamera.setOnAction(e -> {
            if (camera.getRotate() <= 0) {
                return;
            }
            camera.setRotate(camera.getRotate() - 1);
            System.out.println("camera.getRotate() = " + camera.getRotate());
        });
    }
}
