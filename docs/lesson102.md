### TreeView监听

* 给jms节点添加值监听  
  
```java
jms.addEventHandler(TreeItem.<String>valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        System.out.println("event.getNewValue() = " + event.getNewValue());  
        System.out.println("event.getTreeItem().getValue() = " + event.getTreeItem().getValue());  
    }  
});  
```

* 给根节点添加value监听  
  
```java
china.addEventHandler(TreeItem.<String>valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        System.out.println("event.getNewValue() = " + event.getNewValue());  
        System.out.println("event.getTreeItem().getValue() = " + event.getTreeItem().getValue());  
    }  
});  
```

* 给根节点添加graphic监听  
  
```java
china.addEventHandler(TreeItem.graphicChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        System.out.println("event.getNewValue() = " + event.getNewValue());  
        System.out.println("event.getTreeItem().getValue() = " + event.getTreeItem().getValue());  
    }  
}); 
```

* 给根节点添加收起监听  
  
```java
china.addEventHandler(TreeItem.branchCollapsedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        System.out.println("收起");  
    }  
});  
```

* 给根节点添加展开监听  
  
```java
china.addEventHandler(TreeItem.branchExpandedEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        System.out.println("展开");  
    }  
}); 
```

* 给根节点添加子节点修改监听  
  
```java
china.addEventHandler(TreeItem.childrenModificationEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        event.getAddedChildren().forEach(System.out::println);  
        event.getRemovedChildren().forEach(System.out::println);  
    }  
}); 
```
* 给根节点添加监听  
  
```java
china.addEventHandler(TreeItem.treeNotificationEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {  
    @Override  
    public void handle(TreeItem.TreeModificationEvent<String> event) {  
        System.out.println("event.wasPermutated() = " + event.wasPermutated());  
    }  
});
```
