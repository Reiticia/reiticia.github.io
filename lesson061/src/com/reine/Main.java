package com.reine;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 绑定：集合类型：valueAt()
 *
 * @author reine
 * 2022/5/24 9:38
 */
public class Main {
    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList("a", "d", "c");
        SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
        ObjectBinding<String> value = listProperty.valueAt(0);
        System.out.println("value.get() = " + value.get());
        listProperty.set(0, "aa");
        System.out.println("value.get() = " + value.get());
        SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(0);
        ObjectBinding<String> value1 = listProperty.valueAt(integerProperty);
        System.out.println("value1.get() = " + value1.get());
        integerProperty.set(1);
        listProperty.set(1, "bb");
        System.out.println("value1.get() = " + value1.get());
    }
}
