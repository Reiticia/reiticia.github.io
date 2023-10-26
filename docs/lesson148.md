---
lang: zh-CN
title: Shadow阴影效果
---


# Shadow阴影效果

* 创建阴影`Shadow shadow = new Shadow();`

* 通过叠加两个相同图层，但下面一层设置阴影效果来实现外阴影
  
    ```java
    Button button = new Button("button");  
    Label label = new Label("this is text.你好！");  
    Rectangle rectangle = new Rectangle(100, 100);  
    rectangle.setFill(Color.valueOf("#ff9999"));  
    Circle circle = new Circle(50);  
    circle.setFill(Color.valueOf("#996699"));  
    HBox box = new HBox(50);  
    box.setAlignment(Pos.CENTER);  
    box.getChildren().addAll(button, label, rectangle, circle);   
    box.getChildren().forEach(node -> {  
        node.setEffect(getEffect());  
    });  
    // 使用两个图层叠加产生阴影效果  
    Button button1 = new Button("button");  
    Label label1 = new Label("this is text.你好！");  
    Rectangle rectangle1 = new Rectangle(100, 100);  
    rectangle1.setFill(Color.valueOf("#ff9999"));  
    Circle circle1 = new Circle(50);  
    circle1.setFill(Color.valueOf("#996699"));  
    HBox box1 = new HBox(50);  
    box1.setAlignment(Pos.CENTER);  
    box1.getChildren().addAll(button1, label1, rectangle1, circle1);  
    AnchorPane root = new AnchorPane();  
    root.getChildren().addAll(box, box1);  
    AnchorPane.setTopAnchor(box, 110.0);  
    AnchorPane.setLeftAnchor(box, 110.0);  
    AnchorPane.setTopAnchor(box1, 100.0);  
    AnchorPane.setLeftAnchor(box1, 100.0);
    ```

![](../assets/Pasted%20image%2020220616100213.png)