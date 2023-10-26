---
lang: zh-CN
title: 绑定计算
---


# 绑定计算

初始化两个监视属性

```java
SimpleIntegerProperty a = new SimpleIntegerProperty(1);  
SimpleIntegerProperty b = new SimpleIntegerProperty(2);
```

* 加法`IntegerBinding aAdd6 = a.add(6);`

* 减法、乘法、除法
  
    ```java
    System.out.println("a.subtract(1).get() = " + a.subtract(2).get());  
    System.out.println("a.multiply(2.0).get() = " + a.multiply(2.0).get());  
    System.out.println("a.divide(2.0).get() = " + a.divide(2.0).get());
    ```
    
    > aAdd6.get() = 7  
    > false  
    > 3  
    > a.subtract(1).get() = -1  
    > a.multiply(2.0).get() = 2.0  
    > a.divide(2.0).get() = 0.5

* 修改a的值，获取aAdd6
  
    ```java
    a.set(10);  
    // 计算的变量发生改变，则结果也会跟着改变  
    System.out.println("aAdd6.get() = " + aAdd6.get());
    ```
    
    > aAdd6.get() = 16

* 绑定计算属性操作
  
    ```java
    SimpleIntegerProperty x = new SimpleIntegerProperty(6);  
    System.out.println("x.negate().get() = " + x.negate().get()); // 取相反数  
    SimpleBooleanProperty flag = new SimpleBooleanProperty(false);  
    System.out.println("flag.not().get() = " + flag.not().get()); // 取非
    ```
    
    > x.negate().get() = -6  
    > flag.not().get() = true

## 案例：通过输入框数字控制按钮相对于界面的大小

```java
// 省略创建组件代码
SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(2);  
textField.textProperty().addListener(((observable, oldValue, newValue) -> {  
    Tooltip tooltip = new Tooltip();  
    if (newValue.equals("")) {  
        tooltip.setText("输入不能为空");  
        textField.setTooltip(tooltip);  
        return;  
    }  
    if (newValue.equals("0")){  
        tooltip.setText("输入不能为0");  
        textField.setTooltip(tooltip);  
        return;  
    }  
    // 限制输入  
    if (!newValue.matches("[0-9]*")) {  
        textField.setText(oldValue);  
        newValue = oldValue;  
    }  
    // 卸载提示  
    Tooltip.uninstall(textField,tooltip);  
    int value = Integer.parseInt(newValue);  
    integerProperty.set(value);  
}));  
// 绑定界面大小的一半  
DoubleBinding divide = anchorPane.widthProperty().divide(integerProperty);  
button.prefWidthProperty().bind(divide);  
DoubleBinding divide1 = anchorPane.heightProperty().divide(integerProperty);  
button.prefHeightProperty().bind(divide1);
```

![](../assets/VeryCapture_20220523122632.gif)