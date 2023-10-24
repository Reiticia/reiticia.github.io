### Media媒体 AudioClip短音频播放

1. 获取音频文件`URL url = this.getClass().getClassLoader().getResource("music/Ring01.wav");`

2. 加载音频文件`AudioClip ac = new AudioClip(url.toExternalForm());`

3. 播放设置
   
   ```java
   // ac.setBalance(1);// 左声道  
   // ac.setBalance(-1);// 右声道  
   ac.setBalance(0);// 左右声道均衡  
   // ac.setPan(1);  
   ac.setPriority(1);// 设置优先级  
   ac.setRate(3);// 设置播放速率  
   // ac.setCycleCount(AudioClip.INDEFINITE);// 设置循环次数  
   ac.setVolume(1);// 设置音量0~1
   ```
   
4. 播放`ac.play();`

5. 停止`ac.stop();`

6. 获取播放状态`ac.isPlaying()`