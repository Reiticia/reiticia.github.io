package com.reine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author reine
 * 2022/6/7 13:24
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreeView<String> treeView = new TreeView<>();
        treeView.setLayoutX(100);
        treeView.setLayoutY(100);

        TreeItem<String> china = new TreeItem<>("中国");
        TreeItem<String> hlj = new TreeItem<>("黒龙江");
        TreeItem<String> heb = new TreeItem<>("哈尔滨");
        TreeItem<String> jms = new TreeItem<>("佳木斯");
        TreeItem<String> dq = new TreeItem<>("大庆");
        hlj.getChildren().addAll(heb, jms, dq);

        TreeItem<String> gd = new TreeItem<>("广东");
        TreeItem<String> zj = new TreeItem<>("珠海");
        TreeItem<String> sz = new TreeItem<>("深圳");
        TreeItem<String> dg = new TreeItem<>("东莞");
        gd.getChildren().addAll(zj, sz, dg);

        TreeItem<String> tw = new TreeItem<>("台湾");
        TreeItem<String> tb = new TreeItem<>("台北");
        TreeItem<String> gx = new TreeItem<>("高雄");
        TreeItem<String> tn = new TreeItem<>("台南");
        tw.getChildren().addAll(tb, gx, tn);

        china.getChildren().addAll(hlj, gd, tw);
        treeView.setRoot(china);

        // 设置可编辑
        treeView.setEditable(true);
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> param) {
                return new TreeCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item.equals("")) {
                            this.setGraphic(null);
                            return;
                        }
                        // 展开时的图片
                        if (this.getTreeItem().isExpanded()) {
                            ImageView imageView = new ImageView("/images/add.png");
                            imageView.setPreserveRatio(true);
                            imageView.setFitWidth(15);
                            this.setDisclosureNode(imageView);
                        } else {
                            // 收起时的图片
                            ImageView imageView = new ImageView("/images/sub.png");
                            imageView.setPreserveRatio(true);
                            imageView.setFitWidth(15);
                            this.setDisclosureNode(imageView);
                        }
                        this.setUserData(item);
                        initGraphic();
                    }

                    @Override
                    public void startEdit() {
                        super.startEdit();
                        TextField textField = new TextField(this.getUserData().toString());
                        this.setGraphic(textField);
                        textField.requestFocus();
                        textField.setOnKeyPressed(event -> {
                            if (event.getCode() == KeyCode.ENTER) {
                                commitEdit(textField.getText());
                            }
                        });
                    }

                    @Override
                    public void cancelEdit() {
                        super.cancelEdit();
                        initGraphic();
                    }

                    @Override
                    public void commitEdit(String newValue) {
                        super.commitEdit(newValue);
                        this.setUserData(newValue);
                    }

                    private void initGraphic() {
                        Label label = new Label(this.getUserData().toString());
                        this.setGraphic(label);
                    }
                };
            }
        });

        // 展开
        china.setExpanded(true);
        hlj.setExpanded(true);
        gd.setExpanded(true);
        tw.setExpanded(true);

        Button button = new Button("button");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button, treeView);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TreeView自定义Cell");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(event -> {

        });
    }
}
