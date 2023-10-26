---
lang: zh-CN
title: Clipboard剪贴板
---


# Clipboard剪贴板

* 获取剪贴板`Clipboard clipboard = Clipboard.getSystemClipboard()`

* 判断剪贴板是否有某一类型内容
  
    ```java
    // 是否有文本
    clipboard.hasString()
    // 是否有文件
    clipboard.hasFiles()
    // 是否有图片（如果是网络图片链接，则is为true；如果是本地图片右键复制，则为false）
    clipboard.hasImage()
    ```

* 获取剪贴板内容
  
    ```java
    // 获取文本
    String str = clipboard.getString()
    // 获取文件
    List<File> files = clipboard.getFiles()
    // 获取图片
    Image image = clipboard.getImage()
    ```

* 获取剪贴板指定格式的内容`Image obj = (Image) clipboard.getContent(DataFormat.IMAGE);`

* 将指定内容复制到剪贴板
      
    ```java
    ClipboardContent content = new ClipboardContent();
    content.put(DataFormat.IMAGE,new Image("file:E:\\Users\\86158\\图片\\110300202.jpg"));
    clipboard.setContent(content);
    ```