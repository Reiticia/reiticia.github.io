---
lang: zh-CN
title: BubbleChart气泡图
---


# BubbleChart气泡图

* 填充数据
      
    ```java
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
        return chart;  
    }
    ```
    
    ![](../assets/Pasted%20image%2020220614094130.png)