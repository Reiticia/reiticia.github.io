package com.reine;

import com.reine.entity.Data;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author reine
 * 2022/6/8 8:54
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // TreeItem设置
        Data data1 = new Data("张三", "软件1班", 20, 0.6, true);
        Data data2 = new Data("李四", "软件2班", 30, 0.4, false);
        Data data3 = new Data("王五", "软件3班", 40, 0.7, true);
        Data data4 = new Data("赵六", "软件1班", 50, 0.9, false);
        Data data5 = new Data("钱七", "软件1班", 60, 0.3, true);
        Data data6 = new Data("孙八", "软件2班", 70, 0.4, false);
        Data data7 = new Data("周九", "软件2班", 80, 0.1, true);
        TreeItem<Data> root = new TreeItem<>(data1);
        TreeItem<Data> item2 = new TreeItem<>(data2);
        TreeItem<Data> item3 = new TreeItem<>(data3);
        TreeItem<Data> item4 = new TreeItem<>(data4);
        TreeItem<Data> item5 = new TreeItem<>(data5);
        TreeItem<Data> item6 = new TreeItem<>(data6);
        TreeItem<Data> item7 = new TreeItem<>(data7);
        root.getChildren().addAll(item2, item3, item4);
        item2.getChildren().addAll(item5, item6);
        item3.getChildren().addAll(item7);
        root.setExpanded(true);
        item2.setExpanded(true);
        item3.setExpanded(true);

        // TreeTableView设置
        TreeTableView<Data> view = new TreeTableView<>();
        view.setLayoutX(100);
        view.setLayoutY(100);
        view.setRoot(root);
        view.setPrefWidth(600);
        // 平分列宽
        view.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        // 设置多选
        view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // 设置单元格可选中
        view.getSelectionModel().setCellSelectionEnabled(true);

        // TreeTableColumn设置
        TreeTableColumn<Data, String> nameCol = new TreeTableColumn<>("姓名");
        TreeTableColumn<Data, String> clazzCol = new TreeTableColumn<>("班级");
        TreeTableColumn<Data, Integer> ageCol = new TreeTableColumn<>("年龄");
        TreeTableColumn<Data, Double> scoreCol = new TreeTableColumn<>("分数");
        TreeTableColumn<Data, Boolean> maleCol = new TreeTableColumn<>("布尔");
        nameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        clazzCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("clazz"));
        ageCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("age"));
        scoreCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("score"));
        maleCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("male"));

        // 设置可编辑
        view.setEditable(true);
        nameCol.setCellFactory(new Callback<TreeTableColumn<Data, String>, TreeTableCell<Data, String>>() {
            @Override
            public TreeTableCell<Data, String> call(TreeTableColumn<Data, String> param) {
                return new TreeTableCell<Data, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            this.setGraphic(null);
                            return;
                        }
                        this.setAlignment(Pos.CENTER);
                        this.setUserData(item);
                        initGraphic();
                    }

                    @Override
                    public void startEdit() {
                        super.startEdit();
                        TextField textField = new TextField(this.getUserData().toString());
                        this.setGraphic(textField);
                        textField.requestFocus();
                        textField.setOnKeyPressed(event -> {
                            if (event.getCode() == KeyCode.ENTER) {
                                commitEdit(textField.getText());
                            }
                        });
                    }

                    @Override
                    public void cancelEdit() {
                        super.cancelEdit();
                        initGraphic();
                    }

                    /**
                     * 这里在进行数据更新时，必须在实体类中的nameProperty返回SimpleStringProperty对象，</n>
                     * 否则下次双击编辑时会显示上一次编辑前的值
                     * @param newValue
                     */
                    @Override
                    public void commitEdit(String newValue) {
                        super.commitEdit(newValue);
                        this.setUserData(newValue);
                    }

                    private void initGraphic() {
                        Label label = new Label(this.getUserData().toString());
                        this.setGraphic(label);
                    }
                };
            }
        });

        // 加载列
        view.getColumns().addAll(nameCol, clazzCol, ageCol, scoreCol, maleCol);

        Button button = new Button("ModifiedOrPrint");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button, view);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TreeTableView自定义单元格");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            data1.setScore(0.9);
        });
    }
}
