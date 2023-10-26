---
lang: zh-CN
title: 3D图形
---


# 3D图形

* 创建场景时启用3D渲染`Scene scene = new Scene(root, 800, 800, true);`

* 设置3d渲染效果的透视相机`scene.setCamera(new PerspectiveCamera())`

* 放置组件
  
```java
Button button1 = new Button("button1");  
button1.setTranslateZ(0);  
// button1.setDepthTest(DepthTest.ENABLE);// 启用3d渲染机制  
Button button2 = new Button("button2");  
button2.setTranslateZ(300);  
// button2.setDepthTest(DepthTest.ENABLE);  
Button button3 = new Button("button3");  
button3.setTranslateZ(600);  
// button3.setDepthTest(DepthTest.ENABLE);  
Button button4 = new Button("button4");  
button4.setTranslateZ(50);  
// 由于没有启用深度测试，并且button4比button1晚设置，所以button4会覆盖button1  
button4.setDepthTest(DepthTest.DISABLE); 
AnchorPane root = new AnchorPane();  
root.setDepthTest(DepthTest.ENABLE);// 禁用3d渲染机制  
root.setStyle("-fx-background-color: #FFFFFF00");  
root.getChildren().addAll(button1, button2, button3,button4);
```