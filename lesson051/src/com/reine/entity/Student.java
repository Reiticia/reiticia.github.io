package com.reine.entity;

import java.beans.PropertyChangeSupport;

/**
 * @author reine
 * 2022/5/22 9:30
 */
public class Student {
    private String name;
    private int age;
    public PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        pcs.firePropertyChange("setName_pro", oldValue, this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldValue = this.age;
        this.age = age;
        pcs.firePropertyChange("setAge_pro", oldValue, this.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
