package EventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerDemo {

    public static void main(String[] args) {

        Frame frame = new Frame();

        // 创建组件(事件源)
        TextField tf = new TextField(20);
        Choice choice = new Choice();
        choice.add("张三");
        choice.add("李四");
        choice.add("王二");

        // 给文本域名添加TextListener,监听内容的变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                System.out.println("当前文本框内容为：" + tf.getText());
            }
        });


        // 给下拉选择框添加ItemListener,监听条目选项的变化
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("当前的条目为" + e.getItem());
            }
        });


        // 给frame注册ContainerListener，监听容器中组件的变化
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println("添加的组件" + e.getChild());
            }

            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        // 组件添加到frame中
        Box hbox = Box.createHorizontalBox();
        hbox.add(choice);
        hbox.add(tf);
        frame.add(hbox);

        // 显示最佳窗体
        frame.pack();
        frame.setVisible(true);
    }
}
