package com.reine;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * 简单登录窗口
 *
 * @author reine
 * 2022/5/13 12:13
 */
public class Main extends Application {
    private static User user;

    public static void main(String[] args) {
        user = new User("reine", "111");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane form = new GridPane();
        form.setStyle("-fx-background-color: pink;");
        Label username = new Label("账号:");
        username.setFont(Font.font(16));
        TextField inputUsername = new TextField();
        inputUsername.setPromptText("请输入账号");
        inputUsername.setTooltip(new Tooltip("请输入账号"));
        inputUsername.setPrefWidth(200);
        // 设置默认失焦
        inputUsername.setFocusTraversable(false);
        Label password = new Label("密码:");
        password.setFont(Font.font(16));
        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("请输入密码");
        inputPassword.setTooltip(new Tooltip("请输入密码"));
        inputPassword.setPrefWidth(200);
        // 设置默认失焦
        inputPassword.setFocusTraversable(false);
        Button reset = new Button("重置");
        Button login = new Button("登录");
        reset.setFocusTraversable(false);
        login.setFocusTraversable(false);

        // 提示信息
        Label tip = new Label();
        // 设置提示信息颜色
        tip.setTextFill(Color.RED);

        form.add(username, 0, 0);
        form.add(inputUsername, 1, 0);
        form.add(password, 0, 1);
        form.add(inputPassword, 1, 1);
        // 创建水平布局放置两个按钮
        HBox buttonGroup = new HBox();
        buttonGroup.getChildren().addAll(tip, reset, login);
        // 右对齐
        buttonGroup.setAlignment(Pos.TOP_RIGHT);
        // 设置组件间间距
        buttonGroup.setSpacing(10);
        form.add(buttonGroup, 1, 2);
        // 设置组件间水平和垂直边距
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);
        Scene scene = new Scene(form);
        primaryStage.setScene(scene);
        primaryStage.setTitle("简单登录窗口");
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.setResizable(false);
        primaryStage.show();

        // 密码框文本变化监听器
        inputPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length()>8){
                inputPassword.setText(oldValue);
                tip.setText("密码最多8位");
            }
        });

        // 重置按钮点击事件
        reset.setOnAction(event -> {
            inputUsername.setText("");
            inputPassword.setText("");
            tip.setText("");
        });

        // 登录按钮点击事件
        login.setOnAction(event -> {
            String usernameText = inputUsername.getText();
            String passwordText = inputPassword.getText();
            // 创建动画
            FadeTransition fadeTransition = new FadeTransition();
            // 动画持续时间
            fadeTransition.setDuration(Duration.seconds(0.1));
            fadeTransition.setNode(form);
            // 透明度从0到1
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            if (usernameText.trim().equals("")) {
                tip.setText("请输入账号");
                // 播放动画
                fadeTransition.play();
            } else if (passwordText.trim().equals("")) {
                tip.setText("请输入密码");
                fadeTransition.play();
            } else if (!usernameText.trim().equals(user.getUsername())) {
                tip.setText("用户不存在");
                fadeTransition.play();
            } else if (!passwordText.trim().equals(user.getPassword())) {
                tip.setText("密码错误");
                fadeTransition.play();
            } else {
                // 展示登录成功弹窗
                DialogPane success = new DialogPane();
                success.setContentText("恭喜你登录成功");
                // 设置按钮
                success.getButtonTypes().add(ButtonType.CLOSE);
                Button close = (Button) success.lookupButton(ButtonType.CLOSE);
                Scene successScene = new Scene(success);
                Stage successStage = new Stage();
                successStage.setScene(successScene);
                // 关闭主窗口
                primaryStage.close();
                // 设置模态，如果主窗口关闭了，则不能开启下列两行
                // successStage.initOwner(primaryStage);
                // successStage.initModality(Modality.WINDOW_MODAL);
                successStage.initStyle(StageStyle.UTILITY);
                successStage.show();
                // 按钮点击事件：关闭窗口
                close.setOnAction(eventFail -> successStage.close());
            }
        });

        // Enter键盘事件
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                // 触发按钮点击事件
                login.fire();
            } else if (event.getCode().equals(KeyCode.ESCAPE)) {
                primaryStage.close();
            }
        });
    }
}
