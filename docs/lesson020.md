---
lang: zh-CN
title: TextFlow文本布局
---


# TextFlow文本布局

**特点：支持多行文本，自动识别单词间的空格，在调整窗口大小时自动调整文本位置**

* 创建文本布局
  
  ```java
  Text text = new Text("Hello JavaFX");
  Text text1 = new Text("Hello World");
  TextFlow textFlow = new TextFlow();
  textFlow.setStyle("-fx-background-color: #336699;");
  textFlow.setTextAlignment(TextAlignment.CENTER);//
  textFlow.setLineSpacing(50);
  textFlow.getChildren().addAll(text, text1,new Button("Button"));
  ```

* 设置文本内边距`textFlow.setPadding(new Insets(10));`

* 设置文本对齐方式`textFlow.setTextAlignment(TextAlignment.CENTER);`

* 设置行间距`textFlow.setLineSpacing(50);`
  **textFlow特性放置到其他组件上会失去其特性，其无法监听到窗口大小的变化**
    
  ```java
  AnchorPane anchorPane = new AnchorPane(textFlow);  
  AnchorPane.setLeftAnchor(textFlow, 10.0);  
  Scene scene = new Scene(anchorPane);  
  primaryStage.setScene(scene);  
  primaryStage.setTitle("Hello JavaFX");  
  primaryStage.setWidth(800);  
  primaryStage.setHeight(600);  
  primaryStage.show();  
  primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> { 
      System.out.println("anchorPane width: " + anchorPane.getWidth());  
      System.out.println("textFlow width:" + textFlow.getWidth());
  });
  ```
  
  ![](../assets/Pasted%20image%2020220513091010.png)

  解决方法：对父组件监视属性绑定监听器
  
  ```java
  anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {  
    textFlow.setPrefWidth(newValue.doubleValue()-textFlow.getLayoutX());  
  });
  anchorPane.heightProperty().addListener((observable, oldValue, newValue) -> {  
    textFlow.setPrefHeight(newValue.doubleValue()-textFlow.getLayoutY());  
  });
  ```