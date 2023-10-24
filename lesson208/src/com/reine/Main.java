package com.reine;

import com.reine.node.MyNode;
import com.reine.node.MyView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/21 21:48
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MyNode node = new MyNode(10);
        for (int i = 0; i < 10; i++) {
            node.getChildren().add(new Button("Button" + i));
        }

        AnchorPane root = new AnchorPane();
        root.getChildren().add(node);
        AnchorPane.setTopAnchor(node, 100.0);
        AnchorPane.setLeftAnchor(node, 100.0);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("自定义组件");
        primaryStage.show();
    }

    private Node getView() {
        Button button = new Button("button");
        Button button1 = new Button("button1");
        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-background-color: #ffffcc");
        vBox.getChildren().addAll(button, button1);
        return vBox;
    }
}
