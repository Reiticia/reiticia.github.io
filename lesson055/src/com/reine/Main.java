package com.reine;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * 单向绑定和双向绑定，绑定两者数据类型相同
 *
 * @author reine
 * 2022/5/23 8:00
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===========单向绑定===========");
        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(5);
        // x绑定y，y是多少x是多少
        x.bind(y);
        System.out.println("x.get() = " + x.get());
        System.out.println("y.get() = " + y.get());
        y.set(10);
        System.out.println("x.get() = " + x.get());
        y.set(100);
        System.out.println("x.get() = " + x.get());
        // java.lang.RuntimeException: A bound value cannot be set.
        // x.set(9);
        System.out.println("x.isBound() = " + x.isBound()); // 判断是否被禁止修改值
        System.out.println("y.isBound() = " + y.isBound());
        // 解绑
        x.unbind();
        System.out.println("===========双向绑定===========");
        x.set(1);
        y.set(5);
        // 双向绑定，初始化以括号内的为准
        x.bindBidirectional(y);
        System.out.println("x.get() = " + x.get());
        System.out.println("y.get() = " + y.get());
        x.set(30);
        System.out.println("x.get() = " + x.get());
        System.out.println("y.get() = " + y.get());
        System.out.println("x.isBound() = " + x.isBound());
        System.out.println("y.isBound() = " + y.isBound());
        // 解绑，下面两个语句皆可
        x.unbindBidirectional(y);
        y.unbindBidirectional(x);
    }
}
