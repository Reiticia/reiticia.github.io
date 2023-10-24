package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Comparator;

/**
 *
 *
 * @author reine
 * 2022/6/7 7:42
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

        // 设置多选
        treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // 设置可编辑
        treeView.setEditable(true);
        treeView.setCellFactory(TextFieldTreeCell.forTreeView());

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

        // 给jms节点添加值监听
        jms.addEventHandler(TreeItem.<String>valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println("event.getNewValue() = " + event.getNewValue());
                System.out.println("event.getTreeItem().getValue() = " + event.getTreeItem().getValue());
            }
        });
        // 给根节点添加value监听
        china.addEventHandler(TreeItem.<String>valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println("event.getNewValue() = " + event.getNewValue());
                System.out.println("event.getTreeItem().getValue() = " + event.getTreeItem().getValue());
            }
        });
        // 给根节点添加graphic监听
        china.addEventHandler(TreeItem.graphicChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println("event.getNewValue() = " + event.getNewValue());
                System.out.println("event.getTreeItem().getValue() = " + event.getTreeItem().getValue());
            }
        });
        // 给根节点添加收起监听
        china.addEventHandler(TreeItem.branchCollapsedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println("收起");
            }
        });
        // 给根节点添加展开监听
        china.addEventHandler(TreeItem.branchExpandedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println("展开");
            }
        });
        // 给根节点添加子节点修改监听
        china.addEventHandler(TreeItem.childrenModificationEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                event.getAddedChildren().forEach(System.out::println);
                event.getRemovedChildren().forEach(System.out::println);
            }
        });
        // 给根节点添加监听
        china.addEventHandler(TreeItem.treeNotificationEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println("event.wasPermutated() = " + event.wasPermutated());
            }
        });

        button.setOnAction(event -> {
            // jms.setValue("jms");
            // hlj.setValue("hlj");
            // heb.setGraphic(new Button("heb"));
            // gd.getChildren().add(new TreeItem<>("韶关"));
            // gd.getChildren().remove(0);
            gd.getChildren().sort(Comparator.comparing(TreeItem::getValue));
        });
    }
}
