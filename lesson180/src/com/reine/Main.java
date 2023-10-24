package com.reine;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 19:30
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);
        Box box = new Box(150, 150, 150);
        Cylinder cylinder = new Cylinder(50, 200, 64);
        Point3D point3D = new Point3D(1, 0, 0);
        cylinder.setRotationAxis(point3D);
        cylinder.setRotate(60);
        Sphere sphere = new Sphere(100, 64);
        hBox.getChildren().addAll(box, cylinder, sphere);

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #ffffff00;");
        root.getChildren().addAll(hBox);
        SubScene subScene = new SubScene(root, 800, 800, false, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        subScene.setCamera(camera);
        HBox h = new HBox(100);
        Button button = new Button("button");
        TextField textField = new TextField("javafx 3D");
        h.getChildren().addAll(button, textField, subScene);

        Scene scene = new Scene(h);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D 子场景");
        primaryStage.show();

        button.setOnAction(event -> {
            cylinder.setRotate(cylinder.getRotate() + 10);
        });
    }
}
