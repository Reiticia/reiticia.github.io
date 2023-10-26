---
lang: zh-CN
title: 键盘事件
---


# 键盘事件

## 键盘按下事件（如果按下按键不放，则会多次触发监听）

```java
button1.setOnKeyPressed(new EventHandler<KeyEvent>() {  
    @Override  
    public void handle(KeyEvent event) {  
        System.out.println("event.getCharacter() = " + event.getCharacter());  
        // 事件类型  
        System.out.println("event.getEventType() = " + event.getEventType());  
        // 事件源  
        System.out.println("event.getSource() = " + event.getSource());  
        // 事件目标  
        System.out.println("event.getTarget() = " + event.getTarget());  
        // 获得按下的按键名称  
        System.out.println("event.getText() = " + event.getText());  
        System.out.println("event.isControlDown() = " + event.isControlDown());  
        // 判断按下的按键  
        if (event.getCode() == KeyCode.SPACE) {  
            if (iTime.get() <= 100) {  
                iTime.set(iTime.get() + 1);  
            }  
            if (dTime.get() <= 1) {  
                dTime.set(dTime.get() + 0.01);  
            }  
        }  
        System.out.println("按下了" + event.getCode().getName());  
    }  
});
```

## 松开按键事件

```java
button1.setOnKeyReleased(new EventHandler<KeyEvent>() {  
    @Override  
    public void handle(KeyEvent event) {  
        System.out.println("释放了" + event.getCode().getName());  
        if (event.getCode() == KeyCode.SPACE) {  
            iTime.set(0);  
            dTime.set(0);  
        }  
    }  
});
```

## 作用于有输入焦点的组件的监听器

```java
textField.setOnKeyTyped(new EventHandler<KeyEvent>() {  
    @Override  
    public void handle(KeyEvent event) {  
        System.out.println("event.getCharacter() = " + event.getCharacter());  
    }  
});
```
