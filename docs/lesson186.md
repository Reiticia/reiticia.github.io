### Animation TranslateTransition位移动画

* 创建位移动画`TranslateTransition tt = new TranslateTransition();`

* 设置动画持续时间`tt.setDuration(Duration.seconds(3));`

* 设置动画的节点`tt.setNode(rectangle);`

* 设置起始位置
  
```java
tt.setFromX(0);// 起始位置  
tt.setFromY(0);
```

* 设置终止位置

```java
tt.setToX(500);// 终止位置  
tt.setToY(500);
```

* 设置偏移量**如果和setTo同时存在，则该设置无效**

```java
// tt.setByX(100);// 偏移量
// tt.setByY(100);
```

* 设置动画反向播放`tt.setAutoReverse(true);`

* 设置动画循环播放`tt.setCycleCount(Animation.INDEFINITE);`

* 设置插值器，默认是匀速`tt.setInterpolator(Interpolator.LINEAR);`


![](../assets/VeryCapture_20220619203209.gif)