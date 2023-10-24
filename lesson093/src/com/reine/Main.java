package com.reine;

import com.reine.entity.Student;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * TableView加载普通JavaBean
 *
 * @author reine
 * 2022/6/5 18:08
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建5个学生对象
        Student student1 = new Student("张三", 20, 80.0, true);
        Student student2 = new Student("李四", 21, 90.0, false);
        Student student3 = new Student("王五", 22, 100.0, true);
        Student student4 = new Student("赵六", 23, 70.0, false);
        Student student5 = new Student("钱七", 24, 60.0, true);

        ObservableList<Student> list = FXCollections.observableArrayList();
        list.addAll(student1, student2, student3, student4, student5);

        TableView<Student> tableView = new TableView<>(list);
        tableView.setLayoutX(100);
        tableView.setLayoutY(100);

        // 第一种写法
        // 每一列
        TableColumn<Student, String> nameCol = new TableColumn<>("姓名");
        nameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> cellData) {
                return new SimpleStringProperty(cellData.getValue().getName());
            }
        });
        // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型
        TableColumn<Student, Number> ageCol = new TableColumn<>("年龄");
        ageCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<Student, Number> cellData) {
                return new SimpleIntegerProperty(cellData.getValue().getAge());
            }
        });
        TableColumn<Student, Number> scoreCol = new TableColumn<>("成绩");
        scoreCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<Student, Number> cellData) {
                return new SimpleDoubleProperty(cellData.getValue().getScore());
            }
        });
        TableColumn<Student, Boolean> isBoyCol = new TableColumn<>("是男生");
        isBoyCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Student, Boolean> cellData) {
                return new SimpleBooleanProperty(cellData.getValue().getGender());
            }
        });

        // 第二种写法，通过加载属性名称进行加载，内部通过反射调用属性列的getter方法，因此getter方法编写必须符合规范
        // TableColumn<Student, String> nameCol = new TableColumn<>("姓名");
        // nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        // // 对于数字类型的字段，可以指定其抽象类Number或者它本身所属的类作为泛型
        // // TableColumn<Student, Number> ageCol = new TableColumn<>("年龄");
        // // ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        // // TableColumn<Student, Number> scoreCol = new TableColumn<>("成绩");
        // // scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        // TableColumn<Student, Integer> ageCol = new TableColumn<>("年龄");
        // ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        // TableColumn<Student, Double> scoreCol = new TableColumn<>("成绩");
        // scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        // TableColumn<Student, Boolean> isBoyCol = new TableColumn<>("是男生");
        // isBoyCol.setCellValueFactory(new PropertyValueFactory<>("isBoy"));

        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(ageCol);
        tableView.getColumns().add(scoreCol);
        tableView.getColumns().add(isBoyCol);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(tableView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView加载普通JavaBean");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            if (tableView.getItems().size() > 0) {
                tableView.getItems().remove(0);
                // 成功修改并显示到界面
                // tableView.getItems().set(3, new Student("REINE", 20, 80.0, true));
                // 成功修改但界面不刷新
                // student1.setName("REINE");
                // 必须强制刷新
                // tableView.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("没有数据");
                alert.show();
            }
        });
    }
}
