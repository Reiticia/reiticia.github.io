package com.reine;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 绑定：三元运算
 *
 * @author reine
 * 2022/5/23 20:13
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=============When==============");
        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(2);
        SimpleBooleanProperty b = new SimpleBooleanProperty(true);
        NumberBinding TO = new When(x.greaterThan(y)).then(10).otherwise(20);
        System.out.println("TO.get() = " + TO.doubleValue());
        x.set(3);
        System.out.println("TO.get() = " + TO.doubleValue());
        StringBinding TO1 = new When(x.greaterThan(y)).then("100").otherwise("200");
        System.out.println("TO1.get() = " + TO1.get());
        NumberBinding TO2 = new When(x.greaterThan(y)).then(new SimpleIntegerProperty(5)).otherwise(new SimpleIntegerProperty(6));
        System.out.println("TO2.intValue() = " + TO2.intValue());
    }
}
