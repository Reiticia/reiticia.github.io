### ListView

* 设置每一个单元格的高度`listView.setFixedCellSize(50);`
* 阻止获得焦点`listView.setFocusTraversable(false);`
* 索引为2的元素默认获取焦点（可以和设置选中效果共存）`listView.getFocusModel().focus(2);`
* 选中索引为0的元素
  效果图
  ![](../assets/Pasted%20image%2020220603130603.png)
* 自定义Callback用于展示和修改listView
  
  ```java
  Callback<ListView<Data>, ListCell<Data>> cell = TextFieldListCell.forListView(new StringConverter<Data>() {  
      @Override  
      public String toString(Data object) {  
          if (object == null) {  
              return "";  
          }  
          return object.getName();  
      }  
      @Override  
      public Data fromString(String string) {  
          return new Data(string);  
      }  
  });  
  listView.setCellFactory(cell);
  ```
* 设置选中要进行编辑索引为2的数据`listView.edit(2);`
* 开始修改监听
  
  ```java
  listView.setOnEditStart(new EventHandler<ListView.EditEvent<Data>>() {  
      @Override  
      public void handle(ListView.EditEvent<Data> event) {  
          System.out.println("开始编辑");  
          System.out.println("event.getIndex() = " + event.getIndex());  
          System.out.println("event.getNewValue() = " + event.getNewValue());  
      }  
  });
  ```
* 取消编辑监听==当前选中项输入框被移除是调用，也就是不管有没有条件数据都会调用==
  
  ```java
  listView.setOnEditCancel(event -> {  
      System.out.println("取消编辑");  
  });
  ```
* 完成编辑监听==使用该方法时需要手动设置新数据，该方法声明后会导致cell中的fromString方法失效==
  
  ```java
  listView.setOnEditCommit(event -> {  
      System.out.println("完成编辑");  
      System.out.println("event.getNewValue().getName() = " + event.getNewValue().getName());  
      // 设置新数据  
      observableList.set(event.getIndex(), event.getNewValue());  
  });
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220603134357.png)
  
  #### 其他几种编辑效果
* ComboBoxListCell
  
  ```java
  Callback<ListView<Data>, ListCell<Data>> cell = ComboBoxListCell.forListView(new StringConverter<Data>() {  
      @Override  
      public String toString(Data object) {  
          return object.getName();  
      }  
      @Override  
      public Data fromString(String string) {  
          return new Data(string);  
      }  
  }, new Data("F"), new Data("G"));
  listView.setCellFactory(cell);
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220603134738.png)
* 传入可观察列表
  
  ```java
  ObservableList<Data> observableList1 = FXCollections.observableArrayList(observableList.subList(0, observableList.size()));  
  Callback<ListView<Data>, ListCell<Data>> cell = ComboBoxListCell.forListView(new StringConverter<Data>() {  
      @Override  
      public String toString(Data object) {  
          return object.getName();  
      }  
      @Override  
      public Data fromString(String string) {  
          return new Data(string);  
      }  
  }, observableList1);
  listView.setCellFactory(cell);
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220603135035.png)
* ChoiceBoxListCell
  
  ```java
  ObservableList<Data> observableList1 = FXCollections.observableArrayList(observableList.subList(0, observableList.size()));  
  Callback<ListView<Data>, ListCell<Data>> cell = ChoiceBoxListCell.forListView(new StringConverter<Data>() {  
      @Override  
      public String toString(Data object) {  
          return object.getName();  
      }  
      @Override  
      public Data fromString(String string) {  
          return new Data(string);  
      }  
  }, observableList1);
  listView.setCellFactory(cell);
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220603135224.png)
* CheckBoxListCell（设置除了B默认选中）==使用此方法进行设置可以不用将listView设置为可编辑==
  
  ```java
  ObservableList<Data> observableList1 = FXCollections.observableArrayList(observableList.subList(0, observableList.size()));  
  Callback<ListView<Data>, ListCell<Data>> cell = CheckBoxListCell.forListView(new Callback<Data, ObservableValue<Boolean>>() {  
      @Override  
      public ObservableValue<Boolean> call(Data param) {  
          SimpleBooleanProperty sbp = new SimpleBooleanProperty(true);  
          if (param.getName().equals("B")) {  
              sbp.set(false);  
          }  
          return sbp;  
      }  
  }, new StringConverter<Data>() {  
      @Override  
      public String toString(Data object) {  
          return object.getName();  
      }  
      @Override  
      public Data fromString(String string) {  
          return new Data(string);  
      }  
  });  
  listView.setCellFactory(cell);
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220603135456.png)