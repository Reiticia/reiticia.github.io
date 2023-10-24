package com.reine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * ButtonBar 按钮栏
 * @author reine
 * 2022/5/17 9:14
 */
public class Main extends Application implements EventHandler<ActionEvent> {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        ButtonBar buttonBar = new ButtonBar();// 按钮栏
        Button button1 = new Button("button1");
        button1.setPrefWidth(200);
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        ButtonBar.setButtonData(button1, ButtonData.APPLY);
        ButtonBar.setButtonData(button2, ButtonData.FINISH);
        ButtonBar.setButtonData(button3, ButtonData.NO);
        buttonBar.getButtons().addAll(button1, button2, button3);

        // 设置为true后，button1的大小会影响其他按钮的大小
        ButtonBar.setButtonUniformSize(button1, true);
        button1.setOnAction(this);
        button2.setOnAction(this);
        button3.setOnAction(this);

        // 更改平台
        buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_WINDOWS);

        anchorPane.getChildren().addAll(buttonBar);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ButtonBar 按钮栏");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        Button source = (Button) event.getSource();
        switch (ButtonBar.getButtonData(source)) {
            case APPLY:
                System.out.println("APPLY = " + source.getText());
                break;
            case FINISH:
                System.out.println("FINISH = " + source.getText());
                break;
            case NO:
                System.out.println("NO = " + source.getText());
                break;
            default:break;
        }
    }
}
