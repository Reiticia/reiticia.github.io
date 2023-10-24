package com.reine;

import com.reine.job.MyScheduledService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * DialogPane 对话框布局
 *
 * @author reine
 * 2022/5/13 10:02
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("点我显示对话框");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #f5f5f5");
        anchorPane.getChildren().add(button);
        button.setOnAction(event -> {
            DialogPane dialogPane = new DialogPane();
            dialogPane.setHeaderText("这是一个对话框头 - -");
            dialogPane.setContentText("这是一个对话框");//这里可以设置对话框的内容
            dialogPane.getButtonTypes().add(ButtonType.APPLY);
            dialogPane.getButtonTypes().add(ButtonType.CLOSE);

            // 设置对话框的图标
            ImageView imageView = new ImageView("images/logo.png");
            imageView.setFitWidth(32);
            imageView.setFitHeight(32);
            dialogPane.setGraphic(imageView);

            // 设置对话框扩展内容
            dialogPane.setExpandableContent(new Text("这是一个扩展内容"));
            dialogPane.setExpanded(true);// 设置扩展内容是否展开

            // 为对话框安排一个场景
            Scene scene = new Scene(dialogPane);
            Stage stage = new Stage();
            stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            // 新建多任务
            MyScheduledService myScheduledService = new MyScheduledService(dialogPane, stage);
            myScheduledService.setDelay(Duration.millis(0));// 设置起始时间
            myScheduledService.setPeriod(Duration.seconds(1));// 设置周期
            myScheduledService.start();

            // 按钮点击事件
            ((Button) dialogPane.lookupButton(ButtonType.APPLY)).setOnAction(event1 -> {
                System.out.println("点击了应用按钮");
            });
            ((Button) dialogPane.lookupButton(ButtonType.CLOSE)).setOnAction(event1 -> {
                System.out.println("点击了关闭按钮");
                Platform.runLater(stage::close);
            });

        });
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DialogPane 对话框布局");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}
