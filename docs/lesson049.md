---
lang: zh-CN
title: ScrollBar、ScrollPane、Separator
---


# ScrollBar、ScrollPane、Separator

## ScrollBar滚动条

* 创建滚动条`ScrollBar scrollBar = new ScrollBar();`

* 设置方向：垂直`scrollBar.setOrientation(Orientation.VERTICAL);`

* 设置滚动条长度`scrollBar.setVisibleAmount(50);`

* 设置初始滚动距离`scrollBar.setValue(20);`

* 设置滚动条宽度`scrollBar.setPrefWidth(100);`

* 设置宽度`scrollBar.setPrefHeight(vBox.getHeight());`

* 设置最大值**不设置默认为100**`scrollBar.setMax(vBox.getHeight());`

* 点击上下箭头每次滚动10`scrollBar.setUnitIncrement(10);`

* 点击滚动条空白区域每次滚动100`scrollBar.setBlockIncrement(100);`

* 属性监听
  
    ```java
    scrollBar.valueProperty().addListener(((observable, oldValue, newValue) -> {  
        System.out.println("newValue = " + newValue);  
    }));
    ```
  
![](../assets/Pasted%20image%2020220521165044.png)

## ScrollPane滚动面板

* 创建滚动面板，创建滚动面板内部组件，设置宽高
  
    ```java
    HBox hBox = new HBox(10);  
    for (int i = 0; i < 10; i++) {  
        hBox.getChildren().add(new Button("Hbtn" + i));  
    }  
    VBox vBox = new VBox(10);  
    for (int i = 0; i < 10; i++) {  
        vBox.getChildren().add(new Button("Vbtn" + i));  
    }  
    VBox box = new VBox(10, hBox, vBox);  
    // 滚动面板  
    ScrollPane scrollPane = new ScrollPane();  
    scrollPane.setPrefWidth(300);  
    scrollPane.setPrefHeight(300);  
    scrollPane.setContent(box);
    ```

![](../assets/Pasted%20image%2020220521165246.png)

## Separator分隔符

* 创建分隔符`Separator separator = new Separator();`

* 设置宽高(此设置并不会改变分隔符的宽度和长度)
  
    ```java
    separator.setPrefWidth(300);  
    separator.setPrefHeight(300);
    ```

* 设置分隔符方向：垂直`separator.setOrientation(Orientation.VERTICAL);`

* 设置水平居左`separator.setHalignment(HPos.LEFT);`

* 设置垂直居下`separator.setValignment(VPos.BOTTOM);`

![](../assets/Pasted%20image%2020220521165808.png)