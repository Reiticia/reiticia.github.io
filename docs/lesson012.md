### 文本框、密码框、标签

#### 文本框

* 常规设置
  
```java
TextField textField = new TextField();  
textField.setText("请输入内容");  
textField.setPrefWidth(200);  
textField.setPrefHeight(30);  
textField.setLayoutX(primaryStage.getWidth() / 2 - textField.getPrefWidth() / 2);  
textField.setLayoutY(primaryStage.getHeight() / 2 - textField.getPrefHeight() / 2);
```

* 设置提示`textField.setTooltip(new Tooltip("这是一个输入框"));`

![](../assets/Pasted%20image%2020220512094843.png)

* 设置文本框中提示文字
  
```java
// 提示文字信息
textField.setPromptText("请输入内容");  
// 设置默认失焦
textField.setFocusTraversable(false);
```

![](../assets/Pasted%20image%2020220512095602.png)

* 监听文本输入
  
```java
textField.textProperty().addListener(new ChangeListener<String>() {  
    @Override  
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {  
        // 如果输入的字符串长度大于7位，则填充上一个字符串，即限制字符串长度为7
        if (newValue.length() > 7) {  
            textField.setText(oldValue);  
        }  
    }  
});
```

* 监听选中的文本变化
  
```java
textField.selectedTextProperty().addListener(new ChangeListener<String>() {  
    @Override  
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {  
        System.out.println(newValue);  
    }  
});
```

![](../assets/Pasted%20image%2020220512100932.png)

#### 密码框

* 创建密码框`PasswordField passwordField = new PasswordField();`

![](../assets/Pasted%20image%2020220512101147.png)

* 其他设置与文本框类似

* 监听事件与文本框类似
  
#### 标签

* 创建标签`Label label = new Label("I'm a label");`

* 其他设置与文本框类似

* 鼠标单击事件
  
```java
label.setOnMouseClicked(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        System.out.println("label clicked");  
    }  
});
```
