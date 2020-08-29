package SwingTest.FourDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InputDialogDemo {
    JFrame jf = new JFrame("测试InputDialog");
    JTextArea ta = new JTextArea("",6,35);
    JButton jButton = new JButton(new AbstractAction("弹出输入对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = JOptionPane.showInputDialog(jf, "请输入您的电话号码：", "输入对话框",JOptionPane.DEFAULT_OPTION);
            ta.append(s);
        }
    });

    public void init(){
        // 将多行文本域和JButton添加到JFrame中
        jf.add(ta);
        jf.add(jButton, BorderLayout.SOUTH);

        // 显示JFrame
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new InputDialogDemo().init();
    }


}
