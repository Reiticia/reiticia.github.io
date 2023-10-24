package com.reine.entity;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/5/25 23:21
 */
public class School {
    // 默认值
    private SimpleStringProperty name = new SimpleStringProperty("哈佛大学");

    public School(){

    }
    public School(String name){
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        System.out.println("SCHOOL");
        return name;
    }
}
