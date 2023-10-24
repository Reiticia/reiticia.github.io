### 3D图形 Material材质

* 创建材质`PhongMaterial phongMaterial = new PhongMaterial();`

* 设置漫反射颜色`phongMaterial.setDiffuseColor(Color.valueOf("#ff9966"));`

* 设置镜面反射颜色`phongMaterial.setSpecularColor(Color.WHITE);`

* 设置高光强度**越大高光面积越小**`phongMaterial.setSpecularPower(25);`

* 设置漫反射贴图`phongMaterial.setDiffuseMap(new Image("images/image.png"));`

* 设置法线贴图`phongMaterial.setBumpMap(new Image("images/fxImage.png"));`

* 设置自发光贴图`phongMaterial.setSelfIlluminationMap(new Image("images/image.png"));`

* 为3D图形设置材质`shape.setMaterial(phongMaterial);`

![](../assets/Pasted%20image%2020220618172420.png)