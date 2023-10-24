package com.reine;

import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 * 可观察集合中的一些方法
 *
 * @author reine
 * 2022/5/26 14:58
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----------rotate()----------");
        // ObservableList<String> list = FXCollections.observableArrayList();
        // list.add("a");
        // list.add("c");
        // list.add("e");
        // list.add("b");
        // list.add("d");
        //
        // // 从倒数第3个元素依此往后循环对列表元素进行排序
        // FXCollections.rotate(list, 3);
        // list.forEach(item -> System.out.print(item + " "));
        // System.out.println();
        // // 删除索引为1的元素
        // list.remove(1);
        // list.forEach(item -> System.out.print(item + " "));

        // System.out.println();
        System.out.println("----------Callback----------");
        // // 每次相list中添加元素时，会触发一次回调函数
        // ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
        //     /**
        //      * 此方法返回值将作为list的每个值
        //      * @param param
        //      * @return
        //      */
        //     @Override
        //     public Observable[] call(SimpleStringProperty param) {
        //         if (param.getValue().equals("c")) {
        //             System.out.println("str1.set(\"c\"); run into this method");
        //         }
        //         System.out.println("call : " + param.get());
        //         return new Observable[]{param};
        //     }
        // });
        //
        // SimpleStringProperty str1 = new SimpleStringProperty("a");
        // SimpleStringProperty str2 = new SimpleStringProperty("b");
        //
        // list.add(str1);
        // list.add(str2);
        // list.forEach(item -> System.out.print(item.get() + " "));
        // System.out.println();
        //
        // list.addListener(new ListChangeListener<SimpleStringProperty>() {
        //     @Override
        //     public void onChanged(Change<? extends SimpleStringProperty> c) {
        //         System.out.println("onChanged : " + c);
        //         while (c.next()) {
        //             System.out.println("c.wasUpdated() = " + c.wasUpdated());
        //         }
        //     }
        // });
        // // 重复地往集合中添加元素，只会调用一次call方法
        // list.add(str2);
        // list.forEach(item -> System.out.print(item.get() + " "));
        // System.out.println();
        //
        // str1.set("c");
        // list.forEach(item -> System.out.print(item.get() + " "));
        //
        // System.out.println();
        /* 该例子证明如果在创建可观察列表时没有指定回调函数callback，则当集合中存储的数据发生变化时，不会触发集合对应监视属性的监听方法*/
        System.out.println("----------无效例子----------");
        ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(param -> new Observable[]{param});
        // ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList();
        SimpleListProperty<SimpleStringProperty> listProperty = new SimpleListProperty<>(list);
        listProperty.addListener((ListChangeListener<SimpleStringProperty>) c -> {
            while (c.next()) {
                System.out.println("c.wasUpdated() = " + c.wasUpdated());
            }
        });
        SimpleStringProperty string1 = new SimpleStringProperty("aa");
        SimpleStringProperty string2 = new SimpleStringProperty("cc");
        listProperty.add(string1);
        listProperty.add(string2);
        string1.set("bb");

    }
}
