package com.reine;

import com.reine.entity.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author reine
 * 2022/5/23 15:51
 */
public class Main1 {
    public static void main(String[] args) throws Exception {
        // 使用反射创建Data对象
        Class<?> clazz = Class.forName("com.reine.entity.Data");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Data data = (Data) constructor.newInstance("reine", 18);
        System.out.println("data = " + data);

    }
}
