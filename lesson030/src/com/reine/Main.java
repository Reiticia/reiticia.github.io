package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TabPane 标签栏
 * @author reine
 * 2022/5/14 19:52
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        TabPane tabPane = new TabPane();
        tabPane.setStyle("-fx-background-color: skyblue;");

        // 宽度不够时，会变成下拉菜单
        tabPane.setPrefSize(300, 300);
        Tab tab1 = new Tab("tab1");
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");

        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-background-color: pink;");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(new Button("button1"), new Button("button2"));
        tab1.setContent(vBox);

        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: lightyellow;");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Button("button1"), new Button("button2"));
        tab2.setContent(hBox);

        ImageView imageView = new ImageView("images/logo.png");
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        // 设置图标
        tab3.setGraphic(imageView);

        tabPane.getTabs().addAll(tab1, tab2, tab3);
        tabPane.getSelectionModel().select(tab2);// 默认选中第二个tab
        // tabPane.setSide(Side.RIGHT);// 设置tab方向

        // tab改变时监听器
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue.getText()));

        // tab1选择改变（展开，收起）
        tab1.setOnSelectionChanged(event -> System.out.println("tab1 selected status：" + tab1.isSelected()));

        tabPane.setRotateGraphic(false);// 设置图标是否旋转

        // tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);// 设置tab不可关闭

        anchorPane.getChildren().add(tabPane);
        AnchorPane.setTopAnchor(tabPane, 100.0);
        AnchorPane.setLeftAnchor(tabPane, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TabPane 标签栏");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        AtomicInteger i = new AtomicInteger(4);

        // 通过鼠标点击布局添加tab
        anchorPane.setOnMouseClicked(event -> {
            tabPane.getTabs().add(new Tab("tab" + i.getAndIncrement()));
        });

        // 关闭后
        tab1.setOnClosed(event-> tabPane.getTabs().add(new Tab("tab" + i.getAndIncrement())));

        // 开始关闭时
        tab1.setOnCloseRequest(event->{
            tabPane.getTabs().add(new Tab("tab" + i.getAndIncrement()));
            // 阻止事件传递给关闭后事件，会导致tab关闭失败
            event.consume();
        });
    }
}
