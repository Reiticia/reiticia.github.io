package com.reine;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author reine
 * 2022/6/4 19:59
 */
public class Main1 extends Application {

    int index = 0;
    String data = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> observableList = FXCollections.observableArrayList();

        observableList.add("鸢一折纸");
        observableList.add("本条二亚");
        observableList.add("时崎狂三");
        observableList.add("冰芽川四糸乃");
        observableList.add("五河琴里");
        observableList.add("星宫六喰");
        observableList.add("镜野七罪");
        observableList.add("八舞夕弦");
        observableList.add("八舞耶俱矢");
        observableList.add("诱宵美九");
        observableList.add("夜刀神十香");

        ListView<String> listView = new ListView<>(observableList);
        listView.setPrefWidth(300);
        listView.setPrefHeight(300);
        listView.setLayoutX(50);
        listView.setLayoutY(100);

        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

            int position = 0;

            @Override
            public ListCell<String> call(ListView<String> param) {
                Label label = new Label();
                label.setFont(new Font(15));
                ListCell<String> cell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            return;
                        }
                        label.setText(item);
                        this.setGraphic(label);
                    }
                };
                cell.setPrefHeight(30);

                // 拖拽监听
                cell.setOnDragDetected(event -> {
                    // 拖拽模式
                    Dragboard dragboard = cell.startDragAndDrop(TransferMode.COPY_OR_MOVE);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(data);
                    // 设置拖拽图标
                    WritableImage writableImage = new WritableImage((int) cell.getWidth(), (int) cell.getHeight());
                    WritableImage snapshot = cell.snapshot(new SnapshotParameters(), writableImage);
                    dragboard.setDragView(snapshot);
                    dragboard.setContent(content);
                });

                // 拖拽进入到另一个cell
                cell.setOnDragEntered(event -> {
                    // 获取拖拽进入的位置
                    position = param.getItems().indexOf(label.getText());
                    param.getFocusModel().focus(position);
                });

                // 拖拽释放
                cell.setOnDragOver(event -> {
                    event.acceptTransferModes(TransferMode.COPY);
                });

                // 拖拽释放
                cell.setOnDragDropped(event -> {
                    Dragboard dragboard = event.getDragboard();
                    param.getItems().remove(dragboard.getString());
                    if (position == -1) {
                        param.getItems().add(dragboard.getString());
                        // 设置选中
                        param.getSelectionModel().select(param.getItems().size() - 1);
                    } else {
                        param.getItems().add(position, dragboard.getString());
                        // 设置选中
                        param.getSelectionModel().select(position);
                    }
                });

                return cell;
            }
        });

        Button button = new Button("button");

        ListView<String> lv = new ListView<>();
        lv.setPrefWidth(300);
        lv.setPrefHeight(300);
        lv.setLayoutX(400);
        lv.setLayoutY(100);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(listView, button,lv);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("列表项拖拽");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        listView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            index = newValue.intValue();
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            data = newValue;
        });


        // 拖拽进入lv
        lv.setOnDragEntered(event -> {
        });

        // 拖拽释放
        lv.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.COPY);
        });

        // 拖拽释放
        lv.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            lv.getItems().add(dragboard.getString());
        });

    }
}
