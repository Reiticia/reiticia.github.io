package com.reine.job;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

/**
 * @author reine
 * 2022/6/6 14:04
 */
public class MyService extends ScheduledService<Double> {
    double value = 0;

    @Override
    protected Task<Double> createTask() {
        return new Task<Double>() {
            @Override
            protected Double call() throws Exception {
                value += 0.1;
                return value;
            }
        };
    }
}
