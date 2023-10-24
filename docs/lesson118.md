### fxml国际化

* 获取默认地区`Locale.getDefault()`

* 获取所有地区`Locale.getAvailableLocales()`

* 手动设置国家和语言`Locale.setDefault(new Locale("en", "US"));`
  
  #### fxml国际化
1. 加载fxml
   
   ```java
   FXMLLoader fxmlLoader = new FXMLLoader();  
   URL fxmlPath = Main.class.getClassLoader().getResource("fxml/sample.fxml");  
   fxmlLoader.setLocation(fxmlPath);  
   ResourceBundle bundle = ResourceBundle.getBundle("i18n/language");  
   fxmlLoader.setResources(bundle);  
   AnchorPane root = fxmlLoader.load();
   ```

2. 国际化配置文件
   *默认配置文件*`language.properties`
   
   ```properties
   value=def  
   value2=def2
   ```
   
   *中文配置文件*`language_zh.properties`
   
   ```properties
   value=按钮  
   value2=文本框
   ```
   
   *英文配置文件*`language_en.properties`
   
   ```properties
   value=button  
   value2=textField
   ```

3. fxml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>  
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.TextField?>  
<?import javafx.scene.layout.AnchorPane?>  
<?import javafx.scene.layout.HBox?>  
<AnchorPane xmlns="http://javafx.com/javafx"  
            xmlns:fx="http://javafx.com/fxml"  
            fx:controller="com.reine.controller.SampleController"  
            prefHeight="400.0" prefWidth="600.0">  
    <HBox spacing="10">  
        <Button text="%value"/>  
        <TextField text="%value2" />  
    </HBox>  

</AnchorPane>
```

4. 控制器

```java
public class SampleController implements Initializable {

    @Override  
    public void initialize(URL location, ResourceBundle resources) {  
        System.out.println(location.getPath());  
        System.out.println(resources);  
    }  

}
```

```

```
