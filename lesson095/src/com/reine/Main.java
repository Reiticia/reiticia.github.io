package com.reine;

import com.reine.entity.StudentProperty;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Optional;

/**
 * @author reine
 * 2022/6/6 7:54
 */

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建5个学生对象
        StudentProperty student1 = new StudentProperty("鸢一折纸", 20, 80.0, false);
        StudentProperty student2 = new StudentProperty("本条二亚", 21, 90.0, false);
        StudentProperty student3 = new StudentProperty("时崎狂三", 22, 100.0, false);
        StudentProperty student4 = new StudentProperty("冰芽川四糸乃", 23, 70.0, false);
        StudentProperty student5 = new StudentProperty("五河琴里", 24, 60.0, false);
        StudentProperty student6 = new StudentProperty("星宫六喰", 20, 80.0, false);
        StudentProperty student7 = new StudentProperty("镜野七罪", 21, 90.0, false);
        StudentProperty student8 = new StudentProperty("八舞夕弦", 22, 100.0, false);
        StudentProperty student9 = new StudentProperty("八舞耶俱矢", 23, 70.0, false);
        StudentProperty student10 = new StudentProperty("诱宵美九", 24, 60.0, false);
        StudentProperty student11 = new StudentProperty("夜刀神十香", 24, 60.0, false);

        ObservableList<StudentProperty> list = FXCollections.observableArrayList();
        list.addAll(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11);

        TableView<StudentProperty> tableView = new TableView<>(list);
        tableView.setLayoutX(100);
        tableView.setLayoutY(100);
        tableView.setPrefWidth(300);
        tableView.setPrefHeight(200);
        tableView.setPlaceholder(new Text("None Data"));
        // 选择性显示或隐藏某列
        tableView.setTableMenuButtonVisible(true);

        // 每一列
        TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型
        TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");
        scoreCol.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
        TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("性别");
        isBoyCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(ageCol);
        tableView.getColumns().add(scoreCol);
        tableView.getColumns().add(isBoyCol);

        // 设置每列宽度相同
        double width = tableView.getPrefWidth() / tableView.getColumns().size();
        for (TableColumn<StudentProperty, ?> col : tableView.getColumns()) {
            col.setPrefWidth(width);
        }

        // 隐藏某列
        isBoyCol.setVisible(false);

        // 设置滚动到某行
        // tableView.scrollTo(student11);

        // 设置滚动到某列
        // tableView.scrollToColumnIndex(2);

        // 设置单元格尺寸
        // tableView.setFixedCellSize(60);

        // 设置可编辑
        tableView.setEditable(true);
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                if (object == null) {
                    return null;
                }
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                // 正则匹配整数
                if (!string.matches("\\d+")) {
                    return null;
                }
                return Integer.parseInt(string);
            }
        }));
        scoreCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                if (object == null) {
                    return null;
                }
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                // 正则匹配小数
                if (!string.matches("\\d+.?\\d*")) {
                    return null;
                }
                return Double.parseDouble(string);
            }
        }));
        // 如果值为true，则显示为男，否则为女
        isBoyCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean object) {
                if (object == null) {
                    return null;
                }
                return object ? "男" : "女";
            }

            @Override
            public Boolean fromString(String string) {
                return string.equals("男");
            }
        }));

        // 设置多选
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // 选中项发生改变监听（行）
        // tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue.getName()));

        // 设置每一个表格的单元格可以被单独选中
        tableView.getSelectionModel().setCellSelectionEnabled(true);

        tableView.getSelectionModel().getSelectedCells().addListener((InvalidationListener) observable -> {
            ObservableList<TablePosition<StudentProperty, ?>> obs = (ObservableList<TablePosition<StudentProperty, ?>>) observable;
            obs.forEach(item -> {
                System.out.print("行 = " + item.getRow() + ", 列 = " + item.getColumn());
                // 获取该单元格数据
                System.out.println(", 数据 = " + item.getTableColumn().getCellData(item.getRow()));
            });
            System.out.println("------------------------------");
        });

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(tableView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView选择模式与监听");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            // 获取所有选中项
            // tableView.getSelectionModel().getSelectedItems().forEach(System.out::println);
            // 选中某一格
            // tableView.getSelectionModel().select(2, nameCol);
            // tableView.requestFocus();
            // 选中选中单元格左边的一格，如果是单选则会切换选中，多选则会追加选中（1格）
            // tableView.getSelectionModel().selectLeftCell();
            // tableView.requestFocus();
            // 选中选中行的上面一行，如果是单选则会切换选中，多选则会追加选中（1行）
            // tableView.getSelectionModel().selectPrevious();
            // tableView.requestFocus();
            // 聚焦某行
            // tableView.getFocusModel().focus(2);
            // tableView.requestFocus();
            // 聚焦某单元格
            tableView.getFocusModel().focus(2, nameCol);
            tableView.requestFocus();
        });
    }
}
