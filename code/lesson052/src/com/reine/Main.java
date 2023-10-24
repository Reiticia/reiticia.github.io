package com.reine;

import com.reine.entity.Data;
import com.reine.entity.Data2;
import com.reine.utils.Color;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 监视属性
 * @author reine
 * 2022/5/22 10:07
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        System.out.println("==============Only Console Output=============");
        SimpleIntegerProperty sip = new SimpleIntegerProperty(5);

        sip.addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue: " + oldValue);
            System.out.println("newValue: " + newValue);
        });

        System.out.println("sip.get() = " + sip.get());
        sip.set(10);
        System.out.println("sip.get() = " + sip.get());

        System.out.println(Color.BLUE + "==============Only Console Output=============");
        ReadOnlyDoubleWrapper rodw = new ReadOnlyDoubleWrapper(3);
        ReadOnlyDoubleProperty property = rodw.getReadOnlyProperty();
        System.out.println("property.get() = " + property.get());

        System.out.println("rodw.get() = " + rodw.get());
        rodw.set(5.0);
        System.out.println("rodw.get() = " + rodw.get());

        System.out.println("property.get() = " + property.get());

        System.out.println(Color.YELLOW + "==============Graph Output=============");

        AnchorPane anchorPane = new AnchorPane();

        Data data = new Data("reine", 19);
        Data2 data2 = new Data2("Jack");
        // 监视属性监听事件
        data2.nameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " + oldValue);
            System.out.println("newValue = " + newValue);
        });
        Button button = new Button("change data");
        data.getSimpleStringPropertyName().addListener((observable, oldValue, newValue) -> {
            // 证明该对象为监视属性本身
            SimpleStringProperty name = (SimpleStringProperty) observable;
            System.out.println("name.getBean() = " + name.getBean());
            System.out.println("name.getName() = " + name.getName());
            System.out.println("oldValue = " + oldValue);
            System.out.println("newValue = " + newValue);
        });
        // 按钮点击事件
        button.setOnAction(event -> {
            data.setName("Jack");
            data2.setName("Tom");
            System.out.println(data2.getName());
        });
        anchorPane.getChildren().addAll(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("监视属性");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
