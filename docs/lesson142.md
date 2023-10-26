---
lang: zh-CN
title: Color
---


# Color

获取颜色的几种方法

```java
list.add(Color.valueOf("#ffcccc"));  
list.add(Color.valueOf("#ffcccc55"));  
list.add(Color.valueOf("0xffcccc"));  
list.add(Color.CADETBLUE);  
list.add(Color.MEDIUMAQUAMARINE);  
list.add(new Color(58.0 / 255, 95.0 / 255, 85.0 / 255, 1.0));  
list.add(new Color(58.0 / 255, 95.0 / 255, 85.0 / 255, 0.5));  
list.add(new Color(58.0 / 255, 95.0 / 255, 85.0 / 255, 0));  
list.add(Color.rgb(199, 84, 80, 1));  
list.add(Color.hsb(205, 0.55, 0.96, 1));  
Color color = Color.rgb(255, 102, 102);  
list.add(color.deriveColor(-100, 1, 1, 1));  
list.add(Color.web("rgb(102,51,102)", 0.5));  
list.add(Color.gray(0.5, 1));  
list.add(Color.grayRgb(128, 1));  
list.add(Color.rgb(54, 105, 198, 1));  
list.add(Color.rgb(54, 105, 198, 1).brighter()); // 更亮  
list.add(Color.rgb(54, 105, 198, 1).darker()); // 更暗  
list.add(Color.rgb(54, 105, 198, 1).saturate()); // 更饱和  
list.add(Color.rgb(54, 105, 198, 1).desaturate()); // 更淡  
list.add(Color.rgb(54, 105, 198, 1).grayscale()); // 更灰  
list.add(Color.rgb(54, 105, 198, 1).invert()); // 更反色
```
