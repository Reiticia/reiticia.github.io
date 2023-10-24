package com.reine;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/5/23 11:06
 */
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: pink;");

        Button button = new Button("button");
        TextField textField = new TextField("2");
        textField.setPromptText("请输入数字");
        textField.setFocusTraversable(false);

        anchorPane.getChildren().addAll(button, textField);
        AnchorPane.setBottomAnchor(textField, 10.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(2);
        textField.textProperty().addListener(((observable, oldValue, newValue) -> {
            Tooltip tooltip = new Tooltip();
            if (newValue.equals("")) {
                tooltip.setText("输入不能为空");
                textField.setTooltip(tooltip);
                return;
            }
            if (newValue.equals("0")){
                tooltip.setText("输入不能为0");
                textField.setTooltip(tooltip);
                return;
            }
            // 限制输入
            if (!newValue.matches("[0-9]*")) {
                textField.setText(oldValue);
                newValue = oldValue;
            }
            // 卸载提示
            Tooltip.uninstall(textField,tooltip);
            int value = Integer.parseInt(newValue);
            integerProperty.set(value);
        }));
        // 绑定界面大小的一半
        DoubleBinding divide = anchorPane.widthProperty().divide(integerProperty);
        button.prefWidthProperty().bind(divide);
        DoubleBinding divide1 = anchorPane.heightProperty().divide(integerProperty);
        button.prefHeightProperty().bind(divide1);
    }
}
