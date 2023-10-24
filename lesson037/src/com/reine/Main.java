package com.reine;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * ChoiceBox 下拉列表 监听属性变化
 *
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

        TextField textField = new TextField();
        textField.setPrefWidth(200);
        Button button = new Button("changeName");

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
                System.out.println("渲染了1次");
                return value;
            }

            @Override
            public Student fromString(String string) {
                System.out.println("fromString:" + string);
                return null;
            }
        });

        anchorPane.getChildren().addAll(textField, button, choiceBox);
        AnchorPane.setTopAnchor(textField, 10.0);
        AnchorPane.setTopAnchor(button, 10.0);
        AnchorPane.setLeftAnchor(textField, 10.0);
        AnchorPane.setLeftAnchor(button, 250.0);
        AnchorPane.setTopAnchor(choiceBox, 50.0);
        AnchorPane.setLeftAnchor(choiceBox, 10.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceBox 下拉列表 监听属性变化");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 选择改变监听事件
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            newValue.getNameSimpleStringProperty().addListener((observable1, oldValue1, newValue1) -> {
                int index = choiceBox.getItems().indexOf(newValue);
                choiceBox.getItems().remove(newValue);
                choiceBox.getItems().add(index,newValue);
            });
            System.out.println(newValue.getName());
        });

        // 按钮点击事件
        button.setOnAction(event -> {
            String newName = textField.getText();
            if (newName.equals("")) {
                return;
            }
            Student student = choiceBox.getValue();
            student.setName(newName);

            // // 获得选中栏的索引
            // int i = choiceBox.getItems().indexOf(student);
            // // 移除
            // choiceBox.getItems().remove(student);
            // // 修改
            // student.setName(newName);
            // // 添加回去
            // choiceBox.getItems().add(i, student);

        });


    }
}

class Student {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleDoubleProperty score = new SimpleDoubleProperty();
    private SimpleStringProperty subject = new SimpleStringProperty();

    public Student(String name, double score, String subject) {
        this.name.setValue(name);
        this.score.setValue(score);
        this.subject.setValue(subject);
    }

    public Student() {
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public double getScore() {
        return score.getValue();
    }

    public void setScore(double score) {
        this.score.setValue(score);
    }

    public String getSubject() {
        return subject.getValue();
    }

    public void setSubject(String subject) {
        this.subject.setValue(subject);
    }

    public SimpleStringProperty getNameSimpleStringProperty(){
        return name;
    }
}
