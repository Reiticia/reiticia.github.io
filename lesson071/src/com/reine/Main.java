package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

/**
 * 案例：像素操作（字符画）
 *
 * @author reine
 * 2022/5/31 7:44
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image image = new Image("file:E:\\Users\\86158\\图片\\b43f5ff69922b5e10793b54a6b13f77.jpg");
        PixelReader pixelReader = image.getPixelReader();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                // i横坐标-j纵坐标
                Color color = pixelReader.getColor(j, i);
                int value = (int) (color.getRed() * 255);
                String string = getString(value);
                stringBuffer.append(string);
            }
            stringBuffer.append("\n");
        }

        write(stringBuffer);

        ImageView imageView = new ImageView(image);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(imageView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("案例：像素操作（字符画）");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public String getString(int value) {
        // 按照value的范围，返回字符串，其中value的范围是0-255
        if (value >= 0 && value <= 60) {
            return "@";
        } else if (value > 60 && value <= 70) {
            return "$";
        } else if (value > 70 && value <= 80) {
            return "N";
        } else if (value > 80 && value <= 90) {
            return "S";
        } else if (value > 90 && value <= 100) {
            return "O";
        } else if (value > 100 && value <= 110) {
            return "A";
        } else if (value > 110 && value <= 120) {
            return "X";
        } else {
            return " ";
        }
    }

    public void write(StringBuffer stringBuffer) {
        File file = new File("E:\\Code\\JavaFx\\Aimls-lesson-study\\lesson71\\resources\\string.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            bufferedWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
