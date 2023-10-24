package com.reine.utils.factory;

import com.reine.entity.Person;
import com.reine.utils.PersonBuilder;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

/**
 * @author reine
 * 2022/6/9 20:35
 */
public class PersonBuilderFactory implements BuilderFactory {

    private final JavaFXBuilderFactory javaFXBuilderFactory = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Person.class) {
            System.out.println("返回Builder");
            return new PersonBuilder();
        }
        return javaFXBuilderFactory.getBuilder(type);
    }
}
