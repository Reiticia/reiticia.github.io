package com.reine;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;

/**
 * 延时监听
 * @author reine
 * 2022/5/22 22:12
 */
public class Main {
    public static void main(String[] args) {
        SimpleIntegerProperty sip = new SimpleIntegerProperty(1);
        // 数据改变会触发数据更改监听
        Change change = new Change();
        WeakChangeListener<Number> listener = new WeakChangeListener<>(change);
        sip.addListener(listener);
        sip.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("数据更改监听");
            }
        });
        // 如果不绑定数据更改监听事件，则当数据进行多次更改而未被读取时，只会调用一次延时监听事件，提升效率
        Inva inva = new Inva();
        sip.addListener(inva);
        sip.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("延时监听");
            }
        });
        // 使用弱引用则无需移除监听器
        // sip.removeListener(change);
        sip.set(2);
        sip.set(3);
        sip.set(4);
        sip.set(5);
        sip.get();
        // 移除监听器
        sip.removeListener(inva);
        sip.set(6);
    }
}

class Inva implements InvalidationListener {
    @Override
    public void invalidated(Observable observable) {
        System.out.println("失效监听");
    }
}

class Change implements ChangeListener<Number> {

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println("数据更改监听");
    }
}