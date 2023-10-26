---
lang: zh-CN
title: Animation StrokeTransition边框颜色过渡动画
---

# Animation StrokeTransition边框颜色过渡动画

* 创建缩放动画`StrokeTransition st = new StrokeTransition();`

* 设置动画持续时间`st.setDuration(Duration.seconds(3));`

* 设置动画的节点`st.setShape(rectangle);`

* 设置起始颜色`st.setFromValue(Color.BLUE);`

* 设置终止颜色`st.setToValue(Color.YELLOW);`

* 设置动画反向播放`st.setAutoReverse(true);`

* 设置动画循环次数`st.setCycleCount(Animation.INDEFINITE);`

![](../assets/VeryCapture_20220619225530.gif)