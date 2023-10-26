---
lang: zh-CN
title: 监视属性
---


# 监视属性

## SimpleIntegerProperty

```java
SimpleIntegerProperty sip = new SimpleIntegerProperty(5);  
sip.addListener((observable, oldValue, newValue) -> {  
    System.out.println("oldValue: " + oldValue);  
    System.out.println("newValue: " + newValue);  
});  
System.out.println("sip.get() = " + sip.get());  
sip.set(10);  
System.out.println("sip.get() = " + sip.get());
```

> sip.get() = 5
> oldValue: 5
> newValue: 10
> sip.get() = 10

## ReadOnlyDoubleWrapper&ReadOnlyDoubleProperty

```java
ReadOnlyDoubleWrapper rodw = new ReadOnlyDoubleWrapper(3);  
ReadOnlyDoubleProperty property = rodw.getReadOnlyProperty();  
System.out.println("property.get() = " + property.get());  
System.out.println("rodw.get() = " + rodw.get());  
rodw.set(5.0);  
System.out.println("rodw.get() = " + rodw.get());  
System.out.println("property.get() = " + property.get());
```

> property.get() = 3.0
> rodw.get() = 3.0
> rodw.get() = 5.0
> property.get() = 5.0

## 创建实体类封装监视属性

1. 实体类
  
   ```java
   public class Data {  
       private SimpleStringProperty name = new SimpleStringProperty(this,"nameProperty");  
       private SimpleIntegerProperty age = new SimpleIntegerProperty(this,"ageProperty");  
   
       public Data() {  
       }  
   
       public Data(String name, int age) {  
           this.name.set(name);  
           this.age.set(age);  
       }  
   
       public void setName(String name) {  
           this.name.set(name);  
       }  
   
       public void setAge(int age) {  
           this.age.set(age);  
       }  
   
       public SimpleStringProperty getSimpleStringPropertyName() {  
           return this.name;  
       }  
   
       public SimpleIntegerProperty getSimpleIntegerPropertyAge() {  
           return this.age;  
       }  
   
       public String getName() {  
           return this.name.get();  
       }  
   
       public int getAge() {  
           return this.age.get();  
       }  
   
       @Override  
       public String toString() {  
           return "Data's toString method";  
       }  
   }
   ```

2. 创建和使用
  
   ```java
   Data data = new Data("reine", 19);
   Button button = new Button("change data");  
   data.getSimpleStringPropertyName().addListener((observable, oldValue, newValue) -> {  
       // 证明该对象为监视属性本身  
       SimpleStringProperty name = (SimpleStringProperty) observable;  
       System.out.println("name.getBean() = " + name.getBean());  
       System.out.println("name.getName() = " + name.getName());  
       System.out.println("oldValue = " + oldValue);  
       System.out.println("newValue = " + newValue);  
   });  
   // 按钮点击事件  
   button.setOnAction(event -> {  
       data.setName("Jack");  
       data.setAge(27);  
   });
   ```
   
   点击按钮后，控制台输出
   
   > name.getBean() = Data's toString method
   > name.getName() = nameProperty
   > oldValue = reine
   > newValue = Jack
   
   实体类性能优化**在有需要时把对象属性转换为监视属性，不需要监听时为普通数据类型**

3. 实体类
  
   ```java
   public class Data2 {  
       private String name;  
       private SimpleStringProperty nameProperty = null;  
   
       public Data2() {  
       }  
   
       /**  
     * 如果不需要监视属性，则直接给普通属性赋值，如果需要监视属性，则调用监视属性set()方法设置值  
     * @param name  
     */  
       public Data2(String name) {  
           if (nameProperty == null) {  
               this.name = name;  
           } else {  
               this.nameProperty.set(name);  
           }  
       }  
   
       /**  
     * 如果不需要监视属性，则直接给普通属性赋值，如果需要监视属性，则调用监视属性set()方法设置值  
     * @param name  
     */  
       public void setName(String name) {  
           if (nameProperty == null) {  
               this.name = name;  
           } else {  
               this.nameProperty.set(name);  
           }  
       }  
   
       /**  
     * 如果监视属性有值，返回监视属性值，否则返回普通属性值  
     * @return  
     */  
       public String getName() {  
           if (nameProperty == null) {  
               return this.name;  
           } else {  
               return this.nameProperty.get();  
           }  
       }  
   
       /**  
     * 需要使对象拥有监视属性时调用此方法对对象内部指定属性生成监视属性  
     *  
     * @return 对象监视属性  
     */  
       public SimpleStringProperty nameProperty() {  
           if (nameProperty == null) {  
               nameProperty = new SimpleStringProperty(this, "name", this.name);  
           }  
           return nameProperty;  
       }  
   }
   ```

4. 创建和使用
  
   ```java
   Data2 data2 = new Data2("Jack");  
   // 监视属性  
   data2.nameProperty().addListener((observable, oldValue, newValue) -> {  
       System.out.println("oldValue = " + oldValue);  
       System.out.println("newValue = " + newValue);  
   });
   // 按钮点击事件  
   button.setOnAction(event -> {  
       data2.setName("Tom");  
       System.out.println(data2.getName());  
   });
   ```
   
   点击按钮后，控制台输出
   
   > oldValue = Jack
   > newValue = Tom
   > Tom