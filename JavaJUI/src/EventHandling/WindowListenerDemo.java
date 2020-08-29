package EventHandling;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDemo {

    public static void main(String[] args) {

        Frame frame = new Frame();
        frame.setBounds(200,300,400,500);

        // 设置WindowListener，如果用户点击X，则关闭当前窗口。这里使用适配器WindowAdapter
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 关闭当前窗口
                System.exit(0);
            }
        });

//        frame.pack();
        frame.setVisible(true);
    }
}
