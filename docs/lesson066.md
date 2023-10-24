### Tooltip 提示文本

* 创建一个提示文本框`Tooltip tooltip = new Tooltip("this is tip content");`

* 提示文本设置
  
```java
// 字体大小
tooltip.setFont(new Font(12));  
// 背景颜色
tooltip.setStyle("-fx-background-color:blue;");  
// 宽度
tooltip.setPrefWidth(75.0);  
// 高度
tooltip.setPrefHeight(75.0);  
// 文本自动换行
tooltip.setWrapText(true);
```

* 设置文本超出边界的效果`tooltip.setTextOverrun(OverrunStyle.CLIP);`

* 文本居中`tooltip.setTextAlignment(TextAlignment.CENTER);`

* 鼠标指针相对于提示框的位置
  
```java
// 下面两句效果相同
tooltip.setAnchorLocation(PopupWindow.AnchorLocation.CONTENT_TOP_RIGHT);
tooltip.setAnchorLocation(PopupWindow.AnchorLocation.WINDOW_TOP_RIGHT);
```

* 透明度`tooltip.setOpacity(0.5);`

* 自动隐藏`tooltip.setAutoHide(true);`

* 为按钮设置提示文本

```java
// 下面两句效果相同
button.setTooltip(tooltip);  
Tooltip.install(button,tooltip);
```

* 卸载按钮上的提示框`Tooltip.uninstall(button, tooltip);`

* 设置提示文本在窗口呈现时默认展示`tooltip.show(primaryStage);`

* 设置提示文本距离屏幕左上角的位置
  
```java
tooltip.setX(100);  
tooltip.setY(100);
// 或者
tooltip.setAnchorX(100);  
tooltip.setAnchorY(100);
```

* 展示时监听事件
  
```java
tooltip.setOnShowing(event -> {  
    System.out.println("tooltip is showing");  
    // 阻止事件传播（失败，不是JDK版本问题）  
    event.consume();  
});
```

* 展示完成监听事件
  
```java
tooltip.setOnShown(event -> System.out.println("tooltip has shown"));
```

* 隐藏后监听事件
  
```java
tooltip.setOnHidden(event -> System.out.println("tooltip has hidden"));
```

#### 实例

```java
AnchorPane anchorPane = new AnchorPane();  
Tooltip tooltip = new Tooltip();  
// 设置白色透明  
tooltip.setStyle("-fx-background-color:#ffffff00;");  
tooltip.setPrefWidth(100);  
tooltip.setPrefHeight(100);  
VBox vBox = new VBox();  
// 背景颜色，圆角，外边距  
vBox.setStyle("-fx-background-color: pink; -fx-background-radius: 20;-fx-background-insets: 0");  
// 不能完全覆盖  
vBox.setPrefWidth(100);  
vBox.setPrefHeight(100);  
vBox.setAlignment(Pos.CENTER);  
ImageView imageView = new ImageView("images/logo.png");  
imageView.setFitHeight(50);  
imageView.setFitWidth(50);  
vBox.getChildren().addAll(imageView);  
tooltip.setGraphic(vBox);  
Button button = new Button("btn");  
button.setTooltip(tooltip);  
button.setLayoutX(100);  
button.setLayoutY(100);  
anchorPane.getChildren().addAll(button);  
Scene scene = new Scene(anchorPane);  
primaryStage.setScene(scene);  
primaryStage.setTitle("Hello JavaFx");  
primaryStage.setWidth(800);  
primaryStage.setHeight(800);  
primaryStage.show();
```

![](../assets/Pasted%20image%2020220527190016.png)