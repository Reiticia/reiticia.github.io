### Pagination分页器

* 创建分页器
  
  ```java
  Pagination pagination = new Pagination();
  ```

* 设置样式宽高位置
  
  ```java
  pagination.setStyle("-fx-background-color: yellow;");  
  pagination.setPrefWidth(200);  
  pagination.setPrefHeight(200);  
  pagination.setLayoutX(100);  
  pagination.setLayoutY(100);
  ```

* 设置最大页数`pagination.setPageCount(10);`

* 设置最大页码数量`pagination.setMaxPageIndicatorCount(5);`

* 设置最大页数为无限大`pagination.setPageCount(Pagination.INDETERMINATE);`

* 设置当前页码`pagination.setCurrentPageIndex(3);`

* 设置样式`pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);`
  效果图
  ![](../assets/Pasted%20image%2020220520073636.png)

* 设置当前页码变化监听器
  
  ```java
  pagination.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {  
      System.out.println(newValue.intValue());  
  });
  ```

* 设置每一页的效果
  
  ```java
  pagination.setPageFactory(param -> {  
      if (param == 0){  
          HBox hBox = new HBox();  
          hBox.setMaxWidth(100);  
          hBox.setMaxHeight(100);  
          hBox.setAlignment(Pos.CENTER);  
          hBox.setStyle("-fx-background-color: brown;");  
          hBox.getChildren().add(new Label("第一页"));  
          return hBox;  
      }  
      return new Button("Page " + param);  
  });
  ```
  
  效果图（默认样式）
  ![](../assets/Pasted%20image%2020220520073715.png)