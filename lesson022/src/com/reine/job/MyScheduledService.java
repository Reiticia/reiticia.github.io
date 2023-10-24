package com.reine.job;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 * 定时任务
 */
public class MyScheduledService extends ScheduledService<Integer> {
    DialogPane dialogPane = null;
    Stage stage = null;
    int i = 0;

    public MyScheduledService(DialogPane dialogPane, Stage stage) {
        this.dialogPane = dialogPane;
        this.stage = stage;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("call(): " + Thread.currentThread().getName());
                return i++;
            }

            @Override
            protected void updateValue(Integer value) {
                System.out.println("updateValue(): " + Thread.currentThread().getName());
                System.out.println("updateValue的值：" + value);
                super.updateValue(value);
                if (value < 11) {
                    // 小于10，更新界面
                    dialogPane.setContentText(value.toString());
                } else {
                    // 大于10，关闭对话框
                    stage.close();
                    MyScheduledService.this.cancel();
                }
            }

        };
    }
}