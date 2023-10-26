---
lang: zh-CN
title: TextArea多行文本
---


# TextArea多行文本

* 创建多行文本`TextArea textArea = new TextArea();`

* 设置允许自动换行`textArea.setWrapText(true);`

* 设置初始几行几列
      
    ```java
    textArea.setPrefRowCount(5);  
    textArea.setPrefColumnCount(5);
    ```

* 设置宽高**会导致设置初始几行几列无效**
      
    ```java
    textArea.setPrefWidth(600);  
    textArea.setPrefHeight(300);
    ```

* 添加文本`textArea.appendText("Hello World!\n");`

* 删除索引从6开始到索引11（不包含）的字符`textArea.deleteText(6,11);`

* 替换文本`textArea.replaceText(6,11,"JavaFx");`

* 选中全部文本`textArea.selectAll();`

* 选择光标后面一个字符`textArea.selectForward();`

* 选中从索引为4的位置到光标位置的字符`textArea.selectPositionCaret(4);`

* 获取文本长度`int length = textArea.getLength();`

* 设置不可编辑`textArea.setEditable(false);`

* 清空`textArea.clear();`

* 文本变化监听事件
  
    ```java
    textArea.textProperty().addListener((observable, oldValue, newValue) -> {  
        if (newValue.length() > 10) {  
            textArea.setText(oldValue);  
            return;  
        }  
        label.setText(newValue);  
    });
    ```

* 选择的文本发生变化监听事件
  
    ```java
    textArea.selectedTextProperty().addListener((observable, oldValue, newValue) -> {  
        System.out.println(newValue);  
    });
    ```

* 左右滚动监听事件
      
    ```java
    textArea.scrollLeftProperty().addListener((observable, oldValue, newValue) -> {  
        System.out.println(newValue);  
    });
    ```
    
    ![](../assets/Pasted%20image%2020220515135914.png)