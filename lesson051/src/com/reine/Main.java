package com.reine;

import com.reine.entity.Student;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Java基础属性监听器
 * @author reine
 * 2022/5/22 9:29
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        Student student = new Student("reine", 18);
        Button button = new Button("修改数据");

        anchorPane.getChildren().addAll(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Java基础属性监听器");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 监听所有监听器
        // student.pcs.addPropertyChangeListener(new PropertyChangeListener() {
        //     @Override
        //     public void propertyChange(PropertyChangeEvent e) {
        //         System.out.println(e.getPropertyName() + ": " + e.getOldValue() + " -> " + e.getNewValue());
        //     }
        // });

        // 使用标签过滤通知
        student.pcs.addPropertyChangeListener("setName_pro", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                System.out.println("setName_pro: " + e.getOldValue() + " -> " + e.getNewValue());
                System.out.println("e.getSource() = " + e.getSource());
            }
        });

        button.setOnAction(event -> {
            student.setName("reine2");
            student.setAge(19);
        });
    }
}
