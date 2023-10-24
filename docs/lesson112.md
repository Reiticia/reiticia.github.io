### fxml基本编写

1. myfxml.fxml文件

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>  
    <?import javafx.scene.layout.*?>
    <?import javafx.scene.control.Button?>  

    <AnchorPane xmlns="http://javafx.com/javafx">  
        <children>  
            <Button id="fxmlbtn" text="fxmlButton" prefHeight="100" prefWidth="100">  
                <AnchorPane.topAnchor>100.0</AnchorPane.topAnchor>  
                <AnchorPane.leftAnchor>100.0</AnchorPane.leftAnchor>  
            </Button>  
        </children>  
    </AnchorPane>
    ```

2. LoadFxml.java文件
  
   ```java
   public class LoadFxml extends Application {  
       public static void main(String[] args) {  
           launch(args);  
       }  
   
       @Override  
       public void start(Stage primaryStage) throws Exception {  
           FXMLLoader fxmlLoader = new FXMLLoader();  
           fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("com/reine/fxml/myfxml.fxml"));  
           AnchorPane root = fxmlLoader.load();  
           Scene scene = new Scene(root);  
           primaryStage.setScene(scene);  
           primaryStage.setTitle("fxml");  
           primaryStage.setWidth(800);  
           primaryStage.setHeight(800);  
           primaryStage.show();  
   
           Button btn = (Button) root.lookup("#fxmlbtn");  
           btn.setOnAction(event -> {  
               System.out.println("btn.getText() = " + btn.getText());  
           });  
       }  
   }
   ```