package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

/**
 * 图片加载的方式
 * @author reine
 * 2022/5/28 7:51
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        FileInputStream fileInputStream = new FileInputStream(new File("E:\\Users\\86158\\Document\\KDEShare\\1653719308635.gif"));
        Image image = new Image(fileInputStream);

        /*
            is – 从中加载图像的流
            requestedWidth – 图像的边界框宽度
            requestedHeight – 图像的边界框高度
            preserveRatio - 表示在缩放以适应指定边界框内的图像时是否保留原始图像的纵横比
            smooth - 指示在缩放此图像以适合指定边界框时是使用质量更好的过滤算法还是使用更快的过滤算法
         */
        Image image1 = new Image(fileInputStream, 100, 100, true, true);

        String path = "file:E:\\Users\\86158\\图片\\img.jpg";

        /*
            url – 表示用于获取像素数据的 URL 的字符串
            requestedWidth – 图像的边界框宽度
            requestedHeight – 图像的边界框高度
            preserveRatio - 表示在缩放以适应指定边界框内的图像时是否保留原始图像的纵横比
            smooth - 指示在缩放此图像以适合指定边界框时是使用质量更好的过滤算法还是使用更快的过滤算法
            backgroundLoading – 指示图像是否在后台加载
        */
        Image image2 = new Image(path, 400, 400, true, true, true);

        String path1 = "https://pic3.zhimg.com/80/v2-d91e417ebb04cd89c7a2171565d4f846_720w.jpg";

        /*
            url – 表示用于获取像素数据的 URL 的字符串
            requestedWidth – 图像的边界框宽度
            requestedHeight – 图像的边界框高度
            preserveRatio - 表示在缩放以适应指定边界框内的图像时是否保留原始图像的纵横比
            smooth - 指示在缩放此图像以适合指定边界框时是使用质量更好的过滤算法还是使用更快的过滤算法
            backgroundLoading – 指示图像是否在后台加载
        */
        // 加载网络图片最好使用异步加载
        Image image3 = new Image(path1, 400, 400, true, true, true);

        ImageView imageView = new ImageView(image3);
        anchorPane.getChildren().addAll(imageView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("图片加载的方式");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
