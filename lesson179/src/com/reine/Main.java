package com.reine;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 18:53
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

        AmbientLight ambientLight = new AmbientLight();// 环境光
        ambientLight.setColor(Color.YELLOW);
        ambientLight.getScope().add(box);// 将环境光应用到立方体上
        ambientLight.setLightOn(false);// 关闭环境光

        PointLight pointLight = new PointLight();// 点光源
        pointLight.setColor(Color.RED);
        pointLight.setLightOn(false);// 关闭点光源
        pointLight.getScope().add(cylinder);// 将点光源应用到圆柱体上
        pointLight.setTranslateX(400);
        pointLight.setTranslateY(400);
        pointLight.setTranslateZ(-400);

        Button button = new Button("turn on/off ambient light");
        button.setOnAction(e -> {
            ambientLight.setLightOn(!ambientLight.isLightOn());
        });
        Button button1 = new Button("turn on/off point light");
        button1.setOnAction(e -> {
            pointLight.setLightOn(!pointLight.isLightOn());
        });

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #ffffff00;");
        root.getChildren().addAll(hBox, ambientLight, pointLight, button,button1);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 150.0);
        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 10.0);
        AnchorPane.setBottomAnchor(button1, 10.0);
        AnchorPane.setLeftAnchor(button1, 10.0);
        Scene scene = new Scene(root, 800, 800, false, SceneAntialiasing.BALANCED);
        scene.setCamera(new PerspectiveCamera());
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D 光源");
        primaryStage.show();

    }
}
