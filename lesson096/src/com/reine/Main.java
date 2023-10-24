package com.reine;

import com.reine.entity.StudentProperty;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.util.Comparator;

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

        // 设置每列宽度相同（列拉长时挤占空间）
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // 限制用户无法改变列宽度
        tableView.setColumnResizePolicy(param -> true);

        // 是否允许排序（不允许）
        // nameCol.setSortable(false);
        // 排序优先级
        // tableView.getSortOrder().addAll(nameCol, ageCol, scoreCol, isBoyCol);

        // 自定义排序
        // tableView.setSortPolicy(new Callback<TableView<StudentProperty>, Boolean>() {
        //     @Override
        //     public Boolean call(TableView<StudentProperty> param) {
        //         param.getColumns().forEach(col -> {
        //             // 姓名，升序
        //             if (col.getText().equals("姓名") && col.getSortType() == TableColumn.SortType.ASCENDING) {
        //                 // 设置图标
        //                 col.setSortNode(new Label("↑"));
        //                 System.out.println("姓名升序");
        //                 param.getItems().sort(Comparator.comparing(StudentProperty::getName));
        //             }
        //             // 姓名，降序
        //             if (col.getText().equals("姓名") && col.getSortType() == TableColumn.SortType.DESCENDING) {
        //                 col.setSortNode(new Label("↓"));
        //                 System.out.println("姓名降序");
        //                 param.getItems().sort(((o1, o2) -> o2.getName().compareTo(o1.getName())));
        //             }
        //         });
        //         // 如果返回false则会禁用排序
        //         return true;
        //     }
        // });

        // 单独定义某列，升序
        // nameCol.setComparator(((s1, s2) -> {
        //     System.out.println("单独定义名称列，名称升序");
        //     return s1.compareTo(s2);
        // }));

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

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(tableView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView列宽与排序");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            // 排序，没有效果
            // tableView.sort();
            // 名称降序
            // nameCol.setSortType(TableColumn.SortType.DESCENDING);
            // 使用数据源排序
            tableView.getItems().sort((o1, o2) -> {
                System.out.println("使用数据源排序");
                return o1.getName().compareTo(o2.getName());
            });
        });
    }
}
