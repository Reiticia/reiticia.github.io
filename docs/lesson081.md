---
lang: zh-CN
title: 自定义拖拽类型
---

# 自定义拖拽类型

* 设置类型并拷贝到拖拽剪贴板
  
    ```java
    // 成员变量
    private DataFormat personFormat = new DataFormat("data/person");
    
    // 局部变量
    ClipboardContent content = new ClipboardContent();  
    content.put(personFormat, person);  
    dragboard.setContent(content);
    ```

* 读取剪贴板
  
    ```java
    Dragboard dragboard = event.getDragboard();
    Person content = (Person) dragboard.getContent(DataFormat.lookupMimeType("data/person"));
    // 或者使用下面一行代码代替上面一行
    Person content = (Person) dragboard.getContent(personFormat);
    ```
