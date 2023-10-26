---
lang: zh-CN
title: TextField、TextArea
---


# TextField、TextArea

## TextField单行文本

* 监听事件
  
    ```java
    textField.setTextFormatter(new TextFormatter<String>(change -> {  
        System.out.println(change.getText());  
        // 限制用户单次输入的字符类型为小写字母  
        if (change.getText().matches("[a-z]*")) {  
            return change;  
        }  
        return null;  
    }));
    ```
    
    ![](../assets/Pasted%20image%2020220516192248.png)

## TextArea单行文本

* 监听事件
      
    ```java
    // 文本框文本内容变更监听事件
    textArea.textProperty().addListener((observable, oldValue, newValue) -> {  
        // 监听输入的文字内容，对输入的内容进行操作  
        textArea.setTextFormatter(new TextFormatter<>(new StringConverter<String>() {  
            @Override  
            public String toString(String object) {  
                if (object == null) {  
                    return "";  
                }  
                System.out.println(Color.RED+"toString = " + object);  
                System.out.println(Color.RED+"==================");  
                return object;  
            }  
            @Override  
            public String fromString(String string) {  
                System.out.println(Color.BLUE+"fromString = " + string);  
                System.out.println(Color.BLUE+"==================");  
                // 当检测到输入的字符串中含有"5"时，将其替换成"五"，返回给界面进行显示  
                if (string.contains("5")) {  
                    return string.replace("5", "五");  
                }  
                return string;  
            }  
        }));  
        textArea.commitValue();  
    });
    ```
    
    ![](../assets/Pasted%20image%2020220516192342.png)