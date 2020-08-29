package awtTest;

import java.awt.*;

public class AWTtest01 {

    public static void main(String[] args) {

        // 创建一个窗口对象
        Frame frame = new Frame("awt创建一个窗口！");
        // 设置窗口的位置，大小，他们的单位是像素
//        frame.setBackground();  // 设置窗口的背景颜色
        frame.setBounds(100,100,200,200);  // 设置位置和窗口的大小
        // frame默认是invisible的，所以需要设置visible
        frame.setVisible(true);

    }
}
