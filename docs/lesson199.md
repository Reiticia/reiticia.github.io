### Media MediaPlayer音频播放

* 加载音频
  
```java
URL url = this.getClass().getClassLoader().getResource("music/バレンタインデーキッス.mp3");  
Media media = new Media(url.toExternalForm());  
MediaPlayer mediaPlayer = new MediaPlayer(media);
```

* 解码音频地址
  
```java
String decode = URLDecoder.decode(url.toExternalForm(), "UTF-8");// 解码  
System.out.println(decode);
```
* 
* 自动播放`mediaPlayer.setAutoPlay(true);`

```java
mediaPlayer.setOnMarker(event -> {
    System.out.println("" + ColorConsole.BLUE + event.getMarker() + ColorConsole.RESET);
    // 打印标记 
    if (event.getMarker().getKey().equals("a")){ 
        primaryStage.setTitle("a"); 
    } 
});
```

```java
mediaPlayer.setOnReady(() -> {  
    System.out.println("media.getDuration().toSeconds() = " + media.getDuration().toSeconds());// 获取音频时长  
    System.out.println("mediaPlayer.getTotalDuration().toSeconds() = " + mediaPlayer.getTotalDuration().toSeconds());// 获取音频时长  
});
```

* 设置音量0~1`mediaPlayer.setVolume(0.3);`

* 设置播放速率`mediaPlayer.setRate(3);`

* 设置开始时间`mediaPlayer.setStartTime(Duration.seconds(10));`

* 设置结束时间`mediaPlayer.setStopTime(Duration.seconds(20));`

* 设置循环次数，无限循环`mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);`

* 获取循环次数`mediaPlayer.getCycleCount();`

* 静音`mediaPlayer.setMute(true);`

* 获取当前播放时间`mediaPlayer.getCurrentTime()`

* 状态改变
  
```java
mediaPlayer.play();// 播放
mediaPlayer.stop();// 停止
mediaPlayer.pause();// 暂停
mediaPlayer.dispose();// 注销音乐，释放资源
```