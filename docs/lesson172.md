---
lang: zh-CN
title: 2D图形 SVGPath矢量图路径
---


# 2D图形 SVGPath矢量图路径

svg语法

| 语法                                  | 格式                                                    | 描述                                                                                                                                                                     |
| ----------------------------------- | ----------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| M = moveto                          | M x y 移动到指定坐标，xy分别为x轴和y轴的坐标点，类似画笔的起点                  | path中的起点，必须存在（文档中虽然没有提到过，但是path的其他命令都需要依赖一个初始位置，而实际操作过程中也没有需要到可以不使用M的情况，后面发现有例外我再过来补充。                                                                                 |
| L = lineto                          | L x y 在初始位置（M 画的起点）和xy确定的坐标画一条线。                      | 两点一线，直线，绘图中很常见的方式。                                                                                                                                                     |
| H = horizontal lineto               | H x 沿着x轴移动一段位置                                        |                                                                                                                                                                        |
| V = vertical lineto                 | V y 沿着y轴移动一段位置                                        |                                                                                                                                                                        |
| C = curveto                         | C x1 y1 x2 y2 x y  三次贝塞尔曲线                            | 当前点为起点，xy为终点，起点和x1y1控制曲线起始的斜率，终点和x2y2控制结束的斜率。                                                                                                                          |
| S = smooth curveto                  | S x2 y2 x y  简化的贝塞尔曲线                                 | 1.如果S命令跟在一个C命令或者另一个S命令的后面，它的第一个控制点，就会被假设成前一个控制点的对称点。 2.如果S命令单独使用，前面没有C命令或者另一个S命令，那么它的两个控制点就会被假设为同一个点。                                                                  |
| Q = quadratic Bézier curve          | Q x1 y1 x y  二次贝塞尔曲线Q                                 | 只需要一个控制点，用来确定起点和终点的曲线斜率。因此它需要两组参数，控制点和终点坐标。                                                                                                                            |
| T = smooth quadratic Bézier curveto | T x y Q命令的简写命令。                                       | 与S命令相似，T也会通过前一个控制点，推断出一个新的控制点。 1.T命令前面必须是一个Q命令，或者是另一个T命令 2.如果T单独使用，那么控制点就会被认为和终点是同一个点，所以画出来的将是一条直线                                                                     |
| A = elliptical Arc                  | A rx,ry x-axis-rotation large-arc-flag sweep-flag x,y | rx 弧的半长轴长度 ry 弧的半短轴长度 x-axis-rotation 是此段弧所在的x轴与水平方向的夹角，即x轴的逆时针旋转角度，负数代表顺时针旋转角度。 large-arc-flag 为1表示大角度弧线，0表示小角度弧线 sweep-flag 为1表示从起点到终点弧线绕中心顺时针方向，0表示逆时针方向。 xy 是终点坐标。 |
| Z = closepath                       |                                                       | 从当前位置到起点画一条直线闭合。                                                                                                                                                       |
| 示例                                  |                                                       |                                                                                                                                                                        |

```java
SVGPath svgPath = new SVGPath();  
// 与path类似（(0,0)开始 画直线到(100,100) 垂直100 水平-100 闭合）  
svgPath.setContent("m0,0 l100,100 v100 h-100 z");  
svgPath.setStroke(Color.RED);  
box.getChildren().add(svgPath);  
SVGPath svgPath1 = new SVGPath();  
// 与path类似（(0,0)开始 画三次贝塞尔曲线控制(50,-50)和(150,50)到(200,200)）  
svgPath1.setContent("m0,0 c50,-50,150,50,200,0 ");  
svgPath1.setStroke(Color.RED);  
box.getChildren().add(svgPath1);  
SVGPath svgPath2 = new SVGPath();  
// 与path类似（(0,0)开始 画简化贝塞尔曲线控制(50,-50)到(100,100)）  
svgPath2.setContent("m0,0 s50,-50,100,0");  
svgPath2.setStroke(Color.RED);  
box.getChildren().add(svgPath2);  
SVGPath svgPath3 = new SVGPath();  
// 与path类似（(0,0)开始 画二次贝塞尔曲线控制(50,-50)到(100,100)）  
svgPath3.setContent("m0,0 q50,-50,100,0");  
svgPath3.setStroke(Color.RED);  
box.getChildren().add(svgPath3);  
SVGPath svgPath4 = new SVGPath();  
// 与path类似（(0,0)开始 画二次贝塞尔曲线控制(50,-50)到(100,100) 以二次贝塞尔曲线控制点(50,-50)的中心对称点为控制点画到(100,0)）  
svgPath4.setContent("m0,0 q50,-50,100,0 t100,0 ");  
svgPath4.setStroke(Color.RED);  
box.getChildren().add(svgPath4);  
SVGPath svgPath5 = new SVGPath();  
// 与path类似（(0,0)开始 画弧线从以100为横半径100为纵半径横轴旋转0°取长边顺时针到(100,100)）  
svgPath5.setContent("m0,0 a100,100,0,1,1,100,100 ");  
svgPath5.setStroke(Color.RED);  
box.getChildren().add(svgPath5);
```

![](../assets/Pasted%20image%2020220617224532.png)