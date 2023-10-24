### Hyperlink使用

* 基本使用
  
```java
VBox vBox = new VBox();  
Scene scene = new Scene(vBox);  
// 超链接样式，但点击不会跳转链接，点击后面的按钮会打开网页
Hyperlink hyperlink = new Hyperlink("www.baidu.com",new Button("百度"));  
vBox.getChildren().addAll(hyperlink);  
primaryStage.setScene(scene);  
primaryStage.setTitle("Hyperlink");  
primaryStage.setWidth(500);  
primaryStage.setHeight(300);  
primaryStage.show();  
hyperlink.setOnAction(event -> {  
    HostServices hostServices = Main.this.getHostServices();  
    hostServices.showDocument(hyperlink.getText());  
});
```

![](../assets/Pasted%20image%2020220513152926.png)