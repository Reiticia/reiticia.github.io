### fxml的Controller

1. fxml文件
  
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>  
   <?import javafx.scene.control.Button?>  
   <?import javafx.scene.layout.AnchorPane?>  
   <?import javafx.scene.control.Label?>  
   <AnchorPane xmlns="http://javafx.com/javafx"  
               xmlns:fx="http://javafx.com/fxml"  
               fx:controller="com.reine.controller.Hello">  
       <children>  
           <Label fx:id="fxmllabel" text="textOfLabel" prefWidth="200" prefHeight="100" layoutX="100" layoutY="0"  
                  alignment="CENTER">  
           </Label>  
           <Button fx:id="fxmlbtn" text="hello world" prefWidth="200" prefHeight="100" layoutX="100" layoutY="100" onAction="#action">  
           </Button>  
       </children>  
   </AnchorPane>
   ```

2. 对于的Controller
  
   ```java
   public class HelloController {  
       @FXML  
       private Button fxmlbtn;  
       @FXML  
       private Label fxmllabel;  
       /**  
     * 初始化时调用  
     */
       @FXML  
       private void initialize() {  
           System.out.println("initialize");  
           System.out.println("fxmllabel.getText() = " + fxmllabel.getText());  
       }  
   
       @FXML  
       private void action(ActionEvent actionEvent) {  
           fxmllabel.setText(fxmlbtn.getText());  
       }  
   
       /**  
     * 方便与Main方法中获取组件  
     *  
     * @return  
     */  
       public Button getFxmlbtn() {  
           return fxmlbtn;  
       }  
   
       public Label getFxmllabel() {  
           return fxmllabel;  
       }  
   }
   ```

3. 程序入口类
  
   ```java
   public class Main extends Application {  
       public static void main(String[] args) {  
           launch(args);  
       }  
       @Override  
       public void start(Stage primaryStage) throws Exception {  
           FXMLLoader fxmlLoader = new FXMLLoader();  
           fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/hello.fxml"));  
           Pane root = fxmlLoader.load();  
           HelloController controller = fxmlLoader.getController();  
           Button button = controller.getFxmlbtn();  
           Label label = controller.getFxmllabel();  
           // 如果对fxml中的组件添加监听方法，则会覆盖fxml绑定于Controller里面的方法  
           button.setOnAction(event -> {  
               label.setText(button.getText() + "!!!");  
           });  
           Scene scene = new Scene(root);  
           primaryStage.setScene(scene);  
           primaryStage.setTitle("fxml的Controller");  
           primaryStage.setWidth(800);  
           primaryStage.setHeight(800);  
           primaryStage.show();  
       }  
   }
   ```