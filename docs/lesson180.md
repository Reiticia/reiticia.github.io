### 3D图形 SubScene子场景

* 创建子场景`SubScene subScene = new SubScene(root, 800, 800, false, SceneAntialiasing.BALANCED);`

* 将子场景添加到布局中`h.getChildren().addAll(button, textField, subScene);`

* 创建场景`Scene scene = new Scene(h);`

* 设置场景`primaryStage.setScene(scene);`

![](../assets/Pasted%20image%2020220618201608.png)