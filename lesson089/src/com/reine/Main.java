package com.reine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * @author reine
 * 2022/6/4 23:09
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text1 = new Text("Hello World");
        Font font1 = new Font("AdobeDevanagari-Regular", 25);
        text1.setFont(font1);

        Text text2 = new Text("Hello World");
        Font font2 = new Font("Tiger", 25);
        text2.setFont(font2);

        Text text3 = new Text("Hello World");
        Font font3 = Font.loadFont("file:E:\\Aria2\\Aria2Download\\POLYA.otf", 25);
        text3.setFont(font3);

        // 获得系统中所有字体
        Font.getFamilies().forEach(System.out::println);
        System.out.println("------------------------");
        Font.getFontNames().forEach(System.out::println);

        Text text4 = new Text("Hello World");
        Font font4 = Font.font("Trebuchet MS", FontWeight.BOLD, FontPosture.ITALIC, 25);
        text4.setFont(font4);

        // 文本内容设置
        Text text5 = new Text("Hello World");
        Font font5 = Font.font("Trebuchet MS", FontWeight.BLACK, FontPosture.ITALIC, 60);
        text5.setFont(font5);
        // 填充颜色
        text5.setFill(Color.RED);
        // 描边颜色
        text5.setStroke(Color.YELLOW);
        // 描边宽度
        text5.setStrokeWidth(3);
        // 抗锯齿
        text5.setSmooth(true);
        // 下划线
        text5.setUnderline(true);
        // 删除线
        text5.setStrikethrough(true);
        // 字体平滑
        text5.setFontSmoothingType(FontSmoothingType.LCD);


        // 多行文本
        Text text6 = new Text("Hello World,\nこの世界");
        Font font6 = new Font("meiryo", 25);
        text6.setFont(font6);
        // 每行文本居中对齐
        text6.setTextAlignment(TextAlignment.LEFT);
        // 行间距
        text6.setLineSpacing(10);
        // 用像素限制宽度
        // text6.setWrappingWidth(30);

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(text1,text2,text3,text4,text5,text6);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文本与字体");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();


    }
}

