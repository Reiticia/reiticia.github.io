---
lang: zh-CN
title: MediaPlayer获取文件信息
---

# MediaPlayer获取文件信息

* 获取曲目信息`media.getTracks().forEach(System.out::println)`

* 获取元数据`media.getMetadata().forEach((s, o) -> System.out.println(s + ":" + o))`

* 添加标记
  
    ```java
    media.getMarkers().put("a", Duration.seconds(5));
    media.getMarkers().put("b", Duration.seconds(10));  
    media.getMarkers().put("c", Duration.seconds(15));
    ```
  
* 打印标记
  
    ```java
    mediaPlayer.setOnMarker(event -> {  
        System.out.println("" + ColorConsole.BLUE + event.getMarker() + ColorConsole.RESET);// 打印标记  
        if (event.getMarker().getKey().equals("a")){  
            primaryStage.setTitle("a");  
        }  
    });
    ```