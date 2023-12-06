---
lang: zh-CN
title: Stage窗口（续）
---


# Stage窗口（续）

* 设置窗口透明度`primaryStage.setOpacity(0.5);`

* 设置置顶窗口 `primaryStage.setAlwaysOnTop(true);`

* 设置窗口位置
  
    ```java
    // 距离屏幕左上角距离
    primaryStage.setX(100);  
    primaryStage.setY(100);
    ```

* 监听窗口移动
  
    ```java
    primaryStage.xProperty().addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
            System.out.println("x:" + newValue);  
        }  
    });  
    primaryStage.yProperty().addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
            System.out.println("y:" + newValue);  
        }  
    });
    ```

* 窗口样式

     ```java
    // 默认样式  
    stage.initStyle(StageStyle.DECORATED);
    // 透明样式  
    stage1.initStyle(StageStyle.TRANSPARENT);
    // 纯白色背景，没有装饰  
    stage2.initStyle(StageStyle.UNDECORATED);
    // 定义具有纯白色背景和用于实用程序窗口的最小平台装饰的Stage样式。
    stage3.initStyle(StageStyle.UTILITY);
    // 用平台装饰定义Stage风格，消除客户区和装饰之间的边界。客户区背景与装饰统一。
    stage4.initStyle(StageStyle.UNIFIED);
     ```

* 窗口模态
  
    ```java
    // 设置模态窗口，设置后如果该窗口不关闭则不能点击其他窗口
    stage2.initModality(Modality.APPLICATION_MODAL);
    // 设置父窗口
    stage1.initOwner(stage);  
    // 设置模态窗口，该窗口没有关闭前点击stage（即父窗口）窗口无效
    stage1.initModality(Modality.WINDOW_MODAL);
    ```
