package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

/**
 * 设置快捷键
 * @author reine
 * 2022/5/12 9:12
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group);
        Button button = new Button();
        button.setText("btn0");
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setPrefWidth(100);
        button.setPrefHeight(50);
        button.setOnAction(event -> {
            System.out.println("btn0");
        });

        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic = new Mnemonic(button, keyCombination);
        scene.addMnemonic(mnemonic);

        KeyCharacterCombination a = new KeyCharacterCombination("a", KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic1 = new Mnemonic(button, a);
        scene.addMnemonic(mnemonic1);

        KeyCodeCombination keyCodeCombination = new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN);
        scene.getAccelerators().put(keyCodeCombination, new Runnable() {
            @Override
            public void run() {
                System.out.println("RUN");
                System.out.println(Thread.currentThread().getName());
            }
        });

        group.getChildren().add(button);
        primaryStage.setScene(scene);
        primaryStage.setTitle("设置快捷键");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();

    }
}
