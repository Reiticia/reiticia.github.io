---
lang: zh-CN
title: TreeTableView
---

# TreeTableView

1. 装填数据
  
   ```java
   Data data1 = new Data("张三", 20, true);  
   Data data2 = new Data("李四", 30, false);  
   Data data3 = new Data("王五", 40, true);  
   Data data4 = new Data("赵六", 50, false);  
   Data data5 = new Data("钱七", 60, true);  
   Data data6 = new Data("孙八", 70, false);  
   Data data7 = new Data("周九", 80, true);  
   TreeItem<Data> root = new TreeItem<>(data1);  
   TreeItem<Data> item2 = new TreeItem<>(data2);  
   TreeItem<Data> item3 = new TreeItem<>(data3);  
   TreeItem<Data> item4 = new TreeItem<>(data4);  
   TreeItem<Data> item5 = new TreeItem<>(data5);  
   TreeItem<Data> item6 = new TreeItem<>(data6);  
   TreeItem<Data> item7 = new TreeItem<>(data7);  
   root.getChildren().addAll(item2, item3, item4);  
   item2.getChildren().addAll(item5, item6);  
   item3.getChildren().addAll(item7);  
   root.setExpanded(true);  
   item2.setExpanded(true);  
   item3.setExpanded(true);
   ```
   
2. 设置TreeTableView
  
   ```java
   TreeTableView<Data> view = new TreeTableView<>();  
   view.setLayoutX(100);  
   view.setLayoutY(100);  
   view.setRoot(root);  
   view.setPrefWidth(300);  
   // 平分列宽  
   view.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);  
   // 设置多选  
   view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);  
   // 设置单元格可选中  
   view.getSelectionModel().setCellSelectionEnabled(true);
   ```
   
3. 设置列
  
   ```java
   TreeTableColumn<Data, String> nameCol = new TreeTableColumn<>("姓名");  
   TreeTableColumn<Data, Number> ageCol = new TreeTableColumn<>("年龄");  
   TreeTableColumn<Data, Boolean> maleCol = new TreeTableColumn<>("布尔");  
   nameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));  
   ageCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("age"));  
   maleCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("male"));  
   // 加载列  
   view.getColumns().addAll(nameCol, ageCol, maleCol);
   ```
   
4. 事件监听
  
   ```java
   // 行单选事件  
   view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
       System.out.println("选中的行：" + newValue.getValue().getName());  
   });  
   // 行多选事件  
   view.getSelectionModel().getSelectedItems().addListener((InvalidationListener) observable -> {  
       ObservableList<TreeItem<Data>> list = (ObservableList<TreeItem<Data>>) observable;  
       System.out.printf("-----------选中的行数：%d----------------", list.size());  
       list.forEach(System.out::println);  
   });  
   // 单元格多选事件  
   view.getSelectionModel().getSelectedCells().addListener((InvalidationListener) observable -> {  
       ObservableList<TreeTablePosition<Data, ?>> list = (ObservableList<TreeTablePosition<Data, ?>>) observable;  
       System.out.printf("-----------选中的单元格数：%d----------------\n", list.size());  
       list.forEach(item -> {  
           // 获取每一个单元格  
           Object data = item.getTableColumn().getCellData(item.getRow());  
           System.out.printf("(%d,%d):%s\n", item.getRow(), item.getColumn(), data.toString());  
       });  
   });
   ```
