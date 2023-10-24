### Adaptive layout自适应布局

#### Java代码方式实现

```java
private Pane getViewJava(){  
    AnchorPane root = new AnchorPane();  
    root.setPrefSize(600, 400);  
    VBox pane = new VBox();  
    root.getChildren().add(pane);  
    StackPane top = new StackPane();  
    top.setStyle("-fx-background-color: #ffffcc");  
    top.prefWidthProperty().bind(root.widthProperty());  
    top.setPrefHeight(50);  
    StackPane bottom = new StackPane();  
    bottom.setStyle("-fx-background-color: #ccffff");  
    bottom.prefWidthProperty().bind(root.widthProperty());  
    bottom.setPrefHeight(50);  
    HBox middle = new HBox();  
    middle.setStyle("-fx-background-color: #ffcccc");  
    middle.prefWidthProperty().bind(root.widthProperty());  
    DoubleBinding h = root.heightProperty().subtract(top.getPrefHeight()).subtract(bottom.getPrefHeight());  
    middle.prefHeightProperty().bind(h);  
    StackPane left = new StackPane();  
    left.setStyle("-fx-background-color: #ff9999");  
    left.prefHeightProperty().bind(middle.prefHeightProperty());  
    left.prefWidthProperty().bind(middle.prefWidthProperty().multiply(0.3));  
    StackPane right = new StackPane();  
    right.setStyle("-fx-background-color: #996699");  
    right.prefHeightProperty().bind(middle.prefHeightProperty());  
    right.prefWidthProperty().bind(middle.prefWidthProperty().multiply(0.7));  
    middle.getChildren().addAll(left,right);  
    pane.getChildren().addAll(top, middle, bottom);  
    return root;  
}
```

![](../assets/VeryCapture_20220621212003.gif)

#### Fxml方式实现

```xml
<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8.0.171"  
            xmlns:fx="http://javafx.com/fxml/1" fx:id="root">  

    <Label layoutX="209.0" layoutY="127.0" text="Hello World!" fx:id="label">  
        <font>  
            <Font size="30.0"/>  
        </font>  
    </Label>  
    <Button layoutY="200.0" text="${label.text}" prefWidth="${root.width}"/>  

</AnchorPane>
```

![](../assets/VeryCapture_20220621212138.gif)