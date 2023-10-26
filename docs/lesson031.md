---
lang: zh-CN
title: RadioButton、CheckBox
---


# RadioButton、CheckBox

## RadioButton单选按钮

* 创建一个单选按钮组
  
    ```java
    // 单选按钮组  
    ToggleGroup toggleGroup = new ToggleGroup();  
    // 单选按钮  
    RadioButton rb1 = new RadioButton("rb1");  
    RadioButton rb2 = new RadioButton("rb2");  
    RadioButton rb3 = new RadioButton("rb3");  
    RadioButton rb4 = new RadioButton("rb4");  
    rb1.setToggleGroup(toggleGroup);  
    rb2.setToggleGroup(toggleGroup);  
    rb3.setToggleGroup(toggleGroup);  
    rb4.setToggleGroup(toggleGroup);  
    // 或者用下面一行代替上面四行  
    // toggleGroup.getToggles().addAll(rb1, rb2, rb3, rb4);
    ```

* 设置默认选中`toggleGroup.selectToggle(rb2);`

* 监听单选按钮组的选中状态
  
    ```java
    rb1.selectedProperty().addListener((observable, oldValue, newValue) -> System.out.println("rb1.selectedProperty(): " + newValue));
    ```

* 改变选中的单选按钮监听事件
  
    ```java
    toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> System.out.println("toggleGroup.selectedToggleProperty(): " + newValue));
    ```

    ![](../assets/Pasted%20image%2020220515101347.png)

## CheckBox多选按钮

* 创建若干多选按钮
      
    ```java
    CheckBox cb1 = new CheckBox("cb1");  
    CheckBox cb2 = new CheckBox("cb2");  
    CheckBox cb3 = new CheckBox("cb3");  
    CheckBox cb4 = new CheckBox("cb4");
    ```

* 设置默认选中`cb1.setSelected(true);`

* 设置不确定状态`cb2.setIndeterminate(true);`

* 设置允许按钮有不确定状态`cb3.setAllowIndeterminate(true);`

* cb1选中状态改变监听事件
      
    ```java
    cb1.selectedProperty().addListener((observable, oldValue, newValue) -> System.out.println("cb1.selectedProperty(): " + newValue));
    ```

* 鼠标点击布局文件获取每个多选按钮状态
  
    ```java
    anchorPane.setOnMouseClicked(event -> {  
        hBox.getChildren().forEach(node -> {  
            // 打印被选中的按钮  
            if (node instanceof CheckBox) {  
                CheckBox checkBox = (CheckBox) node;  
                System.out.print(Color.RED + checkBox.getText() + " isSelected?:" + checkBox.isSelected());  
                System.out.println(Color.BLUE + " isIndeterminate?:" + checkBox.isIndeterminate());  
            }  
        });  
        System.out.println(Color.RESET + "==========================================");  
    });
    ```
    
    ![](../assets/Pasted%20image%2020220515101310.png)