### ListView关于五种数据类型的加载

#### 普通数据类型（以String为例）

1. 添加数据到ListView中
  
   ```java
   ListView<String> listView = new ListView<>();  
   listView.setPrefWidth(300);  
   listView.setPrefHeight(300);  
   listView.setLayoutX(100);  
   listView.setLayoutY(100);  
   ObservableList<String> observableList = listView.getItems();  
   observableList.add("data - a");  
   observableList.add("data - v");  
   observableList.add("data - s");  
   observableList.add("data - e");  
   observableList.add("data - x");  
   observableList.add("data - n");
   ```

2. 操作observableList
  
   ```java
   // 修改指定位置的数据（更新界面）
   observableList.set(0,"dasdasda");  
   // 在指定位置添加数据（更新界面）
   observableList.add(0, "dadasdasd");  
   // 删除指定位置的数据（更新界面）
   observableList.remove(0 + 1);  
   // 将可观察列表中的数据按顺序排序（2种缩写形式） （更新界面） 
   observableList.sort(String::compareTo);  
   observableList.sort(Comparator.naturalOrder());  
   // 将可观察列表中的数据按倒序排序（更新界面）
   observableList.sort(Comparator.reverseOrder());
   ```
   
   #### 监听数据类型（SimpleXXXProperty）
   
   ###### 通过listView获取可观察列表，往可观察列表里添加数据==使用这种发送当某条具体数据的内容发生改变时，界面不会刷新==

3. 添加数据到ListView中
  
   ```java
   ListView<SimpleStringProperty> listView = new ListView<>();  
   listView.setPrefWidth(300);  
   listView.setPrefHeight(300);  
   listView.setLayoutX(100);  
   listView.setLayoutY(100);  
   SimpleStringProperty dataAProperty = new SimpleStringProperty("data - a");  
   SimpleStringProperty dataVProperty = new SimpleStringProperty("data - v");  
   SimpleStringProperty dataSProperty = new SimpleStringProperty("data - s");  
   SimpleStringProperty dataEProperty = new SimpleStringProperty("data - e");  
   SimpleStringProperty dataXProperty = new SimpleStringProperty("data - x");  
   SimpleStringProperty dataNProperty = new SimpleStringProperty("data - n");  
   // 获得listView创建的默认可观察列表  
   ObservableList<SimpleStringProperty> observableList = listView.getItems();  
   observableList.add(dataAProperty);  
   observableList.add(dataVProperty);  
   observableList.add(dataSProperty);  
   observableList.add(dataEProperty);  
   observableList.add(dataXProperty);  
   observableList.add(dataNProperty);
   ```

4. 操作observableList或具体某个Property属性
  
   ```java
   // （更新界面）
   observableList.add(new SimpleStringProperty("data - o")); 
   // （更新界面）
   observableList.set(0,new SimpleStringProperty("data - u"));  
   // 使用listView生成的observerList的数据进行数据内容更新时，界面不会更新，但数据被修改了（不更新界面）
   dataAProperty.set("data - u");  
   System.out.println("dataAProperty.get() = " + dataAProperty.get());  
   // 刷新listView，强制更新界面  
   listView.refresh();
   ```
   
   ###### 创建可观察列表，传入Callback==使用这种发送当某条具体数据的内容发生改变是，界面中对应数据会被修改==

5. 自定义可观察列表
  
   ```java
   ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {  
       @Override  
       public Observable[] call(SimpleStringProperty param) {  
           System.out.println("初始化数据");  
           return new SimpleStringProperty[]{param};  
       }  
   });  
   // 使用自定义列表  
   ListView<SimpleStringProperty> listView = new ListView<>(list);
   ```

6. 添加数据到list中
  
   ```java
   // 使用自定义列表  
   ListView<SimpleStringProperty> listView = new ListView<>(list);
   listView.setPrefWidth(300);  
   listView.setPrefHeight(300);  
   listView.setLayoutX(100);  
   listView.setLayoutY(100);  
   SimpleStringProperty dataAProperty = new SimpleStringProperty("data - a");  
   SimpleStringProperty dataVProperty = new SimpleStringProperty("data - v");  
   SimpleStringProperty dataSProperty = new SimpleStringProperty("data - s");  
   SimpleStringProperty dataEProperty = new SimpleStringProperty("data - e");  
   SimpleStringProperty dataXProperty = new SimpleStringProperty("data - x");  
   SimpleStringProperty dataNProperty = new SimpleStringProperty("data - n");  
   // 获得listView中设置的可观察列表，即list
   ObservableList<SimpleStringProperty> observableList = listView.getItems();  
   observableList.add(dataAProperty);  
   observableList.add(dataVProperty);  
   observableList.add(dataSProperty);  
   observableList.add(dataEProperty);  
   observableList.add(dataXProperty);  
   observableList.add(dataNProperty);
   ```

7. 操作observableList或具体某个Property属性
  
   ```java
   // （更新界面）
   observableList.add(new SimpleStringProperty("data - o")); 
   // （更新界面）
   observableList.set(0,new SimpleStringProperty("data - u"));  
   // （更新界面）
   dataAProperty.set("data - u");  
   System.out.println("dataAProperty.get() = " + dataAProperty.get());  
   ```
   
   #### 普通对象数据类型（JavaBean）

8. 实体类
  
   ```java
   public class Data {  
       private String name;  
       private int age;  
   
       public Data(String name, int age) {  
           this.name = name;  
           this.age = age;  
       }  
   
       public String getName() {  
           return name;  
       }  
   
       public void setName(String name) {  
           this.name = name;  
       }  
   
       public int getAge() {  
           return age;  
       }  
   
       public void setAge(int age) {  
           this.age = age;  
       }  
   }
   ```

