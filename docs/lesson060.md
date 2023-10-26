---
lang: zh-CN
title: 集合类型的绑定
---

# 集合类型的绑定

以下四种绑定方法List、Set、Map共有

| 中文     | 绑定方法                     | 效果                                                                        |
| ------ | ------------------------ | ------------------------------------------------------------------------- |
| 单向绑定   | bind                     | 绑定的两个属性同时维护一个列表集合，对任意一个属性的更新，都会影响被绑定的元素对应的集合，相当于调用者绑定了被调用者对应的列表元素的内存地址    |
| 双向绑定   | bindBidirectional        | 与单向绑定效果相同                                                                 |
| 单向绑定内容 | bindContent              | 将被调用者对应的集合绑定到调用者对应的集合，被调用者对应的集合的更新，会影响调用者对应的集合，而调用者对应的集合的更新，不会影响被调用者对应的集合 |
| 双向绑定内容 | bindContentBidirectional | 调用者对应的集合会同步被调用者对应集合的数据，被调用者或调用者发生数据更新时，会同时影响两者对应的集合内容，是**真正意义上的双向绑定**     |

代码演示

## 单向绑定

测试代码

```java
ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
ObservableList<String> list1 = FXCollections.observableArrayList("A", "D", "C");
SimpleListProperty<String> listProperty1 = new SimpleListProperty<>(list1);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.bind(listProperty1);
System.out.println(Color.RED + "--------------listProperty.bind(listProperty1)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.add("b");
listProperty1.add("B");
System.out.println(Color.RED + "--------------listProperty.add(\"b\");listProperty1.add(\"B\")--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
listProperty.sort(String::compareTo);
System.out.println(Color.RED + "--------------listProperty.sort(String::compareTo)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
```

> listProperty.get() = [a, d, c] | listProperty1.get() = [A, D, C]  
> --------------listProperty.bind(listProperty1)--------------  
> listProperty.get() = [A, D, C] | listProperty1.get() = [A, D, C]  
> --------------listProperty.add("b");listProperty1.add("B")--------------  
> listProperty.get() = [A, D, C, b, B] | listProperty1.get() = [A, D, C, b, B]  
> list = [a, d, c] | list1 = [A, D, C, b, B]  
> --------------listProperty.sort(String::compareTo)--------------  
> listProperty.get() = [A, B, C, D, b] | listProperty1.get() = [A, B, C, D, b]  
> list = [a, d, c] | list1 = [A, B, C, D, b]  

## 双向绑定

测试代码

```java
ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
ObservableList<String> list1 = FXCollections.observableArrayList("A", "D", "C");
SimpleListProperty<String> listProperty1 = new SimpleListProperty<>(list1);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.bindBidirectional(listProperty1);
System.out.println(Color.RED + "--------------listProperty.bindBidirectional(listProperty1)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.add("b");
listProperty1.add("B");
System.out.println(Color.RED + "--------------listProperty.add(\"b\");listProperty1.add(\"B\")--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
listProperty.sort(String::compareTo);
System.out.println(Color.RED + "--------------listProperty.sort(String::compareTo)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
```

> listProperty.get() = [a, d, c] | listProperty1.get() = [A, D, C]  
> --------------listProperty.bindBidirectional(listProperty1)--------------  
> listProperty.get() = [A, D, C] | listProperty1.get() = [A, D, C]  
> --------------listProperty.add("b");listProperty1.add("B")--------------  
> listProperty.get() = [A, D, C, b, B] | listProperty1.get() = [A, D, C, b, B]  
> list = [a, d, c] | list1 = [A, D, C, b, B]  
> --------------listProperty.sort(String::compareTo)--------------  
> listProperty.get() = [A, B, C, D, b] | listProperty1.get() = [A, B, C, D, b]  
> list = [a, d, c] | list1 = [A, B, C, D, b]  

## 单向绑定内容

测试代码

```java
ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
ObservableList<String> list1 = FXCollections.observableArrayList("A", "D", "C");
SimpleListProperty<String> listProperty1 = new SimpleListProperty<>(list1);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.bindContent(listProperty1);
System.out.println(Color.RED + "--------------listProperty.bindContent(listProperty1)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.add("b");
listProperty1.add("B");
System.out.println(Color.RED + "--------------listProperty.add(\"b\");listProperty1.add(\"B\")--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
listProperty.sort(String::compareTo);
System.out.println(Color.RED + "--------------listProperty.sort(String::compareTo)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
```

> listProperty.get() = [a, d, c] | listProperty1.get() = [A, D, C]  
> --------------listProperty.bindContent(listProperty1)--------------  
> listProperty.get() = [A, D, C] | listProperty1.get() = [A, D, C]  
> --------------listProperty.add("b");listProperty1.add("B")--------------  
> listProperty.get() = [A, D, C, B, b] | listProperty1.get() = [A, D, C, B]  
> list = [A, D, C, B, b] | list1 = [A, D, C, B]  
> --------------listProperty.sort(String::compareTo)--------------  
> listProperty.get() = [A, B, C, D, b] | listProperty1.get() = [A, D, C, B]  
> list = [A, B, C, D, b] | list1 = [A, D, C, B]  

## 双向绑定内容

测试代码

```java
ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
ObservableList<String> list1 = FXCollections.observableArrayList("A", "D", "C");
SimpleListProperty<String> listProperty1 = new SimpleListProperty<>(list1);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.bindContentBidirectional(listProperty1);
System.out.println(Color.RED + "--------------listProperty.bindContent(listProperty1)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
listProperty.add("b");
listProperty1.add("B");
System.out.println(Color.RED + "--------------listProperty.add(\"b\");listProperty1.add(\"B\")--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
listProperty.sort(String::compareTo);
System.out.println(Color.RED + "--------------listProperty.sort(String::compareTo)--------------" + Color.RESET);
System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
System.out.println("list = " + list + " | " + "list1 = " + list1);
```

> listProperty.get() = [a, d, c] | listProperty1.get() = [A, D, C]  
> --------------listProperty.bindContent(listProperty1)--------------  
> listProperty.get() = [A, D, C] | listProperty1.get() = [A, D, C]  
> --------------listProperty.add("b");listProperty1.add("B")--------------  
> listProperty.get() = [A, D, C, b, B] | listProperty1.get() = [A, D, C, b, B]  
> list = [A, D, C, b, B] | list1 = [A, D, C, b, B]  
> --------------listProperty.sort(String::compareTo)--------------  
> listProperty.get() = [A, B, C, D, b] | listProperty1.get() = [A, B, C, D, b]  
> list = [A, B, C, D, b] | list1 = [A, B, C, D, b]  