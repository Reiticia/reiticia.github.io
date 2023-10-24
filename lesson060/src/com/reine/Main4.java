package com.reine;

import com.reine.utils.Color;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

/**
 * Set和Map绑定
 *
 * @author reine
 * 2022/5/24 10:52
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(Color.BLUE + "=============================Set=============================" + Color.RESET);
        ObservableSet<String> set = FXCollections.observableSet("A", "D", "C");
        SimpleSetProperty<String> setProperty = new SimpleSetProperty<>(set);
        ObservableSet<String> set1 = FXCollections.observableSet("a", "d", "c");
        SimpleSetProperty<String> setProperty1 = new SimpleSetProperty<>(set1);

        System.out.println("setProperty.get() = " + setProperty.get() + " | " + "setProperty1.get() = " + setProperty1.get());
        setProperty.bind(setProperty1);
        System.out.println(Color.RED + "--------------setProperty.bind(setProperty1)--------------" + Color.RESET);
        System.out.println("setProperty.get() = " + setProperty.get() + " | " + "setProperty1.get() = " + setProperty1.get());
        System.out.println("set = " + set + " | " + "set1 = " + set1);
        setProperty.add("b");
        setProperty1.add("B");
        System.out.println(Color.RED + "--------------setProperty.add(\"b\");setProperty1.add(\"B\")--------------" + Color.RESET);
        System.out.println("setProperty.get() = " + setProperty.get() + " | " + "setProperty1.get() = " + setProperty1.get());
        System.out.println("set = " + set + " | " + "set1 = " + set1);

        System.out.println(Color.BLUE + "=============================Map=============================" + Color.RESET);
        ObservableMap<String, String> map = FXCollections.observableHashMap();
        map.put("A", "a");
        map.put("D", "d");
        map.put("C", "c");
        SimpleMapProperty<String, String> mapProperty = new SimpleMapProperty<>(map);
        ObservableMap<String, String> map1 = FXCollections.observableHashMap();
        map1.put("a", "A");
        map1.put("d", "D");
        map1.put("c", "C");
        SimpleMapProperty<String, String> mapProperty1 = new SimpleMapProperty<>(map1);
        System.out.println("mapProperty.get() = " + mapProperty.get() + " | " + "mapProperty1.get() = " + mapProperty1.get());
        mapProperty.bind(mapProperty1);
        System.out.println(Color.RED + "--------------mapProperty.bind(mapProperty1)--------------" + Color.RESET);
        System.out.println("mapProperty.get() = " + mapProperty.get() + " | " + "mapProperty1.get() = " + mapProperty1.get());
        System.out.println("map = " + map + " | " + "map1 = " + map1);
        mapProperty.put("B", "b");
        mapProperty1.put("b", "B");
        System.out.println(Color.RED + "--------------mapProperty.put(\"B\", \"b\");mapProperty1.put(\"b\", \"B\")--------------" + Color.RESET);
        System.out.println("mapProperty.get() = " + mapProperty.get() + " | " + "mapProperty1.get() = " + mapProperty1.get());
        System.out.println("map = " + map + " | " + "map1 = " + map1);

    }
}
