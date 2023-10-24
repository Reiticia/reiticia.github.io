### SwingNode

* 创建SwingNode`SwingNode swingNode = new SwingNode();`

* 添加Swing节点
  
```java
SwingUtilities.invokeLater(()->{  
    JPanel rootJP = new JPanel();  
    JButton button = new JButton("button");  
    JButton button1 = new JButton("button1");  
    rootJP.add(button);  
    rootJP.add(button1);  
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 100);// 布局类  
    rootJP.setLayout(flowLayout);  
    swingNode.setContent(rootJP);  
    button.addActionListener(e -> System.out.println("swing button"));  
    button1.addActionListener(e -> System.out.println("swing button1"));  
});
```
* 创建根节点并添加
  
```java
Button fxButton = new Button("fxButton");  
AnchorPane root = new AnchorPane();  
root.getChildren().addAll(swingNode,fxButton);
```

![](../assets/Pasted%20image%2020220621214752.png)