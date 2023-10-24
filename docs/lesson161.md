### Lighting类光照效果

* 创建类光照效果`Lighting lighting = new Lighting();`

* 立体效果`lighting.setSurfaceScale(10);`

* 漫反射`lighting.setDiffuseConstant(2);`

* 镜面反射`lighting.setSpecularConstant(2);`

* 镜面反射强度`lighting.setSpecularExponent(40);`

* 光照类型
  
```java
Light.Distant light = new Light.Distant();  
light.setColor(Color.AQUA);  
light.setAzimuth(270); // 设置光照方向  
light.setElevation(10);// 设置阴影程度，越低阴影越重  
lighting.setLight(light);
```

* 效果叠加
  
```java
GaussianBlur gaussianBlur = new GaussianBlur(15);  
lighting.setBumpInput(gaussianBlur);
```

![](../assets/Pasted%20image%2020220616200742.png)