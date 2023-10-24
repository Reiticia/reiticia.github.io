package com.reine.job;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.Slider;

/**
 * 自定义定时任务
 */
public class My extends ScheduledService<Integer> {
    int i = 0;
    Slider slider;

    public My(Slider slider) {
        this.slider = slider;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                return ++i;
            }

            @Override
            protected void updateValue(Integer value) {
                super.updateValue(value);
                // slider.setValue(value);
            }
        };
    }
}