### Animation 3D图形

* 旋转
  
```java
Timeline timelineR = new Timeline();  
Rotate rotate = new Rotate(0, 0, 0, 0);// 中心点  
rotate.setAxis(new Point3D(1, 1, 1));  
box.getTransforms().add(rotate);  
KeyValue angle1 = new KeyValue(rotate.angleProperty(), 0);  
KeyFrame kf1 = new KeyFrame(Duration.seconds(0), angle1);  
KeyValue angle2 = new KeyValue(rotate.angleProperty(), 360);  
KeyFrame kf2 = new KeyFrame(Duration.seconds(5), angle2);  
timelineR.getKeyFrames().addAll(kf1, kf2);  
timelineR.setCycleCount(Timeline.INDEFINITE);
```

* 旋转
  
```java
Timeline timelineS = new Timeline();  
Scale scale = new Scale(1, 1, 1, 0, 0, 0);// 中心点  
box.getTransforms().add(scale);  
KeyValue scale1x = new KeyValue(scale.xProperty(), 1);  
KeyValue scale1y = new KeyValue(scale.yProperty(), 1);  
KeyValue scale1z = new KeyValue(scale.zProperty(), 1);  
KeyFrame kf3 = new KeyFrame(Duration.seconds(0), scale1x, scale1y, scale1z);  
KeyValue scale2x = new KeyValue(scale.xProperty(), 2);  
KeyValue scale2y = new KeyValue(scale.yProperty(), 2);  
KeyValue scale2z = new KeyValue(scale.zProperty(), 2);  
KeyFrame kf4 = new KeyFrame(Duration.seconds(2), scale2x, scale2y, scale2z);  
timelineS.getKeyFrames().addAll(kf3, kf4);  
timelineS.setCycleCount(Timeline.INDEFINITE);  
timelineS.setAutoReverse(true);
```

![](../assets/VeryCapture_20220619195953.gif)
