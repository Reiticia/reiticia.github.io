---
lang: zh-CN
title: 自定义3D图形
---


# 自定义3D图形

* 创建三角网格`TriangleMesh triangleMesh = new TriangleMesh();`

* 设置空间点位
  
    ```java
    float[] points = {  
        /*0*/0, 0, 0,  
        /*1*/100, 0, 0,  
        /*2*/100, 100, 0,  
        /*3*/0, 100, 0,  
        /*4*/100, 0, 100,  
        /*5*/100, 100, 100,  
        /*6*/0, 0, 100,  
        /*7*/0, 100, 100,  
    };  
    triangleMesh.getPoints().addAll(points);// 空间点位
    ```

* 设置贴图坐标点
  
    ```java
    float[] texCoords = {  
        /*0*/0, 0,  
        /*1*/0.5f, 0,  
        /*2*/0.5f, 0.5f,  
        /*3*/0, 0.5f,  
        /*4*/1, 0,  
        /*5*/1, 0.5f,  
        /*6*/0, -0.5f,  
        /*7*/0, 1,  
    };  
    triangleMesh.getTexCoords().addAll(texCoords);// 贴图坐标点
    ```

* 设置索引坐标
      
    ```java
    int[] faces = {  
        0, 0, 3, 3, 1, 1,  
        0, 0, 1, 1, 3, 3,  
        1, 1, 3, 3, 2, 2,  
        1, 1, 2, 2, 3, 3,  
        1, 1, 5, 5, 4, 4,  
        1, 1, 4, 4, 5, 5,  
        2, 2, 5, 5, 1, 1,  
        2, 2, 1, 1, 5, 5,  
        6, 6, 1, 1, 4, 4,  
        6, 6, 4, 4, 1, 1,  
        6, 6, 0, 0, 1, 1,  
        6, 6, 1, 1, 0, 0,  
        5, 5, 2, 2, 3, 3,  
        5, 5, 3, 3, 2, 2,  
        7, 7, 5, 5, 3, 3,  
        7, 7, 3, 3, 5, 5,  
        6, 6, 5, 5, 7, 7,  
        6, 6, 7, 7, 5, 5,  
        6, 6, 4, 4, 5, 5,  
        6, 6, 5, 5, 4, 4,  
        6, 6, 3, 3, 0, 0,  
        6, 6, 0, 0, 3, 3,  
        6, 6, 7, 7, 3, 3,  
        6, 6, 3, 3, 7, 7,  
    };  
    triangleMesh.getFaces().addAll(faces);// 索引坐标
    ```

* 加载三角网格`MeshView meshView = new MeshView(triangleMesh);`

* 设置材质`meshView.setMaterial(new PhongMaterial(Color.BLUE));`

![](../assets/Pasted%20image%2020220618220424.png)