package com.reine;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author reine
 * 2022/6/21 23:14
 */
public class Main extends Application {
    /**
     * 毛玻璃图片
     */
    private ImageView iv_blur = new ImageView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        ImageView iv = new ImageView("images/saren.jpg");

        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(iv);

        Node view = getView(primaryStage);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(pane, button1, button2, view);
        AnchorPane.setLeftAnchor(button1, 200.0);
        AnchorPane.setLeftAnchor(button2, 300.0);

        Scene scene = new Scene(root, 960, 540);
        primaryStage.setScene(scene);
        primaryStage.setTitle("毛玻璃效果");
        primaryStage.show();

        iv.fitWidthProperty().bind(primaryStage.widthProperty());
        iv.fitHeightProperty().bind(primaryStage.heightProperty());

        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), view);
        tt.setInterpolator(Interpolator.EASE_OUT);
        // 覆盖
        button1.setOnAction(event -> {
            tt.setFromX(-200);
            tt.setToX(0);
            tt.play();
        });

        // 移开
        button2.setOnAction(event -> {
            tt.setFromX(0);
            tt.setToX(-200);
            tt.play();
        });

        // 毛玻璃效果实现
        view.translateXProperty().addListener((observable, oldValue, newValue) -> {
            int w = 200 - (-newValue.intValue());
            int h = (int) root.getHeight();
            if (w > 0) {
                WritableImage image = new WritableImage(w, h);
                pane.snapshot(new SnapshotParameters(), image);
                iv_blur.setImage(image);
            }
        });

    }

    /**
     * 遮盖层
     *
     * @param stage
     * @return
     */
    private Node getView(Stage stage) {
        StackPane sp = new StackPane();
        AnchorPane ap = new AnchorPane();
        iv_blur.setEffect(new GaussianBlur(20));// 高斯模糊
        ap.getChildren().add(iv_blur);// 模糊层
        AnchorPane.setRightAnchor(iv_blur, 0.0);// 靠右

        VBox vBox = new VBox(20);
        vBox.setPrefWidth(200);
        vBox.setStyle("-fx-background-color: #ffffff55");
        for (int i = 0; i < 5; i++) {
            vBox.getChildren().add(new Text("hello javafx" + i));
        }

        sp.getChildren().addAll(ap, vBox);
        vBox.prefHeightProperty().bind(stage.heightProperty());
        sp.setTranslateX(-200);
        return sp;
    }
}
