package awtTest;

import java.awt.*;

public class ScrollPanelDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 1.创建一个ScrollPanel对象
        ScrollPane sl = new ScrollPane();

        // 2.向ScrollPanel添加按钮和文本框
        sl.add(new TextField("这是一个textField"));
        sl.add(new Button("这是一个Button"));

        // 3.向frame中添加ScrollPanel
        frame.add(sl);

        // 设置frame
        frame.setBounds(200,200,500,500);
        frame.setVisible(true);


    }
}
