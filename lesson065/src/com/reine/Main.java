package com.reine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * 文件选择窗口
 * @author reine
 * 2022/5/27 9:27
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        VBox vBox = new VBox(10);
        vBox.setLayoutX(100);
        vBox.setLayoutY(100);
        Button button = new Button("单选文件窗口");
        Button button1 = new Button("多选文件窗口");
        Button button2 = new Button("打开文本");
        Button button3 = new Button("保存文本");
        Button button4 = new Button("选择文件夹");

        TextArea textArea = new TextArea();
        textArea.setPrefWidth(600);
        textArea.setWrapText(true);

        vBox.getChildren().addAll(button, button1, button2, button3, button4, textArea);
        anchorPane.getChildren().addAll(vBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文件选择窗口");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        // 单选文件
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("单选文件");
                fileChooser.setInitialDirectory(new File(File.separator + "DevelopEnvironment"));
                // 限制选择的文件类型
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("可执行文件", "*.exe"),
                        new FileChooser.ExtensionFilter("所有类型", "*.*"));
                File file = fileChooser.showOpenDialog(stage);

                // Optional.ofNullable(file)判空，ifPresent非空执行
                Optional.ofNullable(file).ifPresent(file1 -> textArea.setText(file1.getAbsolutePath()));

            }
        });

        // 多选文件
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("多选文件");
                fileChooser.setInitialDirectory(new File(File.separator + "DevelopEnvironment"));
                // 限制选择的文件类型
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("可执行文件", "*.exe"),
                        new FileChooser.ExtensionFilter("所有类型", "*.*"));
                List<File> files = fileChooser.showOpenMultipleDialog(stage);

                // Optional.ofNullable(file)判空，ifPresent非空执行
                Optional.ofNullable(files).ifPresent(new Consumer<List<File>>() {
                    @Override
                    public void accept(List<File> files) {
                        textArea.clear();
                        files.forEach(file -> {
                            textArea.appendText(file.getAbsolutePath() + "\n");
                        });
                    }
                });
            }
        });

        // 打开文本文件并显示文本
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("打开文本");
                fileChooser.setInitialDirectory(new File("C:" + File.separator + "Users" + File.separator + "86158" + File.separator + "桌面"));
                // 限制选择的文件类型
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("文本文件", "*.txt"));
                File file = fileChooser.showOpenDialog(stage);
                // Optional.ofNullable(file)判空，ifPresent非空执行
                Optional.ofNullable(file).ifPresent(file1 -> {
                    try (
                            FileInputStream fileInputStream = new FileInputStream(file1);
                            InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                            // FileReader reader = new FileReader(file1);
                            BufferedReader br = new BufferedReader(reader);
                    ) {
                        String str = null;
                        while ((str = br.readLine()) != null) {
                            textArea.appendText(str + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            }
        });

        // 保存文本
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("保存文本");
                fileChooser.setInitialFileName("鸡汤-改");
                fileChooser.setInitialDirectory(new File("C:" + File.separator + "Users" + File.separator + "86158" + File.separator + "桌面"));
                // 限制选择的文件类型
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("可执行文件", "*.txt"),
                        new FileChooser.ExtensionFilter("所有类型", "*.*"));
                File file = fileChooser.showSaveDialog(stage);
                // Optional.ofNullable(file)判空，ifPresent非空执行
                Optional.ofNullable(file).ifPresent(file1 -> {
                    System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());
                    try (
                            FileOutputStream fileOutputStream = new FileOutputStream(file1);
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    ) {
                        outputStreamWriter.write(textArea.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

        // 选择文件夹
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("文件夹选择器");
                directoryChooser.setInitialDirectory(new File(File.separator + "DevelopEnvironment"));
                File file = directoryChooser.showDialog(stage);
                Optional.ofNullable(file).ifPresent(file1 -> {
                    textArea.clear();
                    File[] files = file1.listFiles();
                    for (File file2 : files) {
                        textArea.appendText(file2.getAbsolutePath() + "\n");
                    }
                });
            }
        });

    }
}
