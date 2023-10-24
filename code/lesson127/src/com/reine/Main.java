package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/13 10:33
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 所有的data中的value不需要总和为100，只是演示时便于观察
        PieChart.Data data1 = new PieChart.Data("data1", 40);
        PieChart.Data data2 = new PieChart.Data("data2", 10);
        PieChart.Data data3 = new PieChart.Data("data3", 10);
        PieChart.Data data4 = new PieChart.Data("data4", 15);
        PieChart.Data data5 = new PieChart.Data("data5", 25);

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(data1, data2, data3, data4, data5);

        PieChart chart = new PieChart(list);
        // 指示线长度
        // chart.setLabelLineLength(100);
        chart.setPrefWidth(600);
        chart.setPrefHeight(600);
        // 设置起始角度（未设置默认以向右射线顺时针分配区域，设置正数逆时针旋转，设置负数顺时针旋转）
        // chart.setStartAngle(90);
        // 设置不显示指示线以及文本内容
        // chart.setLabelsVisible(false);
        // 设置初始分配时按照相反方向
        chart.setClockwise(true);
        // 设置不显示下面的图示
        // chart.setLegendVisible(false);
        // 设置图示方位
        chart.setLegendSide(Side.TOP);
        // 设置图题
        chart.setTitle("这是图题");
        // 设置图题方位
        chart.setTitleSide(Side.RIGHT);
        // 改变数据是否播放动画
        // chart.setAnimated(true);

        Button button = new Button("button");

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button, chart);
        AnchorPane.setTopAnchor(chart, 100.0);
        AnchorPane.setLeftAnchor(chart, 100.0);
        Scene scene = new Scene(root);

        scene.getStylesheets().add(Main.class.getClassLoader().getResource("css/chart.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("PieChart饼状图");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            data1.setPieValue(data1.getPieValue()+10);
        });
        chart.getData().forEach(data -> {
            Node node = data.getNode();
            Tooltip tooltip = new Tooltip(data.getPieValue() + "");
            data.pieValueProperty().addListener((observable, oldValue, newValue) -> tooltip.setText(newValue.toString()));
            node.setOnMouseClicked(event -> System.out.println(data.getName() + "-" + data.getPieValue()));
            tooltip.setFont(new Font(20));
            Tooltip.install(node, tooltip);
        });
    }
}
