---
lang: zh-CN
title: ComboBox下拉列表
---

# ComboBox下拉列表

* 创建下拉列表
  
   ```java
   ComboBox<String> comboBox = new ComboBox<>();  
   comboBox.getItems().addAll("str1","str2","str3","str4","str5");
   ```

* 设置可编辑==相较于ChoiceBox的特点==`comboBox.setEditable(true);`

* 设置提示文字`comboBox.setPromptText("请输入");`

* 设置占位符`comboBox.setPlaceholder(new Label("无元素"));`

* 设置可见行数`comboBox.setVisibleRowCount(3);`

* 选项改变监听事件
  
   ```java
   comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
       System.out.println(newValue);  
   });
   ```

* 单击事件
     
   ```java
   comboBox.setOnAction(event -> {  
       System.out.println(comboBox.getValue());  
   });
   ```

## 案例
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
    
        @Override  
        public boolean equals(Object o) {  
            if (this == o) return true;  
            if (o == null || getClass() != o.getClass()) return false;  
            Student student = (Student) o;  
            return Double.compare(student.score, score) == 0 && Objects.equals(name, student.name) && Objects.equals(subject, student.subject);  
        }  
    
        @Override  
        public int hashCode() {  
            return Objects.hash(name, score, subject);  
        }  
    }
    ```

2. 创建泛型为`Student`的下拉列表并初始化一些数据
  
    ```java
    Student student1 = new Student("张三", 78, "语文");  
    Student student2 = new Student("李四", 69, "数学");  
    Student student3 = new Student("王五", 70, "英语");  
    Student student4 = new Student("赵六", 49, "物理");  
    Student student5 = new Student("钱七", 80, "化学");  
    Student student6 = new Student("孙八", 99, "生物");  
    Student student7 = new Student("周九", 59, "政治");  
    Student student8 = new Student("吴十", 10, "历史");  
    ComboBox<Student> comboBox = new ComboBox<>();  
    comboBox.getItems().addAll(student1, student2, student3, student4, student5, student6, student7, student8);
    ```

3. 数据处理
  
    ```java
    comboBox.setConverter(new StringConverter<Student>() {  
        @Override  
        public String toString(Student object) {  
            if (object == null) {  
                return "";  
            }  
            String value = object.getName() + ":" + object.getScore() + ":" + object.getSubject();  
            return value;  
        }  
        // 在输入框中输入文本按下回车键时，调用此方法  
        @Override  
        public Student fromString(String string) {  
            // 以:分隔每一项
            String[] strings = string.split("[:]");  
            Student student = new Student(strings[0], Integer.parseInt(strings[1]), strings[2]);  
            return student;  
        }  
    });
    ```

![](../assets/Pasted%20image%2020220518173445.png)