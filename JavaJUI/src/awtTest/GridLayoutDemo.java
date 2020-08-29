package awtTest;

import javax.swing.border.Border;
import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {

        Frame frame = new Frame();

        // 1.创建一个textField,放入BorderLayout布局的北区域
        frame.add(new TextField(), BorderLayout.NORTH);

        // 2.创建一个Panel，添加到frame中
        Panel panel = new Panel();
        // 3.将panel的布局改为GridLayout，设置3行5列，上下外边距3px，左右外边距3px
        panel.setLayout(new GridLayout(3,5,3,3));

        // 4.想panel中添加button
        for (int i = 0; i < 10; i++) {
            panel.add(new Button(i+""));
        }

        panel.add(new Button("+"));
        panel.add(new Button("-"));
        panel.add(new Button("*"));
        panel.add(new Button("/"));
        panel.add(new Button("."));

        // 5.将panel添加到frame中，默认是CENTER位置
        frame.add(panel);
        frame.add(new Button("="),BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }
}
