package com.reine;

import com.reine.utils.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * 两对方法
 * @author reine
 * 2022/5/19 14:19
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("str1", "str2", "str3", "str4", "str5");
        comboBox.setEditable(true);
        // 处理输入框按下回车的值
        comboBox.setConverter(new StringConverter<String>() {
            // 输出方法
            @Override
            public String toString(String object) {
                return object+" - AO";
            }

            // 输入方法
            @Override
            public String fromString(String string) {
                System.out.println(Color.GREEN + "setConverter");
                return string + " - AI";
            }
        });

        comboBox.converterProperty().set(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object + " - BO";
            }

            @Override
            public String fromString(String string) {
                System.out.println(Color.BLUE + "converterProperty");
                return string+" - BI";
            }
        });

        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> listCell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        // 如果删除了此行，则会导致下拉列表无法选择
                        super.updateItem(item, empty);
                        if (!empty) {
                            System.out.println(Color.GREEN + "setCellFactory");
                            this.setText(item + " - C");
                        }
                    }
                };
                return listCell;
            }
        });
        // setCellFactory方法会调用此方法，此时只有cellFactoryProperty生效
        comboBox.cellFactoryProperty().set(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> listCell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        // 如果删除了此行，则会导致下拉列表无法选择
                        super.updateItem(item, empty);
                        if (!empty) {
                            System.out.println(Color.BLUE + "cellFactoryProperty");
                            this.setText(item + " - D");
                        }
                    }
                };
                return listCell;
            }
        });

        anchorPane.getChildren().addAll(comboBox);
        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("两对方法");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
