package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 关于宽度高度
 * @author reine
 * 2022/5/21 16:59
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        Button button = new Button("btn");
        // button.setPrefWidth(100);
        // button.setPrefWidth(Button.USE_COMPUTED_SIZE);


        Rectangle rectangle = new Rectangle();
        rectangle.setStyle("-fx-background-color: black;");
        rectangle.setWidth(100);
        rectangle.setHeight(100);

        HBox hBox = new HBox();
        // hBox.setPrefWidth(300);
        // hBox.setMaxHeight(300);
        // 自动计算：默认
        // hBox.setPrefWidth(HBox.USE_COMPUTED_SIZE);
        // 设置最小
        // hBox.setPrefWidth(HBox.USE_PREF_SIZE);
        hBox.getChildren().addAll(button, rectangle);

        anchorPane.getChildren().add(hBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("关于宽度高度");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        System.out.println("hBox.getChildren().size() = " + hBox.getChildren().size());
        System.out.println("hBox.isResizable() = " + hBox.isResizable());
        System.out.println("button.isResizable() = " + button.isResizable());
        System.out.println("rectangle.isResizable() = " + rectangle.isResizable());

        // 设置了PrefWidth会影响Width，未设置PrefWidth会显示-1.0
        System.out.println("button.getPrefWidth() = " + button.getPrefWidth());
        System.out.println("button.getWidth() = " + button.getWidth());

        // 设置文本超过宽度自动换行
        // button.setWrapText(true);

        System.out.println("button.prefHeight(-1) = " + button.prefHeight(-1));
        // 宽度/高度依赖的方向
        System.out.println("button.getContentBias() = " + button.getContentBias());
    }
}
