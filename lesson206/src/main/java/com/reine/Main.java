package com.reine;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author reine
 * 2022/6/21 19:55
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = getViewFxml();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adaptive layout自适应布局");
        primaryStage.show();

    }

    /**
     * 通过Java代码方式编写自适应布局
     * @return
     */
    private Pane getViewJava(){
        AnchorPane root = new AnchorPane();
        root.setPrefSize(600, 400);
        VBox pane = new VBox();
        root.getChildren().add(pane);
        StackPane top = new StackPane();
        top.setStyle("-fx-background-color: #ffffcc");
        top.prefWidthProperty().bind(root.widthProperty());
        top.setPrefHeight(50);
        StackPane bottom = new StackPane();
        bottom.setStyle("-fx-background-color: #ccffff");
        bottom.prefWidthProperty().bind(root.widthProperty());
        bottom.setPrefHeight(50);
        HBox middle = new HBox();
        middle.setStyle("-fx-background-color: #ffcccc");
        middle.prefWidthProperty().bind(root.widthProperty());
        DoubleBinding h = root.heightProperty().subtract(top.getPrefHeight()).subtract(bottom.getPrefHeight());
        middle.prefHeightProperty().bind(h);
        StackPane left = new StackPane();
        left.setStyle("-fx-background-color: #ff9999");
        left.prefHeightProperty().bind(middle.prefHeightProperty());
        left.prefWidthProperty().bind(middle.prefWidthProperty().multiply(0.3));
        StackPane right = new StackPane();
        right.setStyle("-fx-background-color: #996699");
        right.prefHeightProperty().bind(middle.prefHeightProperty());
        right.prefWidthProperty().bind(middle.prefWidthProperty().multiply(0.7));
        middle.getChildren().addAll(left,right);
        pane.getChildren().addAll(top, middle, bottom);
        return root;
    }

    /**
     * 通过fxml方式编写自适应布局
     * @return
     */
    private Pane getViewFxml() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("fxml/main.fxml"));
        Pane root = fxmlLoader.load();
        return root;
    }
}
