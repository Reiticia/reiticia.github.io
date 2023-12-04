---
lang: zh-CN
title: 鼠标事件（拖拽）
---


# 鼠标事件（拖拽）

## 鼠标拖拽

> 在button1上点击(左中右键)后进行拖拽，拖拽区域没有限制

```java
button1.setOnMouseDragged(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        // System.out.println("鼠标拖拽，次数：" + (++dragTime));  
    }  
});
```

## 鼠标拖拽（当鼠标指针移除组件时，事件不会被触发）

```java
button1.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {  
    @Override  
    public void handle(MouseDragEvent event) {  
        // System.out.println("在组件内拖动，次数：" + (++dragTime) );  
    }  
});
```

## 拖拽检测（每次按下鼠标按键进行拖动，会触发事件，直到松开按键重新按下才会重新监听）

```java
button1.setOnDragDetected(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        // 设置全套拖拽动作，以触发组件内鼠标拖拽事件、鼠标拖拽进入、鼠标拖拽退出、鼠标拖拽释放事件  
        button1.startFullDrag();  
        System.out.println("拖拽检测，次数：" + (++dragTime));  
    }  
});
```

## 拖拽进入

```java
button1.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {  
    @Override  
    public void handle(MouseDragEvent event) {  
        System.out.println("拖拽进入");  
    }  
});
```

## 拖拽退出

```java
button1.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {  
    @Override  
    public void handle(MouseDragEvent event) {  
        System.out.println("拖拽退出");  
    }  
});
```

## 拖拽释放

```java
button1.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {  
    @Override  
    public void handle(MouseDragEvent event) {  
        System.out.println("拖拽释放");  
    }  
});
```

**证明：在button1上开始拖拽，一直拖拽到button2上，依此触发button1拖拽进入->button1拖拽退出->button2拖拽进入，但只给button1设置了完整拖拽动作**

```java
button2.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {  
    @Override  
    public void handle(MouseDragEvent event) {  
        System.out.println("拖拽进入Button2");  
        // System.out.println("event.getSource() = " + event.getSource());  
        // System.out.println("event.getTarget() = " + event.getTarget());  
    }  
});
```

## 获取事件对象

```java
// 鼠标在button1上按下按键，拖拽至button2上
button2.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {  
    @Override  
    public void handle(MouseDragEvent event) {  
        // 手势源  
        System.out.println("event.getGestureSource() = " + event.getGestureSource());  
        System.out.println("event.getSource() = " + event.getSource());  
        System.out.println("event.getTarget() = " + event.getTarget());  
    }  
});
```

> event.getGestureSource() = Button@45bb3769[styleClass=button]'button1'  
> event.getSource() = Button@65eadf18[styleClass=button]'button2'  
> event.getTarget() = Text[text="button2", x=0.0, y=0.0, alignment=LEFT, origin=BASELINE, boundsType=LOGICAL_VERTICAL_CENTER, font=Font[name=System Regular, family=System, style=Regular, size=15.0], fontSmoothingType=LCD, fill=0x333333ff]