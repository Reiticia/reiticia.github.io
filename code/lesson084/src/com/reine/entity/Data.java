package com.reine.entity;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * @author reine
 * 2022/6/2 22:27
 */
public class Data {
    private String name;
    private SimpleBooleanProperty selected = new SimpleBooleanProperty();

    public Data() {

    }

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }
}
