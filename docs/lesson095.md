---
lang: zh-CN
title: TableView选择模式与监听
---


# TableView选择模式与监听

* 设置选择性显示或隐藏某列`tableView.setTableMenuButtonVisible(true);`

* 设置每列宽度相同
  
  ```java
  double width = tableView.getPrefWidth() / tableView.getColumns().size();  
  for (TableColumn<StudentProperty, ?> col : tableView.getColumns()) {  
      col.setPrefWidth(width);  
  }
  ```

* 隐藏某列`isBoyCol.setVisible(false);`

* 设置滚动到某行`tableView.scrollTo(student11);`

* 设置滚动到某列`tableView.scrollToColumnIndex(2);`

* 设置单元格尺寸`tableView.setFixedCellSize(60);`

* 设置可编辑`tableView.setEditable(true);`

* 设置每一列的显示效果
  
  ```java
  nameCol.setCellFactory(TextFieldTableCell.forTableColumn());  
  ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {  
      @Override  
      public String toString(Number object) {  
          if (object == null) {  
              return null;  
          }  
          return object.toString();  
      }  
      @Override  
      public Number fromString(String string) {  
          // 正则匹配整数  
          if (!string.matches("\\d+")) {  
              return null;  
          }  
          return Integer.parseInt(string);  
      }  
  }));  
  scoreCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {  
      @Override  
      public String toString(Number object) {  
          if (object == null) {  
              return null;  
          }  
          return object.toString();  
      }  
      @Override  
      public Number fromString(String string) {  
          // 正则匹配小数  
          if (!string.matches("\\d+.?\\d*")) {  
              return null;  
          }  
          return Double.parseDouble(string);  
      }  
  }));  
  // 如果值为true，则显示为男，否则为女  
  isBoyCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Boolean>() {  
      @Override  
      public String toString(Boolean object) {  
          if (object == null) {  
              return null;  
          }  
          return object ? "男" : "女";  
      }  
      @Override  
      public Boolean fromString(String string) {  
          return string.equals("男");  
      }  
  }));
  ```

* 设置多选`tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);`

* 选中项发生改变监听（行）
  
  ```java
  tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue.getName()));
  ```

* 设置每一个表格的单元格可以被单独选中`tableView.getSelectionModel().setCellSelectionEnabled(true);`

* 选中项发生改变监听（单元格）
  
  ```java
  tableView.getSelectionModel().getSelectedCells().addListener((InvalidationListener) observable -> {  
      ObservableList<TablePosition<StudentProperty, ?>> obs = (ObservableList<TablePosition<StudentProperty, ?>>) observable;  
      obs.forEach(item -> {  
          System.out.print("行 = " + item.getRow() + ", 列 = " + item.getColumn());  
          // 获取该单元格数据  
          System.out.println(", 数据 = " + item.getTableColumn().getCellData(item.getRow()));  
      });  
      System.out.println("------------------------------");  
  });
  ```

* 获取所有选中项`tableView.getSelectionModel().getSelectedItems();`

* 选中某一格`tableView.getSelectionModel().select(2, nameCol);`

* 选中选中单元格左边的一格，如果是单选则会切换选中，多选则会追加选中（1格）`tableView.getSelectionModel().selectLeftCell();`

* 选中选中行的上面一行，如果是单选则会切换选中，多选则会追加选中（1行）`tableView.getSelectionModel().selectPrevious();`

* 聚焦某行`tableView.getFocusModel().focus(2);`

* 聚焦某单元格`tableView.getFocusModel().focus(2, nameCol);`