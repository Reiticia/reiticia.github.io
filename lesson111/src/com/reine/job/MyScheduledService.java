package com.reine.job;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

/**
 * @author reine
 * 2022/6/9 7:59
 */
public class MyScheduledService extends ScheduledService<Number> {

    int sum = 0;

    @Override
    protected Task<Number> createTask() {
        System.out.println("创建任务");
        return new Task<Number>() {
            @Override
            protected Number call() throws Exception {
                sum++;
                System.out.println(sum);
                return sum;
            }
            @Override
            protected void updateValue(Number value) {
                super.updateValue(value);
                if (value.intValue() >= 10) {
                    // 停掉外部的任务
                    MyScheduledService.this.cancel();
                    System.out.println("任务取消");
                }
            }
        };
    }
}
