package awtTest;

import java.awt.*;

public class BorderLayoutDemo {

    public static void main(String[] args) {
        Frame frame = new Frame("BorderLayoutDemo");

        // 1. 给frame设置BorderLayout管理器
        frame.setLayout(new BorderLayout(30,20));
        // 2.向frame指定的区域里面添加组件
        frame.add(new Button("北侧按钮"),BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"),BorderLayout.SOUTH);
        frame.add(new Button("居中侧按钮"),BorderLayout.CENTER);
        frame.add(new Button("西侧按钮"),BorderLayout.WEST);
        frame.add(new Button("东侧按钮"),BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
