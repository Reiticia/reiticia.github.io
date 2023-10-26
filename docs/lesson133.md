---
lang: zh-CN
title: ScatterChart散点图
---


# ScatterChart散点图

* 填充数据
  
  ```java
  private ScatterChart<Number, Number> getView() {  
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
      ScatterChart<Number, Number> chart = new ScatterChart<>(X, Y);  
      chart.getData().addAll(xy1, xy2);  
      chart.setTitle("ScatterChart散点图");  
      return chart;  
  }
  ```
  
  ![](../assets/Pasted%20image%2020220614113433.png)

* css
  
  ```css
  /*选中第一种类别的符号*/
  .chart-symbol.default-color0{  
      -fx-background-color: #0066cc;  
      -fx-shape: "M511.8 516.3L349.5 329.6l186.8-162.3 162.3 186.8-186.8 162.2zM356.5 330.1l155.7 179.2 179.2-155.7-155.6-179.3-179.3 155.8zM513.5 516l-233.9-80.6 80.6-233.9 233.9 80.6L513.5 516zM286 432.3l224.5 77.4 77.4-224.5-224.5-77.4L286 432.3zM272 562l-47.1-243 242.9-47.2L515 514.7 272 562z m-41.3-239L276 556.1l233.1-45.2-45.3-233.1L230.7 323zM328.7 675.4L166.4 488.6l186.8-162.3 162.3 186.8-186.8 162.3zM173.5 489.1l155.7 179.2 179.2-155.7-155.7-179.3-179.2 155.8zM434.6 745.2l-233.9-80.6 80.6-233.9 233.9 80.6-80.6 233.9zM207 661.5l224.5 77.4 77.4-224.5L284.3 437 207 661.5zM318.2 800l-47.1-243L514 509.9l47.2 242.9-243 47.2z m-41.3-239l45.2 233.1 233.1-45.2L510 515.8 276.9 561zM487.8 858.4L325.5 671.6l186.8-162.3 162.3 186.8-186.8 162.3zM332.5 672.1l155.7 179.2 179.2-155.7-155.6-179.3-179.3 155.8zM663.8 824.2l-233.9-80.6 80.6-233.9 233.9 80.6-80.6 233.9z m-227.6-83.7l224.5 77.4L738 593.4 513.5 516l-77.3 224.5zM556.2 753.8L509 510.9l243-47.2 47.2 242.9-243 47.2z m-41.3-239l45.2 233.1 233.1-45.2L748 469.5l-233.1 45.3zM670.8 699.4L508.5 512.6l186.8-162.3 162.3 186.8-186.8 162.3zM515.5 513.1l155.7 179.2 179.2-155.7-155.6-179.3-179.3 155.8zM742.8 595l-233.9-80.6 80.6-233.9L823.4 361l-80.6 234z m-227.6-83.7l224.5 77.4L817 364.1l-224.5-77.4-77.3 224.6zM510 515.8l-47.2-242.9 242.9-47.2 47.2 242.9L510 515.8z m-41.3-239L514 509.9l233.1-45.2-45.2-233.1-233.2 45.2zM511.8 516.3L349.5 329.6l186.8-162.3 162.3 186.8-186.8 162.2zM356.5 330.1l155.7 179.2 179.2-155.7-155.6-179.3-179.3 155.8z";  
  }
  ```
