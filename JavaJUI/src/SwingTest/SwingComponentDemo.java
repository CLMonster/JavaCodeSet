package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingComponentDemo {

    // 创建窗口组件
    JFrame jFrame = new JFrame("测试Swing基本组件");

    // 菜单组件
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");
//    "/Users/wangdebao/mycode/myjavacode/JavaJUI/src/SwingTest/SwingComponentDemo.java"

    JMenuItem autoNewLineMenu = new JMenuItem("自动换行");
    JMenuItem copyMenu = new JMenuItem("复制", new ImageIcon("/Users/wangdebao/mycode/myjavacode/JavaJUI/images/copy.png"));
    JMenuItem pasteMenu = new JMenuItem("粘贴", new ImageIcon("JavaJUI/images/paste.png"));  // idea中的相对路径是相对于workPlace而言

    JMenu formatMenu = new JMenu("格式");
    JMenuItem comment = new JMenuItem("注释");
    JMenuItem cancelComment = new JMenuItem("取消注释");

    // 创建文本域
    JTextArea ta = new JTextArea(8, 20);

    // 列表框
    String[] colors = {"red", "green", "blue"};  // 列表项
    JList colorList = new JList(colors);

    // 声明选择相关组件
    JComboBox colorSelect = new JComboBox();
    ButtonGroup bg = new ButtonGroup();
    JRadioButton male = new JRadioButton("女");
    JRadioButton female = new JRadioButton("男");
    JCheckBox isMarried = new JCheckBox("是否已婚");

    // 创建单行文本框和底部的按钮
    JTextField tf = new JTextField(35);
    JButton okBtn = new JButton("确定", new ImageIcon("/Users/wangdebao/mycode/myjavacode/JavaJUI/images/ok.png"));

    // 右键菜单
    JPopupMenu styleJPopupMenu = new JPopupMenu();
    ButtonGroup PopButtonGroup = new ButtonGroup();
    JRadioButtonMenuItem metal = new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem nimbus = new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("windows 风格");
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("windows 经典风格");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");


    public SwingComponentDemo() {
        init();
    }


    // 初始化界面
    private void init() {

        // 组装视图
        // 组装底部
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(tf);
        bottomPanel.add(okBtn);
        jFrame.add(bottomPanel, BorderLayout.SOUTH);


        // 组装选择相关的组件
        JPanel selectedPanel = new JPanel();
        colorSelect.addItem("red");
        colorSelect.addItem("green");
        colorSelect.addItem("blue");
        selectedPanel.add(colorSelect);
        bg.add(male);
        bg.add(female);
        selectedPanel.add(male);
        selectedPanel.add(female);
        selectedPanel.add(isMarried);

        // 组装文本域和选择相关
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(selectedPanel);

        // 组装顶部
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        jFrame.add(top);

        // 组装顶部菜单
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        editMenu.add(autoNewLineMenu);
        editMenu.addSeparator();
        editMenu.add(copyMenu);
        editMenu.add(pasteMenu);
        editMenu.addSeparator();
        editMenu.add(formatMenu);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        jFrame.setJMenuBar(menuBar);


        // 组装右键菜单
        PopButtonGroup.add(metal);
        PopButtonGroup.add(nimbus);
        PopButtonGroup.add(windowsItem);
        PopButtonGroup.add(windowsClassicItem);
        PopButtonGroup.add(motifItem);

        // 创建右键菜单点击的监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                    unsupportedLookAndFeelException.printStackTrace();
                } catch (InstantiationException instantiationException) {
                    instantiationException.printStackTrace();
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }

            }
        };

        // 组册监听
        metal.addActionListener(listener);
        nimbus.addActionListener(listener);
        windowsItem.addActionListener(listener);
        windowsClassicItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        // 将这5个菜单项加入PopupMenu中
        styleJPopupMenu.add(metal);
        styleJPopupMenu.add(nimbus);
        styleJPopupMenu.add(windowsItem);
        styleJPopupMenu.add(windowsClassicItem);
        styleJPopupMenu.add(motifItem);

        // 和awt相比不需要在建立事件监听器，awt的做法：将PopupMenu添加到TextArea中，然后注册监听TextArea的鼠标事件
        // 在Swing中一行代码搞定
        ta.setComponentPopupMenu(styleJPopupMenu);

        // 关闭窗口,在awt中，需要对frame注册监听WindowListener 用closing方法
        // 在swing中一行代码搞定
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 窗口展示
        jFrame.pack();
        jFrame.setVisible(true);


    }

    // 改变组件的外观
    private void changeFlavor(String cmd) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        switch (cmd) {
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;

            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        // 刷新组件
        SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());
        SwingUtilities.updateComponentTreeUI(menuBar);
        SwingUtilities.updateComponentTreeUI(styleJPopupMenu);
    }

    public static void main(String[] args) {

        // 启动程序
        new SwingComponentDemo();
    }
}
