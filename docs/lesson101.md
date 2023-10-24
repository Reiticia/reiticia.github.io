### TreeView

* 创建TreeView和TreeItem
  
```java
TreeView<String> treeView = new TreeView<>();  
treeView.setLayoutX(100);  
treeView.setLayoutY(100);  
TreeItem<String> china = new TreeItem<>("中国");  
TreeItem<String> hlj = new TreeItem<>("黒龙江");  
TreeItem<String> heb = new TreeItem<>("哈尔滨");  
TreeItem<String> jms = new TreeItem<>("佳木斯");  
TreeItem<String> dq = new TreeItem<>("大庆");  
hlj.getChildren().addAll(heb, jms, dq);  
TreeItem<String> gd = new TreeItem<>("广东");  
TreeItem<String> zj = new TreeItem<>("珠海");  
TreeItem<String> sz = new TreeItem<>("深圳");  
TreeItem<String> dg = new TreeItem<>("东莞");  
gd.getChildren().addAll(zj, sz, dg);  
TreeItem<String> tw = new TreeItem<>("台湾");  
TreeItem<String> tb = new TreeItem<>("台北");  
TreeItem<String> gx = new TreeItem<>("高雄");  
TreeItem<String> tn = new TreeItem<>("台南");  
tw.getChildren().addAll(tb, gx, tn);  
china.getChildren().addAll(hlj, gd, tw);  
treeView.setRoot(china);
```

* 设置默认展开
  
```java
china.setExpanded(true);  
hlj.setExpanded(true);  
gd.setExpanded(true);  
tw.setExpanded(true);
```

  ![](../assets/Pasted%20image%2020220607071231.png)

* 设置宽高
  
```java
treeView.setPrefWidth(300);  
treeView.setPrefHeight(100);
```

* 设置单元格尺寸`treeView.setFixedCellSize(40);`

* 设置多选`treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);`

* 设置可编辑
  
```java
treeView.setEditable(true);  
// treeView.setCellFactory(TextFieldTreeCell.forTreeView());
treeView.setCellFactory(TextFieldTreeCell.forTreeView(new StringConverter<String>() {  
    @Override  
    public String toString(String object) {  
        return object + " - china";  
    }  
    @Override  
    public String fromString(String string) {  
        return string;  
    }  
}));
```

* 滚动监听
  
  ```java
  treeView.setOnScrollTo(event -> {  
      System.out.println("scroll to " + event.getScrollTarget());  
  });
  ```

* 选择监听
  
```java
treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
    System.out.println("selectedItemProperty: " + newValue);  
});
```

* 滚动到指定位置`treeView.scrollTo(6);`

* 修改值`china.setValue("种花家");`

* 是否显示根节点（隐藏）`treeView.setShowRoot(false);`

* 是否是叶子节点`china.isLeaf()`

* 获得该节点的前后节点
  
```java
System.out.println("jms.previousSibling().getValue() = " + jms.previousSibling().getValue());  
System.out.println("jms.nextSibling().getValue() = " + jms.nextSibling().getValue());  
System.out.println("jms.previousSibling(dq).getValue() = " + jms.previousSibling(dq).getValue());  
System.out.println("tw.previousSibling().getValue() = " + tw.previousSibling().getValue());
```

* 获取父节点`jms.getParent().getValue()`

* 是否展开`tw.isExpanded()`

* 聚焦
  
```java
treeView.getFocusModel().focus(0);  
treeView.requestFocus();
```

* 展开的数量`treeView.getExpandedItemCount()`