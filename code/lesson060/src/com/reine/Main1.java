package com.reine;

import com.reine.utils.Color;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 绑定：集合类型：List：双向绑定：效果和单向绑定一样，不会修改对应的集合内容
 *
 * @author reine
 * 2022/5/24 9:38
 */
public class Main1 {
    public static void main(String[] args) {
        // 创建可观察列表
        ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
        // 创建该列表的监视属性
        SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
        ObservableList<String> list1 = FXCollections.observableArrayList("A", "D", "C");
        SimpleListProperty<String> listProperty1 = new SimpleListProperty<>(list1);

        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());

        // 单向绑定：绑定的两个属性同时维护一个列表集合，对任意一个属性的更新，都会影响被绑定的元素对应的集合
        listProperty.bindBidirectional(listProperty1);
        System.out.println(Color.RED + "--------------listProperty.bindBidirectional(listProperty1)--------------" + Color.RESET);
        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());

        listProperty.add("b");
        listProperty1.add("B");
        System.out.println(Color.RED + "--------------listProperty.add(\"b\");listProperty1.add(\"B\")--------------" + Color.RESET);
        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
        System.out.println("list = " + list + " | " + "list1 = " + list1);

        listProperty.sort(String::compareTo);
        System.out.println(Color.RED + "--------------listProperty.sort(String::compareTo)--------------" + Color.RESET);
        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
        System.out.println("list = " + list + " | " + "list1 = " + list1);
    }
}
