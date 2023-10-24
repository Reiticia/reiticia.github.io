package com.reine.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 全监视属性设计
 * @author reine
 * 2022/5/22 15:19
 */
public class Data {
    private SimpleStringProperty name = new SimpleStringProperty(this,"nameProperty");
    private SimpleIntegerProperty age = new SimpleIntegerProperty(this,"ageProperty");

    public Data() {
    }

    public Data(String name, int age) {
        this.name.set(name);
        this.age.set(age);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public SimpleStringProperty getSimpleStringPropertyName() {
        return this.name;
    }

    public SimpleIntegerProperty getSimpleIntegerPropertyAge() {
        return this.age;
    }

    public String getName() {
        return this.name.get();
    }

    public int getAge() {
        return this.age.get();
    }

    @Override
    public String toString() {
        return "Data's toString method";
    }
}
