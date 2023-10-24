### Media MediaView视频播放

* 创建视频播放器
  
```java
String music = "file:/C:/Users/86158/桌面/2ada3de244a02335936a408e8efff631.mp4";  
Media media = new Media(music);  
MediaPlayer mediaPlayer = new MediaPlayer(media);  
mediaPlayer.setVolume(0.5);// 设置音量  
MediaView mediaView = new MediaView(mediaPlayer);// 创建一个MediaView对象，用于显示视频
```

* 设置不保持宽高比（默认保持）`mediaView.setPreserveRatio(false);`

* 设置宽高
  
```java
mediaView.setFitWidth(200);  
mediaView.setFitHeight(200);
```

* 设置是否平滑播放`mediaView.setSmooth(true);`

* 截取视频视图
  
```java
Rectangle2D rectangle2D = new Rectangle2D(0, 0, 200, 200);  
mediaView.setViewport(rectangle2D);// 截取视频中200*200的区域，位置从(0,0)开始
```

* 设置视频效果
  
```java
ColorAdjust colorAdjust = new ColorAdjust();  
colorAdjust.setHue(-0.5);  
mediaView.setEffect(colorAdjust);// 设置视频效果
```

* 获取宽高
  
```java
mediaPlayer.setOnReady(() -> {  
  System.out.println(media.getWidth());  
  System.out.println(media.getHeight());  
});
```
