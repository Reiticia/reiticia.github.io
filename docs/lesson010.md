---
lang: zh-CN
title: Button按钮事件触发
---


# Button按钮事件触发

* 鼠标点击事件
  
    ```java
    button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {  
        @Override  
        public void handle(MouseEvent event) {  
            System.out.println("鼠标单击事件");  
            // 判断鼠标点击次数
            if (event.getClickCount()==2){  
                System.out.println("鼠标双击事件");  
            }  
        }  
    });
    ```

* 获取鼠标按键`event.getButton().name();`

* 判断鼠标按键`event.getButton().equals(MouseButton.PRIMARY`

* 键盘事件
  
    ```java
    // 键盘按下事件，如果按下键盘不松开，则会一直触发事件
    button.setOnKeyPressed(new EventHandler<KeyEvent>() {  
        @Override  
        public void handle(KeyEvent event) {  
            System.out.println("按下：" + event.getCode().name()); 
            // 判断按下的按钮（ENTER）
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
    ```