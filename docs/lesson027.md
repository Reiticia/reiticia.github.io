---
lang: zh-CN
title: MenuBar菜单栏及其子组件（续）
---


# MenuBar菜单栏及其子组件（续）

* 设置分隔线
  
    ```java
    SeparatorMenuItem separ1 = new SeparatorMenuItem();  
    SeparatorMenuItem separ2 = new SeparatorMenuItem();
    ```

* 设置菜单项子菜单
      
    ```java
    Menu M1M5 = new Menu("M1M5");  
    MenuItem M1M5I1 = new MenuItem("M1M5I1");  
    MenuItem M1M5I2 = new MenuItem("M1M5I2");  
    M1M5.getItems().addAll(M1M5I1, M1M5I2);
    ```

* 将分隔线、子菜单添加到菜单中
      
    ```java
    // 为了看出分隔线的效果，多创建了几个菜单项，创建菜单项的代码省略
    MENU1.getItems().addAll(M1I1, separ1, M1I2, separ2, M1I3, M1I4, M1M5);
    ```
      
    ![](../assets/Pasted%20image%2020220513183734.png)

* 设置单选组`ToggleGroup toggleGroup = new ToggleGroup();`

* 在单选组内设置三个单选项
  
    ```java
    // 设置三个单选项  
    RadioMenuItem radio1 = new RadioMenuItem("Radio1");  
    RadioMenuItem radio2 = new RadioMenuItem("Radio2");  
    RadioMenuItem radio3 = new RadioMenuItem("Radio3");  
    // 设置单选组  
    radio1.setToggleGroup(toggleGroup);  
    radio2.setToggleGroup(toggleGroup);  
    radio3.setToggleGroup(toggleGroup);  
    // 设置单选项2默认勾选  
    radio2.setSelected(true);
    ```

* 将单选组中的单选项添加到菜单中
      
    ```java
    MENU2.getItems().addAll(radio1, radio2, radio3);
    ```
      
    ![](../assets/Pasted%20image%2020220513183801.png)

* 创建4个复选项
  
    ```java
    CheckMenuItem check1 = new CheckMenuItem("Check1");  
    CheckMenuItem check2 = new CheckMenuItem("Check2");  
    CheckMenuItem check3 = new CheckMenuItem("Check3");  
    CheckMenuItem check4 = new CheckMenuItem("Check4");
    ```

* 将复选项添加到菜单中
      
    ```java
    MENU3.getItems().addAll(check1, check2, check3, check4);
    ```
      
    ![](../assets/Pasted%20image%2020220513183938.png)

* 设置菜单禁用`MENU4.setDisable(true);`
    
    ![](../assets/Pasted%20image%2020220513184107.png)