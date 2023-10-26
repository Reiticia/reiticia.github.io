---
lang: zh-CN
title: TableView
---


# TableView

## TableView加载普通JavaBean

1. 定义普通学生实体类
  
   ```java
   public class Student {  
       private String name;  
       private Integer age;  
       private Double score;  
       private Boolean gender;  
   
       public Student() {  
       }  
   
       public Student(String name, Integer age, Double score, Boolean gender) {  
           this.name = name;  
           this.age = age;  
           this.score = score;  
           this.gender = gender;  
       }  
   
       public String getName() {  
           return name;  
       }  
   
       public void setName(String name) {  
           this.name = name;  
       }  
   
       public Integer getAge() {  
           return age;  
       }  
   
       public void setAge(Integer age) {  
           this.age = age;  
       }  
   
       public Double getScore() {  
           return score;  
       }  
   
       public void setScore(Double score) {  
           this.score = score;  
       }  
   
       public Boolean getGender() {  
           return gender;  
       }  
   
       public void setGender(Boolean boy) {  
           gender = boy;  
       }  
   }
   ```

2. 创建学生对象，填充可观察列表
  
   ```java
   // 创建5个学生对象  
   Student student1 = new Student("张三", 20, 80.0, true);  
   Student student2 = new Student("李四", 21, 90.0, false);  
   Student student3 = new Student("王五", 22, 100.0, true);  
   Student student4 = new Student("赵六", 23, 70.0, false);  
   Student student5 = new Student("钱七", 24, 60.0, true);  
   ObservableList<Student> list = FXCollections.observableArrayList();  
   list.addAll(student1, student2, student3, student4, student5);
   ```

3. 传入list创建TableView
  
   ```java
   TableView<Student> tableView = new TableView<>(list);  
   tableView.setLayoutX(100);  
   tableView.setLayoutY(100);
   ```

4. 构建tableView的每一列数据
  
   ```java
   TableColumn<Student, String> nameCol = new TableColumn<>("姓名");  
   nameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {  
       @Override  
       public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> cellData) {  
           return new SimpleStringProperty(cellData.getValue().getName());  
       }  
   });  
   // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型  
   TableColumn<Student, Number> ageCol = new TableColumn<>("年龄");  
   ageCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Number>, ObservableValue<Number>>() {  
       @Override  
       public ObservableValue<Number> call(TableColumn.CellDataFeatures<Student, Number> cellData) {  
           return new SimpleIntegerProperty(cellData.getValue().getAge());  
       }  
   });  
   TableColumn<Student, Number> scoreCol = new TableColumn<>("成绩");  
   scoreCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Number>, ObservableValue<Number>>() {  
       @Override  
       public ObservableValue<Number> call(TableColumn.CellDataFeatures<Student, Number> cellData) {  
           return new SimpleDoubleProperty(cellData.getValue().getScore());  
       }  
   });  
   TableColumn<Student, Boolean> isBoyCol = new TableColumn<>("是男生");  
   isBoyCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Boolean>, ObservableValue<Boolean>>() {  
       @Override  
       public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Student, Boolean> cellData) {  
           return new SimpleBooleanProperty(cellData.getValue().getGender());  
       }  
   });
   ```
   
   另一种写法
   
   ```java
   // 第二种写法，通过加载属性名称进行加载，内部通过反射调用属性列的getter方法，因此getter方法编写必须符合规范  
   TableColumn<Student, String> nameCol = new TableColumn<>("姓名");  
   nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));  
   // 对于数字类型的字段，可以指定其抽象类Number或者它本身所属的类作为泛型  
   // TableColumn<Student, Number> ageCol = new TableColumn<>("年龄");  
   // ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));  
   // TableColumn<Student, Number> scoreCol = new TableColumn<>("成绩");  
   // scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));  
   TableColumn<Student, Integer> ageCol = new TableColumn<>("年龄");  
   ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));  
   TableColumn<Student, Double> scoreCol = new TableColumn<>("成绩");  
   scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));  
   TableColumn<Student, Boolean> isBoyCol = new TableColumn<>("是男生");  
   isBoyCol.setCellValueFactory(new PropertyValueFactory<>("isBoy"));
   ```

5. 给tableView添加列
  
   ```java
   tableView.getColumns().add(nameCol);  
   tableView.getColumns().add(ageCol);  
   tableView.getColumns().add(scoreCol);  
   tableView.getColumns().add(isBoyCol);
   ```

   ![](../assets/Pasted%20image%2020220605210231.png)

6. 用于测试的按钮点击事件
  
   ```java
   button.setOnAction(event -> {  
       if (tableView.getItems().size() > 0) {  
           // 成功删除并移除出界面  
           tableView.getItems().remove(0);  
           // 成功修改并显示到界面  
           tableView.getItems().set(3, new Student("REINE", 20, 80.0, true));  
           // 成功修改但界面不刷新  
           student1.setName("REINE");  
           // 必须强制刷新  
           tableView.refresh();  
       } else {  
           Alert alert = new Alert(Alert.AlertType.ERROR);  
           alert.setHeaderText("没有数据");  
           alert.show();  
       }  
   });
   ```
   
## TableView加载监视JavaBean

