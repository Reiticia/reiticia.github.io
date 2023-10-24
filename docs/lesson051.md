### Java基础属性监听器

1. 创建实体类
  
   ```java
   public class Student {  
       private String name;  
       private int age;  
       // 添加属性监听器支持
       public PropertyChangeSupport pcs = new PropertyChangeSupport(this);  
       public Student() {  
       }  
       public Student(String name, int age) {  
           this.name = name;  
           this.age = age;  
       }  
       public String getName() {  
           return name;  
       }  
       public void setName(String name) {  
           String oldValue = this.name;  
           this.name = name;  
           // 属性发生变化时，用属性监听器绑定监听属性
           pcs.firePropertyChange("setName_pro", oldValue, this.name);  
       }  
       public int getAge() {  
           return age;  
       }  
       public void setAge(int age) {  
           int oldValue = this.age;  
           this.age = age;  
           // 属性发生变化时，用属性监听器绑定监听属性
           pcs.firePropertyChange("setAge_pro", oldValue, this.age);  
       }  
       @Override  
       public String toString() {  
           return "Student{" +  
               "name='" + name + '\'' +  
               ", age=" + age +  
               '}';  
       }
   }  
   ```

2. 创建学生类并初始化`Student student = new Student("reine", 18);`

3. 创建按钮并绑定事件用于修改学生属性
  
   ```java
   Button button = new Button("修改数据");
   anchorPane.getChildren().addAll(button);
   button.setOnAction(event -> {  
       student.setName("reine2");  
       student.setAge(19);  
   });
   ```

4. 监听学生所有属性值改变
  
   ```java
   student.pcs.addPropertyChangeListener(new PropertyChangeListener() {  
       @Override  
       public void propertyChange(PropertyChangeEvent e) {  
           System.out.println(e.getPropertyName() + ": " + e.getOldValue() + " -> " + e.getNewValue());  
       }  
   });
   ```
   
   > setName_pro: reine -> reine2  
   > setAge_pro: 18 -> 19

5. 监听学生单个属性值改变
  
   ```java
   student.pcs.addPropertyChangeListener("setName_pro", new PropertyChangeListener() {  
       @Override  
       public void propertyChange(PropertyChangeEvent e) {  
           System.out.println("setName_pro: " + e.getOldValue() + " -> " + e.getNewValue());  
           System.out.println("e.getSource() = " + e.getSource());  
       }  
   });
   ```
   
   > setName_pro: reine -> reine2  
   > e.getSource() = Student{name='reine2', age=18}