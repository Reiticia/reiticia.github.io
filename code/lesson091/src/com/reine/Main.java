package com.reine;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author reine
 * 2022/6/5 14:46
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Alert弹窗");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Alert");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            // 创建指定类型的alert，如果该alert中没有对应的按钮却给该类型的按钮设置了监听，则会报错NullPointerException
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            // alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            Button cancel = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
            // Button close = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);

            // 删除确定按钮
            // alert.getDialogPane().getButtonTypes().remove(0);

            alert.setTitle("alert");
            alert.setHeaderText("HeaderText");
            alert.setContentText("ContentText");
            ImageView imageView = new ImageView("images/logo.png");
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(25);
            alert.setGraphic(imageView);

            // 设置模态
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();

            // ok.setOnAction(event1 -> {
            //     System.out.println("OK");
            // });
            //
            // cancel.setOnAction(event1 -> {
            //     System.out.println("CANCEL");
            // });

            // close.setOnAction(event1 -> {
            //     System.out.println("CLOSE");
            // });
        });
    }
}
