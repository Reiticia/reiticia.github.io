package com.reine.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/6/3 20:13
 */
public class DataPro {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();

    public DataPro() {
    }

    public DataPro(String name, int age) {
        this.name.set(name);
        this.age.set(age);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }
}
