### FlowPane流式布局

* 创建流式布局
  
```java
// 创建8个按钮  
Button[] buttons = new Button[8];  
for (int i = 0; i < buttons.length; i++) {  
    buttons[i] = new Button("Button " + i);  
}  
// 创建流式布局  
FlowPane flowPane = new FlowPane();  
flowPane.setStyle("-fx-background-color: #336699;");  
flowPane.getChildren().addAll(buttons);
```

* 设置垂直流式布局（默认为水平流式布局）`flowPane.setOrientation(Orientation.VERTICAL);`

* 设置对齐方式：水平居中、垂直居中`flowPane.setAlignment(Pos.CENTER);`

* 设置组件间水平间距`flowPane.setHgap(10);`

* 设置组件间垂直间距`flowPane.setVgap(10);`

* 设置边距`flowPane.setPadding(new Insets(10));`

* 设置第一个按钮的外边距==此时其他按钮距离顶部的距离也会随着改变==`FlowPane.setMargin(buttons[0], new Insets(10));`