package com.reine;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 绑定判断
 *
 * @author reine
 * 2022/5/23 12:31
 */
public class Main {
    public static void main(String[] args) {
        SimpleIntegerProperty a = new SimpleIntegerProperty(1);
        SimpleIntegerProperty b = new SimpleIntegerProperty(2);
        System.out.println("a.add(10).subtract(14).divide(2.0).multiply(3).get() = "
                + a.add(10).subtract(14).divide(2.0).multiply(b).get());
        System.out.println("============绑定判断============");
        // 大于、小于、等于、不等于、大于等于、小于等于
        BooleanBinding greaterThan = a.greaterThan(b);
        BooleanBinding lessThan = a.lessThan(b);
        BooleanBinding equalTo = a.isEqualTo(b);
        // ...
        // 判断是否相等，第二个参数代表误差为1
        a.set(9);
        System.out.println("a.isEqualTo(10,1) = " + a.isEqualTo(10, 1).get());
        System.out.println("greaterThan = " + greaterThan.get());
        System.out.println("lessThan = " + lessThan.get());
        System.out.println("equalTo = " + equalTo.get());

        a.set(3);
        System.out.println("greaterThan = " + greaterThan.get());
        System.out.println("lessThan = " + lessThan.get());
        System.out.println("equalTo = " + equalTo.get());

    }
}
