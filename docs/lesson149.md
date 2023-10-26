---
lang: zh-CN
title: BoxBlur类方框模糊
---


# BoxBlur类方框模糊

* 创建类方框模糊`BoxBlur boxBlur = new BoxBlur();`

* 基本设置
  
    ```java
    // 模糊大小，设置为0则该方向不模糊
    boxBlur.setWidth(10);  
    boxBlur.setHeight(10);  
    // 模糊程度（0~3）  
    boxBlur.setIterations(1);
    ```
  
![](../assets/Pasted%20image%2020220616111049.png)