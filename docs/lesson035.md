### ButtonBar按钮栏

* 添加按钮到按钮栏
  
```java
ButtonBar buttonBar = new ButtonBar();// 按钮栏  
Button button1 = new Button("button1");  
button1.setPrefWidth(200);  
Button button2 = new Button("button2");  
Button button3 = new Button("button3");  
ButtonBar.setButtonData(button1, ButtonData.APPLY);  
ButtonBar.setButtonData(button2, ButtonData.FINISH);  
ButtonBar.setButtonData(button3, ButtonData.NO);  
buttonBar.getButtons().addAll(button1, button2, button3);
```

* 按钮栏设置  

*设置为true后，button1的大小会影响其他按钮的大小*  
`ButtonBar.setButtonUniformSize(button1, true);`

* 更改平台`buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_WINDOWS);`
![](../assets/Pasted%20image%2020220517095856.png)