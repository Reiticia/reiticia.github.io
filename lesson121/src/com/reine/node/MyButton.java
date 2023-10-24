package com.reine.node;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * 自定义按钮控件
 *
 * @author reine
 * 2022/6/12 13:14
 */
public class MyButton extends Button implements Cloneable {

    public MyButton() {
        super();
    }

    public MyButton(String text) {
        super(text);
    }

    public MyButton(String text, Node graphic) {
        super(text, graphic);
    }

    @Override
    public MyButton clone() throws CloneNotSupportedException {
        return (MyButton) super.clone();
    }
}