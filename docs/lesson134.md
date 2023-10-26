---
lang: zh-CN
title: AreaChart区域图
---


# AreaChart区域图

* 填充数据
  
  ```java
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
  ```
  
  ![](../assets/Pasted%20image%2020220614162503.png)

* css
  
  ```css
  /*选中区域*/  
  .chart-series-area-fill.default-color0 {  
      /*填充颜色*/  
      -fx-fill: #ffcccc55;  
  }  
  /*选中端点*/  
  .chart-area-symbol.default-color0 {  
      /*端点外圈颜色，填充色*/  
      -fx-background-color: #ffffcc, #ccffff;  
  }  
  
  /*选中线段*/  
  .chart-series-area-line.default-color0 {  
      /*线段颜色*/  
      -fx-stroke: #99cccc;  
  }  
  
  /*选中图示*/  
  .chart-legend-symbol.default-color0 {  
      /*图示外圈颜色，填充色*/  
      -fx-background-color: #ffcc99, #ffcccc;  
  }
  ```
