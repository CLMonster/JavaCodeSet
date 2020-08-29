package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JColorChooserDemo {
    JFrame jf = new JFrame("测试颜色选择器");
    JTextArea ta = new JTextArea("我爱中华",6,35);

    // 声明按钮
    JButton jbtn = new JButton(new AbstractAction("改变文本框背景颜色"){

        @Override
        public void actionPerformed(ActionEvent e) {
            // 弹出颜色选择器 , 这是该程序的核心代码
            Color color = JColorChooser.showDialog(jf, "颜色选择器", Color.WHITE);
            // 修改TextArea的背景颜色
            ta.setBackground(color);
        }
    });

    /**
     * 组装视图
     */
    public void init(){

        // 将按钮放在Jframe的SOUTH区域，本文框放在CENTER区域
        jf.add(ta);
        jf.add(jbtn, BorderLayout.SOUTH);



        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // 启动程序
        new JColorChooserDemo().init();
    }
}
