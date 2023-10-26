---
lang: zh-CN
title: 鼠标事件（续）
---


# 鼠标事件（续）

* 获取此次点击位置和上次是否一致`event.isStillSincePress()`

* 获取点击属性`event.getPickResult()`

* 阻止事件传递（父传子）`circle.setMouseTransparent(true);`

* 使组件边界内部所有区域都具有事件监听效果`circle.setPickOnBounds(true);`