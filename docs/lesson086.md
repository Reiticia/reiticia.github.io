---
lang: zh-CN
title: ListView自定义单元格
---


# ListView自定义单元格

1. 创建10个DataPro数据并创建可观察列表
  
   ```java
   // 创建10个DataPro  
   DataPro data1 = new DataPro("鸢一折纸", 18);  
   DataPro data2 = new DataPro("本条二亚", 19);  
   DataPro data3 = new DataPro("时崎狂三", 20);  
   DataPro data4 = new DataPro("冰芽川四糸乃", 18);  
   DataPro data5 = new DataPro("五河琴里", 18);  
   DataPro data6 = new DataPro("星宫六喰", 18);  
   DataPro data7 = new DataPro("镜野七罪", 18);  
   DataPro data8 = new DataPro("八舞夕弦", 18);  
   DataPro data9 = new DataPro("八舞耶俱矢", 18);  
   DataPro data10 = new DataPro("诱宵美九", 18);  
   DataPro data11 = new DataPro("夜刀神十香", 18);  
   ObservableList<DataPro> observableList = FXCollections.observableArrayList(param -> {  
       // 当对象中任意一个属性改变时都会检测到  
       Observable[] observables = new Observable[2];  
       observables[0] = param.nameProperty();  
       observables[1] = param.ageProperty();  
       return observables;  
   });  
   observableList.add(data1);  
   observableList.add(data2);  
   observableList.add(data3);  
   observableList.add(data4);  
   observableList.add(data5);  
   observableList.add(data6);  
   observableList.add(data7);  
   observableList.add(data8);  
   observableList.add(data9);  
   observableList.add(data10);  
   observableList.add(data11);
   ```
2. 将数据拷贝一份`List<DataPro> listBackup = new ArrayList<>(observableList);`

3. 通过observableList创建listView`ListView<DataPro> listView = new ListView<>(observableList);`

4. 设置listView可编辑`listView.setEditable(true);`

5. 自定义单元格
  
   ```java
   listView.setCellFactory(new Callback<ListView<DataPro>, ListCell<DataPro>>() {  
       /**  
     * 当前选中的索引、数据、数据栏格式  
     */  
       int index = 0;  
       DataPro temp = new DataPro();  
       ListCell<DataPro> cell;  
       @Override  
       public ListCell<DataPro> call(ListView<DataPro> param) {  
           // 当双击编辑时获得编辑项的索引和内容  
           param.setOnEditStart(event -> {  
               // 获得当前选中编辑的数据  
               index = event.getIndex();  
               temp = param.getItems().get(index);  
           });  
           ListCell<DataPro> listCell = new ListCell<DataPro>() {  
               // 展示数据  
               @Override  
               protected void updateItem(DataPro item, boolean empty) {  
                   super.updateItem(item, empty);  
                   if (empty || item == null) {  
                       return;  
                   }  
                   ImageView imageView = new ImageView("images/logo.png");  
                   imageView.setPreserveRatio(true);  
                   imageView.setFitWidth(25);  
                   Label name = new Label(item.getName());  
                   Label age = new Label(String.valueOf(item.getAge()));  
                   HBox hBox = new HBox(10, name, age);  
                   hBox.setAlignment(Pos.CENTER);  
                   BorderPane borderPane = new BorderPane(hBox, null, null, null, imageView);  
                   this.setGraphic(borderPane);  
               }  
               // 双击编辑  
               @Override  
               public void startEdit() {  
                   cell = this;  
                   super.startEdit();  
                   ImageView imageView = new ImageView("images/logo.png");  
                   imageView.setPreserveRatio(true);  
                   imageView.setFitWidth(25);  
                   TextField name = new TextField(temp.getName());  
                   name.setPrefWidth(120);  
                   TextField age = new TextField(String.valueOf(temp.getAge()));  
                   age.setPrefWidth(40);  
                   HBox hBox = new HBox(10, name, age);  
                   hBox.setAlignment(Pos.CENTER);  
                   BorderPane borderPane = new BorderPane(hBox, null, null, null, imageView);  
                   this.setGraphic(borderPane);  
                   // 修改了姓名  
                   name.setOnKeyPressed(event -> {  
                       if (event.getCode().equals(KeyCode.ENTER)) {  
                           if (!name.getText().trim().equals("")) {  
                               temp.setName(name.getText());  
                               temp.setAge(Integer.parseInt(age.getText()));  
                           }  
                           cell.commitEdit(temp);  
                       }  
                   });  
                   // 修改了年龄  
                   age.setOnKeyPressed(event -> {  
                       if (event.getCode().equals(KeyCode.ENTER)) {  
                           if (!age.getText().trim().equals("")) {  
                               temp.setName(name.getText());  
                               temp.setAge(Integer.parseInt(age.getText()));  
                           }  
                           cell.commitEdit(temp);  
                       }  
                   });  
               }  
               @Override  
               public void cancelEdit() {  
                   super.cancelEdit();  
                   ImageView imageView = new ImageView("images/logo.png");  
                   imageView.setPreserveRatio(true);  
                   imageView.setFitWidth(25);  
                   Label name = new Label(temp.getName());  
                   Label age = new Label(String.valueOf(temp.getAge()));  
                   HBox hBox = new HBox(10, name, age);  
                   hBox.setAlignment(Pos.CENTER);  
                   BorderPane borderPane = new BorderPane(hBox, null, null, null, imageView);  
                   this.setGraphic(borderPane);  
               }  
               @Override  
               public void commitEdit(DataPro newValue) {  
                   super.commitEdit(newValue);  
                   System.err.println("提交编辑");  
               }  
           };  
           return listCell;  
       }  
   });
   ```
   
   效果图
   ![](../assets/Pasted%20image%2020220604141149.png)