package com.reine;

import com.reine.entity.Student;
import com.reine.utils.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * 泛型为Student的ComboBox
 * @author reine
 * 2022/5/19 11:13
 */
public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:lightyellow;");

        // 新建5个Student对象
        Student student1 = new Student("张三", 86, "语文");
        Student student2 = new Student("李四", 94, "数学");
        Student student3 = new Student("王五", 83, "英语");
        Student student4 = new Student("赵六", 75, "物理");
        Student student5 = new Student("钱七", 64, "化学");

        ComboBox<Student> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(student1, student2, student3, student4, student5);
        comboBox.setPrefWidth(200);

        // 设置自定义单元格
        comboBox.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                System.out.println(Color.RED + "call");
                // 匿名内部类
                ListCell<Student> listCell = new ListCell<>() {
                    @Override
                    protected void updateItem(Student item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            HBox hBox = new HBox(10);
                            ImageView imageView = new ImageView("/images/logo.png");
                            imageView.setFitWidth(20);
                            imageView.setFitHeight(20);
                            Label name = new Label(item.getName());
                            Label score = new Label(item.getScore() + "");
                            Label subject = new Label(item.getSubject());
                            hBox.getChildren().addAll(imageView, name, new Separator(), score, new Separator(), subject);
                            setGraphic(hBox);
                            System.out.println(Color.BLUE + "fill");
                        } else {
                            System.out.println(Color.GREEN + "empty");
                        }
                    }
                };
                return listCell;
            }
        });

        // 设置自定义字符串转换器
        comboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Student object) {
                System.out.println(Color.YELLOW + "toString");
                if (object == null) {
                    return "";
                }
                String value = object.getName() + ":" + object.getScore() + ":" + object.getSubject();
                return value;
            }

            // 在输入框中输入文本按下回车键时，调用此方法
            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        anchorPane.getChildren().addAll(comboBox);
        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("泛型为Student的ComboBox");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
}

