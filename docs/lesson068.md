# ImageView

* 设置图片`imageView.setImage(new Image("images/logo.png"));`

* 设置保持宽高比`imageView.setPreserveRatio(true);`

* 设置保持较好的图片压缩质量`imageView.setSmooth(true);`

* 设置宽高**如果设置了保持宽高比，则会以第一个设置为**
  
    ```java
    // 如果在新建image对象时设置了请求宽高，然后imageView又再次设置了宽高，则会在image获取到的图片宽高基础上再进行一次修改
    imageView.setFitWidth(100);  
    imageView.setFitHeight(100);
    ```

* 设置圆角
  
    ```java
    Rectangle rectangle = new Rectangle(100, imageView.prefHeight(-1));  
    // 圆弧水平直径  
    rectangle.setArcWidth(50);  
    // 圆弧垂直直径  
    rectangle.setArcHeight(50);  
    // 将图片剪切到rectangle图形上  
    imageView.setClip(rectangle);
    ```

* 图片截取
  
    ```java
    // 在图片距左上角(25,25)开始往右截75，再往下截75，此大小相对于原始图片尺寸而言
    Rectangle2D rectangle2D = new Rectangle2D(0, 0, 30, 30);  
    imageView.setViewport(rectangle2D);
    ```

* 获取图片设置宽高
      
    ```java
    imageView.getFitWidth();  
    imageView.getFitHeight();
    ```

* 获取节点布局调整方向`imageView.getContentBias();`

* 获取实际宽高
      
    ```java
    imageView.prefWidth(-1);
    imageView.prefHeight(-1);
    ```

* 鼠标拖动事件
      
    ```java
    // 鼠标拖动时改变图片截取的位置，但是没有保存，会导致每次松开鼠标后如果再次点击鼠标欲再次进行拖动，截图窗口位置会重置
    imageView.setOnMouseDragged(new EventHandler<MouseEvent>() {  
        @Override  
        public void handle(MouseEvent event) {  
            if (event.getSceneX() >= 100 || event.getSceneY() >= 100) {  
                return;  
            }  
            if (event.getSceneX() < 0 || event.getSceneY() < 0) {  
                return;  
            }  
            Rectangle2D rectangle2D = new Rectangle2D(event.getSceneX(), event.getSceneY(), 30, 30);  
            imageView.setViewport(rectangle2D);  
        }  
    });
    ```

## 案例：使用滚动面板实现图片移动

主要代码

```java
String path = "images/logo.png";  
Image image = new Image(path);  
ImageView imageView = new ImageView(image);  
imageView.setFitWidth(500);  
imageView.setFitHeight(500);  
ScrollPane scrollPane = new ScrollPane();  
scrollPane.setPrefSize(100,100);  
scrollPane.setContent(imageView);  
AnchorPane anchorPane = new AnchorPane(scrollPane);  
Scene scene = new Scene(anchorPane);  
primaryStage.setScene(scene);  
primaryStage.setTitle("Hello JavaFx");  
primaryStage.setWidth(800);  
primaryStage.setHeight(800);  
primaryStage.show();
```

![](../assets/VeryCapture_20220529201940.gif)