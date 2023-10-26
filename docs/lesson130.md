---
lang: zh-CN
title: LineChart折线图
---


# LineChart折线图

* 填充数据
  
  ```java
  private LineChart<String, Number> getView2() { 
      // x轴
      CategoryAxis X = new CategoryAxis();  
      // y轴
      NumberAxis Y = new NumberAxis("y轴", 0, 100, 10);  
      // 第一种类别
      XYChart.Series<String, Number> xy1 = new XYChart.Series<>();  
      xy1.setName("xy1");  
      // 第二种类别
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
      // 给每种类别各自添加数据
      xy1.getData().addAll(data1, data2, data3, data4);  
      xy2.getData().addAll(data5, data6, data7, data8);  
      LineChart<String, Number> chart = new LineChart<>(X, Y);  
      chart.getData().addAll(xy1, xy2);  
      return chart;  
  }
  ```

* 其他设置参考柱状图

* css
  
  ```css
  /*选中折线图中第一条线段的线段*/
  .chart-series-line.default-color0 {  
      -fx-stroke: #ffffcc;  
  }  
  /*选中折线图中第一条线段的顶点*/
  .chart-line-symbol.default-color0 {  
      -fx-background-color: #ccffff, #ffcccc;  
  }  
  
  /*选中折线图中第二条线段的线段*/
  .chart-series-line.default-color1 {  
      -fx-stroke: #99cccc;  
  }  
  
  /*选中折线图中第二条线段的顶点*/
  .chart-line-symbol.default-color0 {  
      -fx-background-color: #ffcc99, #ffcccc;  
  }
  ```