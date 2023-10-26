---
lang: zh-CN
title: BarChart柱状图基本设置
---


# BarChart柱状图基本设置

* 数据填充
  
  ```java
  private BarChart<String, Number> getView1() {  
      // x轴
      CategoryAxis x = new CategoryAxis();  
      x.setLabel("国家");  
      /* 最低，最高，间距*/  
      // y轴
      NumberAxis y = new NumberAxis(0, 100, 10);  
      y.setLabel("GDP");  
      // 构造数据  
      ObservableList<XYChart.Series<String, Number>> listData = FXCollections.observableArrayList();  
      // 数据类型
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
  ```

* 开启动画效果`chart.setAnimated(true);`

* 设置图示的位置`chart.setLegendSide(Side.RIGHT);`

* 设置图示是否可见`chart.setLegendVisible(false);`

* 设置图题的位置`chart.setTitleSide(Side.BOTTOM);`

* 设置方向`chart.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);`

* 设置每一类数据柱状之间的间距`chart.setBarGap(0);`

* 设置每一组数据柱状之间的间距`chart.setCategoryGap(100);`

* 获取x轴`CategoryAxis xAxis = (CategoryAxis) chart.getXAxis();`

* 设置x轴开始于原点的距离`xAxis.setStartMargin(100);`

* 设置x轴末尾距离坐标轴末尾的距离`xAxis.setEndMargin(100);`

* 设置前后留有空间`xAxis.setGapStartAndEnd(true);`

* 设置X轴的位置`xAxis.setSide(Side.TOP);`

* 设置x轴类别标签颜色`xAxis.setTickLabelFill(Color.PURPLE);`

* 设置x轴类别字体大小`xAxis.setTickLabelFont(new Font(20));`

* 设置类别标签与轴刻度的间距`xAxis.setTickLabelGap(100);`

* 设置类型标签旋转45°`xAxis.setTickLabelRotation(45);`

* 是否显示类别名称`xAxis.setTickLabelsVisible(false);`

* css类选择器
  
  ```css
  /*选中柱状图中第一个数据*/
  .chart-bar.data0 {  
      -fx-bar-fill: red;  
  }  
  /*选中柱状图中第二个数据*/
  .chart-bar.data1 {  
      -fx-bar-fill: blue;  
  }
  ```