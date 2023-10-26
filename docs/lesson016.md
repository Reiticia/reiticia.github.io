---
lang: zh-CN
title: BorderPane 方位布局
---


# BorderPane 方位布局

* 基本代码
  
    ```java
    // 使用top、left、right、bottom、center设置方位
    BorderPane pane = new BorderPane();  
    pane.setStyle("-fx-background-color:#1899c0;");  
    pane.setTop(anchorPane1);  
    pane.setLeft(anchorPane2);  
    pane.setRight(anchorPane3);  
    pane.setBottom(anchorPane4);  
    pane.setCenter(anchorPane5);
    ```

* 设置内边距`pane.setPadding(new Insets(10));`

* 设置某个组件的某一侧边距`BorderPane.setMargin(anchorPane1, new Insets(10));`

* 获取某一方位的组件`pane.getTop();`