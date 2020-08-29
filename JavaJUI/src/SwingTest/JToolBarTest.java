package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JToolBarTest {
    JFrame jf = new JFrame("测试JToolBar");

    JToolBar jToolBar = new JToolBar();
    JTextArea ta = new JTextArea(8,35);

    // 创建一个AbstractAction类型的对象,AbtractAction是Action的实现类
    // "上一首" 为组件的名字，icon为组件的图标
    Action pre = new AbstractAction("上一首",new ImageIcon("./JavaJUI/images/pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            ta.append("上一首.\n");
        }
    };
    Action pause = new AbstractAction("暂停",new ImageIcon("./JavaJUI/images/pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            ta.append("暂停.\n");
        }
    };
    Action next = new AbstractAction("下一首",new ImageIcon("./JavaJUI/images/next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            ta.append("下一首.\n");
        }
    };


    /**
     * 初始化窗体
     */
    public void init(){
        // 组装工具栏,方法1，这种方式只有图标
//        jToolBar.add(pre);
//        jToolBar.addSeparator();
//        jToolBar.add(pause);
//        jToolBar.addSeparator();
//        jToolBar.add(next);

        // 组装工具栏,方法2
        // 通过Action对象来创建JButton,这时候JButton里带有字符串显示
        JButton preJButton = new JButton(pre);
        JButton pauseJButton = new JButton(pause);
        JButton nextJButton = new JButton(next);
        jToolBar.add(preJButton);
        jToolBar.addSeparator();
        jToolBar.add(pauseJButton);
        jToolBar.addSeparator();
        jToolBar.add(nextJButton);

        // 让工具条可拖动
        jToolBar.setFloatable(true);

        // 文本域默认不支持滚动条
        // 把设置到JScrollPane中，这个组件就有支持滚动条了
        JScrollPane jScrollPane = new JScrollPane(ta);

        // 将JToolBar放入JFrame
        jf.add(jToolBar, BorderLayout.NORTH);
        jf.add(jScrollPane);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JToolBarTest().init();
    }
}
