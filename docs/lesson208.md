### 自定义组件

#### 封装方法返回节点

```java
private Node getView() {  
    Button button = new Button("button");  
    Button button1 = new Button("button1");  
    VBox vBox = new VBox(10);  
    vBox.setStyle("-fx-background-color: #ffffcc");  
    vBox.getChildren().addAll(button, button1);  
    return vBox;  
}
```

#### 继承节点重写layoutChildren

```java
public class MyNode extends VBox {  

    public MyNode(double spacing) {  
        super(spacing);  
    }  

    @Override  
    protected void layoutChildren() {  
        super.layoutChildren();  
        System.out.println("layoutChildren");  
        for (int i = 0; i < this.getChildren().size(); i++) {  
            int temp = i;  
            if (i % 2 == 0) {  
                Button node = (Button) this.getChildren().get(i);  
                node.setTranslateX(20);  
                node.setOnAction(event -> {  
                    System.out.println("button - " + temp);  
                });  
            }  
        }  
    }  
}
```