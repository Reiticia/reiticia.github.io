### 3D图形 立方体、柱体、球体

#### 立方体

* 创建立方体
  
```java
Box box = new Box(100, 100, 200);  
children.add(box);
```

* 平移与旋转
  
```java
Box node = (Box) hBox.getChildren().get(0);  
node.setTranslateZ(100);// 沿z轴平移100  
node.setRotationAxis(new Point3D(1, 0, 0));// 沿x轴旋转  
node.setRotate(45);// 沿x轴旋转45度
```

* 图形样式设置
  
```java
node2.setDrawMode(DrawMode.LINE);// 线框模式  
node2.setCullFace(CullFace.BACK);// 只显示前面的部分  
// node2.setCullFace(CullFace.FRONT);// 只显示后面的部分
```
  
![](../assets/Pasted%20image%2020220618150638.png)
  
#### 柱体
* 创建柱体`Cylinder cylinder = new Cylinder(50, 200, 64);`

![](../assets/Pasted%20image%2020220618150834.png)
  
#### 球体
* 创建球体`Sphere sphere = new Sphere(50, 64);`

* ![](../assets/Pasted%20image%2020220618150919.png)