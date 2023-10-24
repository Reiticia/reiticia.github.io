### SplitPane分割面板

* 创建一个分割面板`SplitPane splitPane = new SplitPane();`
* 设置宽高

```java
splitPane.setPrefWidth(800);
splitPane.setPrefHeight(800);
```

* 创建4个堆栈面板并在每一个面板中放置一个按钮

```java
StackPane stackPane1 = new StackPane();// 创建一个堆栈面板
stackPane1.getChildren().add(button1);
StackPane stackPane2 = new StackPane();
stackPane2.setStyle("-fx-background-color:blue;");
stackPane2.getChildren().add(button2);
StackPane stackPane3 = new StackPane();
stackPane3.getChildren().add(button3);
StackPane stackPane4 = new StackPane();
stackPane4.getChildren().add(button4);
```

* 设置为分割面板项`splitPane.getItems().addAll(stackPane1, stackPane2, stackPane3, stackPane4);`
* 设置为垂直方向`splitPane.setOrientation(Orientation.VERTICAL);`
* 设置分割位置

```java
splitPane.setDividerPosition(0,0.25);
splitPane.setDividerPosition(1,0.5);
splitPane.setDividerPosition(2,0.75);
splitPane.setDividerPosition(3,1.0);
```

效果图

![image-20220520182311807](../assets/image-20220520182311807.png)

* 设置分割面板最大宽度和某一项最小宽度

```java
stackPane1.setMinWidth(100);
splitPane.setMaxWidth(200);
```

效果图

![image-20220520182458121](../assets/image-20220520182458121.png)
