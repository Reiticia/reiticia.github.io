### TitledPane、Accordion

#### TitledPane标题面板

* 创建一个标题面板`TitledPane titledPane = new TitledPane("TitledPane", new Button("Button1"));`

* 创建多个标题面板放置在布局中

```java
TitledPane titledPane = new TitledPane("TitledPane", new Button("Button1"));  
TitledPane titledPane1 = new TitledPane();  
titledPane1.setText("TitledPane1");  
titledPane1.setContent(new Button("Button2"));  
TitledPane titledPane2 = new TitledPane();  
titledPane2.setText("TitledPane2");  
HBox hBox = new HBox();  
hBox.setStyle("-fx-background-color: #ff0000");  
hBox.getChildren().addAll(new Button("Button3"),new Button("Button4"),new Button("Button5"));  
titledPane2.setContent(hBox);
AnchorPane.getChildren().addAll(titledPane, titledPane1,titledPane2);
```

![](../assets/Pasted%20image%2020220514170550.png)

* 设置标题面板是否有动画效果`titledPane.setAnimated(true);`

* 设置标题面板是否可折叠`titledPane.setCollapsible(false);`

* 设置标题面板是否展开`titledPane.setExpanded(false);`

* 设置标题面板的图标`titledPane2.setGraphic(new Button("Button6"));`

* 设置组件从右到左进行排列`titledPane2.setNodeOrientation(NodeOrientation.INHERIT);`

* 标题面板展开收起事件
  
```java
titledPane.expandedProperty().addListener((observable, oldValue, newValue) -> {  
  System.out.println("oldValue = " + oldValue + " newValue = " + newValue);  
});
```

#### Accordion手风琴

==特点：手风琴中可以设置多个标题面板，同一时间只能展开一个面板==

* 创建一个手风琴`Accordion accordion = new Accordion();`

* 在手风琴中添加标题面板`accordion.getPanes().addAll(titledPane,titledPane1,titledPane2);`

* 手风琴中所有标题面板展开和收起事件
  
```java
accordion.expandedPaneProperty().addListener((observable, oldValue, newValue) -> {  
    // 解决面板收起时，newValue为null的问题  
    if (newValue == null) {  
        System.out.println("oldValue = " + oldValue.getText()+"被折叠");  
        return;  
    }  
    System.out.println(newValue.getText());  
});
```

![](../assets/Pasted%20image%2020220514182516.png)