---
lang: zh-CN
title: Animation FadeTransition渐变动画
---


# Animation FadeTransition渐变动画

* 创建渐变动画`FadeTransition ft = new FadeTransition();`

* 设置动画持续时间`ft.setDuration(Duration.seconds(1));`

* 设置动画的节点`ft.setNode(rectangle);`

* 设置起始透明度`ft.setFromValue(1);`

* 设置终止透明度`ft.setToValue(0);`

* 每次渐变的透明度**如果和setTo同时存在，则该设置无效**`ft.setByValue(-1);`

* 设置动画反向播放`ft.setAutoReverse(true);`

* 设置动画循环次数`ft.setCycleCount(2);`

![](../assets/VeryCapture_20220619223802.gif)