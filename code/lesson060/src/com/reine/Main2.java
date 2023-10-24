package com.reine;

import com.reine.utils.Color;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 绑定：集合类型：List：绑定内容：会修改对应的集合内容
 *
 * @author reine
 * 2022/5/24 9:38
 */
public class Main2 {
    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
        SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
        ObservableList<String> list1 = FXCollections.observableArrayList("A", "D", "C");
        SimpleListProperty<String> listProperty1 = new SimpleListProperty<>(list1);

        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());

        // 单向绑定内容：将被调用者对应的集合绑定到调用者对应的集合，被调用者对应的集合的更新，会影响调用者对应的集合，而调用者对应的集合的更新，不会影响被调用者对应的集合
        listProperty.bindContent(listProperty1);
        System.out.println(Color.RED + "--------------listProperty.bindContent(listProperty1)--------------" + Color.RESET);
        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());

        listProperty.add("b");
        listProperty1.add("B");
        // listProperty添加的元素不会影响到listProperty1，而listProperty1添加的元素会影响到listProperty
        System.out.println(Color.RED + "--------------listProperty.add(\"b\");listProperty1.add(\"B\")--------------" + Color.RESET);
        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
        System.out.println("list = " + list + " | " + "list1 = " + list1);

        // 对括号内的元素进行排序时，括号外元素中对应的属性也会进行排序，不对应的元素保持不变，对括号外元素进行排序时，不会影响括号内的元素
        listProperty.sort(String::compareTo);
        System.out.println(Color.RED + "--------------listProperty.sort(String::compareTo)--------------" + Color.RESET);
        System.out.println("listProperty.get() = " + listProperty.get() + " | " + "listProperty1.get() = " + listProperty1.get());
        System.out.println("list = " + list + " | " + "list1 = " + list1);
    }
}
