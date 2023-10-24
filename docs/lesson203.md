### Media MediaPlayer获取音乐频谱数据

* 设置频谱刷新频率，默认为0.1s`mediaPlayer.setAudioSpectrumInterval(1.0);`

* 频谱阈值，设置为-100dB`mediaPlayer.setAudioSpectrumThreshold(-100);`

* 设置频谱绘制的频率带数量，默认为128`mediaPlayer.setAudioSpectrumNumBands(50);`

* 设置音频频谱的监听器
  
```java
mediaPlayer.setAudioSpectrumListener(new AudioSpectrumListener() {  
    @Override  
    public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {  
        // System.out.println(timestamp + " " + duration);  
        // System.out.println(magnitudes.length);// 音乐频谱变化幅度（128）  
        // System.out.println(magnitudes[46]);// 振幅  
        System.out.println(phases[44]);  
    }  
});
```