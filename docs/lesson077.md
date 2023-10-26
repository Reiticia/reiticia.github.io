---
lang: zh-CN
title: 鼠标事件（传递和冒泡）
---

# 鼠标事件（传递和冒泡）

==自定义的事件响应方法比内置的事件响应方法优先执行==

1. 自定义鼠标事件处理器
  
   ```java
   class MyEventHandler implements EventHandler<MouseEvent> {  
       private final ConsoleColor consoleColor;  
   
       public MyEventHandler(ConsoleColor consoleColor) {  
           this.consoleColor = consoleColor;  
       }  
   
       @Override  
       public void handle(MouseEvent event) {  
           System.out.print(consoleColor);  
           System.out.println("event.getEventType() = " + event.getEventType());  
           System.out.println("event.getSource() = " + event.getSource());  
           System.out.println("event.getTarget() = " + event.getTarget());  
           System.out.print(ConsoleColor.RESET);  
       }  
   }
   ```

2. 为每一个组件创建事件处理器
  
   ```java
   MyEventHandler hBoxHandler = new MyEventHandler(ConsoleColor.YELLOW);  
   MyEventHandler anchorPaneHandler = new MyEventHandler(ConsoleColor.RED);  
   MyEventHandler sceneHandler = new MyEventHandler(ConsoleColor.GREEN);  
   MyEventHandler stageHandler = new MyEventHandler(ConsoleColor.CYAN);
   ```
   
## 事件传递

**调用顺序：父组件->子组件**

* 事件处理（传递）`hBox.addEventFilter(MouseEvent.MOUSE_CLICKED, hBoxHandler);`

* 阻止事件传递`event.consume();`
  
## 事件冒泡

**调用顺序：子组件->父组件**

* 事件处理（冒泡）`hBox.addEventHandler(MouseEvent.MOUSE_CLICKED, hBoxHandler);`

* 阻止事件冒泡`event.consume();`

**button本身无法进行事件冒泡，要实现事件冒泡需要手动调用事件**`Event.fireEvent(hBox, event);`