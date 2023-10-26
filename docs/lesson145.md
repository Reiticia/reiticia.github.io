---
lang: zh-CN
title: RadialGradient径向渐变
---


# RadialGradient径向渐变

```java
List<Stop> stops = new ArrayList<>();  
stops.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(0,0)为中心向外延申）  
RadialGradient rg = new RadialGradient(0, 0, 0, 0, 50, false, CycleMethod.NO_CYCLE, stops);  
list.add(rg);  

List<Stop> stops1 = new ArrayList<>();  
stops1.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops1.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops1.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）  
RadialGradient rg1 = new RadialGradient(0, 0, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops1);  
list.add(rg1);  

List<Stop> stops2 = new ArrayList<>();  
stops2.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops2.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops2.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）（中心点向左偏移）  
RadialGradient rg2 = new RadialGradient(0, -1, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops2);  
list.add(rg2);  

List<Stop> stops3 = new ArrayList<>();  
stops3.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops3.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops3.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）（中心点向右偏移）  
RadialGradient rg3 = new RadialGradient(0, 1, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops3);  
list.add(rg3);  

List<Stop> stops4 = new ArrayList<>();  
stops4.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops4.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops4.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）（中心点向右偏移）（顺时针旋转45°）  
RadialGradient rg4 = new RadialGradient(45, 1, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops4);  
list.add(rg4);  

List<Stop> stops5 = new ArrayList<>();  
stops5.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops5.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops5.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）（中心点向左偏移）（顺时针旋转45°）  
RadialGradient rg5 = new RadialGradient(45, -1, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops5);  
list.add(rg5);  

List<Stop> stops6 = new ArrayList<>();  
stops6.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops6.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops6.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）（中心点向左偏移）（顺时针旋转45°）  
RadialGradient rg6 = new RadialGradient(45, -0.5, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops6);  
list.add(rg6);  

List<Stop> stops7 = new ArrayList<>();  
stops7.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops7.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops7.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以(50,50)为中心向外延申）（中心点向左偏移）（顺时针旋转45°）（百分比方式定位）  
RadialGradient rg7 = new RadialGradient(45, -1, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops7);  
list.add(rg7);  

List<Stop> stops8 = new ArrayList<>();  
stops8.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops8.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops8.add(new Stop(0.9, Color.valueOf("#ffcccc")));  
stops8.add(new Stop(1, Color.valueOf("#ffffff00")));  
// 径向渐变（以(50,50)为中心向外延申）（百分比方式定位）（余下部分用透明填充）  
RadialGradient rg8 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops8);  
list.add(rg8);  

for (int i = 0; i < list.size(); i++) {  
    Rectangle node = (Rectangle) grid.getChildren().get(i);  
    node.setFill(list.get(i));  
}  

Circle circle1 = new Circle(50);  
List<Stop> stops9 = new ArrayList<>();  
stops9.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops9.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops9.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以圆心向外延申）（百分比方式定位）  
RadialGradient rg9 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops9);  
circle1.setFill(rg9);  
grid.add(circle1, 0, 2);  

Circle circle2 = new Circle(50);  
List<Stop> stops10 = new ArrayList<>();  
stops10.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops10.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops10.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以距离圆心(50,50)为中心向外延申）（百分比方式定位）（余下部分用透明填充）  
RadialGradient rg10 = new RadialGradient(0, 0, 50, 50, 50, false, CycleMethod.NO_CYCLE, stops10);  
circle2.setFill(rg10);  
grid.add(circle2, 1, 2);  

Circle circle3 = new Circle(50);  
List<Stop> stops11 = new ArrayList<>();  
stops11.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops11.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops11.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以距离圆心(50,50)为中心向外延申）（百分比方式定位）（余下部分用透明填充）(对称)  
RadialGradient rg11 = new RadialGradient(0, 0, 0, 0, 25, false, CycleMethod.REFLECT, stops11);  
circle3.setFill(rg11);  
grid.add(circle3, 2, 2);  

Circle circle4 = new Circle(50);  
List<Stop> stops12 = new ArrayList<>();  
stops12.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops12.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops12.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以距离圆心(50,50)为中心向外延申）（百分比方式定位）（余下部分用透明填充）(重复)  
RadialGradient rg12 = new RadialGradient(0, 0, 0, 0, 25, false, CycleMethod.REPEAT, stops12);  
circle4.setFill(rg12);  
grid.add(circle4, 3, 2);  

Polygon polygon = new Polygon(50, 0, 100, 100, 0, 100);  
List<Stop> stops13 = new ArrayList<>();  
stops13.add(new Stop(0, Color.valueOf("#ffffcc")));  
stops13.add(new Stop(0.5, Color.valueOf("#ccffff")));  
stops13.add(new Stop(1, Color.valueOf("#ffcccc")));  
// 径向渐变（以距离圆心(50,50)为中心向外延申）（百分比方式定位）（余下部分用透明填充）(重复)  
RadialGradient rg13 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops13);  
polygon.setFill(rg13);  
grid.add(polygon, 4, 2);
```

![](../assets/Pasted%20image%2020220616080755.png)