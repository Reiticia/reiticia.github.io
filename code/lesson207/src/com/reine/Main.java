package com.reine;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author reine
 * 2022/6/21 21:23
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        SwingNode swingNode = new SwingNode();
        Button fxButton = new Button("fxButton");

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(swingNode,fxButton);
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SwingNode");
        primaryStage.show();

        fxButton.setOnAction(event -> {
            System.out.println("fxButton");
        });

        SwingUtilities.invokeLater(()->{
            JPanel rootJP = new JPanel();
            JButton button = new JButton("button");
            JButton button1 = new JButton("button1");
            rootJP.add(button);
            rootJP.add(button1);
            FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 100);// 布局类
            rootJP.setLayout(flowLayout);
            swingNode.setContent(rootJP);

            button.addActionListener(e -> System.out.println("swing button"));
            button1.addActionListener(e -> System.out.println("swing button1"));
        });
    }
}
