### ImageInput图片填充

```java
ImageInput imageInput = new ImageInput();  
imageInput.setX(0);  
imageInput.setY(0);  
imageInput.setSource(new Image("emoji/1f612.png"));  
DropShadow dropShadow = new DropShadow();  
dropShadow.setRadius(30);  
dropShadow.setInput(imageInput);
```

![](../assets/Pasted%20image%2020220616172741.png)