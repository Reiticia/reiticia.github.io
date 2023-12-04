---
lang: zh-CN
title: 可观察集合中的一些方法
---


# 可观察集合中的一些方法

以下例子均以list为例

* rotate()重新排序
  
    ```java
    ObservableList<String> list = FXCollections.observableArrayList();  
    list.add("a");  
    list.add("c");  
    list.add("e");  
    list.add("b");  
    list.add("d");  
    // 从倒数第3个元素依此往后循环对列表元素进行排序  
    FXCollections.rotate(list, 3);  
    list.forEach(item -> System.out.print(item + " "));  
    System.out.println();  
    // 删除索引为1的元素  
    list.remove(1);  
    list.forEach(item -> System.out.print(item + " "));
    ```
    
    > e b d a c  
    > e d a c 

* Callback() 回调函数
  
    ```java
    // 每次相list中添加元素时，会触发一次回调函数  
    ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
        /**  
       * 此方法返回值将作为list的每个值  
       * @param param  
       * @return  
       */
        @Override  
        public Observable[] call(SimpleStringProperty param) {
            if (param.getValue().equals("c")) {
                System.out.println("str1.set("c"); run into this method");
            }
            System.out.println("call : " + param.get());
            return new Observable[]{
                param
            };
        }
    });
    SimpleStringProperty str1 = new SimpleStringProperty("a");
    SimpleStringProperty str2 = new SimpleStringProperty("b");
    list.add(str1);
    list.add(str2);
    list.forEach(item -> System.out.print(item.get() + " "));
    System.out.println();
    list.addListener(new ListChangeListener<SimpleStringProperty>() {
        @Override  
        public void onChanged(Change<? extends SimpleStringProperty> c) {
            System.out.println("onChanged : " + c);
            while (c.next()) {
                System.out.println("c.wasUpdated() = " + c.wasUpdated());
            }
        }
    });
    // 重复地往集合中添加元素，只会调用一次call方法  
    list.add(str2);
    list.forEach(item -> System.out.print(item.get() + " "));
    System.out.println();
    str1.set("c");
    list.forEach(item -> System.out.print(item.get() + " "));
    ```
    
    > call : a  
    > call : b  
    > a b   
    > onChanged : { [StringProperty [value: b]] added at 2 }  
    > c.wasUpdated() = false  
    > a b b   
    > onChanged : { updated at range [0, 1) }  
    > c.wasUpdated() = true  
    > c b b   

* 反例(下面例子证明：如果在创建可观察列表时没有指定回调函数callback，则当集合中存储的数据发生变化时，不会触发集合对应监视属性的监听方法)
  
    ```java
    ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList();
    SimpleListProperty<SimpleStringProperty> listProperty = new SimpleListProperty<>(list);
    listProperty.addListener((ListChangeListener<SimpleStringProperty>) c -> {
        while (c.next()) {
            System.out.println("c.wasUpdated() = " + c.wasUpdated());
        }
    }
                            );
    SimpleStringProperty string1 = new SimpleStringProperty("aa");
    SimpleStringProperty string2 = new SimpleStringProperty("cc");
    listProperty.add(string1);
    listProperty.add(string2);
    // 此行无输出
    string1.set("bb");
    ```
    
    > c.wasUpdated() = false  
    > c.wasUpdated() = false  

* 将上面例子第一行改为
      
    ```java
    ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(param -> new Observable[]{param});
    ```
    
    > c.wasUpdated() = false  
    > c.wasUpdated() = false  
    > c.wasUpdated() = true  

## 两个可观察列表双向绑定的另一种实现

```java
SimpleStringProperty str1 = new SimpleStringProperty("aa");  
SimpleStringProperty str2 = new SimpleStringProperty("dd");  
ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {  
    @Override  
    public Observable[] call(SimpleStringProperty param) {  
        System.out.println(Color.RED + "(list)call : " + param.get() + Color.RESET);  
        return new Observable[]{param};  
    }  
});  
ObservableList<SimpleStringProperty> list1 = FXCollections.observableList(list, new Callback<SimpleStringProperty, Observable[]>() {  
    @Override  
    public Observable[] call(SimpleStringProperty param) {  
        System.out.println(Color.BLUE + "(list1)call : " + param.get() + Color.RESET);  
        return new Observable[]{param};  
    }  
});  
list.addListener(new ListChangeListener<SimpleStringProperty>() {  
    @Override  
    public void onChanged(Change<? extends SimpleStringProperty> c) {  
        System.out.println(Color.RED + "(list)onChanged : " + c + Color.RESET);  
        while (c.next()) {  
            System.out.println(Color.RED + "c.wasUpdated() = " + c.wasUpdated() + Color.RESET);  
        }  
    }  
});  
list1.addListener(new ListChangeListener<SimpleStringProperty>() {  
    @Override  
    public void onChanged(Change<? extends SimpleStringProperty> c) {  
        System.out.println(Color.BLUE + "(list1)onChanged : " + c + Color.RESET);  
        while (c.next()) {  
            System.out.println(Color.BLUE + "c.wasUpdated()1 = " + c.wasUpdated() + Color.RESET);  
        }  
    }  
});  
list1.add(str1);  
list.forEach(item -> System.out.print(Color.RED + item.get() + " "));  
list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));  
System.out.println();  
System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);  

list.add(str2);  
list.forEach(item -> System.out.print(Color.RED + item.get() + " "));  
list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));  
System.out.println();  
System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);  

str1.set("cc");  
list.forEach(item -> System.out.print(Color.RED + item.get() + " "));  
list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));  
System.out.println();  
System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);  

str2.set("bb");  
list.forEach(item -> System.out.print(Color.RED + item.get() + " "));  
list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));  
System.out.println();  
System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);
```

> (list1)call : aa   
> (list)call : aa  
> (list)onChanged : { [StringProperty [value: aa]] added at 0 }  
> c.wasUpdated() = false  
> (list1)onChanged : { [StringProperty [value: aa]] added at 0 }  
> c.wasUpdated()1 = false  
> aa aa   
> (list)call : dd  
> (list)onChanged : { [StringProperty [value: dd]] added at 1 }  
> c.wasUpdated() = false  
> aa dd aa dd   
> (list1)onChanged : { updated at range [0, 1) }  
> c.wasUpdated()1 = true  
> (list1)onChanged : { updated at range [0, 1) }  
> c.wasUpdated() = true  
> cc dd cc dd   
> (list)onChanged : { updated at range [1, 2) }  
> c.wasUpdated() = true  
> cc bb cc bb   