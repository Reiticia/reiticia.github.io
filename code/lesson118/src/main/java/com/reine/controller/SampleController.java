package com.reine.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author reine
 * 2022/6/10 19:31
 */
public class SampleController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(location.getPath());
        System.out.println(resources);
    }
}
