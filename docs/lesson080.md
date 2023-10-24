### Dragboard 鼠标拖拽结合剪贴板

#### 将标签文本拖拽到输入框中

1. 创建标签和输入框
  
   ```java
   Label label = new Label("Hello World");  
   label.setLayoutX(0);  
   label.setLayoutY(0);  
   TextField textField = new TextField();  
   textField.setLayoutX(200);  
   textField.setLayoutY(0);
   ```
   
2. 标签拖拽检测
  
   ```java
   label.setOnDragDetected(event -> {  
       // 开始拖拽动作（剪切模式，模式不会影响具体效果，最终效果仍需定义代码进行实现）  
       Dragboard dragboard = label.startDragAndDrop(TransferMode.MOVE);  
       Text text = new Text(label.getText());  
       // 设置拖拽时的图标
       WritableImage writableImage = new WritableImage((int) label.getWidth(), (int) label.getHeight());  
       text.snapshot(new SnapshotParameters(), writableImage);  
       dragboard.setDragView(writableImage, 0, 0);  
       // 将文本内容复制到拖拽剪贴板中
       ClipboardContent content = new ClipboardContent();  
       content.putString(label.getText());  
       dragboard.setContent(content);  
   });
   ```
   
3. 拖拽经过textField
  
   ```java
   textField.setOnDragOver(event -> {  
       // 于上面的设置的模式相同，如果不写此行，下面setOnDragDropped不会生效  
       event.acceptTransferModes(TransferMode.MOVE);  
   });
   ```
   
4. 在textField上释放拖拽动作
  
   ```java
   textField.setOnDragDropped(event -> {  
       // 获得拖拽面板的数据  
       textField.setText(event.getDragboard().getString());  
       event.setDropCompleted(true);  
   });
   ```
   
5. xxxxxxxxxx3 1ClipboardContent content = new ClipboardContent();2content.put(DataFormat.IMAGE,new Image("file:E:\\Users\\86158\\图片\\110300202.jpg"));3clipboard.setContent(content);java
  
   ```java
   label.setOnDragDone(new EventHandler<DragEvent>() {  
       @Override  
       public void handle(DragEvent event) {  
           if (event.getTransferMode() == TransferMode.MOVE) {  
               label.setText("");  
           }  
       }  
   });
   ```
   
   ![](../assets/VeryCapture_20220602092416.gif)
   
   #### 将外部图片拖拽到界面中
6. 拖拽进入到hBox
  
   ```java
   hBox.setOnDragEntered(event -> {  
       // 设置拖拽进入时的边框效果
       hBox.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));  
       // System.out.println("setOnDragEntered:event.getTransferMode() = " + event.getTransferMode());  // MOVE  
   });
   ```
   
7. 拖拽退出到hBox外
  
   ```java
   hBox.setOnDragExited(event -> {  
       hBox.setBorder(null);  
   });
   ```
   
8. 拖拽经过hBox
  
   ```java
   hBox.setOnDragOver(event -> {  
       // System.out.println("setOnDragOver:event.getTransferMode() = " + event.getTransferMode());  // MOVE  
       event.acceptTransferModes(event.getTransferMode());  
   });
   ```
   
9. 拖拽释放
  
   ```java
   hBox.setOnDragDropped(event -> {  
       // 获取拖拽面板  
       Dragboard dragboard = event.getDragboard();  
       // 加载URL  
       if (dragboard.hasUrl()) {  
           imageView.setImage(new Image(dragboard.getUrl()));  
       }  
   });
   ```

![](../assets/VeryCapture_20220602092825.gif)