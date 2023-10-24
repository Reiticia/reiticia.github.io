package com.reine.event;

import com.reine.utils.ConsoleColor;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.text.Text;

public class MyEvent extends MouseEvent implements EventHandler<MouseEvent> {
    private final Node node;

    public MyEvent(Node node) {
        /*
        eventType – 事件的类型
        x - 相对于场景的 x
        y - 相对于场景的 y
        screenX – 相对于屏幕的 x 坐标
        screenY - 相对于屏幕的 y 坐标
        button – 使用的鼠标按钮
        clickCount – 点击次数
        shiftDown – 如果按下 shift 修饰符，则为 true
        controlDown – 如果按下控制修饰符，则为 true
        altDown – 如果按下了 alt 修饰符，则为 true
        metaDown – 如果按下 meta 修饰符，则为 true
        primaryButtonDown - 如果主按钮被按下，则为 true
        middleButtonDown - 如果按下了中间按钮，则为 true
        secondaryButtonDown – 如果辅助按钮被按下，则为 true
        synthesized – 如果这个事件是合成的
        popupTrigger – 此事件是否表示当前平台的弹出触发器
        StillSincePress – 见isStillSincePress()
        pickResult - 选择结果。可以为空，在这种情况下，将根据场景坐标构造没有任何其他值的 2D 拾取结果
            target - 选择的目标（在场景的情况下为空）
            sceneX - 场景 X 坐标
            sceneY - 场景 Y 坐标
        */
        super(MouseEvent.MOUSE_CLICKED,
                0, 0, 0, 0,
                MouseButton.PRIMARY, 1,
                false, false, false, false,
                true, false, false,
                false, false, false,
                new PickResult(node, 0, 0));
        this.node = node;
        System.out.println(ConsoleColor.GREEN + "MyEvent构造方法" + ConsoleColor.RESET);
    }

    @Override
    public void handle(MouseEvent event) {
        if (node instanceof Text) {
            System.out.println(ConsoleColor.YELLOW + "((Text) node).getText() = " + ((Text) node).getText() + ConsoleColor.RESET);
        }
    }
}