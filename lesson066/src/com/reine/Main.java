package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

/**
 * Tooltip
 *
 * @author reine
 * 2022/5/27 13:37
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();

        Button button = new Button("btn");

        Tooltip tooltip = new Tooltip("this is tip content");
        tooltip.setFont(new Font(12));
        tooltip.setStyle("-fx-background-color:blue;");
        tooltip.setPrefWidth(75.0);
        tooltip.setPrefHeight(75.0);
        tooltip.setWrapText(true);
        // 文本超出边界后的效果
        // tooltip.setTextOverrun(OverrunStyle.CLIP);

        // 文本居中
        tooltip.setTextAlignment(TextAlignment.CENTER);
        // 鼠标指针相对于提示框的位置
        tooltip.setAnchorLocation(PopupWindow.AnchorLocation.CONTENT_TOP_RIGHT);
        // tooltip.setAnchorLocation(PopupWindow.AnchorLocation.WINDOW_TOP_RIGHT);

        // 透明度
        tooltip.setOpacity(0.5);
        tooltip.setAutoHide(true);
        // 下面两句效果相同
        // button.setTooltip(tooltip);
        Tooltip.install(button,tooltip);

        // 卸载按钮上的提示框
        // Tooltip.uninstall(button, tooltip);

        tooltip.setOnShown(event -> System.out.println("tooltip has shown"));

        tooltip.setOnHidden(event -> System.out.println("tooltip has hidden"));

        tooltip.setOnShowing(event -> {
            System.out.println("tooltip is showing");
            // 阻止事件传播（失败，不是JDK版本问题）
            event.consume();
        });

        tooltip.setOnCloseRequest(event -> {
            System.out.println("setOnCloseRequest");
        });

        borderPane.setCenter(button);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tooltip");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> Tooltip.uninstall(button, tooltip));

        // tooltip.show(primaryStage);
        // 相对于整个屏幕的距离
        // tooltip.setX(100);
        // tooltip.setY(100);

        // tooltip.setAnchorX(100);
        // tooltip.setAnchorY(100);
    }
}
