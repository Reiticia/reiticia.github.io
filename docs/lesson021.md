---
lang: zh-CN
title: TilePane瓦片布局
---


# TilePane瓦片布局

**特点：布局内所有的组件会以最大的组件的占用空间为基准，按照比例放置在TilePane中**

* 创建瓦片布局
  
    ```java
    Button button1 = new Button("btn1");
    button1.setPrefWidth(100);
    Button button2 = new Button("btn2");
    button2.setPrefHeight(100);
    Button button3 = new Button("btn3");
    Button button4 = new Button("btn4");
    Button button5 = new Button("btn5");
    Button button6 = new Button("btn6");
    Button button7 = new Button("btn7");
    Button button8 = new Button("btn8");
    TilePane tilePane = new TilePane();
    tilePane.setStyle("-fx-background-color: #FF0000");
    tilePane.setHgap(10);
    tilePane.setVgap(10);
    tilePane.setPadding(new Insets(10));
    tilePane.setAlignment(Pos.CENTER);
    TilePane.setMargin(button1, new Insets(10));
    tilePane.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8);
    ```
      
    ![](../assets/Pasted%20image%2020220513095925.png)