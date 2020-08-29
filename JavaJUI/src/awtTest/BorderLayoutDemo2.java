package awtTest;

import java.awt.*;

public class BorderLayoutDemo2 {

    public static void main(String[] args) {
        Frame frame = new Frame("BorderLayoutDemo");

        // 1. 给frame设置BorderLayout管理器
        frame.setLayout(new BorderLayout(30,20));
        // 2.向frame指定的区域里面添加组件
        frame.add(new Button("北侧按钮"),BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"),BorderLayout.SOUTH);

        // 将两个组件放入panel中(因为panel默认是FlowLayout布局，可以放多个组件),实现一个区域放两个组件
        Panel panel = new Panel();
        panel.add(new Button("居中侧按钮"),BorderLayout.CENTER);
        panel.add(new TextField("我是文本框"),BorderLayout.CENTER);
        // 将panel放入frame中
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
