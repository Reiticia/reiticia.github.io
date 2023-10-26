---
lang: zh-CN
title: 多任务Task
---

# 多任务Task

* 查看当前线程是否为JavaFx的UI线程`Platform.isFxApplicationThread()`

1. 创建MyTask继承Task类
  
   ```java
   public class MyTask extends Task<Number> {  
       /**  
     * 调用start方法时执行  
     *  
     * @return  
     * @throws Exception  
     */    @Override  
       protected Number call() throws Exception {  
           this.updateTitle("拷贝文件");  
           FileInputStream fileInputStream = new FileInputStream(new File("E:\\Users\\86158\\图片\\110300202_waifu2x_1x_3n_jpg (2).png"));  
           FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\Users\\86158\\图片\\测试复制.png"));  
           double max = fileInputStream.available();  
           byte[] bytes = new byte[1024];  
           int len = 0;  
           double sum = 0;  
           double progress = 0;  
           while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {  
               if (isCancelled()) {  
                   break;  
               }  
               fileOutputStream.write(bytes, 0, len);  
               sum += len;  
               this.updateProgress(sum, max);  
               progress = sum / max;  
               if (progress < 0.5) {  
                   this.updateMessage("请耐心等待");  
               } else if (progress < 0.8) {  
                   this.updateMessage("马上就好");  
               } else if (progress < 1) {  
                   this.updateMessage("即将完成");  
               } else {  
                   this.updateMessage("拷贝完成");  
               }  
               Thread.sleep(10);  
           }  
           fileInputStream.close();  
           fileOutputStream.close();  
           return 100;  
       }  
   
       @Override  
       protected void updateProgress(long workDone, long max) {  
           super.updateProgress(workDone, max);  
       }  
   
       @Override  
       protected void updateProgress(double workDone, double max) {  
           super.updateProgress(workDone, max);  
       }  
   
       @Override  
       protected void updateMessage(String message) {  
           super.updateMessage(message);  
       }  
   
       @Override  
       protected void updateTitle(String title) {  
           super.updateTitle(title);  
       }  
   
       @Override  
       protected void updateValue(Number value) {  
           super.updateValue(value);  
           // 判断当前线程是否是fx线程  
           // System.out.println(Platform.isFxApplicationThread());  
   
       }  
   }
   ```

2. 创建多任务类
  
   ```java
   MyTask myTask = new MyTask();  
   Thread thread = new Thread(myTask);
   // 设置为守护线程  
   thread.setDaemon(true);
   ```

3. 开启多任务
  
   ```java
   start.setOnAction(event -> {  
       thread.start();  
       // 绑定多任务进度，使进度条呈现持续加载效果
       progressBar.progressProperty().bind(myTask.progressProperty());  
       // 绑定多任务标题，当多任务标题改变时，界面标签随着改变
       title.textProperty().bind(myTask.titleProperty());  
       // 绑定多任务信息，当多任务信息改变时，界面标签随着改变
       message.textProperty().bind(myTask.messageProperty());  
       // 绑定多任务值，当多任务值改变时，界面标签随着改变
       value.textProperty().bind(myTask.valueProperty().asString());  
       // 绑定多任务状态，当多任务状态改变时，界面标签随着改变
       state.textProperty().bind(myTask.stateProperty().asString());  
       // 当多任务发生异常时，打印异常信息
       myTask.exceptionProperty().addListener((observable, oldValue, newValue) -> {  
           if (newValue != null) {  
               System.out.println(newValue.getMessage());  
           }  
       });  
   });
   ```

4. 结束多任务
  
   ```java
   cancel.setOnAction(event -> {  
       myTask.cancel();  
       progressBar.progressProperty().unbind();  
       title.textProperty().unbind();  
       message.textProperty().unbind();  
       value.textProperty().unbind();  
       state.textProperty().unbind();
   });
   ```
   
   效果图
   ![](../assets/VeryCapture_20220608213639.gif)