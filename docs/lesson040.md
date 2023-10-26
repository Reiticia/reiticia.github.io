---
lang: zh-CN
title: 使用setCellFactory自定义单元格（本节使用JDK9）
---


# 使用setCellFactory自定义单元格（本节使用JDK9）

## Label和ListCell

1. 创建Label
  
   ```java
   Label label = new Label();  
   HBox hBox1 = new HBox(10);  
   hBox1.setStyle("-fx-background-color: pink;");  
   hBox1.setAlignment(Pos.CENTER);  
   hBox1.setMaxWidth(200);  
   hBox1.setMaxHeight(200);  
   hBox1.getChildren().addAll(new Button("btn1"), new Button("btn2"));  
   label.setStyle("-fx-background-color: skyblue;");  
   label.setPrefWidth(250);  
   label.setPrefHeight(250);  
   label.setAlignment(Pos.CENTER);  
   label.setContentDisplay(ContentDisplay.CENTER);  
   // 此方法可以传入一个Node类型的变量
   label.setGraphic(hBox1);
   ```

2. 创建ListCell
  
   ```java
   ListCell<String> listCell = new ListCell<>();  
   // 下面一行代码让ListCell在JDK8环境下不报NullPointerException  
   // listCell.updateListView(new ListView<>());  
   listCell.setStyle("-fx-background-color: yellow;");  
   listCell.setPrefWidth(250);  
   listCell.setPrefHeight(250);  
   listCell.setAlignment(Pos.CENTER);  
   listCell.setContentDisplay(ContentDisplay.CENTER);  
   HBox hBox2 = new HBox(10);  
   hBox2.setStyle("-fx-background-color: pink;");  
   hBox2.setAlignment(Pos.CENTER);  
   hBox2.setMaxWidth(200);  
   hBox2.setMaxHeight(200);  
   hBox2.getChildren().addAll(new Button("btn1"), new Button("btn2"));  
   listCell.setGraphic(hBox2);
   ```

3. 创建自定义的ListCell
  
   1. 自定义ListCell类
     
      ```java
      class MyListCell<T> extends ListCell<T> {  
          @Override  
          protected void updateItem(T item, boolean empty) {  
              super.updateItem(item, empty);  
      
              HBox hBox2 = new HBox(10);  
              hBox2.setStyle("-fx-background-color: pink;");  
              hBox2.setAlignment(Pos.CENTER);  
              hBox2.setMaxWidth(200);  
              hBox2.setMaxHeight(200);  
              hBox2.getChildren().addAll(new Button(item.toString()), new Button(item.toString()));  
      
              this.setStyle("-fx-background-color: yellow;");  
              this.setPrefWidth(250);  
              this.setPrefHeight(250);  
              this.setAlignment(Pos.CENTER);  
              this.setContentDisplay(ContentDisplay.CENTER);  
              this.setGraphic(hBox2);  
          }  
      }
      ```
   
   2. 创建MyListCell
     
      ```java
      MyListCell1<String> myListCell = new MyListCell1<>();  
      myListCell.updateItem("hello", true);
      ```

4. 添加控件到布局中，调整位置，添加布局到场景，添加场景到舞台，调整舞台设置（省略）

   ![](../assets/Pasted%20image%2020220519135550.png)
   
## 泛型为String的ComboBox

1. 创建下拉列表
  
   ```java
   ComboBox<String> comboBox = new ComboBox<>();  
   comboBox.getItems().addAll("str1", "str2", "str3", "str4", "str5");  
   comboBox.setPrefWidth(200);
   ```

2. 自定义ListCell类
  
   ```java
   class MyListCell<T> extends ListCell<T> {  
       @Override  
       protected void updateItem(T item, boolean empty) {  
           super.updateItem(item, empty);  
           if (!empty){  
               HBox hBox2 = new HBox(10);  
               hBox2.setStyle("-fx-background-color: pink;");  
               hBox2.setAlignment(Pos.CENTER);  
               hBox2.getChildren().addAll(new Button(item.toString()), new Button(item.toString()));  
               this.setAlignment(Pos.CENTER);  
               this.setContentDisplay(ContentDisplay.CENTER);  
               this.setGraphic(hBox2);  
           }  
       }  
   }
   ```

3. 设置自定义单元格
  
   ```java
   comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {  
       @Override  
       public ListCell<String> call(ListView<String> param) {  
           MyListCell<String> listCell = new MyListCell<>();  
           return listCell;  
       }  
   });
   ```

4. 添加控件到布局中，调整位置，添加布局到场景，添加场景到舞台，调整舞台设置（省略）

   ![](../assets/Pasted%20image%2020220519140002.png)
   
## 泛型为Student的ComboBox

1. 创建5个Student对象
  
   ```java
   Student student1 = new Student("张三", 86, "语文");  
   Student student2 = new Student("李四", 94, "数学");  
   Student student3 = new Student("王五", 83, "英语");  
   Student student4 = new Student("赵六", 75, "物理");  
   Student student5 = new Student("钱七", 64, "化学");
   ```

2. 创建下拉列表
  
    ```java
    ComboBox<Student> comboBox = new ComboBox<>();  
    comboBox.getItems().addAll(student1, student2, student3, student4, student5);  
    comboBox.setPrefWidth(200);
    ```

3. 自定义单元格
  
    ```java
    comboBox.setCellFactory(new Callback<>() {  
        @Override  
        public ListCell<Student> call(ListView<Student> param) {  
            System.out.println(Color.BLUE + "call");  
            // 匿名内部类  
            ListCell<Student> listCell = new ListCell<>() {  
                @Override  
                protected void updateItem(Student item, boolean empty) {  
                    super.updateItem(item, empty);  
                    if (!empty) {  
                        HBox hBox = new HBox(10);  
                        ImageView imageView = new ImageView("/images/logo.png");  
                        imageView.setFitWidth(20);  
                        imageView.setFitHeight(20);  
                        Label name = new Label(item.getName());  
                        Label score = new Label(item.getScore() + "");  
                        Label subject = new Label(item.getSubject());  
                        hBox.getChildren().addAll(imageView, name, new Separator(), score, new Separator(), subject);  
                        setGraphic(hBox);  
                    }  
                }  
            };  
            return listCell;  
        }  
    });
    ```

4. 设置自定义字符串转换器
  
    ```java
    comboBox.setConverter(new StringConverter<>() {  
        @Override  
        public String toString(Student object) {  
            System.out.println(Color.YELLOW + "toString");  
            if (object == null) {  
                return "";  
            }  
            String value = object.getName() + ":" + object.getScore() + ":" + object.getSubject();  
            return value;  
        }  
        // 在输入框中输入文本按下回车键时，调用此方法  
        @Override  
        public Student fromString(String string) {  
            return null;  
        }  
    });
    ```

5. 添加控件到布局中，调整位置，添加布局到场景，添加场景到舞台，调整舞台设置（省略）
  
    ![](../assets/Pasted%20image%2020220519140419.png)
