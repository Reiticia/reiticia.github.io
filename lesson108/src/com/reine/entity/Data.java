package com.reine.entity;

import javafx.beans.property.*;

/**
 * 优化后的Data类
 *
 * @author reine
 * 2022/6/8 8:55
 */
public class Data {
    /**
     * 使用ReadOnlyXXXWrapper类型的属性来声明属性，这样可以避免属性的设置和读取
     */
    // private ReadOnlyStringWrapper name = new ReadOnlyStringWrapper();
    private SimpleStringProperty name = new SimpleStringProperty();
    private ReadOnlyStringWrapper clazz = new ReadOnlyStringWrapper();
    private ReadOnlyIntegerWrapper age = new ReadOnlyIntegerWrapper();
    private ReadOnlyDoubleWrapper score = new ReadOnlyDoubleWrapper();
    private SimpleBooleanProperty male = new SimpleBooleanProperty();

    public Data() {
    }

    public Data(String name, String clazz, Integer age, Double score, Boolean male) {
        this.name.set(name);
        this.clazz.set(clazz);
        this.age.set(age);
        this.score.set(score);
        this.male.set(male);
    }

    public String getName() {
        return name.get();
    }

    // public ReadOnlyStringProperty nameProperty() {
    //     return name.getReadOnlyProperty();
    // }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public ReadOnlyIntegerProperty ageProperty() {
        return age.getReadOnlyProperty();
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

    public double getScore() {
        return score.get();
    }

    public ReadOnlyDoubleProperty scoreProperty() {
        return score.getReadOnlyProperty();
    }

    public void setScore(double score) {
        this.score.set(score);
    }

    public String getClazz() {
        return clazz.get();
    }

    public ReadOnlyStringProperty clazzProperty() {
        return clazz.getReadOnlyProperty();
    }

    public void setClazz(String clazz) {
        this.clazz.set(clazz);
    }
}
