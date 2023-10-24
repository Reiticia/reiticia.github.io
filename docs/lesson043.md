### ColorPicker和DatePicker

#### ColorPicker

* 创建ColorPicker
  
  ```java
  ColorPicker colorPicker = new ColorPicker(Color.RED);
  ```

* 点击事件
  
  ```java
  colorPicker.setOnAction(event -> {  
    System.out.println("click the color picker");  
  });
  ```

* 属性改变监听事件
  
  ```java
  colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {  
      System.out.println("oldValue = " + oldValue);  
      System.out.println("red = " + newValue.getRed());  
      System.out.println("green = " + newValue.getGreen());  
      System.out.println("blue = " + newValue.getBlue());  
      String value = newValue.toString().substring(2);  
      System.out.println("newValue.toString() = " + newValue);  
      anchorPane.setStyle("-fx-background-color: #" + value + ";");  
  });
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220519203606.png)
  
  #### DatePicker

* 创建DatePicker
  
  ```java
  DatePicker datePicker = new DatePicker(LocalDate.now());
  ```

* 设置不可编辑
  
  ```java
  datePicker.setEditable(false);
  ```

* 属性改变监听事件
  
  ```java
  datePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
      if (newValue == null) {
          return;
      }
      System.out.println("newValue.getYear() = " + newValue.getYear());
      System.out.println("newValue.getMonth() = " + newValue.getMonth().getValue());
      System.out.println("newValue.getDayOfMonth() = " + newValue.getDayOfMonth());
      System.out.println("newValue.getDayOfWeek() = " + newValue.getDayOfWeek().getValue());
      System.out.println("newValue.getDayOfYear() = " + newValue.getDayOfYear());
  }));
  ```

* 展示日期
  
  ```java
  datePicker.setConverter(new StringConverter<LocalDate>() {  
      @Override  
      public String toString(LocalDate object) {  
          if (object == null) {  
              return null;  
          }  
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
          return object.format(formatter);  
      }  
      @Override  
      public LocalDate fromString(String string) {  
          return null;  
      }  
  });
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220519203906.png)

* 修改默认日期格式
  
  ```java
  datePicker.setDayCellFactory(param -> {  
      DateCell dateCell = new DateCell() {  
          @Override  
          public void updateItem(LocalDate item, boolean empty) {  
              super.updateItem(item, empty);  
              if (!empty) {  
                  ImageView imageView = new ImageView("/images/logo.png");  
                  imageView.setFitWidth(20);  
                  imageView.setFitHeight(20);  
                  this.setText("");  
                  this.setGraphic(imageView);  
              }  
          }  
      };  
      return dateCell;  
  });
  ```
  
  效果图
  ![](../assets/Pasted%20image%2020220519203938.png)