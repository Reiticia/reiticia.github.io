package com.reine.entity;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/5/25 23:19
 */
public class Student {
    private SimpleStringProperty name = new SimpleStringProperty("张三");
    private SimpleObjectProperty<School> school = new SimpleObjectProperty<>(new School());

    public Student(String  name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        System.out.println("STUDENT");
        return name;
    }

    public School getSchool() {
        return school.get();
    }

    // 固定方法名称
    public SimpleObjectProperty<School> schoolProperty() {
        System.out.println("STUDENT");
        return school;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSchool(String  name) {
        this.school.set(new School(name));
    }
}
