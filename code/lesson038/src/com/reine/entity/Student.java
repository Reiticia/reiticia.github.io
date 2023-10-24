package com.reine.entity;

import java.util.Objects;

/**
 * @author reine
 * 2022/5/18 16:04
 */
public class Student {
    private String name;
    private double score;
    private String subject;

    public Student(String name, double score, String subject) {
        this.name = name;
        this.score = score;
        this.subject = subject;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.score, score) == 0 && Objects.equals(name, student.name) && Objects.equals(subject, student.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, subject);
    }
}

