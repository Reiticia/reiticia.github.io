### 绑定：字符串处理、对象处理

#### concat(),format() 字符串拼接和格式化输出

```java
System.out.println("=============concat();format()==============");  
SimpleIntegerProperty value = new SimpleIntegerProperty(10);  
StringExpression sexp = Bindings.concat("value = ", value.asString(Locale.getDefault(), "%s"));  
System.out.println(sexp.get());  
StringExpression sexp1 = Bindings.format("value = %s", value);  
System.out.println(sexp1.get());  
value.set(20);  
System.out.println("==========value.set(20)==========");  
System.out.println(sexp.get());  
System.out.println(sexp1.get());
```

> value = 10  
> value = 10  
> --------value.set(20)--------  
> value = 20  
> value = 20  

#### max(),min() 最大值最小值

```java
SimpleIntegerProperty x = new SimpleIntegerProperty(1);  
SimpleIntegerProperty y = new SimpleIntegerProperty(2);  
System.out.println("Bindings.max(x,y).intValue() = " + Bindings.max(x, y).intValue());  
System.out.println("Bindings.min(x,y).intValue() = " + Bindings.min(x, y).intValue());
```

> Bindings.max(x,y).intValue() = 2  
> Bindings.min(x,y).intValue() = 1  

#### createStringBinding() 自定义字符串匹配规则

```java
StringExpression sexp2 = Bindings.createStringBinding(() -> {  
    switch (value.get()) {  
        case 10:  
            return "Ten";  
        case 20:  
            return "Twenty";  
        default:  
            return "default";  
    }  
}, value);  
value.set(20);  
// 调用上面匿名内部类中的方法
System.out.println("value.get() = " + value.get());  
System.out.println("sexp2.get() = " + sexp2.get());
```

> value.get() = 20  
> sexp2.get() = Twenty  

#### selectString() 深层绑定JavaBean中某个属性

1. 创建两层结构的JavaBean
  
   ```java
   public class Student {
       private SimpleStringProperty name = new SimpleStringProperty("张三");
       private SimpleObjectProperty<School> school = new SimpleObjectProperty<>(new School());
       public Student(String  name) {
           this.name.set(name);
       }
       public String getName() {
           return name.get();
       }
       public SimpleStringProperty nameProperty() {
           System.out.println("STUDENT");
           return name;
       }
       public School getSchool() {
           return school.get();
       }
       // 此方法名必须按照此格式  
       public SimpleObjectProperty<School> schoolProperty() {
           System.out.println("STUDENT");
           return school;
       }
       public void setName(String name) {
           this.name.set(name);
       }
       public void setSchool(String  name) {
           this.school.set(new School(name));
       }
   }
   public class School {
       // 默认值  
       private SimpleStringProperty name = new SimpleStringProperty("哈佛大学");
       public School(){
       }
       public School(String name){
           this.name.set(name);
       }
       public String getName() {
           return name.get();
       }
       public SimpleStringProperty nameProperty() {
           System.out.println("SCHOOL");
           return name;
       }
   }
   ```

```java
// 嵌套一层的JavaBean
Student student = new Student("张三");  
SimpleObjectProperty<Student> studentProperty = new SimpleObjectProperty<>(student);  
// 可观察属性，外层JavaBean中的属性名称，内层JavaBean中的属性名称  
// 绑定了student对象中的school属性中的name属性  
StringExpression sexp3 = Bindings.selectString(studentProperty, "school", "name");  
System.out.println("sexp3.get() = " + sexp3.get());  
// 当school的name属性改变时，会触发sexp3值的改变  
student.setSchool("清华大学");  
System.out.println("sexp3.get() = " + sexp3.get());
```

> STUDENT  
> SCHOOL  
> sexp3.get() = 哈佛大学  
> STUDENT  
> SCHOOL  
> sexp3.get() = 清华大学  

#### convert() 字符串转换

```java
System.out.println("Bindings.convert(new SimpleIntegerProperty(100)).get().getClass() = " + Bindings.convert(new SimpleIntegerProperty(100)).get().getClass());
```

> Bindings.convert(new SimpleIntegerProperty(100)).get().getClass() = class java.lang.String