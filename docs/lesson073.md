### 鼠标事件（点击）

#### 鼠标点击事件

```java
button1.setOnMouseClicked(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        // 获取相对于场景的鼠标指针坐标  
        System.out.println("event.getSceneX() = " + event.getSceneX());  
        System.out.println("event.getSceneX() = " + event.getSceneX());  
        // 获取相对于整个屏幕的鼠标指针坐标  
        System.out.println("event.getScreenX() = " + event.getScreenX());  
        System.out.println("event.getScreenY() = " + event.getScreenY());  
        // 获取相对于该组件内部的鼠标指针坐标  
        System.out.println("event.getX() = " + event.getX());  
        System.out.println("event.getY() = " + event.getY());  
        // 事件源（事件发起者）  
        System.out.println("event.getSource() = " + event.getSource());  
        // 事件目标（点击的区域，一般是事件源或者事件源内部的组件）  
        System.out.println("event.getTarget() = " + event.getTarget());  
        // 事件类型  
        System.out.println("event.getEventType() = " + event.getEventType());  
        // 获取点击的按键  
        System.out.println("event.getButton() = " + event.getButton());  
        // 是否按下CTRL  
        System.out.println("event.isControlDown() = " + event.isControlDown());  
        // 连续点击次数  
        System.out.println("event.getClickCount() = " + event.getClickCount());  
        // 鼠标右键是否按下（先长按鼠标右键，然后同时单击鼠标左键，打印true）  
        System.out.println("鼠标右键是否按下 = " + event.isSecondaryButtonDown());  
        if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {  
            System.out.println("双击鼠标左键");  
        }  
    }  
});
```

#### 鼠标按下

```java
button1.setOnMousePressed(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        System.out.println("鼠标按下");  
    }  
});
```

#### 鼠标释放

```java
button1.setOnMouseReleased(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        System.out.println("鼠标释放");  
    }  
});
```

#### 鼠标进入

```java
button1.setOnMouseEntered(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        System.out.println("event.getX() = " + event.getX());  
        System.out.println("event.getY() = " + event.getY());  
        System.out.println("鼠标进入");  
    }  
});
```

#### 鼠标退出

```java
button1.setOnMouseExited(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        System.out.println("鼠标退出");  
    }  
});
```

#### 鼠标移动

```java
button2.setOnMouseMoved(new EventHandler<MouseEvent>() {  
    @Override  
    public void handle(MouseEvent event) {  
        System.out.println("鼠标移动");  
    }  
});
```