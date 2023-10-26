---
lang: zh-CN
title: fxml使用CSS
---

# fxml使用CSS

## 第一种方式（在Java代码中设置样式）

```java
root.setStyle("-fx-background-color: linear-gradient(to bottom right, yellow, black);" +  
        "-fx-border-color: green;-fx-border-width: 10,20,30,40;");
```

## 第二种方式（在fxml文件中设置样式）

* 直接在标签中定义style属性
  
  ```xml
  <TextField text="fxml textField" prefWidth="100" style="-fx-text-fill: blue"/>
  ```
  
* 在标签内部创建style标签，在style标签中添加内容
  
  ```xml
  <VBox>  
      <style>  
          -fx-background-color:#BFEFFF;  
          -fx-border-color:#CD0000;  
          -fx-border-width:10 5 0 20;  
      </style>  
      ...
  </VBox>
  ```
  
## 第三种方式（引入外部css文件）

1. 为fxml引入css
  
   ```java
   scene.getStylesheets().add(Objects.requireNonNull(Main.class.getClassLoader().getResource("css/samplecss.css")).toExternalForm());
   ```
   
2. 创建css文件
* 使用id选择器（fxml文件中组件必须定义id属性或者fx:id属性）
  
  ```css
  /*id选择器*/  
  #root {  
      -fx-background-color: linear-gradient(from 0.0% 0.0% to 100.0% 0.0%, #23d0f3ff 0.0%, #d791f9ff 50.0%, #fe7b84ff 100.0%); 
  }
  ```
  
* 使用标签选择器
  
  ```css
  /*标签选择器*/
  Button{  
      -fx-background-color: black;  
  }
  ```
  
* 使用。类选择器（即将对应的标签名替换为小写，用-分隔每个单词的写法）
  
  ```css
  /*类选择器*/  
  .label {  
      -fx-font-family: "Adobe Devanagari";  
      -fx-font-size: 30;  
      -fx-text-fill: linear-gradient(from 0.0% 0.0% to 100.0% 0.0%, #8139b5ff 0.0%, #fd1e1cff 50.0%, #fbaf46ff 100.0%);  
  }
  ```
  
* 伪类选择器（伪类选择器中定义的对象名称往往是自定义名称，必须在需要设置该样式的组件上添加styleClass属性）
  
  ```css
  /*伪类选择器*/  
  .mycss {  
      -fx-background-color: #ffcc99;  
  }
  ```