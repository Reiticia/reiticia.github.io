package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author reine
 * 2022/6/5 15:45
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(10);

        Button customDialog = new Button("CustomDialog");
        hBox.getChildren().addAll(customDialog);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CustomDialog");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 自定义弹窗
        customDialog.setOnAction(event -> {
            Stage stage = new Stage();
            DialogPane dialog = new DialogPane();
            dialog.setStyle("-fx-background-color: pink; -fx-border-color: black; -fx-border-width: 2px;");
            dialog.setHeaderText("这是一个自定义弹窗");
            dialog.setContentText("这是一个自定义弹窗");
            ImageView imageView = new ImageView("images/logo.png");
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(30);
            dialog.setGraphic(imageView);
            // dialog.setPrefSize(300,150);
            // 添加按钮
            dialog.getButtonTypes().add(ButtonType.OK);
            dialog.getButtonTypes().add(ButtonType.CANCEL);

            // 弹窗按钮点击事件
            ((Button)dialog.lookupButton(ButtonType.OK)).setOnAction(event1 -> stage.close());
            ((Button)dialog.lookupButton(ButtonType.CANCEL)).setOnAction(event1 -> stage.close());

            Scene scene1 = new Scene(dialog);
            stage.setScene(scene1);
            // 务必删除下面两行设置，会有白边效果
            // stage.setWidth(300);
            // stage.setHeight(200);
            // 设置没有装饰的窗口
            stage.initStyle(StageStyle.UNDECORATED);
            // 模态窗口
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            // 始终置顶
            // stage.setAlwaysOnTop(true);
            stage.show();
        });
    }
}
