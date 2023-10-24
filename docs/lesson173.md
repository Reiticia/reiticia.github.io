### 2D图形 图形计算

* 图形裁切`imageView.setClip(circle);`

* 取交集**如果原来的图形有边框，则获得的图形对应位置会有原来图形的边框**`Shape.intersect(cir, rectangle)`

* 取差集**如果原来的图形有边框，则获得的图形对应位置会有原来图形的边框**`Shape.subtract(cir, rectangle)`

* 取并集**如果原来的图形有边框，则获得的图形对应位置会有原来图形的边框**`Shape.union(cir, rectangle)`

![](../assets/Pasted%20image%2020220618090847.png)