---
lang: zh-CN
title: 其他弹窗
---

# 其他弹窗

## ChoiceDialog下拉列表弹窗

```java
ObservableList<String > list = FXCollections.observableArrayList();  
list.add("鸢一折纸");  
list.add("本条二亚");  
list.add("时崎狂三");  
list.add("冰芽川四糸乃");  
list.add("五河琴里");  
list.add("星宫六喰");  
list.add("镜野七罪");  
list.add("八舞夕弦");  
list.add("八舞耶俱矢");  
list.add("诱宵美九");  
list.add("夜刀神十香");  
ChoiceDialog<String> dialog = new ChoiceDialog<>("鸢一折纸",list);  
dialog.selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));  
dialog.show();
```

![](../assets/Pasted%20image%2020220605171311.png)

## TextInputDialog输入框弹窗

```java
TextInputDialog dialog = new TextInputDialog("输入框弹窗");  
Button ok = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);  
dialog.show();  
ok.setOnAction(event1 -> {  
    System.out.println(dialog.getEditor().getText());  
});
```

![](../assets/Pasted%20image%2020220605171326.png)

## 自定义弹窗

```java
Stage stage = new Stage();  
DialogPane dialog = new DialogPane();  
dialog.setStyle("-fx-background-color: pink; -fx-border-color: black; -fx-border-width: 2px;");  
dialog.setHeaderText("这是一个自定义弹窗");  
dialog.setContentText("这是一个自定义弹窗");  
ImageView imageView = new ImageView("images/logo.png");  
imageView.setPreserveRatio(true);  
imageView.setFitWidth(30);  
dialog.setGraphic(imageView);  
// dialog.setPrefSize(300,150);  
// 添加按钮  
dialog.getButtonTypes().add(ButtonType.OK);  
dialog.getButtonTypes().add(ButtonType.CANCEL);  
// 弹窗按钮点击事件  
((Button)dialog.lookupButton(ButtonType.OK)).setOnAction(event1 -> stage.close());  
((Button)dialog.lookupButton(ButtonType.CANCEL)).setOnAction(event1 -> stage.close());  
Scene scene1 = new Scene(dialog);  
stage.setScene(scene1);  
// 务必删除下面两行设置，会有白边效果  
// stage.setWidth(300);  
// stage.setHeight(200);  
// 设置没有装饰的窗口  
stage.initStyle(StageStyle.UNDECORATED);  
// 模态窗口  
stage.initOwner(primaryStage);  
stage.initModality(Modality.WINDOW_MODAL);  
// 始终置顶  
// stage.setAlwaysOnTop(true);  
stage.show();
```

![](../assets/Pasted%20image%2020220605171448.png)