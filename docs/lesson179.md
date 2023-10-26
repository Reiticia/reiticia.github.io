---
lang: zh-CN
title: 3D图形 光源
---


# 3D图形 光源

## 环境光

* 创建环境光`AmbientLight ambientLight = new AmbientLight();`

* 设置颜色`ambientLight.setColor(Color.YELLOW);`

* 将环境光应用到立方体上`ambientLight.getScope().add(box);`

* 关闭环境光`ambientLight.setLightOn(false);`

![](../assets/Pasted%20image%2020220618192416.png)
  
## 点光源
* 创建点光源`PointLight pointLight = new PointLight();`

* 设置颜色`pointLight.setColor(Color.RED);`

* 将点光源应用到圆柱体上`pointLight.getScope().add(cylinder);`

* 关闭点光源`pointLight.setLightOn(false);`

* 设置位移
      
    ```java
    pointLight.setTranslateX(400);  
    pointLight.setTranslateY(400);  
    pointLight.setTranslateZ(-400);
    ```
  
![](../assets/Pasted%20image%2020220618192656.png)