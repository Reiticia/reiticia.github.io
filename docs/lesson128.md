### BarChart柱状图

```java
/**  
 * 第一种方式  
 *  
 * @return  
 */  
private BarChart<String, Number> getView1() {
    // 创建行以及设置标签
    CategoryAxis x = new CategoryAxis();  
    x.setLabel("国家");
    // 创建列以及设置标签
    /* 最低，最高，间距*/  
    NumberAxis y = new NumberAxis(0, 100, 10);  
    y.setLabel("GDP");  
    // 图数据
    ObservableList<XYChart.Series<String, Number>> listData = FXCollections.observableArrayList();  
    // 创建类型（同一种类型的柱状会显示同一颜色）
    XYChart.Series<String, Number> xy = new XYChart.Series<>();  
    xy.setName("生产总值");  
    ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();  
    XYChart.Data<String, Number> data1 = new XYChart.Data<>("日本", 70);  
    XYChart.Data<String, Number> data2 = new XYChart.Data<>("美国", 90);  
    XYChart.Data<String, Number> data3 = new XYChart.Data<>("英国", 50);  
    // 添加数据
    data.addAll(data1, data2, data3);  
    // 设置该类型的数据
    xy.setData(data);  
    // 添加类型
    listData.add(xy);  
    // 创建柱状图
    return new BarChart<>(x, y, listData);
}
```

```java
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
    BarChart<String, Number> chart = new BarChart<>(x, y);  
    chart.getData().addAll(ChinaXY, JapanXY, AmericanXY);  
    return chart;  
}
```

```java
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
```

```java
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
```

添加柱状图到布局中

```java
GridPane box = new GridPane();  
BarChart<String, Number> chart1 = getView1();  
chart1.setTitle("第一种方式");  
chart1.setPrefWidth(300);  
chart1.setPrefHeight(300);  
box.add(chart1, 0, 0);  
BarChart<String, Number> chart2 = getView2();  
chart2.setTitle("第二种方式");  
chart2.setPrefWidth(300);  
chart2.setPrefHeight(300);  
box.add(chart2, 1, 0);  
BarChart<String, Number> chart3 = getView3();  
chart3.setTitle("第三种方式");  
chart3.setPrefWidth(300);  
chart3.setPrefHeight(300);  
box.add(chart3, 0, 1);  
BarChart<Number, String> chart4 = getView4();  
chart4.setTitle("第三种方式");  
chart4.setPrefWidth(300);  
chart4.setPrefHeight(300);  
box.add(chart4, 1, 1);
```

效果图
![](../assets/Pasted%20image%2020220613163003.png)