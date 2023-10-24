### 绑定：三元运算

初始化两个监视属性

```java
SimpleIntegerProperty x = new SimpleIntegerProperty(1);  
SimpleIntegerProperty y = new SimpleIntegerProperty(2);
```

* 三元运算
  
```java
// when(条件)then(表达式1)otherwise(表达式2)
NumberBinding TO = new When(x.greaterThan(y)).then(10).otherwise(20);
```
