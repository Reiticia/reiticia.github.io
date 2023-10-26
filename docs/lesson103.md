---
lang: zh-CN
title: TreeView四种内置TreeCell
---

# TreeView四种内置TreeCell

* 设置可编辑`treeView.setEditable(true);`
  
## TextFieldTreeCell
* 使用`treeView.setCellFactory(TextFieldTreeCell.forTreeView());`
  
## ComboBoxTreeCell
* 使用`treeView.setCellFactory(ComboBoxTreeCell.forTreeView(new String[]{"中国", "韩国", "日本"}));`
  
## ChoiceBoxTreeCell
* 使用`treeView.setCellFactory(ChoiceBoxTreeCell.forTreeView(new String[]{"中国", "韩国", "日本"}));`
  
## CheckBoxTreeCell（不需要设置可编辑即可修改选中）

1. 定义Property实体类
  
   ```java
   public class Data {  
       private SimpleBooleanProperty selected = new SimpleBooleanProperty(false);  
       private SimpleStringProperty value = new SimpleStringProperty("");  
   
       public Data(boolean selected, String value) {  
           this.selected.set(selected);  
           this.value.set(value);  
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
   
       public String getValue() {  
           return value.get();  
       }  
   
       public SimpleStringProperty valueProperty() {  
           return value;  
       }  
   
       public void setValue(String value) {  
           this.value.set(value);  
       }  
   }
   ```

2. 装填TreeView
  
   ```java
   TreeView<Data> treeView = new TreeView<>();  
   treeView.setLayoutX(100);  
   treeView.setLayoutY(100);  
   TreeItem<Data> china = new TreeItem<>(new Data(false, "中国"));  
   TreeItem<Data> hlj = new TreeItem<>(new Data(true, "黒龙江"));  
   TreeItem<Data> heb = new TreeItem<>(new Data(false, "哈尔滨"));  
   TreeItem<Data> jms = new TreeItem<>(new Data(false, "佳木斯"));  
   TreeItem<Data> dq = new TreeItem<>(new Data(false, "大庆"));  
   hlj.getChildren().addAll(heb, jms, dq);  
   TreeItem<Data> gd = new TreeItem<>(new Data(false, "广东"));  
   TreeItem<Data> zj = new TreeItem<>(new Data(true, "珠海"));  
   TreeItem<Data> sz = new TreeItem<>(new Data(false, "深圳"));  
   TreeItem<Data> dg = new TreeItem<>(new Data(true, "东莞"));  
   gd.getChildren().addAll(zj, sz, dg);  
   china.getChildren().addAll(hlj, gd);  
   treeView.setRoot(china);
   ```

3. 设置显示效果（CheckBoxTreeCell）
  
   ```java
   treeView.setCellFactory(CheckBoxTreeCell.forTreeView(new Callback<TreeItem<Data>, ObservableValue<Boolean>>() {  
       @Override  
       public ObservableValue<Boolean> call(TreeItem<Data> param) {  
           if (treeView.getTreeItemLevel(param) == 1) {  
               param.getValue().setSelected(true);  
           }  
           return param.getValue().selectedProperty();  
       }  
   }, new StringConverter<TreeItem<Data>>() {  
       @Override  
       public String toString(TreeItem<Data> object) {  
           return object.getValue().getValue();  
       }  
       @Override  
       public TreeItem<Data> fromString(String string) {  
           return null;  
       }  
   }));
   ```
   
   ![](../assets/Pasted%20image%2020220607102315.png)