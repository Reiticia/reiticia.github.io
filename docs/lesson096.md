### TableView列宽与排序

#### 列宽

* 设置每列宽度相同（列拉长时挤占空间）`tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);`
* 限制用户无法改变列宽度`tableView.setColumnResizePolicy(param -> true);`
  
  #### 排序
* 是否允许排序（不允许）`nameCol.setSortable(false);`
* 排序优先级`tableView.getSortOrder().addAll(nameCol, ageCol, scoreCol, isBoyCol);`
* 自定义排序
  
  ```java
  tableView.setSortPolicy(new Callback<TableView<StudentProperty>, Boolean>() {  
      @Override  
      public Boolean call(TableView<StudentProperty> param) {  
          param.getColumns().forEach(col -> {  
              // 姓名，升序  
              if (col.getText().equals("姓名") && col.getSortType() == TableColumn.SortType.ASCENDING) {  
                  // 设置图标  
                  col.setSortNode(new Label("↑"));  
                  System.out.println("姓名升序");  
                  param.getItems().sort(Comparator.comparing(StudentProperty::getName));  
              }  
              // 姓名，降序  
              if (col.getText().equals("姓名") && col.getSortType() == TableColumn.SortType.DESCENDING) {  
                  col.setSortNode(new Label("↓"));  
                  System.out.println("姓名降序");  
                  param.getItems().sort(((o1, o2) -> o2.getName().compareTo(o1.getName())));  
              }  
          });  
          // 如果返回false则会禁用排序  
          return true;  
      }  
  });
  ```
* 单独定义某列，升序
  
  ```java
  nameCol.setComparator(((s1, s2) -> {  
      System.out.println("单独定义名称列，名称升序");  
      return s1.compareTo(s2);  
  }));
  ```
* 点击按钮进行排序
  
  ```java
  button.setOnAction(event -> {  
      // 名称降序  
      nameCol.setSortType(TableColumn.SortType.DESCENDING);  
      // 使用数据源排序  
      tableView.getItems().sort((o1, o2) -> {  
          System.out.println("使用数据源排序");  
          return o1.getName().compareTo(o2.getName());  
      });  
  });
  ```
