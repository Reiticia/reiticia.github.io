package com.reine;

import com.reine.job.DataTask;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author reine
 * 2022/6/14 16:56
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button play = new Button("play");
        Button stop = new Button("stop");
        HBox btnBox = new HBox(10);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.getChildren().addAll(play, stop);

        LineChart<Number, Number> chart = getView();

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(btnBox, chart);
        AnchorPane.setLeftAnchor(btnBox, 50.0);
        AnchorPane.setTopAnchor(btnBox, 50.0);
        AnchorPane.setLeftAnchor(chart, 30.0);
        AnchorPane.setTopAnchor(chart, 100.0);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX数据可视化");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        DataTask task = new DataTask();
        task.setDelay(Duration.ZERO);
        task.setPeriod(Duration.millis(500));

        task.valueProperty().addListener((observable, oldValue, newValue) -> {
            // 获取chart中的所有类别
            ObservableList<XYChart.Series<Number, Number>> series = chart.getData();
            Optional.ofNullable(newValue).ifPresent(maps -> {
                // 获取第一条数据
                Map<String, Integer> map0 = maps.get(0);
                Integer seriesName0 = map0.get("seriesName");
                Integer xValue0 = map0.get("x");
                Integer yValue0 = map0.get("y");
                XYChart.Series<Number, Number> series0 = series.get(seriesName0);
                XYChart.Data<Number, Number> data0 = new XYChart.Data<>(xValue0, yValue0);
                series0.getData().add(data0);
                // 获取第一条数据
                Map<String, Integer> map1 = maps.get(1);
                Integer seriesName1 = map1.get("seriesName");
                Integer xValue1 = map1.get("x");
                Integer yValue1 = map1.get("y");
                XYChart.Series<Number, Number> series1 = series.get(seriesName1);
                XYChart.Data<Number, Number> data1 = new XYChart.Data<>(xValue1, yValue1);
                series1.getData().add(data1);
                NumberAxis xAxis = (NumberAxis) chart.getXAxis();
                if (xValue0 > 18 || xValue1 > 18) {
                    xAxis.setLowerBound(xAxis.getLowerBound() + 1);
                    xAxis.setUpperBound(xAxis.getUpperBound() + 1);
                }
                if (xValue0 >= 50 && xValue1 >= 50) {
                    series0.getData().clear();
                    series1.getData().clear();
                    xAxis.setLowerBound(0);
                    xAxis.setUpperBound(20);
                    task.resetData();
                }
            });
        });

        play.setOnAction(event -> {
            if (task.isRunning()) {
                return;
            }
            task.start();
        });

        stop.setOnAction(event -> {
            task.cancel();
            task.reset();
        });

    }

    private LineChart<Number, Number> getView() {
        NumberAxis x = new NumberAxis("x", 0, 20, 1);
        NumberAxis y = new NumberAxis("y", 0, 100, 10);
        LineChart<Number, Number> chart = new LineChart<>(x, y);
        chart.setLayoutX(50);
        chart.setLayoutY(100);
        chart.setPrefWidth(700);
        chart.setPrefHeight(500);
        chart.setTitle("监视数据变更");
        // 关闭动画
        chart.setAnimated(false);

        // 两种类型
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("series1");
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("series2");

        chart.getData().addAll(series1, series2);
        return chart;
    }
}
