package com.reine;

import javafx.application.Application;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/18 12:46
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("button1");
        button1.setTranslateZ(0);
        // button1.setDepthTest(DepthTest.ENABLE);// 启用3d渲染机制
        Button button2 = new Button("button2");
        button2.setTranslateZ(300);
        // button2.setDepthTest(DepthTest.ENABLE);
        Button button3 = new Button("button3");
        button3.setTranslateZ(600);
        // button3.setDepthTest(DepthTest.ENABLE);
        Button button4 = new Button("button4");
        button4.setTranslateZ(50);
        // 由于没有启用深度测试，并且button4比button1晚设置，所以button4会覆盖button1
        button4.setDepthTest(DepthTest.DISABLE);

        AnchorPane root = new AnchorPane();
        root.setDepthTest(DepthTest.ENABLE);// 禁用3d渲染机制
        root.setStyle("-fx-background-color: #FFFFFF00");
        root.getChildren().addAll(button1, button2, button3,button4);
        Scene scene = new Scene(root, 800, 800, true);// 启用3d渲染效果
        scene.setCamera(new PerspectiveCamera());// 设置3d渲染效果的透视相机
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D shape");
        primaryStage.show();

        button1.setOnAction(event -> {
            System.out.println(button1.getBoundsInLocal());
            System.out.println(button2.getBoundsInLocal());
            System.out.println(button3.getBoundsInLocal());
        });
    }
}
