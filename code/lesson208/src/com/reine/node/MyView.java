package com.reine.node;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * @author reine
 * 2022/6/21 21:57
 */
public class MyView {


    public Node getView() {
        Button button = new Button("button");
        Button button1 = new Button("button1");
        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-background-color: #ffffcc");
        vBox.getChildren().addAll(button, button1);
        return vBox;
    }
}
