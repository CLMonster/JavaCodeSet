package awtTest;

import javax.swing.*;
import java.awt.*;

public class BoxDemo2 {

    public static void main(String[] args) {

        Frame frame = new Frame();

        // 创建一个水平Box，hbox，存放三个button，两个Butotn之间有一个Gule和一个20px的间隔
        Box hbox = Box.createHorizontalBox();

        hbox.add(new Button("水平Button1"));
        hbox.add(Box.createHorizontalGlue());
        hbox.add(new Button("水平Button2"));
        hbox.add(Box.createHorizontalStrut(20));
        hbox.add(new Button("水平Button3"));

        frame.add(hbox, BorderLayout.NORTH);

        // 创建垂直Box，vbox，存放三个button，两个Butotn之间有一个Gule和一个20px的间隔
        Box vbox = Box.createVerticalBox();

        vbox.add(new Button("垂直Button1"));
        vbox.add(Box.createVerticalGlue());
        vbox.add(new Button("垂直Button2"));
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(new Button("垂直Button3"));
        frame.add(vbox);

        frame.pack();
        frame.setVisible(true);

    }
}
