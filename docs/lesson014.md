### HBox和VBox

#### HBox水平布局

使用HBox，会将此布局内所有组件进行水平排列，如果其中的组件总宽度大于布局宽度，则会将组件进行压缩

* 使用
  
```java
// 创建水平布局容器  
HBox hBox = new HBox();  
hBox.setStyle("-fx-border-color: skyblue");  
hBox.setPrefSize(200,200);  
// 创建3个按钮  
Button button1 = new Button("button1");  
Button button2 = new Button("button2");  
Button button3 = new Button("button3");  
// 将3个按钮添加到容器中  
hBox.getChildren().addAll(button1, button2, button3);
```

* 设置组件内边距`hBox.setPadding(new Insets(10));`

* 设置间距`hBox.setSpacing(10);`

* 设置按钮1的内边距`hBox.setMargin(button1, new Insets(10));`

* 设置水平居中`hBox.setAlignment(Pos.CENTER);`
  
#### VBox垂直布局
  
使用HBox，会将此布局内所有组件进行垂直排列，如果其中的组件总高度大于布局高度，则会将组件进行压缩

* 使用
  
```java
// 创建水平布局容器  
VBox vBox = new VBox();  
vBox.setStyle("-fx-border-color: skyblue");  
vBox.setPrefSize(200,200);  
// 创建3个按钮  
Button button1 = new Button("button1");  
Button button2 = new Button("button2");  
Button button3 = new Button("button3");  
// 将3个按钮添加到容器中  
vBox.getChildren().addAll(button1, button2, button3);
```
  
**注意：同一按钮组件不能同时应用于不同的布局上，只能作用于最后编写的布局**

* 其他设置与HBox类似