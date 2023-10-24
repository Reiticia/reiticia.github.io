### 其他监视属性的绑定判断

* 另一个构造器`SimpleIntegerProperty y = new SimpleIntegerProperty(student, "stu", 10);`

* 以下方法创建不能修改的监视属性`IntegerExpression n = SimpleIntegerProperty.integerExpression(y);`

* 强制类型转换`SimpleIntegerProperty sip = (SimpleIntegerProperty) n;`
  
  ```java
  x.set(90);
  System.out.println("n.get() = " + n.get());  
  System.out.println("((SimpleIntegerProperty) n).getBean() = " + ((SimpleIntegerProperty) n).getBean());  
  System.out.println("sip.getName().equals(y.getName()) = " + sip.getName().equals(y.getName()));
  ```
  
  > n.get() = 10
  > ((SimpleIntegerProperty) n).getBean() = Student{name='reine', age=18}
  > sip.getName().equals(y.getName()) = true

* 类型转换
  
  ```java
  ObjectProperty<Integer> objectProperty = new SimpleObjectProperty<>(2);  
  System.out.println(IntegerExpression.integerExpression(objectProperty).get());
  ```
  
  > 2

* 获取只读属性`SimpleIntegerProperty.readOnlyIntegerProperty(y);`
  
  #### 布尔类型的监视属性
  
  ```java
  SimpleBooleanProperty b1 = new SimpleBooleanProperty(true);  
  SimpleBooleanProperty b2 = new SimpleBooleanProperty(false);  
  // 与或非  
  b1.and(b2);  
  b1.or(b2);  
  b1.not();  
  b1.isEqualTo(b2);  
  b1.isNotEqualTo(b2);
  ```
  
  #### 字符串类型的监视属性

* 创建两个变量
  
  ```java
  SimpleStringProperty up = new SimpleStringProperty("ABC");  
  SimpleStringProperty low = new SimpleStringProperty("abc");
  ```

* 操作
  
  ```java
  System.out.println("up.lessThan(low).get() = " + up.lessThan(low).get());  
  System.out.println("up.concat(low).get() = " + up.concat(low).get());  
  System.out.println("up.isEqualTo(low).get() = " + up.isEqualTo(low).get());  
  System.out.println("up.isEqualToIgnoreCase(low).get() = " + up.isEqualToIgnoreCase(low).get());  
  up.set("");  
  System.out.println("up.isEmpty().get() = " + up.isEmpty().get()); // true  
  System.out.println("up.isNull().get() = " + up.isNull().get()); // false
  ```
  
  > up.lessThan(low).get() = true
  > up.concat(low).get() = ABCabc
  > up.isEqualTo(low).get() = false
  > up.isEqualToIgnoreCase(low).get() = true
  > up.isEmpty().get() = true
  > up.isNull().get() = false
  
  #### 对象类型的监视属性

* 创建属性`SimpleObjectProperty<Student> studentSimpleObjectProperty = new SimpleObjectProperty<>(student);`

* 添加属性监听器
  
  ```java
  studentSimpleObjectProperty.addListener(((observable, oldValue, newValue) -> {  
      System.out.println("oldValue = " + oldValue);  
      System.out.println("newValue = " + newValue);  
  }));
  ```

* 测试
  
  ```java
  // 触发监听器 
  studentSimpleObjectProperty.set(new Student("Jack",82));  
  // 不触发监听器 
  student.setName("Tom");  
  // 不触发监听器  
  studentSimpleObjectProperty.get().setAge(19);
  System.out.println("studentSimpleObjectProperty.isNull().get() = " + studentSimpleObjectProperty.isNull().get());
  ```
  
  > oldValue = Student{name='reine', age=18}
  > newValue = Student{name='Jack', age=82}
  > studentSimpleObjectProperty.isNull().get() = false