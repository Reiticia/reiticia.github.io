package com.reine.entity;

/**
 * @author reine
 * 2022/6/5 18:14
 */
public class Student {
    private String name;
    private Integer age;
    private Double score;
    private Boolean gender;

    public Student() {
    }

    public Student(String name, Integer age, Double score, Boolean gender) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.gender = gender;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean boy) {
        gender = boy;
    }
}
