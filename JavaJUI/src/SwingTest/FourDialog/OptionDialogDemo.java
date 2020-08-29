package SwingTest.FourDialog;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OptionDialogDemo {
    JFrame jf = new JFrame("测试OptionDialog");
    JTextArea ta = new JTextArea("",6,35);
    JButton jButton = new JButton(new AbstractAction("弹出选项对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int s = JOptionPane.showOptionDialog(jf, "选择衣服的大小", "选项对话框",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,
                    null, new String[]{"S","M","L"},"M");

            switch (s){
                case 0:
                    ta.setText("选择了S号\n");
                    break;
                case 1:
                    ta.setText("选择了M号\n");
                    break;
                case 2:
                    ta.setText("选择了L号\n");
                    break;
            }

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
        new OptionDialogDemo().init();
    }
}
