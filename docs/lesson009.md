---
lang: zh-CN
title: Button按钮
---


# Button按钮

* 设置文本`button.setText("btn0");`

* 设置位置
  
    ```java
    button.setLayoutX(100);  
    button.setLayoutY(100);
    ```

* 设置大小
  
    ```java
    button.setPrefWidth(100);  
    button.setPrefHeight(50);
    ```

* 设置字体`button.setFont(Font.font("sans-serif", 20));`

* 设置颜色
      
    ```java
    // 颜色，圆角、内边距
    button.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(20), new Insets(10))));
    ```

* 设置边框
  
    ```java
    // 颜色、类型（实线）、圆角、边框大小
    button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(10))));
    ```

* 设置文本颜色`button.setTextFill(Color.RED);`

* 设置CSS样式（**如果使用多条`setStyle`语句，只有最后一条语句的效果生效**）
      
    ```java
    // 背景颜色、圆角
    button.setStyle("-fx-background-color: #eeff00;-fx-background-radius: 20;");
    ```

* 设置按钮鼠标单击事件
  
    ```java
    button.setOnAction(new EventHandler<ActionEvent>() {  
        @Override  
        public void handle(ActionEvent event) {  
            Button btn = (Button) event.getSource();  
            System.out.println("btn.getText(): " + btn.getText());  
        }  
    });
    ```
