package com.reine.entity;

/**
 * @author reine
 * 2022/6/3 20:13
 */
public class Data {
    private String name;
    private int age;

    public Data(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
