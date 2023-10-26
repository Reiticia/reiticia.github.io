---
lang: zh-CN
title: TableView自定义行
---

# TableView自定义行

```java
tableView.setRowFactory(new Callback<TableView<StudentProperty>, TableRow<StudentProperty>>() {  
    @Override  
    public TableRow<StudentProperty> call(TableView<StudentProperty> param) {  
        return new TableRow<StudentProperty>() {  
            @Override  
            protected void updateItem(StudentProperty item, boolean empty) {  
                super.updateItem(item, empty);  
                if (empty || item == null) {  
                    return;  
                }  
                if (item.getAge()<22){  
                    this.setStyle("-fx-background-color: red;");  
                }  
                this.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.DOTTED, new CornerRadii(3), new BorderWidths(2))));  
                this.setTooltip(new Tooltip(item.getName()));  
            }  
        };  
    }  
});
```