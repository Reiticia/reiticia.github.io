### fxml自定义标签（Builder和BuilderFactory）

* 通用的Person实体类
  
  ```java
  @Data  
  @AllArgsConstructor  
  @NoArgsConstructor  
  @ToString  
  public class Person {  
      private String name;  
      private int age;  
  }
  ```
  
  #### 第一种方式，普通对象
1. Builder类
  
   ```java
   /**  
   * 必须要有getter和setter方法，否则生成对象会报空指针  
   */
   @Getter  
   @Setter  
   public class PersonBuilder implements Builder<Person> {  
       private String name;  
       private int age;  
       @Override  
       public Person build() {  
           System.out.println("build");  
           return new Person(name, age);  
       }  
   }
   ```

2. BuilderFactory类
  
   ```java
   public class PersonBuilderFactory implements BuilderFactory {  
       private final JavaFXBuilderFactory javaFXBuilderFactory = new JavaFXBuilderFactory();  
       @Override  
       public Builder<?> getBuilder(Class<?> type) {  
           if (type == Person.class) {  
               System.out.println("返回Builder");  
               return new PersonBuilder();  
           }  
           return javaFXBuilderFactory.getBuilder(type);  
       }  
   }
   ```

3. fxml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?> 
    <?import java.util.ArrayList?>
    <?import com.reine.entity.Person?>  
    <ArrayList>  
        <Person name="张三" age="18"/>  
        <Person name="李四" age="19"/>  
        <Person name="王五" age="17"/>  
    </ArrayList>
    ```

4. 获取数据

    ```java
    public class Main extends Application {  
        public static void main(String[] args) {  
            launch(args);  
        }  
        @Override  
        public void start(Stage primaryStage) throws Exception {  
            FXMLLoader fxmlLoader = new FXMLLoader();  
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/data.fxml"));  
            fxmlLoader.setBuilderFactory(new PersonBuilderFactory());  
            ArrayList<Person> root = fxmlLoader.load();  
            System.out.println("root = " + root);  
            Platform.exit();  
        }  
    }
    ```

#### 第二种方式，Map对象

1. Builder类
  
   ```java
   public class PersonBuilderMap extends HashMap<String, Object> implements Builder<Person> {  
       private String name;  
       private int age;  
       @Override  
       public Object put(String key, Object value) {  
           System.out.println("Map-put:(" + key + "," + value + ")");  
           switch (key) {  
               case "name":  
                   this.name = String.valueOf(value);  
                   break;  
               case "age":  
                   this.age = Integer.parseInt(String.valueOf(value));  
                   break;  
               default:  
           }  
           return super.put(key, value);  
       }  
       @Override  
       public Person build() {  
           System.out.println("build");  
           return new Person(name, age);  
       }  
   }
   ```

2. BuilderFactory类
  
   ```java
   public class PersonBuilderFactoryMap implements BuilderFactory {  
       private final JavaFXBuilderFactory javaFXBuilderFactory = new JavaFXBuilderFactory();  
       @Override  
       public Builder<?> getBuilder(Class<?> type) {  
           if (type == Person.class) {  
               System.out.println("返回Builder");  
               return new PersonBuilderMap();  
           }  
           return javaFXBuilderFactory.getBuilder(type);  
       }  
   }
   ```

3. fxml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?> 
    <?import java.util.ArrayList?>
    <?import com.reine.entity.Person?> 
    <ArrayList>  
        <Person name="张三" age="18"/>  
        <Person name="李四" age="19"/>  
        <Person name="王五" age="17"/>  
    </ArrayList>
    ```

4. 获取数据
  
   ```java
   public class Main extends Application {  
       public static void main(String[] args) {  
           launch(args);  
       }  
       @Override  
       public void start(Stage primaryStage) throws Exception {  
           FXMLLoader fxmlLoader = new FXMLLoader();  
           fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/data.fxml"));  
           fxmlLoader.setBuilderFactory(new PersonBuilderFactoryMap());  
           ArrayList<Person> root = fxmlLoader.load();  
           System.out.println("root = " + root);  
           Platform.exit();  
       }  
   }
   ```