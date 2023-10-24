package com.reine.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author reine
 * 2022/6/9 11:42
 */
public class HelloController {
    @FXML
    private Button fxmlbtn;
    @FXML
    private Label fxmllabel;

    /**
     * 初始化时调用
     */
    @FXML
    private void initialize() {
        System.out.println("initialize");
        System.out.println("fxmllabel.getText() = " + fxmllabel.getText());
    }

    @FXML
    private void action(ActionEvent actionEvent) {
        fxmllabel.setText(fxmlbtn.getText());
    }

    /**
     * 方便与Main方法中获取组件
     *
     * @return
     */
    public Button getFxmlbtn() {
        return fxmlbtn;
    }

    public Label getFxmllabel() {
        return fxmllabel;
    }
}
