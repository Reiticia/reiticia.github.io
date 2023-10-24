package com.reine;

import com.reine.entity.Student;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.*;

/**
 * 绑定判断，其他基本数据类型
 * @author reine
 * 2022/5/23 16:24
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student("reine", 18);
        SimpleIntegerProperty x = new SimpleIntegerProperty(5);
        SimpleIntegerProperty y = new SimpleIntegerProperty(student, "stu", 10);
        // 特点：不能修改
        IntegerExpression n = SimpleIntegerProperty.integerExpression(y);
        SimpleIntegerProperty sip = (SimpleIntegerProperty) n;
        x.set(90);
        System.out.println("n.get() = " + n.get());
        System.out.println("((SimpleIntegerProperty) n).getBean() = " + ((SimpleIntegerProperty) n).getBean());
        System.out.println("sip.getName().equals(y.getName()) = " + sip.getName().equals(y.getName()));

        // 类型转换
        ObjectProperty<Integer> objectProperty = new SimpleObjectProperty<>(2);
        System.out.println(IntegerExpression.integerExpression(objectProperty).get());

        SimpleIntegerProperty.readOnlyIntegerProperty(y);
        System.out.println("=============SimpleBooleanProperty==============");
        SimpleBooleanProperty b1 = new SimpleBooleanProperty(true);
        SimpleBooleanProperty b2 = new SimpleBooleanProperty(false);
        // 与或非
        b1.and(b2);
        b1.or(b2);
        b1.not();
        b1.isEqualTo(b2);
        b1.isNotEqualTo(b2);
        System.out.println("=============SimpleStringProperty==============");
        SimpleStringProperty up = new SimpleStringProperty("ABC");
        SimpleStringProperty low = new SimpleStringProperty("abc");
        // 判断ascii码大小，从第一位开始判断，若相同则后移一位进行判断
        System.out.println("up.lessThan(low).get() = " + up.lessThan(low).get());
        System.out.println("up.concat(low).get() = " + up.concat(low).get());
        System.out.println("up.isEqualTo(low).get() = " + up.isEqualTo(low).get());
        System.out.println("up.isEqualToIgnoreCase(low).get() = " + up.isEqualToIgnoreCase(low).get());
        up.set("");
        System.out.println("up.isEmpty().get() = " + up.isEmpty().get()); // true
        System.out.println("up.isNull().get() = " + up.isNull().get()); // false

        SimpleObjectProperty<Student> studentSimpleObjectProperty = new SimpleObjectProperty<>(student);
        studentSimpleObjectProperty.addListener(((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " + oldValue);
            System.out.println("newValue = " + newValue);
        }));
        // 触发
        studentSimpleObjectProperty.set(new Student("Jack",82));
        // 不触发
        student.setName("Tom");
        // 不触发
        studentSimpleObjectProperty.get().setAge(19);
        System.out.println("studentSimpleObjectProperty.isNull().get() = " + studentSimpleObjectProperty.isNull().get());
    }
}