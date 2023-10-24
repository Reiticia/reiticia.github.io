package com.reine;

import com.reine.entity.Student;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Locale;

/**
 * 绑定：字符串处理，自定义绑定规则，深层绑定JavaBean中某个属性
 *
 * @author reine
 * 2022/5/25 20:49
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--------concat();format()--------");
        SimpleIntegerProperty value = new SimpleIntegerProperty(10);
        StringExpression sexp = Bindings.concat("value = ", value.asString(Locale.getDefault(), "%s"));

        System.out.println(sexp.get());

        StringExpression sexp1 = Bindings.format("value = %s", value);
        System.out.println(sexp1.get());

        value.set(20);
        System.out.println("--------value.set(20)--------");
        System.out.println(sexp.get());
        System.out.println(sexp1.get());

        System.out.println("--------max();min()--------");
        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(2);
        System.out.println("Bindings.max(x,y).intValue() = " + Bindings.max(x, y).intValue());
        System.out.println("Bindings.min(x,y).intValue() = " + Bindings.min(x, y).intValue());

        System.out.println("--------createStringBinding()--------");
        StringExpression sexp2 = Bindings.createStringBinding(() -> {
            switch (value.get()) {
                case 10:
                    return "Ten";
                case 20:
                    return "Twenty";
                default:
                    return "default";
            }
        }, value);
        value.set(20);
        // 调用上面匿名内部类中的方法
        System.out.println("value.get() = " + value.get());
        System.out.println("sexp2.get() = " + sexp2.get());

        System.out.println("--------selectString()--------");
        // 嵌套一层的JavaBean
        Student student = new Student("张三");
        SimpleObjectProperty<Student> studentProperty = new SimpleObjectProperty<>(student);
        // 可观察属性，外层JavaBean中的属性名称，内层JavaBean中的属性名称
        // 绑定了student对象中的school属性中的name属性
        StringExpression sexp3 = Bindings.selectString(studentProperty, "school", "name");
        System.out.println("sexp3.get() = " + sexp3.get());
        // 当school的name属性改变时，会触发sexp3值的改变
        student.setSchool("清华大学");
        System.out.println("sexp3.get() = " + sexp3.get());

        System.out.println("--------convert()--------");
        // 将SimpleIntegerProperty转换成字符串
        System.out.println("Bindings.convert(new SimpleIntegerProperty(100)).get().getClass() = " + Bindings.convert(new SimpleIntegerProperty(100)).get().getClass());
    }
}
