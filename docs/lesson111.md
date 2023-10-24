### 多任务ScheduledService

1. 创建MyScheduledService继承ScheduledService
  
   ```java
   public class MyScheduledService extends ScheduledService<Number> {  
       int sum = 0;  
       @Override  
       protected Task<Number> createTask() {  
           System.out.println("创建任务");  
           return new Task<Number>() {  
               @Override  
               protected Number call() throws Exception {  
                   sum++;  
                   System.out.println(sum);  
                   return sum;  
               }  
               @Override  
               protected void updateValue(Number value) {  
                   super.updateValue(value);  
                   if (value.intValue() >= 10) {  
                       // 停掉外部的任务  
                       MyScheduledService.this.cancel();  
                       System.out.println("任务取消");  
                   }  
               }  
           };  
       }  
   }
   ```
   
2. 创建MyScheduledService类
  
   ```java
   MyScheduledService myScheduledService = new MyScheduledService();  
   // 多久之后启动  
   myScheduledService.setDelay(Duration.seconds(5));  
   // 1s运行一次  
   myScheduledService.setPeriod(Duration.seconds(1));  
   // 任务失败是否重新启动  
   myScheduledService.setRestartOnFailure(true);  
   // 失败重试次数  
   myScheduledService.setMaximumFailureCount(4);
   ```
   
3. 操作MyScheduledService
  
   ```java
   start.setOnAction(event -> {  
       myScheduledService.start();  
   });  
   cancel.setOnAction(event -> {  
       myScheduledService.cancel();  
   });  
   restart.setOnAction(event -> {  
       myScheduledService.restart();  
   });  
   reset.setOnAction(event -> {  
       myScheduledService.reset();  
       progressBar.setProgress(0);  
   });  
   myScheduledService.valueProperty().addListener(((observable, oldValue, newValue) -> {  
       Optional.ofNullable(newValue).ifPresent(number -> message.setText(String.valueOf(number.intValue())));  
   }));  
   myScheduledService.lastValueProperty().addListener(((observable, oldValue, newValue) -> {  
       Optional.ofNullable(newValue).ifPresent(number -> System.out.println("newValue.intValue() = " + number.intValue()));  
   }));
   ```
