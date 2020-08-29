package SwingTest.FourDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MessageDialogDemo {
    JFrame jf = new JFrame("测试MessageDialog");
    JTextArea ta = new JTextArea("我爱中国！",6,35);


    JButton jButton = new JButton(new AbstractAction("弹出消息对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 弹出消息对话框，显示文本域中输入的内容
            // intmessageType 指定消息对话框的类型，：错误消息，提示对话框，
            JOptionPane.showMessageDialog(jf, ta.getText(),"消息对话框", JOptionPane.ERROR_MESSAGE, new ImageIcon("./JavaJUI/images/ok.png"));  // getText()函数返回TextArea中的文本
        }
    });



    /**
     * @Description:
     * 组装视图
     * 返回值：无
     */
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
        new MessageDialogDemo().init();
    }
}
