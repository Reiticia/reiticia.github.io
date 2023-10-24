### fxml中标签语法

* 定义变量，以供其他组件引用
  
```xml
<fx:define>  
    <ToggleGroup fx:id="group"/>  
    <Insets fx:id="margin" top="10" left="10" bottom="10" right="10"/>  
    <Button fx:id="btn" text="button"/>  
</fx:define>
```

* 设置单选组

```xml
<!--引用fx:define中对于id的单选组-->  
<RadioButton text="A" toggleGroup="$group"/>  
<RadioButton text="B" toggleGroup="$group"/>  
<RadioButton text="C" toggleGroup="$group"/>
```

* 设置内边距
  
```xml
<!--引用fx:define中对于id中的值-->  
<Button text="hello" HBox.margin="$margin"/>  
<Button text="world" HBox.margin="$margin"/>
```

* 引用组件

```xml
<!--引用fx:define中的组件-->  
<fx:reference source="btn"/>
```

* 引用其他fxml文件

```java
<!--包含其他fxml文件-->  
<fx:include source="other.fxml"/>
```

* 引用其他组件的对应属性

```xml
<Button fx:id="btn1" AnchorPane.topAnchor="400.0" text="btn1" prefWidth="200"/>  
<!--引用对应id中的对应属性-->
<Button AnchorPane.topAnchor="500.0" text="btn2" prefWidth="${btn1.prefWidth}"/>
```