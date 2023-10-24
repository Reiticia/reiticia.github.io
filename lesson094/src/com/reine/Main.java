package com.reine;

import com.reine.entity.StudentProperty;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * TableView加载监视JavaBean
 *
 * @author reine
 * 2022/6/5 20:14
 */
public class Main extends Application {
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

        // 合并列
        TableColumn<StudentProperty, Object> group = new TableColumn<>("基本信息");
        group.getColumns().addAll(nameCol, ageCol);

        tableView.getColumns().add(group);
        tableView.getColumns().add(scoreCol);
        tableView.getColumns().add(isBoyCol);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(tableView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("合并列");
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
