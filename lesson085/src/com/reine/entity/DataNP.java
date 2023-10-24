package com.reine.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/6/3 20:13
 */
public class DataNP {
    private String name;
    private SimpleIntegerProperty age = new SimpleIntegerProperty();

    public DataNP(String name, int age) {
        this.name = name;
        this.age.set(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
