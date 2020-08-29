package awtTest;

import javax.swing.*;
import java.awt.*;
import java.nio.ByteOrder;

public class BoxDemo {

    public static void main(String[] args) {

        Frame frame = new Frame();

        // 创建Box容器box1,水平摆放两个button，放在frame容器的北区域
        Box hbox = Box.createHorizontalBox();
        hbox.add(new Button("水平button1"));
        hbox.add(new Button("水平button2"));
        frame.add(hbox, BorderLayout.NORTH);

        // 创建Box容器box2，垂直摆放两个button，放在frame容器的中间区域
        Box vbox = Box.createVerticalBox();
        vbox.add(new Button("垂直button3"));
        vbox.add(new Button("垂直button4"));
        frame.add(vbox, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);





    }
}
