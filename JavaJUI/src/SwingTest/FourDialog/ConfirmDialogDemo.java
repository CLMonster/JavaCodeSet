package SwingTest.FourDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfirmDialogDemo {
    JFrame jf = new JFrame("测试确认对话框");
    JTextArea ta = new JTextArea("我爱中华！",6,35);

    JButton messageJbtn = new JButton(new AbstractAction("弹出确认对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 传递不同的按钮类型
//            int confirmDialog = JOptionPane.showConfirmDialog(jf, ta.getText(), "确认对话框", JOptionPane.DEFAULT_OPTION);
//            int confirmDialog = JOptionPane.showConfirmDialog(jf, ta.getText(), "确认对话框", JOptionPane.YES_NO_OPTION);
//            int confirmDialog = JOptionPane.showConfirmDialog(jf, ta.getText(), "确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
            int confirmDialog = JOptionPane.showConfirmDialog(jf, ta.getText(), "确认对话框", JOptionPane.OK_CANCEL_OPTION);

            ta.append("\n");
            //JOptionPane.YES_OPTION和JOtionPane.OK_OPTION的值都为0
            switch (confirmDialog){
                case JOptionPane.YES_OPTION:
                    ta.append("用户点击了YES按钮\n");
                    break;
                case JOptionPane.NO_OPTION:
                    ta.append("用户点击了NO按钮\n");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    ta.append("用户点击CANCEL按钮");
                    break;
            }
        }
    });


    public void init(){
        // 将多行文本框放入JFrame的CENTER区域，JButton放入JFrame的SOUTH区域
        jf.add(ta);
        jf.add(messageJbtn, BorderLayout.SOUTH);

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ConfirmDialogDemo().init();
    }
}
