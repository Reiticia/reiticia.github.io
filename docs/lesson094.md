### TableView合并列和加载Map类型数据

* 合并列
  
  ```java
  TableColumn<StudentProperty, Object> group = new TableColumn<>("基本信息");  
  group.getColumns().addAll(nameCol, ageCol);
  tableView.getColumns().add(group);  
  tableView.getColumns().add(scoreCol);  
  tableView.getColumns().add(isBoyCol);
  ```

  ![](../assets/Pasted%20image%2020220606074905.png)

* 加载map类型数据
  
  ```java
  // 创建两个泛型相同的map数据
  Map<String, SimpleStringProperty> map = new HashMap<>();  
  map.put("name", new SimpleStringProperty("A"));  
  map.put("age", new SimpleStringProperty("15"));  
  map.put("boolean", new SimpleStringProperty("true"));  
  Map<String, SimpleStringProperty> map1 = new HashMap<>();  
  map1.put("name", new SimpleStringProperty("B"));  
  map1.put("age", new SimpleStringProperty("14"));  
  map1.put("boolean", new SimpleStringProperty("false"));  
  // 创建可观察列表
  ObservableList<Map<String, SimpleStringProperty>> list1 = FXCollections.observableArrayList();  
  list1.addAll(map, map1);  
  // 创建tableView
  TableView<Map<String, SimpleStringProperty>> tableView1 = new TableView<>(list1);  
  tableView1.setLayoutX(100);  
  tableView1.setLayoutY(100);  
  // 构建列
  TableColumn<Map<String, SimpleStringProperty>, String> nameCol1 = new TableColumn<>("姓名");  
  // nameCol1.setCellValueFactory(cellData -> cellData.getValue().get("name"));  
  nameCol1.setCellValueFactory(new MapValueFactory("name"));  
  TableColumn<Map<String, SimpleStringProperty>, String> ageCol1 = new TableColumn<>("年龄");  
  // ageCol1.setCellValueFactory(cellData -> cellData.getValue().get("age"));  
  ageCol1.setCellValueFactory(new MapValueFactory("age"));  
  TableColumn<Map<String, SimpleStringProperty>, String> isBoyCol1 = new TableColumn<>("是男生");  
  // isBoyCol1.setCellValueFactory(cellData -> cellData.getValue().get("boolean"));  
  isBoyCol1.setCellValueFactory(new MapValueFactory("boolean"));  
  // 将列添加到表格中
  tableView1.getColumns().addAll(nameCol1, ageCol1, isBoyCol1);
  ```

![](../assets/Pasted%20image%2020220606075259.png)
