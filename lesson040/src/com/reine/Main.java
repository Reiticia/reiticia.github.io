package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 使用setCellFactory自定义单元格(JDK9)
 * @author reine
 * 2022/5/19 7:54
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("str1", "str2", "str3", "str4", "str5");
        comboBox.setPrefWidth(200);

        // 设置自定义单元格
        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                MyListCell<String> listCell = new MyListCell<>();
                // listCell.updateListView(param);
                return listCell;
            }
        });


        anchorPane.getChildren().addAll(comboBox);
        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("使用setCellFactory自定义单元格(JDK9)");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
}

class MyListCell<T> extends ListCell<T> {
    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty){
            HBox hBox2 = new HBox(10);
            hBox2.setStyle("-fx-background-color: pink;");
            hBox2.setAlignment(Pos.CENTER);
            hBox2.getChildren().addAll(new Button(item.toString()), new Button(item.toString()));
            this.setAlignment(Pos.CENTER);
            this.setContentDisplay(ContentDisplay.CENTER);
            this.setGraphic(hBox2);
        }

    }
}
