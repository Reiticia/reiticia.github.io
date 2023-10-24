package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/14 8:55
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BubbleChart<Number, Number> chart = getView();

        Button button = new Button("btn");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(button, chart);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BubbleChart气泡图");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        button.setOnAction(event -> {

        });
    }

    private BubbleChart<Number, Number> getView() {

        NumberAxis X = new NumberAxis("x轴", 0, 100, 10);
        NumberAxis Y = new NumberAxis("y轴", 0, 100, 10);
        XYChart.Series<Number, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");
        XYChart.Series<Number, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");
        XYChart.Data<Number, Number> data1 = new XYChart.Data<>(10, 10);
        // 设置额外数据（表现为气泡半径）
        data1.setExtraValue(3);
        XYChart.Data<Number, Number> data2 = new XYChart.Data<>(20, 23);
        XYChart.Data<Number, Number> data3 = new XYChart.Data<>(30, 34);
        XYChart.Data<Number, Number> data4 = new XYChart.Data<>(40, 45);
        XYChart.Data<Number, Number> data5 = new XYChart.Data<>(20, 23);
        XYChart.Data<Number, Number> data6 = new XYChart.Data<>(30, 12);
        XYChart.Data<Number, Number> data7 = new XYChart.Data<>(40, 34);
        XYChart.Data<Number, Number> data8 = new XYChart.Data<>(50, 56);
        xy1.getData().addAll(data1, data2, data3, data4);
        xy2.getData().addAll(data5, data6, data7, data8);

        BubbleChart<Number, Number> chart = new BubbleChart<>(X, Y);
        chart.getData().addAll(xy1, xy2);
        chart.setTitle("BubbleChart气泡图");
        return chart;
    }
}
