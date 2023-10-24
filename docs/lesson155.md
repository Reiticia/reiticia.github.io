### DisplacementMap位移图

* 创建位移图`DisplacementMap displacementMap = new DisplacementMap();`

* 从左到右50%的图形不可见，如果为负数，则从右到左`displacementMap.setOffsetX(0.5);`

* 从上到下50%的图形不可见，如果为负数，则从下到上`displacementMap.setOffsetY(0.5);`

* 如果为true，则图形不可见区域会被可见区域平铺填充`displacementMap.setWrap(true);`

* 如果为true，则图形不可见区域会被可见区域平铺填充`displacementMap.setWrap(true);`

* 设置图形错位
  
```java
int w = 100;  
int h = 100;  
FloatMap floatMap = new FloatMap(w, h);  
float value = 0.5f; // 错位距离，越大越远  
for (int i = 0; i < floatMap.getWidth(); i++) {  
    for (int j = 0; j < floatMap.getHeight(); j++) {  
        float tmp;  
        if (j < h / 2) {  
            tmp = value;  
        } else {  
            tmp = value * -1;  
        }  
        floatMap.setSamples(i, j, tmp, 0);  
    }  
}  
displacementMap.setMapData(floatMap);
```
* 图形缩放比例
  
```java
displacementMap.setScaleX(0.5);  
displacementMap.setScaleY(0.5);
```

![](../assets/Pasted%20image%2020220616170215.png)