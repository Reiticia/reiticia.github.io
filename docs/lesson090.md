### Dialog弹窗

* 创建Dialog弹窗**泛型代表弹窗关闭后的返回值类型**`Dialog<ButtonType> dialog = new Dialog<>();`
* 添加按钮并获取
  
```java
dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);  
dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);  
Button close = (Button) dialog.getDialogPane().lookupButton(ButtonType.CLOSE);  
Button ok = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
```
* 设置文本和标题 
  
```java
dialog.setHeaderText("I'm headerText");  
dialog.setTitle("dialog");  
dialog.setContentText("I'm content");
```
* 设置图标`dialog.setGraphic(new Button("icon"));`

* 设置界面大小`dialog.getDialogPane().setPrefSize(300,300);`

* 设置按钮点击后的效果**务必在show之前声明 **
  
```java
dialog.showAndWait().ifPresent(buttonType -> {  
    switch (buttonType.getButtonData()) {  
        case OK_DONE:  
            dialog.setContentText("We are reader");  
            break;  
        case CANCEL_CLOSE:  
            dialog.setContentText("You are gay");  
            break;  
        default:  
    }  
});
```
* 展示`dialog.show();`
* 设置界面大小==在show()后设置才有效果==
  
```java
dialog.setWidth(300);  
dialog.setHeight(300);
```
* 以显示器为准设置位置
  
```java
dialog.setX(100);  
dialog.setY(100);
```
* 窗口关闭监听
  
```java
dialog.setOnCloseRequest(event1 -> {  
    System.out.println("关闭");  
});
```
* 获取点击的按钮
  
```java
dialog.setResultConverter(new Callback<ButtonType, ButtonType>() {  
    @Override  
    public ButtonType call(ButtonType param) {  
        System.out.println("param = " + param);  
        return param;  
    }  
});
```
