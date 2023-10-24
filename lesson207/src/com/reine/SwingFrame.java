package com.reine;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * @author reine
 * 2022/6/21 21:25
 */
public class SwingFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JPanel root = new JPanel();
        JButton button = new JButton("button");
        JButton button1 = new JButton("button1");
        root.add(button);
        root.add(button1);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 100);// 布局类
        root.setLayout(flowLayout);
        jFrame.setContentPane(root);
        jFrame.setTitle("swing frame");
        jFrame.pack();// 适应内容
        jFrame.setVisible(true);
    }
}
