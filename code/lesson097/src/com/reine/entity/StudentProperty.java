package com.reine.entity;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author reine
 * 2022/6/5 18:11
 */
public class StudentProperty {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();
    private SimpleDoubleProperty score = new SimpleDoubleProperty();
    private SimpleBooleanProperty gender = new SimpleBooleanProperty();

    public StudentProperty() {
    }

    public StudentProperty(String name, int age, double score, boolean gender) {
        this.name.set(name);
        this.age.set(age);
        this.score.set(score);
        this.gender.set(gender);
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

    public double getScore() {
        return score.get();
    }

    public SimpleDoubleProperty scoreProperty() {
        return score;
    }

    public void setScore(double score) {
        this.score.set(score);
    }

    public boolean isGender() {
        return gender.get();
    }

    public SimpleBooleanProperty genderProperty() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender.set(gender);
    }

    @Override
    public String toString() {
        return "StudentProperty{" +
                "name=" + name +
                ", age=" + age +
                ", score=" + score +
                ", gender=" + gender +
                '}';
    }
}
