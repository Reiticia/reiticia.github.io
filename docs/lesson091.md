### Alert弹窗

* 创建Alert弹窗==类型决定弹窗内的按钮类型和图标，如果该alert中没有对应的按钮却给该类型的按钮设置了监听，则会报错NullPointerException==
  
```java
Alert alert = new Alert(Alert.AlertType.INFORMATION);
```
* 添加指定类型的按钮`alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);`

* 获取指定类型的按钮
  
```java
Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);  
Button cancel = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);  
Button close = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
```

* 删除按钮，删除的按钮由弹窗中设置的按钮顺序决定`alert.getDialogPane().getButtonTypes().remove(0);`

* 设置文本、标题、图标 
  
```java
alert.setTitle("alert");  
alert.setHeaderText("HeaderText");  
alert.setContentText("ContentText");  
ImageView imageView = new ImageView("images/logo.png");  
imageView.setPreserveRatio(true);  
imageView.setFitWidth(25);  
alert.setGraphic(imageView);
```

* 设置模态`alert.initModality(Modality.APPLICATION_MODAL);`

* 展示`alert.show();`