1. 定义监视学生实体类
  
   ```java
   public class StudentProperty {  
       private SimpleStringProperty name = new SimpleStringProperty();  
       private SimpleIntegerProperty age = new SimpleIntegerProperty();  
       private SimpleDoubleProperty score = new SimpleDoubleProperty();  
       private SimpleBooleanProperty gender = new SimpleBooleanProperty();  
   
       public StudentProperty() {  
       }  
   
       public StudentProperty(String name, int age, double score, boolean gender) {  
           this.name.set(name);  
           this.age.set(age);  
           this.score.set(score);  
           this.gender.set(gender);  
       }  
   
       public String getName() {  
           return name.get();  
       }  
   
       // 注意每一个监视属性获取其监视属性对象的书写
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
   
       public double getScore() {  
           return score.get();  
       }  
   
       public SimpleDoubleProperty scoreProperty() {  
           return score;  
       }  
   
       public void setScore(double score) {  
           this.score.set(score);  
       }  
       // 注意SimpleBooleanProperty类型getter方法的书写
       public boolean isGender() {  
           return gender.get();  
       }  
   
       public SimpleBooleanProperty genderProperty() {  
           return gender;  
       }  
   
       public void setGender(boolean gender) {  
           this.gender.set(gender);  
       }  
   }
   ```

2. 创建学生对象，填充可观察列表
  
   ```java
   // 创建5个学生对象  
   StudentProperty student1 = new StudentProperty("张三", 20, 80.0, true);  
   StudentProperty student2 = new StudentProperty("李四", 21, 90.0, false);  
   StudentProperty student3 = new StudentProperty("王五", 22, 100.0, true);  
   StudentProperty student4 = new StudentProperty("赵六", 23, 70.0, false);  
   StudentProperty student5 = new StudentProperty("钱七", 24, 60.0, true);  
   ObservableList<StudentProperty> list = FXCollections.observableArrayList(); 
   list.addAll(student1, student2, student3, student4, student5);
   ```

3. 传入list创建TableView
  
   ```java
   TableView<Student> tableView = new TableView<>(list);  
   tableView.setLayoutX(100);  
   tableView.setLayoutY(100);
   ```

4. 构建tableView的每一列数据
  
   ```java
   TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");  
   nameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, String>, ObservableValue<String>>() {  
       @Override  
       public ObservableValue<String> call(TableColumn.CellDataFeatures<StudentProperty, String> cellData) {  
           return cellData.getValue().nameProperty();  
       }  
   });  
   // 对于数字类型的字段必须，必须使用其抽象类Number定义泛型  
   TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");  
   ageCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, Number>, ObservableValue<Number>>() {  
       @Override  
       public ObservableValue<Number> call(TableColumn.CellDataFeatures<StudentProperty, Number> cellData) {  
           return cellData.getValue().ageProperty();  
       }  
   });  
   TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");  
   scoreCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, Number>, ObservableValue<Number>>() {  
       @Override  
       public ObservableValue<Number> call(TableColumn.CellDataFeatures<StudentProperty, Number> cellData) {  
           return cellData.getValue().scoreProperty();  
       }  
   });  
   TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("是男生");  
   isBoyCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StudentProperty, Boolean>, ObservableValue<Boolean>>() {  
       @Override  
       public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<StudentProperty, Boolean> cellData) {  
           return cellData.getValue().genderProperty();  
       }  
   });
   ```
    
   另一种写法
    
   ```java
   // 注意监视对象获取监视属性的写法为xxxProperty()，否则无法监听数据变化同时更新界面
   TableColumn<StudentProperty, String> nameCol = new TableColumn<>("姓名");  
   nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));  
   // 对于数字类型的字段，可以指定其抽象类Number或者它本身所属的类作为泛型  
   // TableColumn<StudentProperty, Number> ageCol = new TableColumn<>("年龄");  
   // ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));  
   // TableColumn<StudentProperty, Number> scoreCol = new TableColumn<>("成绩");  
   // scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));  
   TableColumn<StudentProperty, Integer> ageCol = new TableColumn<>("年龄");  
   ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));  
   TableColumn<StudentProperty, Double> scoreCol = new TableColumn<>("成绩");  
   scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));  
   // 注意Boolean监视属性getter的写法为isXXX
   TableColumn<StudentProperty, Boolean> isBoyCol = new TableColumn<>("是男生");  
   isBoyCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
   ```

5. 给tableView添加列
  
   ```java
   tableView.getColumns().add(nameCol);  
   tableView.getColumns().add(ageCol);  
   tableView.getColumns().add(scoreCol);  
   tableView.getColumns().add(isBoyCol);
   ```
    
   ![](../assets/Pasted%20image%2020220605211922.png)

6. 用于测试的按钮点击事件
  
   ```java
   button.setOnAction(event -> {  
       if (tableView.getItems().size() > 0) {  
           // 成功修改并显示到界面  
           // tableView.getItems().set(3, new StudentProperty("REINE", 20, 80.0, true));  
           // 成功修改并显示到界面  
           student1.setName("REINE");  
           // 成功修改并显示到界面  
           student2.setAge(14);  
           // 可以得知list中对于的数据也被修改了
           list.forEach(System.out::println);
       } else {          
           Alert alert = new Alert(Alert.AlertType.ERROR);  
           alert.setHeaderText("没有数据");  
           alert.show(); 
       }  
   });
   ```

7. 当tableView中的数据发生改变时，可观察列表list是否能监听到其数据发生的变化
  
   ```java
   // 对list的某一条数据进行修改时不会触发该监听，除非在创建list时传入了回调函数callback，且修改的属性在callback返回的监视属性数组中才会触发该监听
   list.addListener(new ListChangeListener<StudentProperty>() {  
       @Override  
       public void onChanged(Change<? extends StudentProperty> c) {  
           System.out.println("c = " + c);  
       }  
   });
   ```

8. 相对于第七点提出的通过传入回调函数callback创建可观察列表的写法
  
   ```java
   ObservableList<StudentProperty> list = FXCollections.observableArrayList(new Callback<StudentProperty, Observable[]>() {  
       @Override  
       public Observable[] call(StudentProperty param) {  
           // 将每个StudentProperty对象中所有的监视属性返回
           return new Observable[]{param.nameProperty(),param.ageProperty(),param.scoreProperty(),param.genderProperty()};  
       }  
   });
   ```