package com.reine.utils;

import com.reine.entity.Person;
import javafx.util.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 必须要有getter和setter方法，否则生成对象会报空指针
 * @author reine
 * 2022/6/9 20:30
 */
@Getter
@Setter
public class PersonBuilder implements Builder<Person> {

    private String name;
    private int age;

    @Override
    public Person build() {
        System.out.println("build");
        return new Person(name, age);
    }
}
