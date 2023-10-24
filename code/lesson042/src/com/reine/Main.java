package com.reine;

import com.reine.entity.Student;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * ComboBox
 *
 * @author reine
 * 2022/5/19 16:45
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
        textField.setPrefWidth(100);
        Button button = new Button("点击修改分数");
        // 创建5个学生
        Student student1 = new Student("张三", 79.0, "语文");
        Student student2 = new Student("李四", 89.0, "语文");
        Student student3 = new Student("王五", 69.0, "语文");
        Student student4 = new Student("赵六", 80.0, "语文");
        Student student5 = new Student("钱七", 50.0, "语文");
        ComboBox<Student> comboBox = new ComboBox<>();
        comboBox.setPrefWidth(200);
        comboBox.getItems().addAll(student1, student2, student3, student4, student5);

        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object == null) {
                    return "";
                }
                System.out.println("toString");
                String s = object.getName() + "-" + object.getSubject() + "-" + object.getScore();
                return s;
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        // 修改分数点击事件
        button.setOnAction(event -> {
            String newScore = textField.getText();
            // 获取选中对象值
            Student student = comboBox.getSelectionModel().getSelectedItem();
            // 修改分数
            student.setScore(Double.parseDouble(newScore));
            // 替换选中项
            comboBox.getItems().set(comboBox.getSelectionModel().getSelectedIndex(), student);
        });

        anchorPane.getChildren().addAll(textField, button, comboBox);
        AnchorPane.setTopAnchor(textField, 100.0);
        AnchorPane.setTopAnchor(button, 100.0);
        AnchorPane.setLeftAnchor(button, 150.0);
        AnchorPane.setTopAnchor(comboBox, 200.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ComboBox");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
