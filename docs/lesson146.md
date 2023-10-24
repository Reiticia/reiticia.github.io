### DropShadow投影效果

* 创建投影效果`DropShadow dropShadow = new DropShadow();`

* 设置阴影颜色`dropShadow.setColor(Color.valueOf("#00000055"));`

* 设置阴影面积（0~255）
  
```java
dropShadow.setWidth(100);  
dropShadow.setHeight(100);
```
  
* 移动阴影区域
  
```java
dropShadow.setOffsetX(10);  
dropShadow.setOffsetY(10);
```

* 设置模糊效果
  
```java
// 任选其一
dropShadow.setBlurType(BlurType.GAUSSIAN);  
dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
```
  
* 设置阴影半径`dropShadow.setRadius(10);`

* 设置阴影模糊程度（0.0~1.0）`dropShadow.setSpread(0.5);`
 

![](../assets/Pasted%20image%2020220616085351.png)