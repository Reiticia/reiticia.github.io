package com.reine;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/13 17:18
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BarChart<String, Number> chart = getView2();
        chart.setTitle("第二种方式");
        // chart.setPrefWidth(300);
        // chart.setPrefHeight(300);
        // 开启动画效果
        // chart.setAnimated(true);
        // 设置图示的位置
        // chart.setLegendSide(Side.RIGHT);
        // 设置图示是否可见
        // chart.setLegendVisible(false);
        // 设置图题的位置
        // chart.setTitleSide(Side.BOTTOM);

        // 设置方向
        // chart.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        // 设置每一类数据柱状之间的间距
        // chart.setBarGap(0);
        // 设置每一组数据柱状之间的间距
        // chart.setCategoryGap(100);

        CategoryAxis xAxis = (CategoryAxis) chart.getXAxis();
        // 设置x轴开始于原点的距离
        // xAxis.setStartMargin(100);
        // 设置x轴末尾距离坐标轴末尾的距离
        // xAxis.setEndMargin(100);
        // 设置前后留有空间
        // xAxis.setGapStartAndEnd(true);
        // 设置X轴的位置
        // xAxis.setSide(Side.TOP);
        // 设置x轴类别标签颜色
        // xAxis.setTickLabelFill(Color.PURPLE);
        // 设置x轴类别字体大小
        // xAxis.setTickLabelFont(new Font(20));
        // 设置类别标签与轴刻度的间距
        // xAxis.setTickLabelGap(100);
        // 设置类型标签旋转45°
        // xAxis.setTickLabelRotation(45);
        // 是否显示类别名称
        // xAxis.setTickLabelsVisible(false);

        HBox box = new HBox();
        box.getChildren().addAll(chart);
        Button button = new Button("click");
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box, button);
        AnchorPane.setBottomAnchor(button, 100.0);
        AnchorPane.setRightAnchor(button, 100.0);
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getClassLoader().getResource("css/chart.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("BarChart柱状图基本设置");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        button.setOnAction(event -> {
            XYChart.Series<String, Number> series = chart.getData().get(0);
            XYChart.Data<String, Number> data = series.getData().get(0);
            data.setYValue(20);
        });
    }

    /**
     * 第一种方式
     *
     * @return
     */
    private BarChart<String, Number> getView1() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");
        /* 最低，最高，间距*/
        NumberAxis y = new NumberAxis(0, 100, 10);
        y.setLabel("GDP");
        // 构造数据
        ObservableList<XYChart.Series<String, Number>> listData = FXCollections.observableArrayList();
        XYChart.Series<String, Number> xy = new XYChart.Series<>();
        xy.setName("生产总值");
        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Data<String, Number> data1 = new XYChart.Data<>("日本", 70);
        XYChart.Data<String, Number> data2 = new XYChart.Data<>("美国", 90);
        XYChart.Data<String, Number> data3 = new XYChart.Data<>("英国", 50);
        data.addAll(data1, data2, data3);
        xy.setData(data);
        listData.add(xy);
        return new BarChart<>(x, y, listData);
    }

    /**
     * 第二种方式
     *
     * @return
     */
    private BarChart<String, Number> getView2() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");
        /* 最低，最高，间距*/
        NumberAxis y = new NumberAxis(0, 100, 10);
        y.setLabel("GDP");
        XYChart.Series<String, Number> ChinaXY = new XYChart.Series<>();
        ChinaXY.setName("中国");
        XYChart.Series<String, Number> JapanXY = new XYChart.Series<>();
        JapanXY.setName("日本");
        XYChart.Series<String, Number> AmericanXY = new XYChart.Series<>();
        AmericanXY.setName("美国");
        XYChart.Data<String, Number> data1 = new XYChart.Data<>("GDP", 70);
        XYChart.Data<String, Number> data2 = new XYChart.Data<>("GDP", 90);
        XYChart.Data<String, Number> data3 = new XYChart.Data<>("GDP", 50);
        XYChart.Data<String, Number> data4 = new XYChart.Data<>("GNP", 40);
        XYChart.Data<String, Number> data5 = new XYChart.Data<>("GNP", 93);
        XYChart.Data<String, Number> data6 = new XYChart.Data<>("GNP", 63);
        ChinaXY.getData().addAll(data1, data4);
        JapanXY.getData().addAll(data2, data5);
        AmericanXY.getData().addAll(data3, data6);
        // ChinaXY.getData().forEach(stringNumberData -> {
        //     HBox box = new HBox();
        //     box.setAlignment(Pos.CENTER);
        //     box.setStyle("-fx-background-color: #ffff55;");
        //     box.getChildren().addAll(new Label(String.valueOf(stringNumberData.getYValue())));
        //     stringNumberData.setNode(box);
        //     stringNumberData.getNode().setOnMouseClicked(event -> System.out.println(stringNumberData.getXValue()));
        // });
        BarChart<String, Number> chart = new BarChart<>(x, y);
        chart.getData().addAll(ChinaXY, JapanXY, AmericanXY);
        return chart;
    }

    /**
     * 第三种方式
     *
     * @return
     */
    private BarChart<String, Number> getView3() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");
        /* 最低，最高，间距*/
        NumberAxis y = new NumberAxis(0, 100, 10);
        y.setLabel("GDP");
        XYChart.Series<String, Number> GDPXY = new XYChart.Series<>();
        GDPXY.setName("GDP");
        XYChart.Series<String, Number> GNPXY = new XYChart.Series<>();
        GNPXY.setName("GNP");
        XYChart.Data<String, Number> data1 = new XYChart.Data<>("中国", 70);
        XYChart.Data<String, Number> data2 = new XYChart.Data<>("美国", 90);
        XYChart.Data<String, Number> data3 = new XYChart.Data<>("日本", 50);
        XYChart.Data<String, Number> data4 = new XYChart.Data<>("中国", 40);
        XYChart.Data<String, Number> data5 = new XYChart.Data<>("美国", 93);
        XYChart.Data<String, Number> data6 = new XYChart.Data<>("日本", 63);
        GDPXY.getData().addAll(data1, data2, data3);
        GNPXY.getData().addAll(data4, data5, data6);
        BarChart<String, Number> chart = new BarChart<>(x, y);
        chart.getData().addAll(GDPXY, GNPXY);
        return chart;
    }

    /**
     * 第四种方式
     *
     * @return
     */
    private BarChart<Number, String> getView4() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");
        /* 最低，最高，间距*/
        NumberAxis y = new NumberAxis(0, 100, 10);
        y.setLabel("GDP");
        XYChart.Series<Number, String> GDPXY = new XYChart.Series<>();
        GDPXY.setName("GDP");
        XYChart.Series<Number, String> GNPXY = new XYChart.Series<>();
        GNPXY.setName("GNP");
        XYChart.Data<Number, String> data1 = new XYChart.Data<>(70, "中国");
        XYChart.Data<Number, String> data2 = new XYChart.Data<>(90, "美国");
        XYChart.Data<Number, String> data3 = new XYChart.Data<>(50, "日本");
        XYChart.Data<Number, String> data4 = new XYChart.Data<>(40, "中国");
        XYChart.Data<Number, String> data5 = new XYChart.Data<>(93, "美国");
        XYChart.Data<Number, String> data6 = new XYChart.Data<>(63, "日本");
        GDPXY.getData().addAll(data1, data2, data3);
        GNPXY.getData().addAll(data4, data5, data6);
        BarChart<Number, String> chart = new BarChart<>(y, x);
        chart.getData().addAll(GDPXY, GNPXY);
        return chart;
    }
}
