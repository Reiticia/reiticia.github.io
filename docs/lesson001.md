---
lang: zh-CN
title: JavaFX入门程序
---

# JavaFX入门程序

[lesson001](../code/lesson001)

```java
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The first JavaFx Application");
        primaryStage.show();
    }
}
```