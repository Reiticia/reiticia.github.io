---
lang: zh-CN
title: ListView 鼠标事件
---


# ListView 鼠标事件

## 鼠标悬空事件（每一个列表项）

```java
// 构建每一个列表项
listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {  
    int position = 0;  
    @Override  
    public ListCell<String> call(ListView<String> param) {  
        Label label = new Label();  
        label.setFont(new Font(15));  
        // 创建列表项
        ListCell<String> cell = new ListCell<String>() {  
            @Override  
            protected void updateItem(String item, boolean empty) {  
                super.updateItem(item, empty);  
                if (empty || item == null) {  
                    return;  
                }  
                label.setText(item);  
                this.setGraphic(label);  
            }  
        };  
        // 给列表项设置高度
        cell.setPrefHeight(30);  
        // 鼠标悬空监听  
        cell.hoverProperty().addListener((observable, oldValue, newValue) -> { 
            // newValue代表鼠标是否悬空在此列表项上，是为true 
            if (newValue && !label.getText().equals("")) {  
                // 增大字体
                label.setFont(new Font(20));  
                // 获取该列表项在列表中的索引
                position = param.getItems().indexOf(label.getText());  
                // 获取焦点
                param.getFocusModel().focus(position);  
                label.setStyle("-fx-background-color: pink;");  
                cell.setStyle("-fx-background-color: green;");  
            } else {  
                label.setStyle("-fx-background-color: none;");  
                cell.setStyle("-fx-background-color: none;");  
                label.setFont(new Font(15));  
            }  
        });  
        return cell;  
    }  
});
```

## 鼠标滚轮事件

```java
listView.setOnScroll(event -> {  
    // 水平滚动距离
    System.out.println("event.getDeltaX() = " + event.getDeltaX());  
    // 垂直滚动距离
    System.out.println("event.getDeltaY() = " + event.getDeltaY());  
});
```

## 鼠标拖拽事件

```java
// 通过拖拽列表项改变其在列表中的位置
listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {  

    int position = 0;  

    @Override  
    public ListCell<String> call(ListView<String> param) {  
        Label label = new Label();  
        label.setFont(new Font(15));  
        ListCell<String> cell = new ListCell<String>() {  
            @Override  
            protected void updateItem(String item, boolean empty) {  
                super.updateItem(item, empty);  
                if (empty || item == null) {  
                    return;  
                }  
                label.setText(item);  
                this.setGraphic(label);  
            }  
        };  
        cell.setPrefHeight(30);  

        // 拖拽监听  
        cell.setOnDragDetected(event -> {  
            // 拖拽模式  
            Dragboard dragboard = cell.startDragAndDrop(TransferMode.COPY_OR_MOVE);  
            ClipboardContent content = new ClipboardContent();  
            // 往拖拽剪贴板中存放数据
            content.putString(data);  
            // 设置拖拽图标  
            WritableImage writableImage = new WritableImage((int) cell.getWidth(), (int) cell.getHeight());  
            WritableImage snapshot = cell.snapshot(new SnapshotParameters(), writableImage);  
            dragboard.setDragView(snapshot);  
            dragboard.setContent(content);  
        });  

        // 拖拽进入到另一个cell  
        cell.setOnDragEntered(event -> {  
            // 获取拖拽进入的位置  
            position = param.getItems().indexOf(label.getText());  
            param.getFocusModel().focus(position);  
        });  

        // 拖拽释放  
        cell.setOnDragOver(event -> {  
            event.acceptTransferModes(TransferMode.COPY);  
        });  

        // 拖拽释放  
        cell.setOnDragDropped(event -> {  
            // 获取拖拽剪贴板中的文本
            Dragboard dragboard = event.getDragboard();  
            param.getItems().remove(dragboard.getString());  
            if (position == -1) {  
                param.getItems().add(dragboard.getString());  
                // 设置选中  
                param.getSelectionModel().select(param.getItems().size() - 1);  
            } else {  
                param.getItems().add(position, dragboard.getString());  
                // 设置选中  
                param.getSelectionModel().select(position);  
            }  
        });  

        return cell;  
    }  
});
```