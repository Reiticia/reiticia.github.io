package com.reine;

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

/**
 * @author reine
 * 2022/6/7 9:39
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreeView<String> treeView = new TreeView<>();
        treeView.setLayoutX(100);
        treeView.setLayoutY(100);

        TreeItem<String> china = new TreeItem<>("中国");
        TreeItem<String> hlj = new TreeItem<>("黒龙江");
        TreeItem<String> heb = new TreeItem<>("哈尔滨");
        TreeItem<String> jms = new TreeItem<>("佳木斯");
        TreeItem<String> dq = new TreeItem<>("大庆");
        hlj.getChildren().addAll(heb, jms, dq);

        TreeItem<String> gd = new TreeItem<>("广东");
        TreeItem<String> zj = new TreeItem<>("珠海");
        TreeItem<String> sz = new TreeItem<>("深圳");
        TreeItem<String> dg = new TreeItem<>("东莞");
        gd.getChildren().addAll(zj, sz, dg);

        TreeItem<String> tw = new TreeItem<>("台湾");
        TreeItem<String> tb = new TreeItem<>("台北");
        TreeItem<String> gx = new TreeItem<>("高雄");
        TreeItem<String> tn = new TreeItem<>("台南");
        tw.getChildren().addAll(tb, gx, tn);

        china.getChildren().addAll(hlj, gd, tw);
        treeView.setRoot(china);

        // 设置可编辑
        treeView.setEditable(true);
        // treeView.setCellFactory(TextFieldTreeCell.forTreeView());
        // treeView.setCellFactory(ComboBoxTreeCell.forTreeView(new String[]{"中国", "韩国", "日本"}));
        // treeView.setCellFactory(ChoiceBoxTreeCell.forTreeView(new String[]{"中国", "韩国", "日本"}));
        treeView.setCellFactory(CheckBoxTreeCell.forTreeView(new Callback<TreeItem<String>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TreeItem<String> param) {
                if (treeView.getTreeItemLevel(param) == 0) {
                    return new SimpleBooleanProperty(true);
                } else {
                    return new SimpleBooleanProperty(false);
                }
            }
        }));
        // 展开
        china.setExpanded(true);
        hlj.setExpanded(true);
        gd.setExpanded(true);
        tw.setExpanded(true);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button, treeView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TreeView四种内置TreeCell");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                System.out.println("newValue.getValue() = " + newValue.getValue());
            }
        });

        button.setOnAction(event -> {

        });
    }
}
