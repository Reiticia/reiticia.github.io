package com.reine.entity;

import java.io.Serializable;

/**
 * @author reine
 * 2022/6/2 9:32
 */
public class Person implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private String avatar;

    public Person() {
    }

    public Person(String name, Integer age, String avatar) {
        this.name = name;
        this.age = age;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
