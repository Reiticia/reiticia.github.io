package com.reine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Dragboard 鼠标拖拽结合剪贴板
 *
 * @author reine
 * 2022/6/1 21:05
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("Hello World");
        label.setLayoutX(0);
        label.setLayoutY(0);

        TextField textField = new TextField();
        textField.setLayoutX(200);
        textField.setLayoutY(0);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(label, textField);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dragboard 鼠标拖拽结合剪贴板");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();

        // 拖拽检测
        label.setOnDragDetected(event -> {
            // 开始拖拽动作（剪切模式，模式不会影响具体效果，最终效果仍需定义代码进行实现）
            Dragboard dragboard = label.startDragAndDrop(TransferMode.MOVE);

            Text text = new Text(label.getText());
            WritableImage writableImage = new WritableImage((int) label.getWidth(), (int) label.getHeight());
            text.snapshot(new SnapshotParameters(), writableImage);
            dragboard.setDragView(writableImage, 0, 0);

            ClipboardContent content = new ClipboardContent();
            content.putString(label.getText());
            dragboard.setContent(content);
        });

        // 拖拽经过textField
        textField.setOnDragOver(event -> {
            // 于上面的设置的模式相同，如果不写此行，下面setOnDragDropped不会生效
            event.acceptTransferModes(TransferMode.MOVE);
        });

        // 拖拽释放
        textField.setOnDragDropped(event -> {
            // 获得拖拽面板的数据
            textField.setText(event.getDragboard().getString());
            event.setDropCompleted(true);
        });

        // 拖拽动作完成
        label.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getTransferMode() == TransferMode.MOVE) {
                    label.setText("");
                }
            }
        });
    }
}
