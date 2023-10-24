package com.reine;

import com.reine.entity.StudentProperty;
import com.reine.job.MyService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author reine
 * 2022/6/6 11:04
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建5个学生对象
        StudentProperty student1 = new StudentProperty("鸢一折纸", 20, 0.0, false);
        StudentProperty student2 = new StudentProperty("本条二亚", 21, 0.2, false);
        StudentProperty student3 = new StudentProperty("时崎狂三", 22, 1.0, false);
        StudentProperty student4 = new StudentProperty("冰芽川四糸乃", 23, 0.4, false);
        StudentProperty student5 = new StudentProperty("五河琴里", 24, 0.5, false);
        StudentProperty student6 = new StudentProperty("星宫六喰", 20, 0.3, false);
        StudentProperty student7 = new StudentProperty("镜野七罪", 21, 0.8, false);
        StudentProperty student8 = new StudentProperty("八舞夕弦", 22, 0.4, false);
        StudentProperty student9 = new StudentProperty("八舞耶俱矢", 23, 0.2, false);
        StudentProperty student10 = new StudentProperty("诱宵美九", 24, 0.3, false);
        StudentProperty student11 = new StudentProperty("夜刀神十香", 24, 0.6, false);

        ObservableList<StudentProperty> list = FXCollections.observableArrayList();
        list.addAll(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11);

        // 拷贝可观察列表
        List<StudentProperty> listBackup = new ArrayList<>(list);

        TableView<StudentProperty> tableView = new TableView<>(list);
        tableView.setLayoutX(100);
        tableView.setLayoutY(100);
        tableView.setPrefWidth(500);
        tableView.setPrefHeight(200);
        tableView.setPlaceholder(new Text("None Data"));
        // 选择性显示或隐藏某列
        tableView.setTableMenuButtonVisible(true);

        // 每一列
        TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");
        // nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型
        TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");
        // ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        // TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");
        // scoreCol.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
        // 此行用于替换上面两行，为了下面ProgressBarTableCell的演示
        TableColumn<StudentProperty, Double> scoreCol = new TableColumn<>("充能");
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("性别");
        // isBoyCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        isBoyCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(ageCol);
        tableView.getColumns().add(scoreCol);
        tableView.getColumns().add(isBoyCol);

        // 设置每列宽度相同（列拉长时挤占空间）
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // 限制用户无法改变列宽度
        // tableView.setColumnResizePolicy(param -> true);

        // 设置列排列方式
        // tableView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        tableView.setOnScrollTo(event -> {
            System.out.println("event.getScrollTarget() = " + event.getScrollTarget());
        });

        tableView.setEditable(true);
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));
        ageCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                if (object == null) {
                    return null;
                }
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return new Integer(string);
            }
        }, 15, 16, 17, 18, 19, 20, 21, 22));

        scoreCol.setCellFactory(ProgressBarTableCell.forTableColumn());

        isBoyCol.setCellFactory(ComboBoxTableCell.forTableColumn(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean object) {
                return object ? "男" : "女";
            }

            @Override
            public Boolean fromString(String string) {
                return string.equals("男");
            }
        }, true, false));
        isBoyCol.setCellFactory(CheckBoxTableCell.forTableColumn(new TableColumn<>()));

        MyService service = new MyService();
        service.setDelay(Duration.ZERO);
        service.setPeriod(Duration.seconds(1));

        service.valueProperty().addListener((observable, oldValue, newValue) -> {
            Optional.ofNullable(newValue).ifPresent(aDouble -> {
                if (aDouble > 1.0) {
                    service.cancel();
                    new Alert(Alert.AlertType.INFORMATION, "充能完成").show();
                }
                student1.setScore(newValue);
            });
        });

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(tableView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView5种单元格格式");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("newValue.isGender() = " + newValue.isGender());
        });

        button.setOnAction(event -> {
            // student1.setScore(0.5);
            service.start();
        });
    }
}
