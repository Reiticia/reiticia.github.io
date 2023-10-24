package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/14 15:59
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AreaChart<Number, Number> chart = getView();

        Button button = new Button("btn");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(button, chart);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);
        Scene scene = new Scene(root);
        // scene.getStylesheets().add(this.getClass().getClassLoader().getResource("css/chart.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("AreaChart区域图");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        button.setOnAction(event -> {
            XYChart.Series<Number, Number> series = chart.getData().get(0);
            XYChart.Data<Number, Number> data = series.getData().get(0);
            data.setYValue(data.getYValue().intValue() + 10);
        });
    }

    private AreaChart<Number, Number> getView() {
        NumberAxis X = new NumberAxis("x轴", 0, 100, 10);
        NumberAxis Y = new NumberAxis("y轴", 0, 100, 10);
        // 散点图中每一种类型会显示不同的颜色和图形
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
        AreaChart<Number, Number> chart = new AreaChart<>(X, Y);
        chart.getData().addAll(xy1, xy2);
        chart.setTitle("AreaChart区域图");
        // 设置显示端点
        chart.setCreateSymbols(true);
        return chart;
    }
}
