package com.reine;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 绑定计算
 *
 * @author reine
 * 2022/5/23 10:44
 */
public class Main {
    public static void main(String[] args) {
        SimpleIntegerProperty a = new SimpleIntegerProperty(1);
        SimpleIntegerProperty b = new SimpleIntegerProperty(2);
        IntegerBinding aAdd6 = a.add(6);
        System.out.println("aAdd6.get() = " + aAdd6.get());
        System.out.println(a.get() == aAdd6.get());
        NumberBinding aAddB = a.add(b);
        System.out.println(aAddB.intValue());
        System.out.println("a.subtract(1).get() = " + a.subtract(2).get());
        System.out.println("a.multiply(2.0).get() = " + a.multiply(2.0).get());
        System.out.println("a.divide(2.0).get() = " + a.divide(2.0).get());
        System.out.println("============绑定计算============");
        a.set(10);
        // 计算的变量发生改变，则结果也会跟着改变
        System.out.println("aAdd6.get() = " + aAdd6.get());
        b.set(20);
        System.out.println("aAddB.intValue() = " + aAddB.intValue());
        SimpleIntegerProperty x = new SimpleIntegerProperty(6);
        System.out.println("x.negate().get() = " + x.negate().get()); // 取相反数
        SimpleBooleanProperty flag = new SimpleBooleanProperty(false);
        System.out.println("flag.not().get() = " + flag.not().get()); // 取非
    }
}
