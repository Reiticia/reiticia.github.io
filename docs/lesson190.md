### Animation FillTransition颜色过渡动画

* 创建颜色过渡动画`FillTransition ft = new FillTransition();`

* 设置动画持续时间`ft.setDuration(Duration.seconds(3));`

* 设置动画的图形`ft.setShape(rectangle);`

* 设置起始颜色`ft.setFromValue(Color.RED);`

* 设置终止颜色`ft.setToValue(Color.BLUE);`

* 设置动画反向播放`ft.setAutoReverse(true);`

* 设置动画循环次数`ft.setCycleCount(Animation.INDEFINITE);`

![](../assets/VeryCapture_20220619224539.gif)