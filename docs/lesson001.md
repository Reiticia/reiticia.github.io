### FX入门程序

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