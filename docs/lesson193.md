### Animation ParallelTransition并行动画&SequentialTransition串行动画

**注意：子动画不需要设置节点，只需要在父动画中设置即可**
子动画

```java
// 位移动画  
TranslateTransition tt = new TranslateTransition();  
tt.setDuration(Duration.seconds(3));  
tt.setByX(400);  
// 旋转动画  
RotateTransition rt = new RotateTransition();  
rt.setDuration(Duration.seconds(3));  
rt.setByAngle(360);  
// 填充动画  
FillTransition ft = new FillTransition();  
ft.setDuration(Duration.seconds(3));  
ft.setFromValue(Color.RED);  
ft.setToValue(Color.YELLOW);
```

#### ParallelTransition并行动画

```java
ParallelTransition pt = new ParallelTransition();  
// pt.setNode(rectangle);// 设置动画的节点  
pt.getChildren().addAll(tt, rt); // 将动画添加到并行动画中  
// pt.setAutoReverse(true);// 设置动画反向播放  
// pt.setCycleCount(Animation.INDEFINITE);// 设置动画循环次数
```

#### SequentialTransition串行动画

```java
SequentialTransition st = new SequentialTransition();  
st.setNode(rectangle);// 设置动画的节点  
st.getChildren().addAll(ft, pt); // 将动画添加到并行动画中  
st.setAutoReverse(true);// 设置动画反向播放  
st.setCycleCount(Animation.INDEFINITE);// 设置动画循环次数
```

![](../assets/VeryCapture_20220620091230.gif)