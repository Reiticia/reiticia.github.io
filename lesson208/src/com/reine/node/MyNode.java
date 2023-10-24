package com.reine.node;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * @author reine
 * 2022/6/21 21:59
 */
public class MyNode extends VBox {

    public MyNode(double spacing) {
        super(spacing);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        System.out.println("layoutChildren");
        for (int i = 0; i < this.getChildren().size(); i++) {
            int temp = i;
            if (i % 2 == 0) {
                Button node = (Button) this.getChildren().get(i);
                node.setTranslateX(20);
                node.setOnAction(event -> {
                    System.out.println("button - " + temp);
                });
            }
        }
    }
}
