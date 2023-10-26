---
lang: zh-CN
title: TabPane、Tab
---


# TabPane、Tab

* 创建标签栏并添加3个标签
  
    ```java
    TabPane tabPane = new TabPane();
    // 宽度不够时，会变成下拉菜单
    tabPane.setPrefSize(300, 300);  
    // 省略每个标签中常规设置和添加组件的具体代码
    Tab tab1 = new Tab("tab1");  
    Tab tab2 = new Tab("tab2");  
    Tab tab3 = new Tab("tab3");
    tabPane.getTabs().addAll(tab1, tab2, tab3);
    ```
    
    ![](../assets/Pasted%20image%2020220515084512.png)

* 默认选中第二个tab`tabPane.getSelectionModel().select(tab2);`

* 设置tab方向`tabPane.setSide(Side.RIGHT);`

* 设置标签图标是否跟随标签方向旋转`tabPane.setRotateGraphic(false);`

* 设置tab不可关闭`tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);`

* 标签栏中当前标签改变时监听器
  
    ```java
    tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue.getText()));
    ```

* tab1选择改变监听器（展开，收起）
      
    ```java
    tab1.setOnSelectionChanged(event -> System.out.println("tab1 selected status：" + tab1.isSelected()));
    ```

* tab1标签关闭后触发事件
      
    ```java
    tab1.setOnClosed(event-> tabPane.getTabs().add(new Tab("tab" + i.getAndIncrement())));
    ```

* tab1标签开始关闭时触发事件
      
    ```java
    tab1.setOnCloseRequest(event->{  
        tabPane.getTabs().add(new Tab("tab" + i.getAndIncrement()));  
        // 阻止事件传递给关闭后事件，会导致tab关闭失败  
        event.consume();  
    });
    ```