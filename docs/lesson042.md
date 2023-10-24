### ChoiceBox和ComboBox修改下拉列表项

添加通用属性和控件，布局配置内容省略

```java
TextField textField = new TextField();  
textField.setPrefWidth(100);  
Button button = new Button("点击修改分数");  
// 创建5个学生  
Student student1 = new Student("张三", 79.0, "语文");  
Student student2 = new Student("李四", 89.0, "语文");  
Student student3 = new Student("王五", 69.0, "语文");  
Student student4 = new Student("赵六", 80.0, "语文");  
Student student5 = new Student("钱七", 50.0, "语文");
```

#### ChoiceBox用法

1. 初始化和展示数据
  
   ```java
   choiceBox.getItems().addAll(student1, student2, student3, student4, student5);  
   choiceBox.setConverter(new StringConverter<Student>() {  
       @Override  
       public String toString(Student object) {  
           if (object == null) {  
               return "";  
           }  
           System.out.println("toString");  
           return object.getName() + "-" + object.getSubject() + "-" + object.getScore();  
       }  
       @Override  
       public Student fromString(String string) {  
           return null;  
       }  
   });
   ```

2. 修改按钮点击事件
  
   ```java
   // 先移除元素，再把元素添加回去，使所有列表项重新加载（性能消耗高）
   button.setOnAction(event -> {  
       String newScore = textField.getText();  
       Student student = choiceBox.getValue();  
       student.setScore(Double.parseDouble(newScore));  
       // 获取当前选中项的索引  
       int index = choiceBox.getItems().indexOf(student);  
       // 移除  
       choiceBox.getItems().remove(index);  
       // 再添加  
       choiceBox.getItems().add(index, student);  
   });
   ```
   
   ![](../assets/Pasted%20image%2020220519191824.png)
   
   > toString  
   > toString  
   > toString  
   > toString  
   > toString
   
3. 初始化和展示数据
  
   ```java
   ComboBox<Student> comboBox = new ComboBox<>();  
   comboBox.setPrefWidth(200);  
   comboBox.getItems().addAll(student1, student2, student3, student4, student5);  
   comboBox.setConverter(new StringConverter<Student>() {  
       @Override  
       public String toString(Student object) {  
           if (object == null) {  
               return "";  
           }  
           System.out.println("toString");  
           String s = object.getName() + "-" + object.getSubject() + "-" + object.getScore();  
           return s;  
       }  
       @Override  
       public Student fromString(String string) {  
           return null;  
       }  
   });
   ```

4. 修改按钮点击事件
  
   ```java
   // 替换原来位置的数据，使单条列表项重新加载（性能消耗低）
   button.setOnAction(event -> {  
       String newScore = textField.getText();  
       // 获取选中对象值  
       Student student = comboBox.getSelectionModel().getSelectedItem();  
       // 修改分数  
       student.setScore(Double.parseDouble(newScore));  
       // 替换选中项  
       comboBox.getItems().set(comboBox.getSelectionModel().getSelectedIndex(), student);  
   });
   ```

   ![](../assets/Pasted%20image%2020220519192103.png)
   
   > toString  
   > toString