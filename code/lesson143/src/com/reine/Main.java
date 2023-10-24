package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/15 14:53
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image image = new Image("emoji/1f605.png");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        for (int i = 0; i < 5; i++) {
            Rectangle rectangle = new Rectangle(200, 200);
            rectangle.setFill(Paint.valueOf("#cccccc"));
            grid.add(rectangle, i, 0);
        }

        HBox box = new HBox(10);
        box.getChildren().addAll(new Circle(100), new Polygon(100, 0, 0, 200, 200, 200));

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(grid, box);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ImagePattern");
        primaryStage.setWidth(1050);
        primaryStage.setHeight(800);
        primaryStage.show();

        Rectangle rec0 = (Rectangle) grid.getChildren().get(0);
        rec0.setFill(new ImagePattern(image));
        Rectangle rec1 = (Rectangle) grid.getChildren().get(1);
        rec1.setFill(new ImagePattern(image, 0, 0, 0.5, 0.5, true));
        Rectangle rec2 = (Rectangle) grid.getChildren().get(2);
        rec2.setFill(new ImagePattern(image, 0, 0, 50, 50, false));
        Rectangle rec3 = (Rectangle) grid.getChildren().get(3);
        rec3.setFill(new ImagePattern(image, 25, 0, 50, 50, false));
        Rectangle rec4 = (Rectangle) grid.getChildren().get(4);
        rec4.setFill(new ImagePattern(image, 25, 50, 50, 50, false));
        Circle circle = (Circle) box.getChildren().get(0);
        circle.setFill(new ImagePattern(image, 0, 0, 50, 50, false));
        Polygon polygon = (Polygon) box.getChildren().get(1);
        polygon.setFill(new ImagePattern(image, 0, 0, 50, 50, false));
    }
}
