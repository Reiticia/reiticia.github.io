---
lang: zh-CN
title: 通过clone（方法实现对象拷贝）
---


# 通过clone（方法实现对象拷贝）

1. 实现可克隆接口
  
   ```java
   public class MyButton extends Button implements Cloneable {  
   
       public MyButton() {  
           super();  
       }  
   
       public MyButton(String text) {  
           super(text);  
       }  
   
       public MyButton(String text, Node graphic) {  
           super(text, graphic);  
       }  
   
       @Override  
       public MyButton clone() throws CloneNotSupportedException {  
           return (MyButton) super.clone();  
       }  
   }
   ```

2. 创建组件`MyButton button = new MyButton("button")`

3. 克隆组件
   **浅拷贝，只复制对象，但对于对象内的属性，拷贝的对象会持有原对象属性的引用  即当拷贝对象中的属性发生变化是，原对象对应属性也会改变**
   
   ```java
   MyButton node = button.clone()
   ```