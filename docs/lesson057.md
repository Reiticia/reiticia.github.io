---
lang: zh-CN
title: 绑定判断
---

# 绑定判断

初始化两个监视属性

```java
SimpleIntegerProperty a = new SimpleIntegerProperty(1);  
SimpleIntegerProperty b = new SimpleIntegerProperty(2);
```

* 大于`a.greaterThan(b)`

* 小于`a.lessThan(b)`

* 等于`a.isEqualTo(b)`

* 不等于`a.isNotEqualTo(b)`

* 大于等于`a.greaterThanOrEqualTo(b)`

* 小于等于`a.lessThanOrEqualTo(b)`