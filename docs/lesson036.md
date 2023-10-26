---
lang: zh-CN
title: ChoiceBox下拉列表
---


# ChoiceBox下拉列表

* 创建下拉列表
  
    ```java
    ChoiceBox<Student> choiceBox = new ChoiceBox<>();  
    Student student1 = new Student("张三", 90, "数学");  
    Student student2 = new Student("李四", 87, "英语");  
    Student student3 = new Student("王五", 93, "美术");  
    choiceBox.getItems().addAll(student1, student2, student3);// 添加选项
    ```

* 设置显示的内容
  
    ```java
    choiceBox.setConverter(new StringConverter<Student>() {  
        @Override  
        public String toString(Student object) {  
            String value = object.getName() + ":" + object.getScore() + ":" + object.getSubject();  
            return value;  
        }  
        @Override  
        public Student fromString(String string) {  
            System.out.println("fromString:" + string);  
            return null;  
        }  
    });
    ```

* 设置默认选中`item1`项`choiceBox.setValue("item1");`

* 默认选中最后一个`choiceBox.getSelectionModel().selectLast();`

* 选中上一个`choiceBox.getSelectionModel().selectPrevious();`

* 选择改变监听事件
  
    ```java
    choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
        System.out.println("newValue.getName() = " + newValue.getName());  
        System.out.println("newValue.getSubject() = " + newValue.getSubject());  
        System.out.println("newValue.getScore() = " + newValue.getScore());  
    });
    ```
      
    ![](../assets/Pasted%20image%2020220517231619.png)

## 案例
  
设置两个ChoiceBox下拉列表，第二个下拉列表的数据根据第一个下拉列表选中项而改变，并且设置一个按钮继续降序排列


1. 创建三个可观察列表
       
    ```java
    ObservableList<String> list = FXCollections.observableArrayList("number", "character");  
    ObservableList<Character> list1 = FXCollections.observableArrayList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');  
    ObservableList<Character> list2 = FXCollections.observableArrayList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    ```

2. 创建两个下拉列表，并设置宽度
   
    ```java
    ChoiceBox<String> choiceBox1 = new ChoiceBox<>();  
    choiceBox1.setPrefWidth(100);  
    ChoiceBox<Character> choiceBox2 = new ChoiceBox<>();  
    choiceBox2.setPrefWidth(100);
    ```

3. 为第一个下拉列表绑定数据
   
    ```java
    choiceBox1.setItems(list);
    ```

4. 通过监听第一个下拉列表选中项给第二个下拉列表绑定数据，并设置自动展示
   
    ```java
    choiceBox1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
        if (newValue.equals("number")) {  
            choiceBox2.setItems(list1);  
        } else if (newValue.equals("character")){  
            choiceBox2.setItems(list2);  
        }  
        choiceBox2.show();  
    });
    ```

5. 创建一个用于降序排序的按钮
   
    ```java
    Button button = new Button("sort");
    ```

6. 为按钮添加点击事件
   
    ```java
    button.setOnAction(event -> {  
        list1.sort((o1, o2) -> {  
            // 倒序排序  
            return o2 - o1;  
        });  
        list2.sort((o1, o2) -> {  
            // 倒序排序  
            return o2 - o1;  
        });  
    });
    ```

7. 设置控件在布局中的位置和放置控件（创建布局、场景、舞台展示代码省略）
       
    ```java
    AnchorPane.setTopAnchor(choiceBox1, 100.0);// 设置位置  
    AnchorPane.setLeftAnchor(choiceBox1, 100.0);// 设置位置  
    AnchorPane.setTopAnchor(choiceBox2, 100.0);// 设置位置  
    AnchorPane.setLeftAnchor(choiceBox2, 300.0);// 设置位置  
    anchorPane.getChildren().addAll(choiceBox1, choiceBox2,button);
    ```
       
    ![](../assets/Pasted%20image%2020220517232602.png)