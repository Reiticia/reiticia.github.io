---
lang: zh-CN
title: GridPane网格布局
---


# GridPane网格布局

* 创建网格布局
  
    ```java
    Button[] buttons = new Button[8];  
    for (int i = 0; i < buttons.length; i++) {  
        buttons[i] = new Button("Button " + i);  
    }  
    // 创建网格布局  
    GridPane gridPane = new GridPane();  
    gridPane.setStyle("-fx-background-color: #336699;");  
    // 设置按钮在布局中的位置，第一个参数表示行，第二个参数表示列  
    gridPane.add(buttons[0], 0, 0);  
    gridPane.add(buttons[1], 1, 0);  
    gridPane.add(buttons[2], 0, 1);  
    gridPane.add(buttons[3], 1, 1);  
    gridPane.add(buttons[4], 0, 2);  
    gridPane.add(buttons[5], 1, 2);  
    gridPane.add(buttons[6], 0, 3);  
    gridPane.add(buttons[7], 1, 3);
    ```

* 设置组件间水平间距`gridPane.setHgap(10.0);`

* 设置组件间垂直边距`gridPane.setVgap(10.0);`

* 设置内边距`gridPane.setPadding(new Insets(10.0));`

* 设置第一个按钮的外边距`GridPane.setMargin(buttons[0], new Insets(10.0));`

* 设置对齐方式：水平居中、垂直居中`gridPane.setAlignment(Pos.CENTER);`

* 设置组件位置`GridPane.setConstraints(buttons[0], 0, 0);`

* 添加组件`gridPane.getChildren().add(buttons[0]);`

* 设置第一列的宽度为100`gridPane.getColumnConstraints().add(new ColumnConstraints(100));`

* 设置第一行的高度为100`gridPane.getRowConstraints().add(new RowConstraints(100));`