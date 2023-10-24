package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 20:17
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);

        TriangleMesh triangleMesh = new TriangleMesh();

        float[] points = {
                /*0*/0, 0, 0,
                /*1*/100, 0, 0,
                /*2*/100, 100, 0,
                /*3*/0, 100, 0,
                /*4*/100, 0, 100,
                /*5*/100, 100, 100,
                /*6*/0, 0, 100,
                /*7*/0, 100, 100,
        };
        triangleMesh.getPoints().addAll(points);// 空间点位

        float[] texCoords = {
                /*0*/0, 0,
                /*1*/0.5f, 0,
                /*2*/0.5f, 0.5f,
                /*3*/0, 0.5f,
                /*4*/1, 0,
                /*5*/1, 0.5f,
                /*6*/0, -0.5f,
                /*7*/0, 1,
        };
        triangleMesh.getTexCoords().addAll(texCoords);// 贴图坐标点

        int[] faces = {
                0, 0, 3, 3, 1, 1,
                0, 0, 1, 1, 3, 3,

                1, 1, 3, 3, 2, 2,
                1, 1, 2, 2, 3, 3,

                1, 1, 5, 5, 4, 4,
                1, 1, 4, 4, 5, 5,

                2, 2, 5, 5, 1, 1,
                2, 2, 1, 1, 5, 5,

                6, 6, 1, 1, 4, 4,
                6, 6, 4, 4, 1, 1,

                6, 6, 0, 0, 1, 1,
                6, 6, 1, 1, 0, 0,

                5, 5, 2, 2, 3, 3,
                5, 5, 3, 3, 2, 2,

                7, 7, 5, 5, 3, 3,
                7, 7, 3, 3, 5, 5,

                6, 6, 5, 5, 7, 7,
                6, 6, 7, 7, 5, 5,

                6, 6, 4, 4, 5, 5,
                6, 6, 5, 5, 4, 4,

                6, 6, 3, 3, 0, 0,
                6, 6, 0, 0, 3, 3,

                6, 6, 7, 7, 3, 3,
                6, 6, 3, 3, 7, 7,
        };
        triangleMesh.getFaces().addAll(faces);// 索引坐标

        MeshView meshView = new MeshView(triangleMesh);// 加载三角网格
        // meshView.setRotationAxis(new Point3D(1, 0, 0));
        meshView.setMaterial(new PhongMaterial(Color.BLUE));
        // meshView.setDrawMode(DrawMode.LINE);// 线框模式
        // meshView.setRotate(90);

        hBox.getChildren().addAll(meshView);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);
        Scene scene = new Scene(root, 800, 800, false, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera();
        // camera.setTranslateX(0);
        // camera.setTranslateY(0);
        // camera.setTranslateZ(0);
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D 自定义3D图形");
        primaryStage.show();

    }
}
