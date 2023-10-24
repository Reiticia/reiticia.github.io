### 通过反射创建Node

1. 获取类`Class<?> classType = Class.forName("javafx.scene.control.Button")`

2. 获取构造方法`Constructor<? extends Node> constructors = node.getClass().getConstructor(String.class)`

3. 创建实例对象`Node node2 = constructors.newInstance("I'm a Text")`

4. 获取指定方法`Method method =  node.getClass().getMethod("setText", String.class)`

5. 调用方法`method.invoke(node, "No, I'm a button")`
