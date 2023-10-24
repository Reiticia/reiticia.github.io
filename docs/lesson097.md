### TableView5中内置的TableCell

* 设置列排列方式`tableView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);`

* 创建tableView和添加列
  
  ```java
  TableView<StudentProperty> tableView = new TableView<>(list);
  // 每一列  
  TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");  
  nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());  
  // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型  
  TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");  
  ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty());  
  // TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");  
  // scoreCol.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());  
  // 此行用于替换上面两行，为了下面ProgressBarTableCell的演示  
  TableColumn<StudentProperty, Double> scoreCol = new TableColumn<>("充能");  
  scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));  
  TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("性别");  
  isBoyCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
  ```

* 设置可编辑`tableView.setEditable(true);`

* TextFieldTableCell
  
  ```java
  nameCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {  
      @Override  
      public String toString(String object) {  
          return object;  
      }  
      @Override  
      public String fromString(String string) {  
          return string;  
      }  
  }));
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220606152405.png)

* ChoiceBoxTableCell
  
  ```java
  ageCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(new StringConverter<Number>() {  
      @Override  
      public String toString(Number object) {  
          if (object == null) {  
              return null;  
          }  
          return object.toString();  
      }  
      @Override  
      public Number fromString(String string) {  
          return new Integer(string);  
      }  
  }, 15, 16, 17, 18, 19, 20, 21, 22));
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220606152503.png)

* ProgressBarTableCell
  
  ```java
  scoreCol.setCellFactory(ProgressBarTableCell.forTableColumn());
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220606162535.png)

* ComboBoxTableCell
  
  ```java
  isBoyCol.setCellFactory(ComboBoxTableCell.forTableColumn(new StringConverter<Boolean>() {  
      @Override  
      public String toString(Boolean object) {  
          return object ? "男" : "女";  
      }  
      @Override  
      public Boolean fromString(String string) {  
          return string.equals("男");  
      }  
  }, true, false));
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220606162636.png)

* CheckBoxTableCell
  
  ```java
  isBoyCol.setCellFactory(CheckBoxTableCell.forTableColumn(new TableColumn<>()));
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220606162749.png)
  
  #### 使用定时任务使进度条（ProgressBarTableCell）加载
1. 自定义定时任务类
  
   ```java
   public class MyService extends ScheduledService<Double> {  
       double value = 0;  
   
       @Override  
       protected Task<Double> createTask() {  
           return new Task<Double>() {  
               @Override  
               protected Double call() throws Exception {  
                   value += 0.1;  
                   return value;  
               }  
           };  
       }  
   }
   ```

2. 设置参数并启动
  
   ```java
   MyService service = new MyService();  
   service.setDelay(Duration.ZERO);  
   service.setPeriod(Duration.seconds(1));  
   service.valueProperty().addListener((observable, oldValue, newValue) -> {  
       Optional.ofNullable(newValue).ifPresent(aDouble -> {  
           if (aDouble > 1.0) {  
               service.cancel();  
               new Alert(Alert.AlertType.INFORMATION, "充能完成").show();  
           }  
           student1.setScore(newValue);  
       });  
   });
   ```
