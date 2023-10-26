---
lang: zh-CN
title: ChoiceBox下拉列表修改列表中的属性
---


# ChoiceBox下拉列表修改列表中的属性

**通用初始值设置、渲染和布局调整**

   ```java
   TextField textField=new TextField();
   textField.setPrefWidth(200);
   Button button=new Button("changeName");
   ChoiceBox<Student> choiceBox=new ChoiceBox<>();
   Student student1=new Student("张三",90,"数学");
   Student student2=new Student("李四",87,"英语");
   Student student3=new Student("王五",93,"美术");
   choiceBox.getItems().addAll(student1,student2,student3);// 添加选项  
   choiceBox.setPrefWidth(200);
   choiceBox.setConverter(new StringConverter<Student>(){
       @Override
       public String toString(Student object){
           String value=object.getName()+":"+object.getScore()+":"+object.getSubject();
           return value;
       }
       @Override
       public Student fromString(String string){
           System.out.println("fromString:"+string);
           return null;
       }
   });
   anchorPane.getChildren().addAll(textField,button,choiceBox);
   AnchorPane.setTopAnchor(textField,10.0);
   AnchorPane.setTopAnchor(button,10.0);
   AnchorPane.setLeftAnchor(textField,10.0);
   AnchorPane.setLeftAnchor(button,250.0);
   AnchorPane.setTopAnchor(choiceBox,50.0);
   AnchorPane.setLeftAnchor(choiceBox,10.0);
   ```
   
   ![](../assets/Pasted%20image%2020220518151421.png)

## 第一种方式

1. 实体类
   
   ```java
   class Student {
       private String name;
       private double score;
       private String subject;
   
       public Student(String name, double score, String subject) {
           this.name = name;
           this.score = score;
           this.subject = subject;
       }
   
       public Student() {
       }
   
       public String getName() {
           return name;
       }
   
       public void setName(String name) {
           this.name = name;
       }
   
       public double getScore() {
           return score;
       }
   
       public void setScore(double score) {
           this.score = score;
       }
   
       public String getSubject() {
           return subject;
       }
   
       public void setSubject(String subject) {
           this.subject = subject;
       }
   }
   ```

2. 按钮点击事件
   
   ```java
   button.setOnAction(event->{
       String newName=textField.getText();
       if(newName.equals("")){
           return;
       }
       Student student=choiceBox.getValue();
       // 获得选中栏的索引  
       int i=choiceBox.getItems().indexOf(student);
       // 移除  
       choiceBox.getItems().remove(student);
       // 修改  
       student.setName(newName);
       // 添加回去  
       choiceBox.getItems().add(i,student);
   });
   ```

效果图
![](../assets/Pasted%20image%2020220518151616.png)

## 第二种方式

1. 实体类

   ```java
   class Student {  
       // 使用监听属性对基本数据类型进行包装
       private SimpleStringProperty name = new SimpleStringProperty();  
       private SimpleDoubleProperty score = new SimpleDoubleProperty();  
       private SimpleStringProperty subject = new SimpleStringProperty();  
   
       public Student(String name, double score, String subject) {  
           this.name.setValue(name);  
           this.score.setValue(score);  
           this.subject.setValue(subject);  
       }  
   
       public Student() {  
       }  
   
       public String getName() {  
           return name.getValue();  
       }  
   
       public void setName(String name) {  
           this.name.setValue(name);  
       }  
   
       public double getScore() {  
           return score.getValue();  
       }  
   
       public void setScore(double score) {  
           this.score.setValue(score);  
       }  
   
       public String getSubject() {  
           return subject.getValue();  
       }  
   
       public void setSubject(String subject) {  
           this.subject.setValue(subject);  
       }  
   
       public SimpleStringProperty getNameSimpleStringProperty(){  
           return name;  
       }  
   }
   ```

2. 按钮点击事件

   ```java
   button.setOnAction(event -> {  
       String newName = textField.getText();  
       if (newName.equals("")) {  
           return;  
       }  
       Student student = choiceBox.getValue();  
       student.setName(newName);
   });
   ```

3. 属性变化监听事件

   ```java
   choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
       newValue.getNameSimpleStringProperty().addListener((observable1, oldValue1, newValue1) -> {  
           int index = choiceBox.getItems().indexOf(newValue);  
           choiceBox.getItems().remove(newValue);  
           choiceBox.getItems().add(index,newValue);  
       });  
   });
   ```

效果图
![](../assets/Pasted%20image%2020220518154557.png)