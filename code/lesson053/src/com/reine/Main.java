package com.reine;

import com.reine.utils.Color;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * property扩展：list
 *
 * @author reine
 * 2022/5/22 16:57
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 可观察列表
        ObservableList<String> list = FXCollections.observableArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("item" + i);
        }

        SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
        // 值监听
        listProperty.addListener((observable, oldValue, newValue) -> {
            // oldValue与newValue相同
            oldValue.forEach(System.out::println);
            System.out.println(Color.YELLOW + "--------------" + Color.RESET);
            newValue.forEach(System.out::println);
        });

        // 方法监听
        listProperty.addListener((ListChangeListener<String>) c -> {
            // 具体操作
            System.out.println(c);
            // { [item5] added at 5 }
            // 获得元素列表
            System.out.println("c.getList() = " + c.getList());
            // next方法必须于判断操作类型前调用，指向下一步操作
            // c.reset();// 撤销c.next()操作
            System.out.println("c.next() = " + c.next());
            // 判断操作类型
            System.out.println("c.getFrom() = " + c.getFrom());
            System.out.println("c.getTo() = " + c.getTo());
            System.out.println("c.wasAdded() = " + c.wasAdded());
            System.out.println("c.wasRemoved() = " + c.wasRemoved());
            System.out.println("c.wasReplaced() = " + c.wasReplaced());
            /*
             当可观察列表list中的泛型为普通数据类型时基本为false；
             当可观察列表list中的泛型为监视属性时且创建list时指定了callback回调函数,
             则如果列表中监视属性的值发生改变，则返回true
            */
            System.out.println("c.wasUpdated() = " + c.wasUpdated());
            System.out.println("c.getAddedSubList() = " + c.getAddedSubList());// 获取增加或删除的元素列表
            try {
                System.out.println("c.wasPermutated() = " + c.wasPermutated());// 是否被排序
                System.out.println("c.getPermutation(0) = " + c.getPermutation(0));// 获取原来索引为0的元素经过排序后的位置（索引）
            } catch (IllegalStateException e) {
                System.out.println(Color.RED + "没有进行排序操作" + Color.RESET);
            }
            System.out.println(Color.YELLOW + "----------------------------------" + Color.RESET);
        });

        list.add("item5");
        list.remove("item5");
        list.replaceAll(s -> s.replaceFirst("item1", "listItem1"));
        list.set(3, "ListItem3");
        list.sort(String::compareTo);
        // 关闭应用
        Platform.exit();
    }
}
