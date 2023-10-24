package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/14 10:06
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackedBarChart<String, Number> chart = getView();

        Button button = new Button("btn");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(button, chart);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);
        Scene scene = new Scene(root);
        // scene.getStylesheets().addAll(this.getClass().getClassLoader().getResource("css/chart.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("StackedBarChart堆积柱状图");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        button.setOnAction(event -> {
            XYChart.Series<String, Number> series = chart.getData().get(0);
            XYChart.Data<String, Number> data = series.getData().get(0);
            data.setYValue(90);
        });
    }

    private StackedBarChart<String, Number> getView() {
        CategoryAxis X = new CategoryAxis();
        X.setLabel("x轴");
        NumberAxis Y = new NumberAxis("y轴", 0, 200, 10);
        XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");
        XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");
        XYChart.Data<String, Number> data1 = new XYChart.Data<>("A", 10);
        XYChart.Data<String, Number> data2 = new XYChart.Data<>("B", 23);
        XYChart.Data<String, Number> data3 = new XYChart.Data<>("C", 34);
        XYChart.Data<String, Number> data4 = new XYChart.Data<>("D", 45);
        XYChart.Data<String, Number> data5 = new XYChart.Data<>("A", 23);
        XYChart.Data<String, Number> data6 = new XYChart.Data<>("B", 12);
        XYChart.Data<String, Number> data7 = new XYChart.Data<>("C", 34);
        XYChart.Data<String, Number> data8 = new XYChart.Data<>("D", 56);
        xy1.getData().addAll(data1, data2, data3, data4);
        xy2.getData().addAll(data5, data6, data7, data8);
        StackedBarChart<String, Number> chart = new StackedBarChart<>(X, Y);
        chart.getData().addAll(xy1, xy2);
        chart.setTitle("StackedBarChart堆积柱状图");
        return chart;
    }
}
