package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author reine
 * 2022/6/5 9:30
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Dialog弹窗");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dialog");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {
            // 泛型代表弹窗关闭后的返回值类型
            Dialog<ButtonType> dialog = new Dialog<>();

            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            Button close = (Button) dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
            Button ok = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            dialog.setHeaderText("I'm headerText");
            dialog.setTitle("dialog");
            dialog.setContentText("I'm content");
            dialog.setGraphic(new Button("icon"));
            // 设置界面大小
            dialog.getDialogPane().setPrefSize(300,300);

            // 务必在show之前声明
            dialog.showAndWait().ifPresent(buttonType -> {
                switch (buttonType.getButtonData()) {
                    case OK_DONE:
                        dialog.setContentText("We are reader");
                        break;
                    case CANCEL_CLOSE:
                        dialog.setContentText("You are gay");
                        break;
                    default:
                }
            });

            dialog.show();

            // 在show()后设置才有效果
            // dialog.setWidth(300);
            // dialog.setHeight(300);

            // 以显示器为准设置位置
            // dialog.setX(100);
            // dialog.setY(100);

            close.setOnAction(event1 -> {
                System.out.println("close");
                // dialog.hide();
            });

            ok.setOnAction(event1 -> {
                System.out.println("ok");
                // dialog.hide();
            });

            // 窗口关闭监听
            dialog.setOnCloseRequest(event1 -> {
                System.out.println("关闭");
            });

            // 获取点击的按钮
            dialog.setResultConverter(new Callback<ButtonType, ButtonType>() {
                @Override
                public ButtonType call(ButtonType param) {
                    System.out.println("param = " + param);
                    return param;
                }
            });
        });
    }
}
