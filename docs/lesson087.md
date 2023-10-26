---
lang: zh-CN
title: ListView过滤和排序
---


# ListView过滤和排序

* 过滤
  
    ```java
    textField.textProperty().addListener((observable, oldValue, newValue) -> {  
        FilteredList<DataPro> filtered = observableList.filtered(dataPro -> dataPro.getName().contains(newValue));  
        listView.setItems(filtered);  
    });
    ```

* 排序
  
    ```java
    // 升序
    asc.setOnAction(event -> { 
        // 务必创建一个变量接收排序后的数据，以便恢复原数据
        SortedList<DataPro> sorted = observableList.sorted((Comparator.comparingInt(DataPro::getAge)));  
        listView.setItems(sorted);  
        // 不建议使用这种方式，这种方式会修改原来的数据
        observableList.sort((Comparator.comparingInt(DataPro::getAge)));
    });
    
    // 降序
    desc.setOnAction(event -> {  
        SortedList<DataPro> sorted = observableList.sorted((o1, o2) -> o2.getAge() - o1.getAge());  
        listView.setItems(sorted);  
        // 不建议使用这种方式，这种方式会修改原来的数据
        observableList.sort((o1, o2) -> o2.getAge() - o1.getAge()); 
    });
    ```

* 复原

    ```java
    listView.setItems(observableList);
    ```
