---
lang: zh-CN
title: 设置快捷键
---


# 设置快捷键

* 方式一
  
    ```java
    // KeyCodeCombination第一个参数是主按键，后面的参数为辅助按键（可变参数）
    KeyCombination keyCombination = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);  
    Mnemonic mnemonic = new Mnemonic(button, keyCombination);  
    scene.addMnemonic(mnemonic);
    ```

* 方式二
  
    ```java
    // KeyCharacterCombination第一个参数是主按键，后面的参数为辅助按键（可变参数）
    KeyCharacterCombination a = new KeyCharacterCombination("a", KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);  
    Mnemonic mnemonic1 = new Mnemonic(button, a);
    scene.addMnemonic(mnemonic1);
    ```

* 方式三
  
    ```java
    KeyCodeCombination keyCodeCombination = new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN);
    scene.getAccelerators().put(keyCodeCombination, new Runnable() {  
        @Override  
        public void run() {  
            System.out.println("RUN");  
            System.out.println(Thread.currentThread().getName());  
        }  
    });
    ```
    
    
    > RUN  
    > JavaFX Application Thread