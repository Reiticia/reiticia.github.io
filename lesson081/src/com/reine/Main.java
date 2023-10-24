package com.reine;

import com.reine.entity.Person;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 自定义拖拽类型
 *
 * @author reine
 * 2022/6/2 9:30
 */
public class Main extends Application {

    private DataFormat personFormat = new DataFormat("data/person");

    private Person person = new Person("张三", 18, "file:E:\\Users\\86158\\图片\\图片素材\\pro-image-photography-127307.jpg");

    private Tooltip tooltip = new Tooltip();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox data = initData();

        Button button = new Button(this.person.getName());
        button.setLayoutX(data.getPrefWidth() + 100);

        tooltip.setText(this.person.toString());
        Tooltip.install(button, tooltip);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(data, button);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("自定义拖拽类型");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        // 拖拽检测
        button.setOnDragDetected(event -> {
            Dragboard dragboard = button.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.put(personFormat, person);
            dragboard.setContent(content);
        });
        button.setOnDragOver(event -> {
            event.acceptTransferModes(event.getTransferMode());
        });
        button.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            Person content = (Person) dragboard.getContent(personFormat);
            this.person = content;
            button.setText(person.getName());
            tooltip.setText(person.toString());
        });
        // 拖拽经过data
        data.setOnDragOver(event -> {
            event.acceptTransferModes(event.getTransferMode());
        });
        data.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            // Person content = (Person) dragboard.getContent(DataFormat.lookupMimeType("data/person"));
            TextField name = (TextField) data.getChildren().get(1);
            TextField age = (TextField) data.getChildren().get(2);
            TextField url = (TextField) data.getChildren().get(3);
            ImageView photo = (ImageView) data.getChildren().get(4);
            Person content = (Person) dragboard.getContent(personFormat);
            if (content != null) {
                // 内容不为空，说明是从按钮复制过来的
                name.setText(content.getName());
                age.setText(content.getAge().toString());
                url.setText(content.getAvatar());
                photo.setImage(new Image(content.getAvatar()));
            } else {
                // 内容为空，说明是从外部拖拽图片进来修改
                if (dragboard.hasUrl()) {
                    url.setText(dragboard.getUrl());
                    photo.setImage(new Image(dragboard.getUrl()));
                }
            }

        });

    }

    public VBox initData() {
        VBox data = new VBox(10);
        data.setStyle("-fx-border-width: 5; -fx-border-style: solid; -fx-border-color: yellow;");
        data.setPrefWidth(300);
        data.setPrefHeight(500);
        Button button = new Button("个人详情");
        button.prefWidthProperty().bind(data.prefWidthProperty());
        TextField name = new TextField();
        name.setAlignment(Pos.CENTER);
        TextField age = new TextField();
        age.setAlignment(Pos.CENTER);
        TextField photoUrl = new TextField();
        photoUrl.setVisible(false);

        ImageView photo = new ImageView();
        photo.setPreserveRatio(true);
        photo.setFitWidth(300);
        data.getChildren().addAll(button, name, age, photoUrl, photo);
        data.setAlignment(Pos.TOP_CENTER);

        // 按钮点击效果
        button.setOnDragDetected(event -> {
            Dragboard dragboard = button.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            // 收集信息
            Person person = new Person(name.getText(), Integer.parseInt(age.getText()), photoUrl.getText());
            content.put(personFormat, person);

            WritableImage writableImage = new WritableImage((int) data.getPrefWidth() / 4, (int) data.getPrefHeight() / 4);
            data.snapshot(new SnapshotParameters(), writableImage);
            dragboard.setDragView(writableImage, 0, 0);
            dragboard.setContent(content);
        });

        return data;
    }
}
