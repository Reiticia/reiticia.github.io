package com.reine;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author reine
 * 2022/6/12 9:13
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Node node = new Button("button");
        // 反射1，获取无参构造
        String className = node.getClass().getName();
        Class<?> classType = Class.forName("javafx.scene.control.Button");
        Node node1 = (Node) classType.getConstructor().newInstance();

        // 反射2，获取带参构造
        Constructor<? extends Node> constructors = node.getClass().getConstructor(String.class);
        Node node2 = constructors.newInstance("I'm a Text");

        // 反射3，获取反射对象的方法
        Method method =  node.getClass().getMethod("setText", String.class);
        method.invoke(node, "No, I'm a button");

        HBox hBox = new HBox(40);
        hBox.getChildren().addAll(node, node1, node2);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(hBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("反射");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
