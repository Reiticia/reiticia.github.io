package com.reine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author reine
 * 2022/6/9 20:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private int age;
}
