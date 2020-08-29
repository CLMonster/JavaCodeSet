package awtTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandling {

    private Frame frame = new Frame();
    private TextField tf = new TextField(10);
    // 事件源
    private Button buttonOk = new Button("确认");


    public void init(){
        // 组装视图
        // 监听器
        Mylistener mylistener = new Mylistener();

        // 注册监听
        buttonOk.addActionListener(mylistener);

        // 将组件放入frame中
        frame.add(tf, BorderLayout.NORTH);
        frame.add(buttonOk);

        // 窗体大小最佳，并可见
        frame.pack();
        frame.setVisible(true);
    }


    // 创建一个内部类，当然也可以用匿名内部类。当多个事件源使用这个监听器，使用内部类是比较方便的。
    private class Mylistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("hello,world!");
        }
    }

    public static void main(String[] args) {
        new EventHandling().init();

    }
}
