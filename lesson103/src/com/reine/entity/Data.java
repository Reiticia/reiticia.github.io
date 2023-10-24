package com.reine.entity;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/6/7 9:53
 */
public class Data {
    private SimpleBooleanProperty selected = new SimpleBooleanProperty(false);
    private SimpleStringProperty value = new SimpleStringProperty("");

    public Data(boolean selected, String value) {
        this.selected.set(selected);
        this.value.set(value);
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

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }
}
