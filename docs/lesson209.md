---
lang: zh-CN
title: Java11以模块化方式引入JavaFX
---


# Java11以模块化方式引入JavaFX

1. 添加JavaFX的jar包

2. 编写`module-info.java`
   
   ```java
   module lesson209{  
    // 导出到xxx包下进行使用  
    exports com.reine;  
    // 引用外部包  
    requires javafx.graphics;  
   }
   ```

3. 启动类
   
   ```java
   public class Main extends Application {  
    public static void main(String[] args) {  
        System.out.println("hello world!");  
        launch(args);
    }  
   
    @Override  
    public void start(Stage primaryStage) throws Exception {  
         primaryStage.show(); 
    }
   }
   ```