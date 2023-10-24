### Platform类使用

```java
// 查看两个位置代码运行的线程
public void start(Stage primaryStage) throws Exception {  
    System.out.println("start: " + Thread.currentThread().getName());  
    Platform.runLater(new Runnable() {  
        @Override  
        public void run() {  
            System.out.println("runLater: " + Thread.currentThread().getName());  
        }  
    });  
    primaryStage.setTitle("JavaFX");  
    primaryStage.show();  
}
```

> start: JavaFX Application Thread  
> runLater: JavaFX Application Thread

以上结果表示Platform运行的线程和Application线程一致，则可以使用Platform类来更新UI界面

##### 方法

* 即使关闭窗口，程序依然执行（后台运行）`Platform.setImplicitExit(false);`

* 退出窗口，关闭程序`Platform.exit();`

* 当前平台是否支持3d效果`Platform.isSupported(ConditionalFeature.SCENE3D);`
