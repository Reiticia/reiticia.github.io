package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * @author reine
 * 2022/6/14 21:41
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LineChart<Number, Number> chart = getView1();
        // BarChart<String, Number> chart = getView2();
        Button button = new Button("button");
        HBox box = new HBox(20);
        box.getChildren().addAll(button, chart);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box);
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getClassLoader().getResource("css/chart.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("图表的其他设置");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    /**
     * 获取一个折线图
     *
     * @return
     */
    private LineChart<Number, Number> getView1() {
        NumberAxis x = new NumberAxis("x", -10, 100, 10);
        NumberAxis y = new NumberAxis("y", -10, 100, 10);
        y.setTickLabelFormatter(new StringConverter<Number>() {
            // 修改刻度显示
            @Override
            public String toString(Number object) {
                return object.intValue() + "%";
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });
        LineChart<Number, Number> chart = new LineChart<>(x, y);
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("series1");
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("series2");

        // 创建10个数据
        XYChart.Data<Number, Number> data1 = new XYChart.Data<>(-10, 10);
        XYChart.Data<Number, Number> data2 = new XYChart.Data<>(0, 0);
        XYChart.Data<Number, Number> data3 = new XYChart.Data<>(10, 10);
        XYChart.Data<Number, Number> data4 = new XYChart.Data<>(20, 20);
        XYChart.Data<Number, Number> data5 = new XYChart.Data<>(30, 30);
        XYChart.Data<Number, Number> data6 = new XYChart.Data<>(-10, 40);
        XYChart.Data<Number, Number> data7 = new XYChart.Data<>(0, 50);
        XYChart.Data<Number, Number> data8 = new XYChart.Data<>(10, 60);
        XYChart.Data<Number, Number> data9 = new XYChart.Data<>(20, 70);
        XYChart.Data<Number, Number> data10 = new XYChart.Data<>(30, 80);

        series1.getData().addAll(data1, data2, data3, data4, data5);
        series2.getData().addAll(data6, data7, data8, data9, data10);

        chart.getData().addAll(series1, series2);

        chart.setHorizontalGridLinesVisible(false); // 去掉水平网格线
        chart.setVerticalGridLinesVisible(false); // 去掉垂直网格线

        chart.setHorizontalZeroLineVisible(false); // 去掉水平0线
        chart.setVerticalZeroLineVisible(false); // 去掉垂直0线

        chart.setAlternativeColumnFillVisible(true); // 网格列填充
        chart.setAlternativeRowFillVisible(true); // 网格行填充

        return chart;
    }

    /**
     * 获取一个柱状图
     *
     * @return
     */
    private BarChart<String, Number> getView2() {
        CategoryAxis country = new CategoryAxis();
        country.setLabel("国家");
        NumberAxis people = new NumberAxis("y", -10, 100, 10);

        BarChart<String, Number> chart = new BarChart<>(country, people);
        XYChart.Series<String, Number> male = new XYChart.Series<>();
        male.setName("male");
        XYChart.Series<String, Number> female = new XYChart.Series<>();
        female.setName("female");
        // 创建6个数据
        XYChart.Data<String, Number> data1 = new XYChart.Data<>("中国", 22);
        XYChart.Data<String, Number> data2 = new XYChart.Data<>("日本", 25);
        XYChart.Data<String, Number> data3 = new XYChart.Data<>("美国", 44);
        XYChart.Data<String, Number> data4 = new XYChart.Data<>("中国", 30);
        XYChart.Data<String, Number> data5 = new XYChart.Data<>("日本", 31);
        XYChart.Data<String, Number> data6 = new XYChart.Data<>("美国", 44);

        male.getData().addAll(data1, data2, data3);
        female.getData().addAll(data4, data5, data6);
        chart.getData().addAll(male, female);

        return chart;
    }

}
