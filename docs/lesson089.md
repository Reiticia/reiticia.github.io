---
lang: zh-CN
title: Text&Font
---


# Text&Font

## Font字体

* 创建字体`Font font1 = new Font("AdobeDevanagari-Regular", 25);`

* 加载字体`Font font3 = Font.loadFont("file:E:\\Aria2\\Aria2Download\\POLYA.otf", 25);`

* 设置字体样式`Font font4 = Font.font("Trebuchet MS", FontWeight.BLACK, FontPosture.ITALIC, 25);`

* 获取系统中所有安装字体
  
    ```java
    Font.getFamilies().forEach(System.out::println);  
    System.out.println("------------------------");  
    Font.getFontNames().forEach(System.out::println);
    ```
      
## Text文本
* 创建文本`Text text2 = new Text("Hello World");`

* 设置字体`text.setFont(font);`

* 填充颜色`text5.setFill(Color.RED);`

* 描边颜色`text5.setStroke(Color.YELLOW);`

* 描边宽度`text5.setStrokeWidth(3);`

* 抗锯齿`text5.setSmooth(true);`

* 下划线`text5.setUnderline(true);`

* 删除线`text5.setStrikethrough(true);`

* 字体平滑`text5.setFontSmoothingType(FontSmoothingType.LCD);`

* 每行文本居中对齐`text6.setTextAlignment(TextAlignment.LEFT);`

* 行间距`text6.setLineSpacing(10);`

* 用像素限制宽度`text6.setWrappingWidth(30);`

* 设置位置
      
    ```java
    text.setX(100);  
    text.setY(100);
    ```
  
* 四种位置对齐方式（不能共存，以最后一个设置为准）
  
    ```java
    // 位置对齐方式：以左上角为观测点计算坐标(X,Y)  
    text.setTextOrigin(VPos.TOP);  
    // 位置对齐方式：以中间为观测点计算坐标(X,Y)  
    text.setTextOrigin(VPos.CENTER);  
    // 位置对齐方式：以左下角为观测点计算坐标(X,Y)  
    text.setTextOrigin(VPos.BASELINE);  
    // 位置对齐方式：以左下角为观测点计算坐标(X,Y)，相比上面一行文本会向上移动一点  
    text.setTextOrigin(VPos.BOTTOM);
    ```