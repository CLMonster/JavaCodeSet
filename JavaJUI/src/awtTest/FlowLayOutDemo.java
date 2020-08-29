package awtTest;

import java.awt.*;

public class FlowLayOutDemo {

    public static void main(String[] args) {
        Frame frame = new Frame();

        // 1.通过setLayout方法来设置Frame的布局方式
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
//        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,40,20));

        // 2.添加多个按钮到Frame中
        for (int i = 1; i <= 100; i++) {
            frame.add(new Button("按钮"+i));
        }

        // 3.使用pack方法设置Frame最佳大小
        frame.pack();

        // 设置Frame可见
        frame.setVisible(true);
    }
}
