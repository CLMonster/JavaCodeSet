package awtTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo {

    public static void main(String[] args) {

        Frame frame = new Frame();

        // 1.创建一个Panel容器p1,用于存放多张卡片
        Panel p1 = new Panel();
        // 2.创建CardLayout布局管理器，设置p1的布局管理器为CardLayout，并往p1中添加多个button
        CardLayout cardLayout = new CardLayout();
        p1.setLayout(cardLayout);
        String[] names = {"第一张", "第二张", "第三张", "第四张", "第五张"};
        for (int i = 0; i < names.length; i++) {
            p1.add(names[i],new Button(names[i]));
        }

        // 3.将p1添加到Frame容器的中间区域
        frame.add(p1);

        // 4.创建第二个Panel容器p2，用于存放多个按钮组件
        Panel p2 = new Panel();

        // 5.创建5个Button
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");

        // 6.创建一个时间监听器，监听按钮的点击动作
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand){
                    case "上一张":
                        cardLayout.previous(p1);
                        break;
                    case "下一张":
                        cardLayout.next(p1);
                        break;
                    case "第一张":
                        cardLayout.first(p1);
                        break;
                    case "最后一张":
                        cardLayout.last(p1);
                        break;
                    case "第三张":
                        cardLayout.show(p1,"第三张");
                        break;
                }
            }
        };

        // 7.将时间监听器与按钮绑定
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        // 8.把按钮添加到p2中，并将p2添加到frame的南部区域
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        frame.add(p2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
