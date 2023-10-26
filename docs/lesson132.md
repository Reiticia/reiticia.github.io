---
lang: zh-CN
title: StackedBarChart堆积柱状图
---


# StackedBarChart堆积柱状图

* 填充数据
  
  ```java
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
      return chart;  
  }
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220614110642.png)

* css
  
  ```css
  /*选中堆积柱状图*/
  .stacked-bar-chart {  
    -fx-category-gap: 20;  
  }  
  /*选中堆积柱状图中第一类的*/
  .chart-bar.default-color0 {  
    -fx-bar-fill: blue;  
  }  
  /*选中堆积柱状图中第二类的*/
  .chart-bar.default-color1 {  
    -fx-bar-fill: #ff6666;  
  }
  ```