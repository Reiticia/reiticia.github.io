package com.reine;

import com.reine.entity.StudentProperty;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * TableView加载监视JavaBean
 *
 * @author reine
 * 2022/6/5 20:14
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建5个学生对象
        StudentProperty student1 = new StudentProperty("张三", 20, 80.0, true);
        StudentProperty student2 = new StudentProperty("李四", 21, 90.0, false);
        StudentProperty student3 = new StudentProperty("王五", 22, 100.0, true);
        StudentProperty student4 = new StudentProperty("赵六", 23, 70.0, false);
        StudentProperty student5 = new StudentProperty("钱七", 24, 60.0, true);

        ObservableList<StudentProperty> list = FXCollections.observableArrayList();
        list.addAll(student1, student2, student3, student4, student5);

        TableView<StudentProperty> tableView = new TableView<>(list);
        tableView.setLayoutX(100);
        tableView.setLayoutY(100);

        TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型
        TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");
        scoreCol.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
        TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("是男生");
        isBoyCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        tableView.getColumns().addAll(nameCol, ageCol, scoreCol, isBoyCol);


        // 使用Map定义数据
        Map<String, SimpleStringProperty> map = new HashMap<>();
        map.put("name", new SimpleStringProperty("A"));
        map.put("age", new SimpleStringProperty("15"));
        map.put("boolean", new SimpleStringProperty("true"));
        Map<String, SimpleStringProperty> map1 = new HashMap<>();
        map1.put("name", new SimpleStringProperty("B"));
        map1.put("age", new SimpleStringProperty("14"));
        map1.put("boolean", new SimpleStringProperty("false"));
        ObservableList<Map<String, SimpleStringProperty>> list1 = FXCollections.observableArrayList();
        list1.addAll(map, map1);
        TableView<Map<String, SimpleStringProperty>> tableView1 = new TableView<>(list1);
        tableView1.setLayoutX(100);
        tableView1.setLayoutY(100);
        TableColumn<Map<String, SimpleStringProperty>, String> nameCol1 = new TableColumn<>("姓名");
        // nameCol1.setCellValueFactory(cellData -> cellData.getValue().get("name"));
        nameCol1.setCellValueFactory(new MapValueFactory("name"));
        TableColumn<Map<String, SimpleStringProperty>, String> ageCol1 = new TableColumn<>("年龄");
        // ageCol1.setCellValueFactory(cellData -> cellData.getValue().get("age"));
        ageCol1.setCellValueFactory(new MapValueFactory("age"));
        TableColumn<Map<String, SimpleStringProperty>, String> isBoyCol1 = new TableColumn<>("是男生");
        // isBoyCol1.setCellValueFactory(cellData -> cellData.getValue().get("boolean"));
        isBoyCol1.setCellValueFactory(new MapValueFactory("boolean"));
        tableView1.getColumns().addAll(nameCol1, ageCol1, isBoyCol1);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button, tableView1);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("加载Map数据");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            if (tableView.getItems().size() > 0) {

                student1.setGender(false);
                list.forEach(System.out::println);
            } else {
                tableView.setPlaceholder(new Text("米有数据"));
            }
        });
    }
}
