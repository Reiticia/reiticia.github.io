### TreeTableView自定义单元格

1. 实体类
  
   ```java
   public class Data {  
       /**
     * 由于演示修改修改此属性，故设置为SimpleStringProperty
     */
       private SimpleStringProperty name = new SimpleStringProperty();  
       private ReadOnlyStringWrapper clazz = new ReadOnlyStringWrapper();  
       private ReadOnlyIntegerWrapper age = new ReadOnlyIntegerWrapper();  
       private ReadOnlyDoubleWrapper score = new ReadOnlyDoubleWrapper();  
       private SimpleBooleanProperty male = new SimpleBooleanProperty();  
       public Data() {  
       }  
       public Data(String name, String clazz, Integer age, Double score, Boolean male) {  
           this.name.set(name);  
           this.clazz.set(clazz);  
           this.age.set(age);  
           this.score.set(score);  
           this.male.set(male);  
       }  
       public String getName() {  
           return name.get();  
       }  
       // public ReadOnlyStringProperty nameProperty() {  
       //     return name.getReadOnlyProperty();  
       // }  
       public SimpleStringProperty nameProperty() {  
           return name;  
       }  
       public void setName(String name) {  
           this.name.set(name);  
       }  
       public int getAge() {  
           return age.get();  
       }  
       public ReadOnlyIntegerProperty ageProperty() {  
           return age.getReadOnlyProperty();  
       }  
       public void setAge(int age) {  
           this.age.set(age);  
       }  
       public boolean isMale() {  
           return male.get();  
       }  
       public SimpleBooleanProperty maleProperty() {  
           return male;  
       }  
       public void setMale(boolean male) {  
           this.male.set(male);  
       }  
       public double getScore() {  
           return score.get();  
       }  
       public ReadOnlyDoubleProperty scoreProperty() {  
           return score.getReadOnlyProperty();  
       }  
       public void setScore(double score) {  
           this.score.set(score);  
       }  
       public String getClazz() {  
           return clazz.get();  
       }  
       public ReadOnlyStringProperty clazzProperty() {  
           return clazz.getReadOnlyProperty();  
       }  
       public void setClazz(String clazz) {  
           this.clazz.set(clazz);  
       }  
   }
   ```
2. 自定义名称列的展示和修改
  
   ```java
   view.setEditable(true);  
   nameCol.setCellFactory(new Callback<TreeTableColumn<Data, String>, TreeTableCell<Data, String>>() {  
       @Override  
       public TreeTableCell<Data, String> call(TreeTableColumn<Data, String> param) {  
           return new TreeTableCell<Data, String>() {  
               @Override  
               protected void updateItem(String item, boolean empty) {  
                   super.updateItem(item, empty);  
                   if (empty || item == null) {  
                       this.setGraphic(null);  
                       return;  
                   }  
                   this.setAlignment(Pos.CENTER);  
                   this.setUserData(item);  
                   initGraphic();  
               }  
               @Override  
               public void startEdit() {  
                   super.startEdit();  
                   TextField textField = new TextField(this.getUserData().toString());  
                   this.setGraphic(textField);  
                   textField.requestFocus();  
                   textField.setOnKeyPressed(event -> {  
                       if (event.getCode() == KeyCode.ENTER) {  
                           commitEdit(textField.getText());  
                       }  
                   });  
               }  
               @Override  
               public void cancelEdit() {  
                   super.cancelEdit();  
                   initGraphic();  
               }  
               /**  
             * 这里在进行数据更新时，必须在实体类中的nameProperty返回SimpleStringProperty对象，</n>  
             * 否则下次双击编辑时会显示上一次编辑前的值  
             * @param newValue  
             */  
               @Override  
               public void commitEdit(String newValue) {  
                   super.commitEdit(newValue);  
                   this.setUserData(newValue);  
               }  
               private void initGraphic() {  
                   Label label = new Label(this.getUserData().toString());  
                   this.setGraphic(label);  
               }  
           };  
       }  
   });
   ```
