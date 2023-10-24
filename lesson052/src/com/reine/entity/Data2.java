package com.reine.entity;

import javafx.beans.property.SimpleStringProperty;

/**
 * 性能优化设计
 * @author reine
 * 2022/5/22 15:34
 */
public class Data2 {
    private String name;
    private SimpleStringProperty nameProperty = null;

    public Data2() {
    }

    /**
     * 如果不需要监视属性，则直接给普通属性赋值，如果需要监视属性，则调用监视属性set()方法设置值
     * @param name
     */
    public Data2(String name) {
        if (nameProperty == null) {
            this.name = name;
        } else {
            this.nameProperty.set(name);
        }
    }

    /**
     * 如果不需要监视属性，则直接给普通属性赋值，如果需要监视属性，则调用监视属性set()方法设置值
     * @param name
     */
    public void setName(String name) {
        if (nameProperty == null) {
            this.name = name;
        } else {
            this.nameProperty.set(name);
        }
    }

    /**
     * 如果监视属性有值，返回监视属性值，否则返回普通属性值
     * @return
     */
    public String getName() {
        if (nameProperty == null) {
            return this.name;
        } else {
            return this.nameProperty.get();
        }
    }

    /**
     * 需要使对象拥有监视属性时调用此方法对对象内部指定属性生成监视属性
     *
     * @return 对象监视属性
     */
    public SimpleStringProperty nameProperty() {
        if (nameProperty == null) {
            nameProperty = new SimpleStringProperty(this, "name", this.name);
        }
        return nameProperty;
    }
}
