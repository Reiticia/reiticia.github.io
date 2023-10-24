### StackPane栈布局

* 创建栈布局
  
```java
// 创建5个按钮  
Button button1 = new Button("Button1");  
Button button2 = new Button("Button2");  
Button button3 = new Button("Button3");  
Button button4 = new Button("Button4");  
Button button5 = new Button("Button5");  
// 创建栈布局  
StackPane pane = new StackPane();  
pane.setStyle("-fx-background-color: #336699;");  
pane.getChildren().addAll(button1, button2, button3, button4, button5);
```

* 其他设置与前面布局类似