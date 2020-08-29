package awtTest;


import javax.swing.*;
import java.awt.*;

/**
 * 写法：在类中定义好基本的组件
 * 然后在init方法中组装这些组件
 * 组装组件用Box容器和BorderLayout布局管理器
 */
public class BasicComponentDemo {
    public Frame frame = new Frame("测试基本组件");

    public TextArea textArea = new TextArea(5, 20);
    public Choice colorChoose = new Choice();
    public CheckboxGroup cbg = new CheckboxGroup();
    public Checkbox male = new Checkbox("male", cbg, true);
    public Checkbox female = new Checkbox("female", cbg, false);
    public Checkbox isMarraied = new Checkbox("是否已婚");
    public TextField textField = new TextField(60);
    public Button ok = new Button("确认");
    public List colorList = new List(6);


    public void init(){

        // 对组件进行布局

        // 组装底部
        Box bBox = Box.createHorizontalBox();
        bBox.add(textField);
        bBox.add(ok);
        frame.add(bBox, BorderLayout.SOUTH);

        // 组装，选择部分
        colorChoose.add("red");
        colorChoose.add("green");
        colorChoose.add("blue");

        Box cBox = Box.createHorizontalBox();
        cBox.add(colorChoose);
        cBox.add(male);
        cBox.add(female);
        cBox.add(isMarraied);

        // 组装左边模块
        Box lbox = Box.createVerticalBox();
        lbox.add(textArea);
        lbox.add(cBox);

        // 组装右边模块
        colorList.add("red");
        colorList.add("green");
        colorList.add("blue");

        // 将左侧和右侧用一个Box装起来
        Box centerBox = Box.createHorizontalBox();
        centerBox.add(lbox);
        centerBox.add(colorList);

        frame.add(centerBox, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new BasicComponentDemo().init();

    }


}
