package awtTest;


import java.awt.*;

public class PanelTest02 {

    public static void main(String[] args) {
        // 1.首先创建一个window对象，因为panel内嵌容器以及其他容器是不可以独立存在的，必须依附window存在
        Frame frame = new Frame("用panel写一个窗口！");
        // 2.创建一个panle对象
        Panel panel = new Panel();
        // 3.创建一个文本框和一个按钮，并且把他们放到一个panel容器中
        panel.add(new TextField("这是一个文本框"));
        panel.add(new Button("这是一个按钮！"));
        // 4.把panel 对象放入window中
        frame.add(panel);
        // 5.设置window的位置和大小
        frame.setBounds(500,500,400,350);
        // 6.设置window可见
        frame.setVisible(true);
    }

}
