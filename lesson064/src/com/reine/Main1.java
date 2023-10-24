package com.reine;

import com.reine.utils.Color;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 * @author reine
 * 2022/5/26 17:57
 */
public class Main1 {
    public static void main(String[] args) {
        SimpleStringProperty str1 = new SimpleStringProperty("aa");
        SimpleStringProperty str2 = new SimpleStringProperty("dd");
        ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println(Color.RED + "(list)call : " + param.get() + Color.RESET);
                return new Observable[]{param};
            }
        });
        ObservableList<SimpleStringProperty> list1 = FXCollections.observableList(list, new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println(Color.BLUE + "(list1)call : " + param.get() + Color.RESET);
                return new Observable[]{param};
            }
        });
        list.addListener(new ListChangeListener<SimpleStringProperty>() {
            @Override
            public void onChanged(Change<? extends SimpleStringProperty> c) {
                System.out.println(Color.RED + "(list)onChanged : " + c + Color.RESET);
                while (c.next()) {
                    System.out.println(Color.RED + "c.wasUpdated() = " + c.wasUpdated() + Color.RESET);
                }
            }
        });
        list1.addListener(new ListChangeListener<SimpleStringProperty>() {
            @Override
            public void onChanged(Change<? extends SimpleStringProperty> c) {
                System.out.println(Color.BLUE + "(list1)onChanged : " + c + Color.RESET);
                while (c.next()) {
                    System.out.println(Color.BLUE + "c.wasUpdated()1 = " + c.wasUpdated() + Color.RESET);
                }
            }
        });
        list1.add(str1);
        list.forEach(item -> System.out.print(Color.RED + item.get() + " "));
        list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));
        System.out.println();
        System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);

        list.add(str2);
        list.forEach(item -> System.out.print(Color.RED + item.get() + " "));
        list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));
        System.out.println();
        System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);

        str1.set("cc");
        list.forEach(item -> System.out.print(Color.RED + item.get() + " "));
        list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));
        System.out.println();
        System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);

        str2.set("bb");
        list.forEach(item -> System.out.print(Color.RED + item.get() + " "));
        list1.forEach(item -> System.out.print(Color.BLUE + item.get() + " "));
        System.out.println();
        System.out.println(Color.MAGENTA + "-------------------------------------------------" + Color.RESET);
    }
}
