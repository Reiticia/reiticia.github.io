---
lang: zh-CN
title: 监听
---


# 监听

## 数据更改监听

* 匿名类写法
  
    ```java
    sip.addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
            System.out.println("数据更改监听");  
        }  
    });
    ```

* 使用自定义类监听
  
  1. 自定义类实现ChangeListener
    
     ```java
     class Change implements ChangeListener<Number> {  
     
         @Override  
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
             System.out.println("数据更改监听");  
         }  
     }
     ```
  
  2. 使用自定义监听器类
    
     ```java
     Change change = new Change();
     // 添加监听器
     sip.addListener(change);
     // 若干操作
     // 移除监听器
     sip.removeListener(change);
     ```

* 使用弱引用则无需手动移除监听器
  
    ```java
    Change change = new Change();  
    WeakChangeListener<Number> listener = new WeakChangeListener<>(change);  
    sip.addListener(listener);
    ```

## 失效监听

特点是：**如果不绑定数据更改监听事件，则当数据进行多次更改而未被读取时，只会调用一次延时监听事件，可以提升效率**

* 匿名类写法
  
    ```java
    sip.addListener(new InvalidationListener() {  
        @Override  
        public void invalidated(Observable observable) {  
            System.out.println("延时监听");  
        }  
    });
    ```

* 使用自定义类监听
  
  1. 自定义类实现InvalidationListener
    
     ```java
     class Inva implements InvalidationListener {  
         @Override  
         public void invalidated(Observable observable) {  
             System.out.println("失效监听");  
         }  
     }
     ```
  
  2. 使用自定义监听器类
    
     ```java
     Inva inva = new Inva();
     // 添加监听器
     sip.addListener(inva);
     // 若干操作
     // 移除监听器
     sip.removeListener(inva);
     ```