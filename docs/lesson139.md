---
lang: zh-CN
title: WebView
---

# WebView

* 创建WebView`WebView webView = new WebView();`

* 获取Engine`WebEngine engine = webView.getEngine();`

* 加载网页`engine.load("https://www.baidu.com");`

* 设置网页字体大小`webView.setFontScale(0.5);`

* 网页缩放`webView.setZoom(0.5);`

* 加载HTML文本
  
    ```java
    String html = "<html>" +  
          "<head>" +  
          "<title>JavaFX WebView</title>" +  
          "</head>" +  
          "<body>" +  
          "<h1>Hello World</h1>" +  
          "</body>" +  
          "</html>";  
    engine.loadContent(html, "text/html");
    ```

![](../assets/Pasted%20image%2020220615074255.png)