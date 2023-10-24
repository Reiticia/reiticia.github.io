package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * ChoiceBox 下拉列表
 * @author reine
 * 2022/5/17 12:20
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        ChoiceBox<Student> choiceBox = new ChoiceBox<>();

        Student student1 = new Student("张三", 90, "数学");
        Student student2 = new Student("李四", 87, "英语");
        Student student3 = new Student("王五", 93, "美术");

        choiceBox.getItems().addAll(student1, student2, student3);// 添加选项
        choiceBox.setPrefWidth(200);
        choiceBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                String value = object.getName() + ":" + object.getScore() + ":" + object.getSubject();
                return value;
            }

            @Override
            public Student fromString(String string) {
                System.out.println("fromString:" + string);
                return null;
            }
        });

        // choiceBox.setValue("item1");// 默认选中第一个
        choiceBox.getSelectionModel().selectLast();// 默认选中最后一个
        choiceBox.getSelectionModel().selectPrevious();// 选中上一个

        AnchorPane.setTopAnchor(choiceBox,100.0);// 设置位置
        AnchorPane.setLeftAnchor(choiceBox,100.0);// 设置位置

        anchorPane.getChildren().addAll(choiceBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceBox 下拉列表");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 选择改变监听事件
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue.getName() = " + newValue.getName());
            System.out.println("newValue.getSubject() = " + newValue.getSubject());
            System.out.println("newValue.getScore() = " + newValue.getScore());
        });
    }
}
class Student{
    private String name;
    private double score;
    private String subject;

    public Student(String name, double score, String subject) {
        this.name = name;
        this.score = score;
        this.subject = subject;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}