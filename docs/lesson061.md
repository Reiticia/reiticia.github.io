---
lang: zh-CN
title: 绑定 集合的valueAt()方法
---


# 绑定 集合的valueAt()方法

作用：`valueAt(index)`返回指定index索引下的数据，通过该方法返回的数据可以随着原集合对应位置的数据改变而改变，即绑定到集合的对应位置

  
```java
ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");  
SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);  
// 固定索引
ObjectBinding<String> value = listProperty.valueAt(0);  
System.out.println("value.get() = " + value.get());  
listProperty.set(0, "aa");  
System.out.println("value.get() = " + value.get());  
SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(0);  
// 可观察索引
ObjectBinding<String> value1 = listProperty.valueAt(integerProperty);  
System.out.println("value1.get() = " + value1.get());  
integerProperty.set(1);  
listProperty.set(1, "bb");  
System.out.println("value1.get() = " + value1.get());
```

> value.get() = a  
> value.get() = aa  
> value1.get() = aa  
> value1.get() = bb

## 案例

修改列表中指定位置的字符串，并实时显示 
* 创建控件和数据
  
    ```java
    VBox vBox = new VBox(10);  
    HBox hBox = new HBox(10);  
    TextField tx1 = new TextField();  
    TextField tx2 = new TextField();  
    hBox.getChildren().addAll(tx1, tx2  
    VBox listData = new VBox(10);
    // 数据  
    ObservableList<String> list = FXCollections.observableArrayList("A", "B", "D", "T", "R");  
    SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
    ```

* 显示区域
  
    ```java
    // 填充标签数据  
    for (int i = 0; i < list.size(); i++) {  
        Label label = new Label();  
        label.setFont(new Font(20));  
        label.textProperty().bind(listProperty.valueAt(i));  
        listData.getChildren().add(label);  
    }
    ```

* 监听事件
  
    ```java
    tx2.textProperty().addListener((observable, oldValue, newValue) -> {  
        if (newValue.equals("")){  
            return;  
        }  
        try {  
            int i = Integer.parseInt(tx1.getText());  
            listProperty.set(i, newValue);  
            System.out.println("listProperty.get() = " + listProperty.get());  
        }catch (Exception e){  
            System.err.println("ERROR");  
        }  
    });
    ```
    
    > listProperty.get() = [A, B, a, T, R]  
    > listProperty.get() = [A, B, a'a, T, R]  
    > listProperty.get() = [A, B, aaa, T, R]  
    > listProperty.get() = [A, B, aaaa, T, R]  
    > listProperty.get() = [A, B, 阿阿阿阿, T, R]

![](../assets/VeryCapture_20220525204553.gif)