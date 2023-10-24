package com.reine.event;

import com.reine.utils.ConsoleColor;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * 自定义事件处理器
 */
public class MyEventHandler implements EventHandler<MouseEvent> {
    private final ConsoleColor consoleColor;

    public MyEventHandler(ConsoleColor consoleColor) {
        this.consoleColor = consoleColor;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.print(consoleColor);
        System.out.println("event.getEventType() = " + event.getEventType());
        System.out.println("event.getSource() = " + event.getSource());
        System.out.println("event.getTarget() = " + event.getTarget());
        System.out.print(ConsoleColor.RESET);
    }
}