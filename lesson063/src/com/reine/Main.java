package com.reine;

import com.reine.property.MyIntegerBinding;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * IntegerBinding
 * @author reine
 * 2022/5/26 7:33
 */
public class Main {
    public static void main(String[] args) {
        SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(10);
        MyIntegerBinding integerBinding = new MyIntegerBinding(20);
        System.out.println("integerProperty.get() = " + integerProperty.get());
        System.out.println("integerBinding.get() = " + integerBinding.get());

        integerProperty.bind(integerBinding);
        System.out.println("integerProperty.get() = " + integerProperty.get());
        System.out.println("integerBinding.get() = " + integerBinding.get());

        integerBinding.setValue(35);
        System.out.println("integerProperty.get() = " + integerProperty.get());
        System.out.println("integerBinding.get() = " + integerBinding.get());

    }
}

