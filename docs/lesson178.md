### 3D图形 Camera摄像机（透视相机）

* 创建透视相机`PerspectiveCamera camera = new PerspectiveCamera();`

* 设置相机位置
  
```java
camera.setTranslateX(300); 
// camera.setTranslateY(300);  
camera.setTranslateZ(-500);
```
* 旋转
  
```java
camera.setRotationAxis(Rotate.Y_AXIS);// 旋转轴设置为Y轴  
camera.setRotate(60);// 旋转60°
```
* 设置视野角度`camera.setFieldOfView(100);`

* 设置近野裁切面为1.2`camera.setNearClip(1.2);`

* 设置远野裁切面为100`camera.setFarClip(100);`

