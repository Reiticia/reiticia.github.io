---
lang: zh-CN
title: DialogPane对话框布局
---


# DialogPane对话框布局

* 创建弹窗布局
  
    ```java
    DialogPane dialogPane = new DialogPane();
    // 为对话框安排一个场景  
    Scene scene = new Scene(dialogPane);  
    Stage stage = new Stage();  
    stage.initOwner(primaryStage);  
    stage.initStyle(StageStyle.UTILITY);  
    stage.initModality(Modality.WINDOW_MODAL);  
    stage.setScene(scene);  
    stage.setResizable(false);  
    stage.show();
    ```

* 设置对话框头`dialogPane.setHeaderText("这是一个对话框头 - -");`

* 设置对话框的内容`dialogPane.setContentText("这是一个对话框");`

* 设置对话框的图标
  
    ```java
    ImageView imageView = new ImageView("images/logo.png");  
    imageView.setFitWidth(32);  
    imageView.setFitHeight(32);  
    dialogPane.setGraphic(imageView);
    ```

* 设置对话框扩展内容
  
    ```java
    dialogPane.setExpandableContent(new Text("这是一个扩展内容"));  
    // 设置扩展内容是否展开
    dialogPane.setExpanded(true);
    ```

* 设置按钮
  
    ```java
    dialogPane.getButtonTypes().add(ButtonType.APPLY);
    dialogPane.getButtonTypes().add(ButtonType.CLOSE);
    ```
    
    ![](../assets/Pasted%20image%2020220513111404.png)

### 多任务

* 创建自定义多任务类
  
    ```java
    class MyScheduledService extends ScheduledService<Integer> {  
        DialogPane dialogPane = null;  
        Stage stage = null;  
        int i = 0;  
    
        public MyScheduledService(DialogPane dialogPane, Stage stage) {  
            this.dialogPane = dialogPane;  
            this.stage = stage;  
        }  
    
        @Override  
        protected Task<Integer> createTask() {  
            return new Task<Integer>() {  
                @Override  
                protected Integer call() throws Exception {  
                    System.out.println("call(): " + Thread.currentThread().getName());  
                    return i++;  
                }  
    
                @Override  
                protected void updateValue(Integer value) {  
                    System.out.println("updateValue(): " + Thread.currentThread().getName());  
                    System.out.println("updateValue的值：" + value);  
                    super.updateValue(value);  
                    if (value < 11) {  
                        // 小于10，更新界面  
                        dialogPane.setContentText(value.toString());  
                    } else {  
                        // 大于10，关闭对话框  
                        stage.close();  
                        MyScheduledService.this.cancel();  
                    }  
                }  
    
            };  
        }  
    }
    ```

* 创建多任务
  
    ```java
    MyScheduledService myScheduledService = new MyScheduledService(dialogPane, stage); 
    // 设置起始时间  
    myScheduledService.setDelay(Duration.millis(0));
    // 设置周期  
    myScheduledService.setPeriod(Duration.seconds(1));
    myScheduledService.start();
    ```
    
    ![](../assets/Pasted%20image%2020220513111904.png)