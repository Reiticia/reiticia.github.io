---
lang: zh-CN
title: ListView（下）
---


# ListView（下）

## 关于CheckBoxListCell的选中监听属性

1. 实体类
  
   ```java
   public class Data {  
       private String name;  
       private SimpleBooleanProperty selected = new SimpleBooleanProperty();  
   
       public Data() {  
   
       }  
   
       public Data(String name) {  
           this.name = name;  
       }  
   
       public String getName() {  
           return name;  
       }  
   
       public void setName(String name) {  
           this.name = name;  
       }  
   
       public boolean isSelected() {  
           return selected.get();  
       }  
   
       public SimpleBooleanProperty selectedProperty() {  
           return selected;  
       }  
   
       public void setSelected(boolean selected) {  
           this.selected.set(selected);  
       }  
   }
   ```

2. 省略创建实体类和可观察列表

3. 通过CheckBoxListCell创建回调函数Callback
  
   ```java
   Callback<ListView<Data>, ListCell<Data>> cell = CheckBoxListCell.forListView(param -> {  
       // 不是B就是true  
       if (!param.getName().equals("B")) {  
           param.setSelected(true);  
       }  
       return param.selectedProperty();  
   }, new StringConverter<Data>() {  
       @Override  
       public String toString(Data object) {  
           return object.getName();  
       }  
       @Override  
       public Data fromString(String string) {  
           return new Data(string);  
       }  
   });
   listView.setCellFactory(cell);
   ```

4. 对listView添加属性监听器监听值的改变，验证效果
  
   ```java
   listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
       System.out.println("名称 = " + newValue.getName() + " 是否选中 = " + newValue.isSelected());  
   });
   ```
   
   控制台打印（点击A，取消勾选A，点击B，再点击A）
   
   > 名称 = A 是否选中 = true
   > 名称 = B 是否选中 = false
   > 名称 = A 是否选中 = false
