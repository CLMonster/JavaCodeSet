package awtTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo {

    public static void main(String[] args) {


        Frame frame = new Frame();

        // 创建两个Dialog，一个模式，一个非模式
        Dialog d1 = new Dialog(frame, "模式对话框", true);
        Dialog d2 = new Dialog(frame, "非模式对话框", false);

        // 设置两个Dialog的大小和位置
        d1.setBounds(500, 500, 300, 400);
        d2.setBounds(500, 500, 300, 400);

        // 添加两个Button
        Button b1 = new Button("模式对话框");
        Button b2 = new Button("非模式对话框");

        // 给Button添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });

        // 将Button添加到frame中
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
