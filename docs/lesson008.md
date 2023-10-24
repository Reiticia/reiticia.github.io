### Group容器的使用

```java
// 设置三个按钮
Button button = new Button("btn0");  
// 设置按钮在布局中的位置  
button.setLayoutX(100);  
button.setLayoutY(100);  
Button button1 = new Button("btn1");  
// 设置按钮在布局中的位置  
button1.setLayoutX(100);  
button1.setLayoutY(150);  
Button button2 = new Button("btn2");  
// 设置按钮在布局中的位置  
button2.setLayoutX(100);  
button2.setLayoutY(200);
Group group = new Group();  
group.getChildren().addAll(button, button1, button2);
```

![](../assets/Pasted%20image%2020220511213418.png)

* 移除组件`group.getChildren().remove(button);`

* 移除全部组件`group.getChildren().clear();`

* 不给子组件设置默认宽高`group.setAutoSizeChildren(false);`

![](../assets/Pasted%20image%2020220511213837.png)

* 键盘事件
  
```java
// 键盘按下事件，如果按下键盘不松开，则会一直触发事件
button.setOnKeyPressed(new EventHandler<KeyEvent>() { 
    @Override
    public void handle(KeyEvent event) { 
        System.out.println("按下：" + event.getCode().name());       // 判断按下的按钮（ENTER）      
        if (event.getCode().equals(KeyCode.ENTER)) {
            System.out.println("按下ENTER键");  
        }
    }
}); 
// 键盘抬起事件
button.setOnKeyReleased(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent event) {
        System.out.println("释放：" + event.getCode().name());
    }
});

button.setPrefWidth(100);  
button.setPrefHeight(100);
```

**父组件的设置会影响子组件**

示例`group.setOpacity(0.5);` 


* 查询在指定位置是否有子组件左上角`System.out.println(group.contains(100,100));`
* 将group中所有节点转为数组`group.getChildren().toArray();`
  
```java
Object[] objects = group.getChildren().toArray();  
for (Object object : objects) {  
    System.out.println(object);  
}
```

> Button@5ccd78fc[styleClass=button]'btn0'  
> Button@658d9000[styleClass=button]'btn1'  
> Button@54067514[styleClass=button]'btn2'  

* 监听group中节点数量的改变
  
```java
group.getChildren().addAll(button, button1, button2);  
group.getChildren().addListener(new ListChangeListener<Node>() {  
    @Override  
    public void onChanged(Change<? extends Node> c) {  
        System.out.println(c.getList().size());  
    }  
});  
group.getChildren().remove(button);  
group.getChildren().removeAll(button1, button2);
```

> 2  
> 0