### CustomMenuItem、MenuButton、SplitMenuButton、ContextMenu

#### CustomMenuItem自定义菜单项

* 创建自定义菜单项并在其中添加按钮
  
```java
CustomMenuItem cmi1 = new CustomMenuItem();  
Button button = new Button("button");  
cmi1.setContent(button);
```

* 创建自定义菜单项并在其中添加进度条
  
```java
CustomMenuItem cmi2 = new CustomMenuItem();  
ProgressBar progressBar = new ProgressBar(0.5);  
cmi2.setContent(progressBar);
```

* 创建自定义菜单项并在其中添加布局
  
```java
CustomMenuItem cmi3 = new CustomMenuItem();  
HBox hBox = new HBox();  
hBox.setPrefWidth(200);  
hBox.setPrefHeight(200);  
hBox.setStyle("-fx-background-color: blue");  
// 在布局中设置三个按钮
hBox.getChildren().addAll(new Button("btn1"),new Button("btn2"),new Button("btn3"));  
cmi3.setContent(hBox);
```
  
![](../assets/Pasted%20image%2020220514125833.png)
  
#### MenuButton菜单按钮

* 创建菜单按钮并设置其在布局中的位置
  
```java
MenuButton menuButton = new MenuButton("MenuButton");  
AnchorPane.setTopAnchor(menuButton, 50.0);
```

* 创建三个菜单项设置在菜单按钮中
  
```java
MenuItem mb1 = new MenuItem("MenuItem1");  
MenuItem mb2 = new MenuItem("MenuItem2");  
MenuItem mb3 = new MenuItem("MenuItem3");  
// 对菜单项mb3设置快捷键
mb3.setAccelerator(KeyCombination.valueOf("Ctrl+Alt+Q"));  
menuButton.getItems().addAll(mb1, mb2, mb3);  
menuButton.setMinWidth(150);  
menuButton.setMaxWidth(150);
```

* 键盘快捷键触发事件`mb3.setOnMenuValidation(event-> menuButton.setText("你不好"));`

![](../assets/Pasted%20image%2020220514130350.png)
  
  #### SplitMenuButton分割菜单按钮

* 具体设置代码与菜单按钮类似

![](../assets/Pasted%20image%2020220514130530.png)
  
  #### ContextMenu右键菜单栏

* 创建右键菜单栏并添加菜单项
  
  ```java
  ContextMenu contextMenu = new ContextMenu();  
  MenuItem menuItem1 = new MenuItem("MenuItem1");  
  MenuItem menuItem2 = new MenuItem("MenuItem2");  
  MenuItem menuItem3 = new MenuItem("MenuItem3");  
  contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);
  ```

* 将右键菜单绑定给按钮`button.setContextMenu(contextMenu);`

![](../assets/Pasted%20image%2020220514130807.png)
