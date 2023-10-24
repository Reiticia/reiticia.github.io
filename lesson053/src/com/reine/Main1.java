package com.reine;

import com.reine.utils.Color;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.util.Iterator;
import java.util.Locale;

/**
 * set、map
 * @author reine
 * 2022/5/22 19:34
 */
public class Main1 {
    public static void main(String[] args) {

        System.out.println(Color.YELLOW + "===============Set=================");
        ObservableSet<String> set = FXCollections.observableSet("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        SimpleSetProperty<String> setProperty = new SimpleSetProperty<>(set);

        setProperty.addListener((SetChangeListener<String>) change -> {
            // 与list相同，但没有next方法
        });

        setProperty.add("a");
        Iterator<String> iterator = setProperty.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println("\n================================");
        setProperty.forEach(System.out::print);
        System.out.println(Color.BLUE + "\n===============Map=================");

        ObservableMap<String, String> map = FXCollections.observableHashMap();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            String s = Character.toString(c);
            map.put(s, s.toLowerCase(Locale.ROOT));
        }
        SimpleMapProperty<String, String> mapProperty = new SimpleMapProperty<>(map);

        mapProperty.forEach((s, s2) -> System.out.print(s + "-" + s2 + " "));

    }
}
