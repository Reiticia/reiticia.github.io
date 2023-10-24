package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 控件边界宽高
 * @author reine
 * 2022/5/21 19:54
 */
public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        Button button = new Button("button");
        button.setLayoutX(100);
        button.setLayoutY(100);

        anchorPane.getChildren().addAll(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("控件边界宽高");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        System.out.println(button.getLayoutBounds()); // 边界
        System.out.println(button.getBoundsInLocal()); // 局部边界
        System.out.println(button.getBoundsInParent()); // 父边界
        System.out.println("==================================");

        // 阴影
        button.setEffect(new DropShadow());
        System.out.println(button.getLayoutBounds());
        System.out.println(button.getBoundsInLocal());
        System.out.println(button.getBoundsInParent());
        System.out.println("==================================");

        // 旋转
        button.setRotate(45.0);
        System.out.println(button.getLayoutBounds());
        System.out.println(button.getBoundsInLocal());
        System.out.println(button.getBoundsInParent());
        System.out.println("==================================");

    }
}
