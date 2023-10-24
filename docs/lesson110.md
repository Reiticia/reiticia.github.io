### 多任务Service

1. 创建MyTask继承Task类
  
   ```java
   public class MyTask extends Task<Number> {  
       /**  
     * 调用start方法时执行  
     *  
     * @return  
     * @throws Exception  
     */  
       @Override  
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
               Thread.sleep(1);  
           }  
           fileInputStream.close();  
           fileOutputStream.close();  
           return 0;  
       }  
   }
   ```
2. 创建MyService继承Service类返回MyTask
  
   ```java
   public class MyService extends Service<Number> {  
       @Override  
       protected Task<Number> createTask() {  
           return new MyTask();  
       }  
       @Override  
       protected void executeTask(Task<Number> task) {  
           super.executeTask(task);  
           task.valueProperty().addListener((observable, oldValue, newValue) -> {  
               System.out.println("executeTask:valueProperty");  
           });  
       }  
       @Override  
       protected void ready() {  
           super.ready();  
           System.out.println("ready:"+ Platform.isFxApplicationThread());  
       }  
       @Override  
       protected void scheduled() {  
           super.scheduled();  
           System.out.println("scheduled:"+ Platform.isFxApplicationThread());  
       }  
       @Override  
       protected void running() {  
           super.running();  
           System.out.println("running:"+ Platform.isFxApplicationThread());  
       }  
       @Override  
       protected void succeeded() {  
           super.succeeded();  
           System.out.println("succeeded:"+ Platform.isFxApplicationThread());  
       }  
       @Override  
       protected void cancelled() {  
           super.cancelled();  
           System.out.println("cancelled:"+ Platform.isFxApplicationThread());  
       }  
       @Override  
       protected void failed() {  
           super.failed();  
           System.out.println("failed:"+ Platform.isFxApplicationThread());  
       }  
   }
   ```
3. 创建MyService类
  
   ```java
   MyService myService = new MyService();
   ```
4. 操作MyService
  
   ```java
   start.setOnAction(event -> {  
       myService.start();  
   });  
   cancel.setOnAction(event -> {  
       myService.cancel();  
   });  
   restart.setOnAction(event -> {  
       myService.restart();  
   });  
   reset.setOnAction(event -> {  
       myService.reset();  
       progressBar.setProgress(0);  
   });  
   myService.progressProperty().addListener((observable, oldValue, newValue) -> {  
       progressBar.setProgress(newValue.doubleValue());  
   });  
   myService.messageProperty().addListener(((observable, oldValue, newValue) -> {  
       message.setText(newValue);  
   }));
   ```