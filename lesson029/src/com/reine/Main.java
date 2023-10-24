package com.reine;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * TitledPane 标题面板
 * @author reine
 * 2022/5/14 13:18
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        // 创建一个手风琴，同一时间只能展开一个面板
        Accordion accordion = new Accordion();

        // 创建一个标题面板
        TitledPane titledPane = new TitledPane("TitledPane", new Button("Button1"));

        TitledPane titledPane1 = new TitledPane();
        titledPane1.setText("TitledPane1");
        titledPane1.setContent(new Button("Button2"));

        TitledPane titledPane2 = new TitledPane();
        titledPane2.setText("TitledPane2");
        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #ff0000");
        hBox.getChildren().addAll(new Button("Button3"),new Button("Button4"),new Button("Button5"));
        titledPane2.setContent(hBox);
        // 设置标题面板的图标
        titledPane2.setGraphic(new Button("Button6"));
        // 设置组件从右到左进行排列
        titledPane2.setNodeOrientation(NodeOrientation.INHERIT);

        titledPane.setAnimated(true);// 设置标题面板是否有动画效果
        // titledPane.setCollapsible(false);// 设置标题面板是否可折叠
        titledPane.setExpanded(false);// 设置标题面板是否展开
        titledPane.expandedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " + oldValue + " newValue = " + newValue);
        });

        accordion.getPanes().addAll(titledPane,titledPane1,titledPane2);
        anchorPane.getChildren().add(accordion);
        // 展开收起列表监听事件
        accordion.expandedPaneProperty().addListener((observable, oldValue, newValue) -> {
            // 解决面板收起时，newValue为null的问题
            if (newValue == null) {
                System.out.println("oldValue = " + oldValue.getText()+"被折叠");
                return;
            }
            System.out.println(newValue.getText());
        });

        // anchorPane.getChildren().addAll(titledPane, titledPane1,titledPane2);

        AnchorPane.setTopAnchor(titledPane1, 100.0);
        AnchorPane.setTopAnchor(titledPane2, 200.0);


        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TitledPane 标题面板");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
