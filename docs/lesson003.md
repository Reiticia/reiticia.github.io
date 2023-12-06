---
lang: zh-CN
title: Stage窗口
---

# Stage窗口

* 设置标题`primaryStage.setTitle("JavaFx");`

* 设置图标`primaryStage.getIcon.add(new Image("/images/logo.png"));`

* 设置最小化`primaryStage.setIconified(true);`

* 设置最大化 `primaryStage.setMaximized(true);`

* 设置关闭窗口`primaryStage.close();`

* 设置不可改变窗口大小`primaryStage.setResizable(true);`

* 设置和获取宽高

    ```java
    primaryStage.setWidth(250);  
    primaryStage.setHeight(250);  
    primaryStage.setMaxHeight(500);  
    primaryStage.setMaxWidth(500);  
    primaryStage.setMinHeight(100);  
    primaryStage.setMinWidth(100);
    // 如果没用设置宽高，则以下两个方法必须在show()方法执行才能获取宽高
    primaryStage.getWidth();  
    primaryStage.getHeight();
    ```

* 设置父窗口`stage1.initOwner(stage);` 

* 设置模态窗口，该窗口没有关闭前点击stage（即父窗口）窗口无效`stage1.initModality(Modality.WINDOW_MODAL);`

    ```java
    primaryStage.heightProperty().addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) { 
            System.out.println("高度变化了");  
        }  
    });  
    primaryStage.widthProperty().addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
            System.out.println("宽度变化了");  
        }  
    });
    ```

* 设置全屏
  
    ```java
    primaryStage.setFullScreen(true);  
    primaryStage.setScene(new Scene(new Group()));
    ```
