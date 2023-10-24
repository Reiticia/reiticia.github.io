package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * 剪贴板
 *
 * @author reine
 * 2022/6/1 17:35
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 获取剪贴板
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        Label label = new Label("waiting for paste content");

        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);// 保持宽高比例
        imageView.setLayoutY(50);
        imageView.setFitWidth(300);

        Button button = new Button("copy image");
        button.setLayoutX(600);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(label, imageView, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("剪贴板");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        // CTRL+V
        KeyCodeCombination kc = new KeyCodeCombination(KeyCode.V, KeyCodeCombination.SHORTCUT_DOWN);

        // 粘贴文本
        scene.getAccelerators().put(kc, () -> {
            boolean is = false;
            if (clipboard.hasString()) {
                label.setText(clipboard.getString());
            }

            // 如果是网络图片链接，则is为true；如果是本地图片右键复制，则为false
            // 判断剪贴板是否有文件，如果有，粘贴文件
            if (is = clipboard.hasFiles()) {
                System.out.println("clipboard.hasFiles()");
                List<File> files = clipboard.getFiles();
                try {
                    Image image = new Image(new FileInputStream(files.get(0)));
                    Image obj = (Image) clipboard.getContent(DataFormat.IMAGE);
                    imageView.setImage(image);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            // 如果是网络图片链接，则is为true；如果是本地图片右键复制，则为false
            if (is = clipboard.hasImage()) {
                System.out.println("clipboard.hasImage()");
                imageView.setImage(clipboard.getImage());
            }
            System.out.println("is = " + is);

        });

        // 获取图片，复制图片到剪贴板
        button.setOnAction(event -> {
            content.put(DataFormat.IMAGE,new Image("file:E:\\Users\\86158\\图片\\110300202.jpg"));
            clipboard.setContent(content);
        });
    }
}
