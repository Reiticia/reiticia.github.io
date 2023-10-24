package com.reine;

import com.reine.entity.Student;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * ComboBox实现模糊搜索
 *
 * @author reine
 * 2022/5/18 19:52
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        Student student1 = new Student("张三", 78, "语文");
        Student student2 = new Student("李四", 69, "数学");
        Student student3 = new Student("王五", 70, "英语");
        Student student4 = new Student("赵六", 49, "物理");
        Student student5 = new Student("钱七", 80, "化学");
        Student student6 = new Student("孙八", 99, "生物");
        Student student7 = new Student("周九", 59, "政治");
        Student student8 = new Student("吴十", 10, "历史");
        Student student9 = new Student("郑十一", 20, "地理");
        Student student10 = new Student("王十二", 30, "技术");

        ComboBox<Student> comboBox = new ComboBox<>();

        comboBox.getItems().addAll(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);
        comboBox.setEditable(true);// 设置可编辑（相较于ChoiceBox的特点）
        comboBox.setPlaceholder(new Label("无学生"));// 设置占位符
        ObservableList<Student> originalItems = comboBox.getItems();

        // 数据处理
        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object == null) {
                    return "";
                }
                String value = object.getName() + ":" + object.getScore() + ":" + object.getSubject();
                return value;
            }

            // 在输入框中输入文本按下回车键时，调用此方法
            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        anchorPane.getChildren().addAll(comboBox);
        AnchorPane.setLeftAnchor(comboBox, 250.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ComboBox实现模糊搜索");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 获取单行文本框的文本监听
        comboBox.editorProperty().get().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()|| originalItems.contains(comboBox.getValue())) {
                comboBox.setItems(originalItems);
                comboBox.setPlaceholder(new Label("无学生"));
                return;
            }
            FilteredList<Student> newList = originalItems.filtered(student -> student.getName().contains(newValue));
            if (newList.isEmpty()) {
                comboBox.setItems(null);
                comboBox.setPlaceholder(new Label("无学生"));
            } else {
                comboBox.setItems(newList);
                comboBox.hide();
                comboBox.show();
            }
        });

    }
}
