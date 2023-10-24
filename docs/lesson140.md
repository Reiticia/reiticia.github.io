### WebHistory浏览记录

* 获取历史记录`WebHistory history = engine.getHistory();`

* 获取历史记录页面列表`ObservableList<WebHistory.Entry> list = history.getEntries();`

* 当前页面索引`history.getCurrentIndex()`

* 最大页面索引`history.getMaxSize()`

* 当前页面数量`list.size()`

* 前进
  
```java
forward.setOnAction(e -> {  
    if (history.getCurrentIndex() >= list.size() - 1) {  
        System.out.println("已经是最后一页了");  
        return;  
    }  
    history.go(1);  
});
```
* 后退
  
```java
back.setOnAction(e -> {  
    if (history.getCurrentIndex() <= 0) {  
        System.out.println("已经是第一页了");  
        return;  
    }  
    history.go(-1);  
});
```
