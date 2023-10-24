package com.reine;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/5 15:45
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(10);
        Button choiceDialog = new Button("ChoiceDialog");
        Button textInputDialog = new Button("TextInputDialog");
        hBox.getChildren().addAll(choiceDialog,textInputDialog);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceDialog&TextInputDialog");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 下拉列表弹窗
        choiceDialog.setOnAction(event -> {
            ObservableList<String > list = FXCollections.observableArrayList();
            list.add("鸢一折纸");
            list.add("本条二亚");
            list.add("时崎狂三");
            list.add("冰芽川四糸乃");
            list.add("五河琴里");
            list.add("星宫六喰");
            list.add("镜野七罪");
            list.add("八舞夕弦");
            list.add("八舞耶俱矢");
            list.add("诱宵美九");
            list.add("夜刀神十香");
            ChoiceDialog<String> dialog = new ChoiceDialog<>("鸢一折纸",list);

            dialog.selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));

            dialog.show();
        });
        // 输入框弹窗
        textInputDialog.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog("输入框弹窗");
            Button ok = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            dialog.show();

            ok.setOnAction(event1 -> {
                System.out.println(dialog.getEditor().getText());
            });
        });


    }
}
