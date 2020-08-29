package awtTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo2 {

    public static void main(String[] args) {


        Frame frame = new Frame();

        // 创建一个Dialog，一个模式，一个非模式
        Dialog d1 = new Dialog(frame, "非模式对话框", false);

        // 设置Dialog的大小和位置
        d1.setBounds(500, 500, 300, 400);

        // 创建一个Box里面放一个TextArea和一个Button
        Box box = Box.createVerticalBox();
        box.add(new TextArea(5,10));
        box.add(new Button("确认"));

        d1.add(box);

        // 添加1个Button
        Button b1 = new Button("非模式对话框");

        // 给Button添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });


        // 将Button添加到frame中
        frame.add(b1, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }
}
