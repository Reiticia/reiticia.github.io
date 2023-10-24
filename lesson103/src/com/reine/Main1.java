package com.reine;

import com.reine.entity.Data;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * @author reine
 * 2022/6/7 10:00
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreeView<Data> treeView = new TreeView<>();
        treeView.setLayoutX(100);
        treeView.setLayoutY(100);

        TreeItem<Data> china = new TreeItem<>(new Data(false, "中国"));
        TreeItem<Data> hlj = new TreeItem<>(new Data(true, "黒龙江"));
        TreeItem<Data> heb = new TreeItem<>(new Data(false, "哈尔滨"));
        TreeItem<Data> jms = new TreeItem<>(new Data(false, "佳木斯"));
        TreeItem<Data> dq = new TreeItem<>(new Data(false, "大庆"));
        hlj.getChildren().addAll(heb, jms, dq);

        TreeItem<Data> gd = new TreeItem<>(new Data(false, "广东"));
        TreeItem<Data> zj = new TreeItem<>(new Data(true, "珠海"));
        TreeItem<Data> sz = new TreeItem<>(new Data(false, "深圳"));
        TreeItem<Data> dg = new TreeItem<>(new Data(true, "东莞"));
        gd.getChildren().addAll(zj, sz, dg);

        china.getChildren().addAll(hlj, gd);
        treeView.setRoot(china);

        // 展开
        china.setExpanded(true);
        hlj.setExpanded(true);
        gd.setExpanded(true);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button, treeView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TreeView四种内置TreeCell");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        treeView.setCellFactory(CheckBoxTreeCell.forTreeView(new Callback<TreeItem<Data>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TreeItem<Data> param) {
                if (treeView.getTreeItemLevel(param) == 1) {
                    param.getValue().setSelected(true);
                }
                return param.getValue().selectedProperty();

            }
        }, new StringConverter<TreeItem<Data>>() {
            @Override
            public String toString(TreeItem<Data> object) {
                return object.getValue().getValue();
            }

            @Override
            public TreeItem<Data> fromString(String string) {
                return null;
            }
        }));

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Data>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Data>> observable, TreeItem<Data> oldValue, TreeItem<Data> newValue) {
                System.out.println("newValue.getValue().isSelected() = " + newValue.getValue().isSelected());
            }
        });

        button.setOnAction(event -> {

        });
    }
}
