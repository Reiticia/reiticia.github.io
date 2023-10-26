---
lang: zh-CN
title: Animation RotateTransition旋转动画
---

# Animation RotateTransition旋转动画

* 创建旋转动画`RotateTransition rt = new RotateTransition();`

* 设置动画持续时间`rt.setDuration(Duration.seconds(3));`

* 设置动画的节点`rt.setNode(rectangle);`

* 设置起始角度`rt.setFromAngle(0);`

* 设置终止角度`rt.setToAngle(360);`

* 设置偏移角度`rt.setByAngle(360);`

* 设置旋转轴`rt.setAxis(new Point3D(0,0,1));`

* 设置插值器，默认是匀速`rt.setInterpolator(Interpolator.LINEAR);`

**不能设置旋转点，默认以中心点作为旋转点**
![](../assets/VeryCapture_20220619215439.gif)