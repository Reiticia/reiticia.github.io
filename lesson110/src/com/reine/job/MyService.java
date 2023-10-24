package com.reine.job;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * @author reine
 * 2022/6/8 23:07
 */
public class MyService extends Service<Number> {
    @Override
    protected Task<Number> createTask() {
        return new MyTask();
    }

    @Override
    protected void executeTask(Task<Number> task) {
        super.executeTask(task);
        task.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("executeTask:valueProperty");
        });
    }

    @Override
    protected void ready() {
        super.ready();
        System.out.println("ready:"+ Platform.isFxApplicationThread());
    }

    @Override
    protected void scheduled() {
        super.scheduled();
        System.out.println("scheduled:"+ Platform.isFxApplicationThread());
    }

    @Override
    protected void running() {
        super.running();
        System.out.println("running:"+ Platform.isFxApplicationThread());
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        System.out.println("succeeded:"+ Platform.isFxApplicationThread());
    }

    @Override
    protected void cancelled() {
        super.cancelled();
        System.out.println("cancelled:"+ Platform.isFxApplicationThread());
    }

    @Override
    protected void failed() {
        super.failed();
        System.out.println("failed:"+ Platform.isFxApplicationThread());
    }

}
