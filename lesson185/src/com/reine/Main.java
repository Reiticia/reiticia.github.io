package com.reine;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/19 16:51
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleButton rotateBtn = new ToggleButton("rotate");
        ToggleButton scaleBtn = new ToggleButton("scale");
        ToggleButton stop = new ToggleButton("stop");
        ToggleGroup group = new ToggleGroup();
        rotateBtn.setToggleGroup(group);
        scaleBtn.setToggleGroup(group);
        stop.setToggleGroup(group);
        HBox hBox = new HBox(30);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(rotateBtn, scaleBtn, stop);

        Box box = new Box(100, 100, 100);
        PhongMaterial material = new PhongMaterial(Color.BLUE);
        // material.setDiffuseMap(new Image("file:E:\\Users\\86158\\图片\\0ea0dc59c3c01450e33a1d2131f1c6f.jpg"));
        box.setMaterial(material);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #ffffff00;");
        anchorPane.getChildren().add(box);
        AnchorPane.setTopAnchor(box, 150.0);
        AnchorPane.setLeftAnchor(box, 150.0);
        SubScene subScene = new SubScene(anchorPane, 400, 400, true, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera();
        subScene.setCamera(camera);

        VBox root = new VBox(10);
        // root.setStyle("-fx-background-color: #ffffff00;");
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(hBox, subScene);
        Scene scene = new Scene(root, 400, 500, false, SceneAntialiasing.BALANCED);
        // scene.setFill(Color.valueOf("#ffffff00"));
        // primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation 3D图形");
        primaryStage.show();

        Timeline timelineR = new Timeline();
        Rotate rotate = new Rotate(0, 0, 0, 0);// 中心点
        rotate.setAxis(new Point3D(1, 1, 1));
        box.getTransforms().add(rotate);
        KeyValue angle1 = new KeyValue(rotate.angleProperty(), 0);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0), angle1);
        KeyValue angle2 = new KeyValue(rotate.angleProperty(), 360);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(5), angle2);
        timelineR.getKeyFrames().addAll(kf1, kf2);
        timelineR.setCycleCount(Timeline.INDEFINITE);

        Timeline timelineS = new Timeline();
        Scale scale = new Scale(1, 1, 1, 0, 0, 0);// 中心点
        box.getTransforms().add(scale);
        KeyValue scale1x = new KeyValue(scale.xProperty(), 1);
        KeyValue scale1y = new KeyValue(scale.yProperty(), 1);
        KeyValue scale1z = new KeyValue(scale.zProperty(), 1);
        KeyFrame kf3 = new KeyFrame(Duration.seconds(0), scale1x, scale1y, scale1z);
        KeyValue scale2x = new KeyValue(scale.xProperty(), 2);
        KeyValue scale2y = new KeyValue(scale.yProperty(), 2);
        KeyValue scale2z = new KeyValue(scale.zProperty(), 2);
        KeyFrame kf4 = new KeyFrame(Duration.seconds(2), scale2x, scale2y, scale2z);
        timelineS.getKeyFrames().addAll(kf3, kf4);
        timelineS.setCycleCount(Timeline.INDEFINITE);
        timelineS.setAutoReverse(true);

        rotateBtn.setOnAction(event -> {
            if (timelineR.getStatus() == Timeline.Status.PAUSED || timelineR.getStatus() == Timeline.Status.STOPPED) {
                timelineR.play();
            }else {
                timelineR.pause();
            }
        });
        scaleBtn.setOnAction(event -> {
            if (timelineS.getStatus() == Timeline.Status.PAUSED  || timelineS.getStatus() == Timeline.Status.STOPPED) {
                timelineS.play();
            }else {
                timelineS.pause();
            }
        });
        stop.setOnAction(event -> {
            timelineR.stop();
            timelineS.stop();
        });

        // KeyCodeCombination keyCodeCombination = new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN);
        // scene.getAccelerators().put(keyCodeCombination, () -> {
        //     timelineR.play();
        //     timelineS.play();
        // });

    }
}
