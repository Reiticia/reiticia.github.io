package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * @author reine
 * 2022/6/7 6:16
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

        // 宽高
        treeView.setPrefWidth(300);
        treeView.setPrefHeight(100);

        // 设置单元格尺寸
        treeView.setFixedCellSize(40);

        // 设置多选
        treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // 设置可编辑
        treeView.setEditable(true);
        treeView.setCellFactory(TextFieldTreeCell.forTreeView());
        treeView.setCellFactory(TextFieldTreeCell.forTreeView(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object + " - china";
            }

            @Override
            public String fromString(String string) {
                return string;
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
        primaryStage.setTitle("TreeView");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 滚动监听
        treeView.setOnScrollTo(event -> {
            System.out.println("scroll to " + event.getScrollTarget());
        });

        // 选择监听
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("selectedItemProperty: " + newValue);
        });

        button.setOnAction(event -> {
            // 滚动
            treeView.scrollTo(6);
            // 修改值
            china.setValue("种花家");
            // 是否显示根节点（隐藏）
            treeView.setShowRoot(false);
            // 是否是叶子节点
            System.out.println("china.isLeaf() = " + china.isLeaf());
            // 获得该节点的前后节点
            System.out.println("jms.previousSibling().getValue() = " + jms.previousSibling().getValue());
            System.out.println("jms.nextSibling().getValue() = " + jms.nextSibling().getValue());

            System.out.println("jms.previousSibling(dq).getValue() = " + jms.previousSibling(dq).getValue());
            System.out.println("tw.previousSibling().getValue() = " + tw.previousSibling().getValue());

            // 是否展开
            System.out.println("tw.isExpanded() = " + tw.isExpanded());

            treeView.getFocusModel().focus(0);
            treeView.requestFocus();

            // 展开的数量
            System.out.println("treeView.getExpandedItemCount() = " + treeView.getExpandedItemCount());

            // 获取父节点
            System.out.println("jms.getParent().getValue() = " + jms.getParent().getValue());

        });
    }
}
