---
lang: zh-CN
title: 启动图形界面的三种方式
---

# 启动图形界面的三种方式

1. `launch(args);`

2. `Application.launch(args);`

3. `Application.launch(Launch.class, args);`,Launch类主要代码如下

    ```java
    public class Launch extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Launch类");
            primaryStage.show();
        }
    }
    ```

## 生命周期方法

**运行的线程**

> main() = main  
> init() = JavaFX-Launcher  
> start() = JavaFX Application Thread  
> stop() = JavaFX Application Thread  
