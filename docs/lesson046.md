---
lang: zh-CN
title: ProgressBar和ProgressIndicator进度显示
---


# ProgressBar和ProgressIndicator进度显示

## ProgressBar

* 创建进度条`ProgressBar progressBar = new ProgressBar();`
* 设置进度`progressBar.setProgress(0.5);`
* 设置长度宽度
    
    ```java
    progressBar.setPrefWidth(500);
    progressBar.setPrefHeight(10.0);
    ```

* 设置不确定进度`progressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);`

## ProgressIndicator

* 设置进度圈`ProgressIndicator progressIndicator = new ProgressIndicator(0.5);`
* 设置进度`progressIndicator.setProgress(0.5);`
* 设置长度宽度

    ```java
    // 这两个设置在Jdk11中无效
    progressIndicator.setPrefWidth(500);
    progressIndicator.setPrefHeight(10.0);
    ```

* 设置不确定进度==默认==`progressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);`

## 控制

1. 创建一个按钮

    ```java
    Button button = new Button("pause");
    button.setLayoutX(150.0);
    button.setLayoutY(150.0);
    ```

2. 设置按钮点击事件

    ```java
    button.setOnAction(event -> {
        if (scheduledService.isRunning()) {
            scheduledService.cancel();
            button.setText("start");
        } else {
            scheduledService.restart();
            button.setText("pause");
        }
    });
    ```

3. 创建ScheduledService的匿名内部类

    ```java
    // 该变量被定义为类全局变量
    scheduledService = new ScheduledService<Double>() {
        double i = 0.0;
        @Override
        protected Task<Double> createTask() {
            return new Task<Double>() {
                @Override
                protected Double call() throws Exception {
                    return i += 0.0001;
                }
                @Override
                protected void updateValue(Double value) {
                    super.updateValue(value);
                    progressBar.setProgress(value);
                    progressIndicator.setProgress(value);
                    if (value >= 1) {
                        scheduledService.cancel();
                        System.out.println("finish");
                    }
                }
            };
        }
    };
    ```

4. scheduledService设置

    ```java
    scheduledService.setDelay(Duration.millis(1));
    scheduledService.setPeriod(Duration.millis(1));
    scheduledService.start();
    ```

![](../assets/VeryCapture_20220520115121.gif)
