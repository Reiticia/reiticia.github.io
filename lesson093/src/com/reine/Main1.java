package com.reine;

import com.reine.entity.StudentProperty;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

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
        // ObservableList<StudentProperty> list = FXCollections.observableArrayList(new Callback<StudentProperty, Observable[]>() {
        //     @Override
        //     public Observable[] call(StudentProperty param) {
        //         return new Observable[]{param.nameProperty(),param.ageProperty(),param.scoreProperty(),param.genderProperty()};
        //     }
        // });
        list.addAll(student1, student2, student3, student4, student5);

        TableView<StudentProperty> tableView = new TableView<>(list);
        tableView.setLayoutX(100);
        tableView.setLayoutY(100);

        // 第一种写法
        // 每一列
        TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");
        nameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<StudentProperty, String> cellData) {
                return cellData.getValue().nameProperty();
            }
        });
        // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型
        TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");
        ageCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<StudentProperty, Number> cellData) {
                return cellData.getValue().ageProperty();
            }
        });
        TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");
        scoreCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<StudentProperty, Number> cellData) {
                return cellData.getValue().scoreProperty();
            }
        });
        TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("是男生");
        isBoyCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<StudentProperty, Boolean> cellData) {
                return cellData.getValue().genderProperty();
            }
        });

        // 第二种写法，通过加载属性名称进行加载，内部通过反射调用属性列的xxxProperty方法，因此xxxProperty方法编写必须符合规范
        // TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");
        // nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        // // 对于数字类型的字段，可以指定其抽象类Number或者它本身所属的类作为泛型
        // // TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");
        // // ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        // // TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");
        // // scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        // TableColumn<StudentProperty, Integer> ageCol = new TableColumn<>("年龄");
        // ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        // TableColumn<StudentProperty, Double> scoreCol = new TableColumn<>("成绩");
        // scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        // TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("是男生");
        // isBoyCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        // 对list的某一条数据进行修改时不会触发该监听，除非在创建list时传入了回调函数callback，且修改的属性在callback返回的监视属性数组中才会触发该监听
        list.addListener(new ListChangeListener<StudentProperty>() {
            @Override
            public void onChanged(Change<? extends StudentProperty> c) {
                System.out.println("c = " + c);
            }
        });

        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(ageCol);
        tableView.getColumns().add(scoreCol);
        tableView.getColumns().add(isBoyCol);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(tableView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView加载监视JavaBean");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            if (tableView.getItems().size() > 0) {
                // // 成功修改并显示到界面
                // tableView.getItems().set(3, new StudentProperty("REINE", 20, 80.0, true));
                //
                // student1.setName("REINE");
                // student2.setAge(14);

                student1.setGender(false);
                list.forEach(System.out::println);
            } else {
                tableView.setPlaceholder(new Text("米有数据"));
            }
        });
    }
}
