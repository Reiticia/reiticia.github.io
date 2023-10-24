### ComboBox实现模糊搜索

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

2. 初始化下拉列表和填充数据
  
    ```java
    Student student1 = new Student("张三", 78, "语文");  
    Student student2 = new Student("李四", 69, "数学");  
    Student student3 = new Student("王五", 70, "英语");  
    Student student4 = new Student("赵六", 49, "物理");  
    Student student5 = new Student("钱七", 80, "化学");  
    Student student6 = new Student("孙八", 99, "生物");  
    Student student7 = new Student("周九", 59, "政治");  
    Student student8 = new Student("吴十", 10, "历史");  
    Student student9 = new Student("郑十一", 20, "地理");  
    Student student10 = new Student("王十二", 30, "技术");  
    ComboBox<Student> comboBox = new ComboBox<>();  
    comboBox.getItems().addAll(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);
    ```

3. 其他设置
  
    ```java
    // 设置可编辑（相较于ChoiceBox的特点）  
    comboBox.setEditable(true);
    // 设置占位符
    comboBox.setPlaceholder(new Label("无学生"));
    ```

4. 保存原数据
  
    ```java
    ObservableList<Student> originalItems = comboBox.getItems();
    ```

5. 数据展示处理
  
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
            return null;  
        }  
    });
    ```

6. 获取单行文本框的文本监听
  
    ```java
    comboBox.editorProperty().get().textProperty().addListener((observable, oldValue, newValue) -> {  
        if (newValue == null || newValue.isEmpty()|| originalItems.contains(comboBox.getValue())) {  
            comboBox.setItems(originalItems);  
            comboBox.setPlaceholder(new Label("无学生"));  
            return;  
        }  
        // 取出符合条件的学生装进列表
        FilteredList<Student> newList = originalItems.filtered(student -> student.getName().contains(newValue));  
        if (newList.isEmpty()) {  
            comboBox.setItems(null);  
            comboBox.setPlaceholder(new Label("无学生"));  
        } else {  
            comboBox.setItems(newList);  
            comboBox.hide();  
            comboBox.show();  
        }  
    });
    ```

7. 添加控件到布局中，调整位置，添加布局到场景，添加场景到舞台，调整舞台设置（省略）

![](../assets/Pasted%20image%2020220518225412.png)