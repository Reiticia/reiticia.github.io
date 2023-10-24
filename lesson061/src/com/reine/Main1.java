package com.reine;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 使用valueAt改变列表元素
 * @author reine
 * 2022/5/25 14:03
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        VBox vBox = new VBox(10);
        HBox hBox = new HBox(10);
        TextField tx1 = new TextField();
        TextField tx2 = new TextField();
        hBox.getChildren().addAll(tx1, tx2);
        VBox listData = new VBox(10);

        // 数据
        ObservableList<String> list = FXCollections.observableArrayList("A", "B", "D", "T", "R");
        SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);

        // 填充标签数据
        for (int i = 0; i < list.size(); i++) {
            Label label = new Label();
            label.setFont(new Font(20));
            label.textProperty().bind(listProperty.valueAt(i));
            listData.getChildren().add(label);
        }

        vBox.getChildren().addAll(hBox, listData);
        anchorPane.getChildren().add(vBox);
        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("使用valueAt改变列表元素");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 绑定
        tx2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("")){
                return;
            }
            try {
                int i = Integer.parseInt(tx1.getText());
                listProperty.set(i, newValue);
                System.out.println("listProperty.get() = " + listProperty.get());
            }catch (Exception e){
                System.err.println("ERROR");
            }
        });



    }
}
