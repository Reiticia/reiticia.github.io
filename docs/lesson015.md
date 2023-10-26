---
lang: zh-CN
title: setManaged(false)、setVisible(false)、setOpacity(0)区别
---


# setManaged(false)、setVisible(false)、setOpacity(0)区别

* `setManaged(false)`设置这个组件脱离父组件的控制，将不会在父组件上进行显示，且后面的组件会往前靠拢，但不会将其移出父组件（即父组件里面的组件数量不变）

* `setVisible(false)`设置这个组件不可见，在父组件中这个组件将会消失在屏幕上，其原来位于的父组件中的位置会留空，不会将其移出父组件（即父组件里面的组件数量不变）

* `setOpacity(0)`设置组件透明度为0（即完全透明）