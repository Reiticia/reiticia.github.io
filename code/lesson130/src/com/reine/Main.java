package com.reine;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/13 21:26
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        LineChart<Number, Number> chart1 = getView1();
        LineChart<String, Number> chart2 = getView2();

        chart2.setId("linechart");

        Button button = new Button("btn");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(button, chart1, chart2);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getClassLoader().getResource("css/chart.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("LineChart折线图");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        button.setOnAction(event -> {
            // 获得第一种类别数据
            XYChart.Series<Number, Number> series = chart1.getData().get(0);
            // 获得类别数据中的第一项
            XYChart.Data<Number, Number> data = series.getData().get(0);
            // 修改y轴数据
            data.setYValue(40);
        });
    }

    private LineChart<Number, Number> getView1() {
        NumberAxis X = new NumberAxis("x轴", 0, 100, 10);
        NumberAxis Y = new NumberAxis("y轴", 0, 100, 10);

        XYChart.Series<Number, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");
        XYChart.Series<Number, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Data<Number, Number> data1 = new XYChart.Data<>(10, 10);
        XYChart.Data<Number, Number> data2 = new XYChart.Data<>(20, 23);
        XYChart.Data<Number, Number> data3 = new XYChart.Data<>(30, 34);
        XYChart.Data<Number, Number> data4 = new XYChart.Data<>(40, 45);

        XYChart.Data<Number, Number> data5 = new XYChart.Data<>(20, 23);
        XYChart.Data<Number, Number> data6 = new XYChart.Data<>(30, 12);
        XYChart.Data<Number, Number> data7 = new XYChart.Data<>(40, 34);
        XYChart.Data<Number, Number> data8 = new XYChart.Data<>(50, 56);

        xy1.getData().addAll(data1, data2, data3, data4);
        xy2.getData().addAll(data5, data6, data7, data8);

        LineChart<Number, Number> chart = new LineChart<>(X, Y);
        chart.getData().addAll(xy1, xy2);

        // 设置不显示顶点
        // chart.setCreateSymbols(false);
        // 设置是否显示动画效果（不显示）
        // chart.setAnimated(false);

        xy1.getData().forEach(numberNumberData -> {
            Node node = numberNumberData.getNode();
            Tooltip tooltip = new Tooltip(numberNumberData.getXValue() + "-" + numberNumberData.getYValue());
            Tooltip.install(node, tooltip);
            node.setOnMouseClicked(event -> {
                System.out.println(numberNumberData.getXValue() + "-" + numberNumberData.getYValue());
            });
        });
        chart.setTitle("LineChart折线图");

        return chart;
    }

    private LineChart<String, Number> getView2() {
        CategoryAxis X = new CategoryAxis();
        NumberAxis Y = new NumberAxis("y轴", 0, 100, 10);

        XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");
        XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Data<String, Number> data1 = new XYChart.Data<>("10", 10);
        XYChart.Data<String, Number> data2 = new XYChart.Data<>("20", 23);
        XYChart.Data<String, Number> data3 = new XYChart.Data<>("30", 34);
        XYChart.Data<String, Number> data4 = new XYChart.Data<>("40", 45);

        XYChart.Data<String, Number> data5 = new XYChart.Data<>("20", 23);
        XYChart.Data<String, Number> data6 = new XYChart.Data<>("30", 12);
        XYChart.Data<String, Number> data7 = new XYChart.Data<>("40", 34);
        XYChart.Data<String, Number> data8 = new XYChart.Data<>("50", 56);

        xy1.getData().addAll(data1, data2, data3, data4);
        xy2.getData().addAll(data5, data6, data7, data8);

        LineChart<String, Number> chart = new LineChart<>(X, Y);
        chart.getData().addAll(xy1, xy2);
        chart.setTitle("LineChart折线图");

        return chart;
    }
}
