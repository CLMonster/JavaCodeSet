package awtTest;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo {

    public static void main(String[] args) {

        // create a frame container
        Frame frame = new Frame();

        // 基于frame ,创建BoxLayout，并且该对象存放组件是垂直存放
//        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.Y_AXIS);
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);

        // 将boxLayout给frame
        frame.setLayout(boxLayout);

        // 添加两个组件
        frame.add(new Button("button1"));
        frame.add(new Button("button2"));


        frame.pack();
        frame.setVisible(true);
    }
}
