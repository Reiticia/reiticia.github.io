---
lang: zh-CN
title: TreeView自定义Cell拖拽
---

# TreeView自定义Cell拖拽

```java
treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {  
    /**  
     * 保存上次拖拽经过的cell  
     */  
    TreeCell<String> temp = null;  
    /**  
     * 保存被拖拽的节点  
     */  
    TreeItem<String> originItem = null;  
    /**  
     * 自定义cell  
     * @param param 节点  
     * @return 自定义的cell  
     */
    @Override  
    public TreeCell<String> call(TreeView<String> param) {  
        TreeCell<String> treeCell = new TreeCell<String>() {  
            /**  
             * 自定义cell  
             */
            @Override  
            protected void updateItem(String item, boolean empty) {  
                super.updateItem(item, empty);  
                if (empty || item.equals("")) {  
                    this.setGraphic(null);  
                    return;  
                }  
                // 展开时的图片  
                if (this.getTreeItem().isExpanded()) {  
                    ImageView imageView = new ImageView("/images/add.png");  
                    imageView.setPreserveRatio(true);  
                    imageView.setFitWidth(15);  
                    this.setDisclosureNode(imageView);  
                } else {  
                    // 收起时的图片  
                    ImageView imageView = new ImageView("/images/sub.png");  
                    imageView.setPreserveRatio(true);  
                    imageView.setFitWidth(15);  
                    this.setDisclosureNode(imageView);  
                }  
                this.setUserData(item);  
                Label label = new Label(this.getUserData().toString());  
                this.setGraphic(label);  
            }  
        };  
        // 拖拽开始  
        treeCell.setOnDragDetected(event -> {  
            // 设置拖拽模式  
            Dragboard dragboard = treeCell.startDragAndDrop(TransferMode.COPY_OR_MOVE);  
            // 拖拽剪贴板  
            ClipboardContent content = new ClipboardContent();  
            content.putString(treeCell.getItem());  
            // 设置拖拽图片时的效果  
            Text text = new Text(treeCell.getItem());  
            text.setFont(new Font(15));  
            WritableImage writableImage = new WritableImage((int) treeCell.getWidth() - 200, 20);  
            text.snapshot(new SnapshotParameters(), writableImage);  
            dragboard.setDragView(writableImage);  
            // 设置拖拽内容  
            dragboard.setContent(content);  
            originItem = treeCell.getTreeItem();  
        });  
        // 拖拽经过  
        treeCell.setOnDragOver(event -> {  
            event.acceptTransferModes(TransferMode.MOVE);  
            Optional.ofNullable(temp).ifPresent(tmp -> tmp.setBorder(null));  
            temp = treeCell;  
            // 鼠标移动距离接近treeCell底部  
            if (event.getY() > treeCell.getHeight() - 10 && event.getY() <= treeCell.getHeight()) {  
                BorderStroke stroke = new BorderStroke(  
                    null, null, Color.GREEN, null,  
                    null, null, BorderStrokeStyle.SOLID, null,  
                    new CornerRadii(0), new BorderWidths(1), new Insets(0));  
                Border border = new Border(stroke);  
                treeCell.setBorder(border);  
            }  
        });  
        // 拖拽结束  
        treeCell.setOnDragDropped(event -> {  
            Dragboard dragboard = event.getDragboard();  
            String value = dragboard.getString();  
            // 是否是叶子节点  
            treeCell.getTreeItem().isLeaf();  
            // 是否折叠  
            treeCell.getTreeItem().isExpanded();  
            // 如果节点的父节点不为空，并且该节点的级别与拖拽的节点级别相同时，才能成功完成拖拽动作  
            if (treeCell.getTreeItem().getParent() != null && treeView.getTreeItemLevel(treeCell.getTreeItem()) == treeView.getTreeItemLevel(originItem)) {  
                // 将原来的treeCell移除  
                originItem.getParent().getChildren().remove(originItem);  
                // 获取其在父节点中的索引  
                int index = treeCell.getTreeItem().getParent().getChildren().indexOf(treeCell.getTreeItem());  
                // 在其父节点上指定位置创建节点，节点内容为剪贴板中的值  
                TreeItem<String> treeItem = new TreeItem<>(value);  
                treeCell.getTreeItem().getParent().getChildren().add(index + 1, treeItem);  
                // 设置其对于的子节点  
                setChildren(originItem, treeItem);  
            }  
            // 取消边框样式  
            treeCell.setBorder(null);  
        });  
        return treeCell;  
    }  
    /**  
     * 设置子节点  
     *  
     * @param originItem 原节点  
     * @param treeItem   新节点  
     */  
    private void setChildren(TreeItem<String> originItem, TreeItem<String> treeItem) {  
        // 设置原有的状态（是否展开）  
        boolean expanded = originItem.isExpanded();  
        treeItem.setExpanded(expanded);  
        // 获取原节点的子节点  
        originItem.getChildren().forEach(item -> {  
            // 将该节点添加到节点中  
            treeItem.getChildren().add(item);  
        });  
    }  
});
```

按钮点击事件用于展开或收起所有节点

```java
button.setOnAction(event -> {  
    expandedAllItem(china, isExpanded);  
    isExpanded = !isExpanded;  
});
```

```java
/**  
 * 展开所有节点  
 *  
 * @param item       当前节点  
 * @param isExpanded 是否展开  
 */  
private void expandedAllItem(TreeItem<String> item, boolean isExpanded) {  
    item.setExpanded(isExpanded);  
    item.getChildren().forEach(stringTreeItem -> {  
        expandedAllItem(stringTreeItem, isExpanded);  
    });  
}
```