9. 添加数据到ListView中
  
   ```java
   Data data1 = new Data("张三", 19);  
   Data data2 = new Data("李四", 20);  
   Data data3 = new Data("王五", 23);  
   Data data4 = new Data("赵六", 22);  
   Data data5 = new Data("钱七", 21);  
   // 使用自定义列表  
   ListView<Data> listView = new ListView<>();  
   listView.setPrefWidth(300);  
   listView.setPrefHeight(300);  
   listView.setLayoutX(100);  
   listView.setLayoutY(100);  
   ObservableList<Data> observableList = listView.getItems();  
   observableList.add(data1);  
   observableList.add(data2);  
   observableList.add(data3);  
   observableList.add(data4);  
   observableList.add(data5);
   ```

10. 操作observableList或某个对象属性
  
    ```java
    //（更新界面）
    observableList.add(new Data("reine",20));  
    //（更新界面）
    observableList.remove(0);  
    //（更新界面）
    observableList.set(0, new Data(observableList.get(0).getName(), 100));  
    //（不更新界面）
    data1.setName("REINE");  
    listView.refresh();
    ```
    
    #### 属性为Property数据类型的JavaBean数据类型

11. 实体类
  
    ```java
    public class DataPro {  
        private SimpleStringProperty name = new SimpleStringProperty();  
        private SimpleIntegerProperty age = new SimpleIntegerProperty();  
    
        public DataPro(String name, int age) {  
            this.name.set(name);  
            this.age.set(age);  
        }  
    
        public String getName() {  
            return name.get();  
        }  
    
        public SimpleStringProperty nameProperty() {  
            return name;  
        }  
    
        public void setName(String name) {  
            this.name.set(name);  
        }  
    
        public int getAge() {  
            return age.get();  
        }  
    
        public SimpleIntegerProperty ageProperty() {  
            return age;  
        }  
    
        public void setAge(int age) {  
            this.age.set(age);  
        }  
    }
    ```

12. 添加数据到ListView中
  
    ```java
    DataPro data1 = new DataPro("张三", 19);  
    DataPro data2 = new DataPro("李四", 20);  
    DataPro data3 = new DataPro("王五", 23);  
    DataPro data4 = new DataPro("赵六", 22);  
    DataPro data5 = new DataPro("钱七", 21);  
    // 自定义可观察列表
    ObservableList<DataPro> list = FXCollections.observableArrayList(new Callback<DataPro, Observable[]>()  
        @Override  
        public Observable[] call(DataPro param) {  
            // 当对象中任意一个属性改变时都会检测到  
            Observable[] observables = new Observable[2];  
            observables[0] = param.nameProperty();  
            observables[1] = param.ageProperty();  
            return observables;  
        }  
    });  
    // 使用自定义列表  
    ListView<DataPro> listView = new ListView<>(list);  
    listView.setPrefWidth(300);  
    listView.setPrefHeight(300);  
    listView.setLayoutX(100);  
    listView.setLayoutY(100);  
    ObservableList<DataPro> observableList = listView.getItems();  
    observableList.add(data1);  
    observableList.add(data2);  
    observableList.add(data3);  
    observableList.add(data4);  
    observableList.add(data5);
    ```

13. 操作observableList或某个对象属性
  
    ```java
    //（更新界面）
    observableList.set(0,new DataPro("REINE",20));  
    //（更新界面）
    data1.setName("REINE");
    ```
    
    #### 属性既有普通数据类型又有Property的JavaBean数据类型

14. 实体类
  
    ```java
    public class DataNP {  
        private String name;  
        private SimpleIntegerProperty age = new SimpleIntegerProperty();  
    
        public DataNP(String name, int age) {  
            this.name = name;  
            this.age.set(age);  
        }  
    
        public String getName() {  
            return name;  
        }  
    
        public void setName(String name) {  
            this.name = name;  
        }  
    
        public int getAge() {  
            return age.get();  
        }  
    
        public SimpleIntegerProperty ageProperty() {  
            return age;  
        }  
    
        public void setAge(int age) {  
            this.age.set(age);  
        }  
    }
    ```

15. 添加数据到ListView中
  
    ```java
    DataNP data1 = new DataNP("张三", 19);  
    DataNP data2 = new DataNP("李四", 20);  
    DataNP data3 = new DataNP("王五", 23);  
    DataNP data4 = new DataNP("赵六", 22);  
    DataNP data5 = new DataNP("钱七", 21);  
    ObservableList<DataNP> list = FXCollections.observableArrayList(new Callback<DataNP, Observable[]>() {  
        @Override  
        public Observable[] call(DataNP param) {  
            // 将参数中所有Property属性返回（1个）  
            return new SimpleIntegerProperty[]{param.ageProperty()};  
        }  
    });  
    // 使用自定义列表  
    ListView<DataNP> listView = new ListView<>(list);  
    listView.setPrefWidth(300);  
    listView.setPrefHeight(300);  
    listView.setLayoutX(100);  
    listView.setLayoutY(100);  
    ObservableList<DataNP> observableList = listView.getItems();  
    observableList.add(data1);  
    observableList.add(data2);  
    observableList.add(data3);  
    observableList.add(data4);  
    observableList.add(data5);
    ```

16. 操作observableList或某个对象属性
  
    ```java
    //（更新界面）
    observableList.set(0,new DataNP("REINE",20));  
    // 只修改普通属性界面不会更新（不更新界面）  
    data1.setName("REINE");  
    // 修改了监视属性会界面更新，会将之前进行修改的普通属性一并更新到界面（更新界面）
    data1.setAge(30);
    ```