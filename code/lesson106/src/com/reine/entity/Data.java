package com.reine.entity;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/6/8 8:55
 */
public class Data {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();
    private SimpleBooleanProperty male = new SimpleBooleanProperty();

    public Data(String name, int age, boolean isMale) {
        this.name.set(name);
        this.age.set(age);
        this.male.set(isMale);
    }

    public Data() {
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

    public boolean isMale() {
        return male.get();
    }

    public SimpleBooleanProperty maleProperty() {
        return male;
    }

    public void setMale(boolean male) {
        this.male.set(male);
    }
}
