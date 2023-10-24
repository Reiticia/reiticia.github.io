package com.reine.node;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 * @author reine
 * 2022/6/12 13:31
 */
public class MyListView<T> extends ListView<T> implements Cloneable {

    public MyListView() {
    }

    public MyListView(ObservableList<T> items) {
        super(items);
    }

    @Override
    public MyListView<T> clone() throws CloneNotSupportedException {
        return (MyListView<T>) super.clone();
    }
}
