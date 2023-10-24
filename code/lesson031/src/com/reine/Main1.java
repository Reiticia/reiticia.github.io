package com.reine;

import com.reine.utils.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 多选按钮
 *
 * @author reine
 * 2022/5/15 9:33
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: skyblue;");

        HBox hBox = new HBox(10);

        CheckBox cb1 = new CheckBox("cb1");
        CheckBox cb2 = new CheckBox("cb2");
        CheckBox cb3 = new CheckBox("cb3");
        CheckBox cb4 = new CheckBox("cb4");

        // 设置默认选中
        cb1.setSelected(true);

        // 设置不确定状态
        cb2.setIndeterminate(true);

        // 设置允许按钮有不确定状态
        cb3.setAllowIndeterminate(true);

        hBox.getChildren().addAll(cb1, cb2, cb3, cb4);

        anchorPane.getChildren().addAll(hBox);

        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("多选按钮");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 选中状态改变监听事件
        cb1.selectedProperty().addListener((observable, oldValue, newValue) -> System.out.println("cb1.selectedProperty(): " + newValue));

        anchorPane.setOnMouseClicked(event -> {
            hBox.getChildren().forEach(node -> {
                // 打印被选中的按钮
                if (node instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) node;
                    System.out.print(Color.RED + checkBox.getText() + " isSelected?:" + checkBox.isSelected());
                    System.out.println(Color.BLUE + " isIndeterminate?:" + checkBox.isIndeterminate());
                }
            });
            System.out.println(Color.RESET + "==========================================");
        });
    }
}
