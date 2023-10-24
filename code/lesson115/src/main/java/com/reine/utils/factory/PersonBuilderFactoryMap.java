package com.reine.utils.factory;

import com.reine.entity.Person;
import com.reine.utils.PersonBuilderMap;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

/**
 * @author reine
 * 2022/6/9 22:02
 */
public class PersonBuilderFactoryMap implements BuilderFactory {

    private final JavaFXBuilderFactory javaFXBuilderFactory = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Person.class) {
            System.out.println("返回Builder");
            return new PersonBuilderMap();
        }
        return javaFXBuilderFactory.getBuilder(type);
    }
}
