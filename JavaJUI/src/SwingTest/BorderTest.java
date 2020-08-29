package SwingTest;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BorderTest {
    JFrame jFrame = new JFrame("测试边框");


    // 组装视图
    public void init(){
        // 1.将JFrame的布局管理器设置为GridLayout
        jFrame.setLayout(new GridLayout(2, 4 ,1,1));

        // 2.在网格中添加JPanel组件，设置边框和内容

        // 前四个使用xxxFatctory方式创建，后三个用new对象的方式创建
        // 创建BevelBorder
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN);
        jFrame.add(getJPanelWithBorder(bevelBorder, "bevelBorder"));

        // 创建LineBorder
        Border lineBorder = BorderFactory.createLineBorder(Color.ORANGE, 5);
        jFrame.add(getJPanelWithBorder(lineBorder,"LineBorder"));

        // 创建EmptyBorder
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        jFrame.add(getJPanelWithBorder(emptyBorder,"emptyBorder"));

        // 创建EtchedBorder
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.BLUE, Color.GRAY);
        jFrame.add(getJPanelWithBorder(etchedBorder, "EtchedBorder"));

        // 创建TitleBorder
        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLUE, 5), "hello,world!",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong", Font.BOLD, 18),Color.red);
        jFrame.add(getJPanelWithBorder(titledBorder, "TitleBorder"));

        // 创建MatteBorder
        MatteBorder matteBorder = new MatteBorder(5, 5, 5, 5, Color.GREEN);
        jFrame.add(getJPanelWithBorder(matteBorder, "MatteBorder"));

        // 创建CompoundBorder
        CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.RED, 5), titledBorder);
        jFrame.add(getJPanelWithBorder(compoundBorder, "CompoundBorder"));


        // 3.显示JFrame
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * 设置组件边框
     * @param border Border对象
     * @param content Border的文字内容
     * @return JPanel
     */
    private JPanel getJPanelWithBorder(Border border, String content){
        JPanel jPanel = new JPanel();
        // 给JPanel设置内容
        jPanel.add(new JLabel(content));
        // 设置边框
        jPanel.setBorder(border);
        return jPanel;
    }

    public static void main(String[] args) {
        new BorderTest().init();
    }


}
