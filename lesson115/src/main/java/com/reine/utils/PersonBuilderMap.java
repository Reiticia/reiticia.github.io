package com.reine.utils;

import com.reine.entity.Person;
import javafx.util.Builder;

import java.util.HashMap;

/**
 * @author reine
 * 2022/6/9 21:54
 */
public class PersonBuilderMap extends HashMap<String, Object> implements Builder<Person> {

    private String name;
    private int age;

    @Override
    public Object put(String key, Object value) {
        System.out.println("Map-put:(" + key + "," + value + ")");
        switch (key) {
            case "name":
                this.name = String.valueOf(value);
                break;
            case "age":
                this.age = Integer.parseInt(String.valueOf(value));
                break;
            default:
        }
        return super.put(key, value);

    }

    @Override
    public Person build() {
        System.out.println("build");
        return new Person(name, age);
    }
}
