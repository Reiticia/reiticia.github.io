---
lang: zh-CN
title: MenuBar菜单栏及其子组件
---


# MenuBar菜单栏及其子组件

* 创建菜单栏`MenuBar menuBar = new MenuBar();`

* 创建菜单`Menu MENU1 = new Menu("MENU1");`

* 创建菜单项`MenuItem M1I2 = new MenuItem("M1I2");`

* 创建菜单项并添加组件（如图片）
  
    ```java
    ImageView imageView = new ImageView("images/logo.png");  
    imageView.setFitHeight(20);  
    imageView.setFitWidth(20);  
    // 创建菜单项同时设置图标  
    MenuItem M1I1 = new MenuItem("M1I1", imageView);
    ```

* 设置快捷键`M1I1.setAccelerator(KeyCombination.valueOf("Ctrl+Alt+0"));`

* 将菜单项添加到菜单中`MENU1.getItems().addAll(M1I1, M1I2, M1I3);`

* 将菜单添加到菜单栏中`menuBar.getMenus().addAll(MENU1, MENU2, MENU3, MENU4);`

* 菜单项点击事件`M1I1.setOnAction(event -> System.out.println("M1I1.setOnAction"));`

* 菜单事件

    ```java
    // 菜单隐藏完毕触发
    MENU1.setOnHidden(event -> System.out.println("MENU1.setOnHidden"));  
    // 菜单隐藏中触发
    MENU1.setOnHiding(event -> System.out.println("MENU1.setOnHiding"));  
    // 菜单展示中触发
    MENU1.setOnShowing(event -> System.out.println("MENU1.setOnShowing"));  
    // 菜单展示完毕触发
    MENU1.setOnShown(event -> System.out.println("MENU1.setOnShown"));
    ```
      
    ![](../assets/Pasted%20image%2020220513163405.png)