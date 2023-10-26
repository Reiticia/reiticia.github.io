---
lang: zh-CN
title: AnchorPane 布局（绝对布局）
---


# AnchorPane 布局（绝对布局）

* 创建AnchorPane 布局`AnchorPane ap = new AnchorPane();`

* 设置样式`ap.setStyle("-fx-background-color: red;");`

* 设置鼠标点击事件
  
    ```java
    ap.setOnMouseClicked(new EventHandler<MouseEvent>() {  
        @Override  
        public void handle(MouseEvent event) {  
            System.out.println("click");  
        }  
    });
    ```

* 添加子组件和设置子组件位置
  
    ```java
    Button button = new Button("btn0");  
    Button button1 = new Button("btn1");  
    // 设置内边距，单独设置无效，需配合下面四行中的任意几行才有效果
    ap.setPadding(new Insets(10, 10, 10, 10));
    // 管理子组件的位置，当父组件与子组件的设置冲突时，子组件设置无效
    AnchorPane.setTopAnchor(button, 10.0);  
    AnchorPane.setLeftAnchor(button, 10.0);  
    AnchorPane.setBottomAnchor(button, 10.0);  
    AnchorPane.setRightAnchor(button, 10.0);  
    // 无效设置  
    button.setLayoutX(20);  
    button.setLayoutY(20);  
    ap.getChildren().addAll(button, button1);
    ```

    ![](../assets/Pasted%20image%2020220512111653.png)

* 添加group布局
  
    ```java
    Button button = new Button("btn0");  
    Button button1 = new Button("btn1");  
    Group group1 = new Group();  
    group.getChildren().add(button);  
    group1.getChildren().add(button1);  
    ap.getChildren().addAll(group, group1);  
    AnchorPane.setTopAnchor(group, 10.0);  
    AnchorPane.setBottomAnchor(group1, 10.0);
    ```

    ![](../assets/Pasted%20image%2020220512112100.png)

* 添加AnchorPane布局
      
    ```java
    // 创建两个AnchorPane布局
    AnchorPane anchorPane = new AnchorPane();  
    anchorPane.setStyle("-fx-background-color: green;");  
    AnchorPane anchorPane1 = new AnchorPane();  
    anchorPane1.setStyle("-fx-background-color: yellow;");  
    anchorPane.getChildren().add(anchorPane1);  
    primaryStage.setScene(new Scene(anchorPane));  
    primaryStage.setTitle("JavaFx");  
    primaryStage.setHeight(300);  
    primaryStage.setWidth(300);  
    primaryStage.show();  
    anchorPane.setTopAnchor(anchorPane1, 0.0);  
    anchorPane.setBottomAnchor(anchorPane1, anchorPane.getHeight() / 2 - anchorPane1.getHeight() / 2);  
    anchorPane.setLeftAnchor(anchorPane1, 0.0);  
    anchorPane.setRightAnchor(anchorPane1, anchorPane.getWidth() / 2 - anchorPane1.getWidth() / 2);
    ```

* 添加宽高属性监听器
      
    ```java
    anchorPane.heightProperty().addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
            anchorPane.setBottomAnchor(anchorPane1, anchorPane.getHeight() / 2);  
        }  
    });  
    anchorPane.widthProperty().addListener(new ChangeListener<Number>() {  
        @Override  
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {  
            anchorPane.setRightAnchor(anchorPane1, anchorPane.getWidth() / 2);  
        }  
    });
    ```
    
    ![](../assets/VeryCapture_20220512114447.gif)