### ListView

* 创建可观察列表并创建ListView
  
```java
ObservableList<String> observableList = FXCollections.observableArrayList();  
observableList.add("data - c");  
observableList.add("data - e");  
observableList.add("data - g");  
observableList.add("data - a");  
observableList.add("data - x");  
observableList.add("data - q");  
observableList.add("data - r");  
observableList.add("data - w");  
ListView<String> listView = new ListView<>(observableList);
```

![](../assets/Pasted%20image%2020220602165259.png)
* 设置无数据时的默认显示`listView.setPlaceholder(new Label("无数据"));`

* 设置宽高
  
```java
listView.setPrefWidth(300);  
listView.setPrefHeight(200);
```

* 设置坐标
  
```java
listView.setLayoutX(100);  
listView.setLayoutY(100);
```

* 添加元素`listView.getItems().add("data - u");`

* 设置排列方向为水平方向`listView.setOrientation(Orientation.HORIZONTAL);`

* 设置多选`listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);`

* 选择索引为0的元素`listView.getSelectionModel().select(0);`

* 设置列表元素可编辑
  
```java
listView.setEditable(true);  
listView.setCellFactory(TextFieldListCell.forListView());
```

* 获取焦点`listView.requestFocus();`

* 选择索引为2和4`listView.getSelectionModel().selectIndices(2, 4);`

* 添加元素`observableList.add("data - add");`

* 选择最后一个`listView.getSelectionModel().selectLast();`

* 滚动条滚动到指定位置
  
```java
listView.scrollTo(listView.getItems().size()-1);
listView.scrollTo("data - add");
listView.scrollTo(3);
```

* 获取被选中元素的索引`listView.getSelectionModel().getSelectedIndex()`

* 获取被选中元素的内容`listView.getSelectionModel().getSelectedItems()`

* 点击选项内容改变监听
  
```java
listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
    System.out.println("newValue = " + newValue);  
});
```

* 点击选项索引改变监听
  
```java
listView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {  
    System.out.println("newValue = " + newValue);  
});
```
* 滚动监听（必须通过调用scrollTo方法才会触发监听）
  
```java
listView.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {  
    @Override  
    public void handle(ScrollToEvent<Integer> event) {  
        listView.getItems().remove(0);  
    }  
});
```