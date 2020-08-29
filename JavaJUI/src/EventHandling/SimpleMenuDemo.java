package EventHandling;

import java.awt.*;
import java.awt.event.*;

public class SimpleMenuDemo {
    // 组件
    private Frame frame = new Frame("这是一个简单的菜单测试！");
    // 创建MenuBar
    MenuBar menuBar = new MenuBar();
    // 创建菜单组件
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu = new Menu("格式");

    // 创建菜单项
    MenuItem NewLine = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");
    MenuItem comment = new MenuItem("注释 ctrl shift Q",new MenuShortcut(KeyEvent.VK_Q,true));
    MenuItem cancelComment = new MenuItem("取消注释");
    TextArea textArea = new TextArea(6,40);



    public void init(){
        // 组装视图，从局部到整体
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = comment.getActionCommand();
                textArea.append(actionCommand);
            }
        });

        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        // 组装编辑菜单
        editMenu.add(NewLine);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(new MenuItem("-"));
        editMenu.add(formatMenu);

        // 组装菜单条
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // 将菜单条添加到frame中
        frame.setMenuBar(menuBar);
        frame.add(textArea);

        frame.pack();
        frame.setVisible(true);

        // 关闭窗口
        shutdown();

    }

    private void shutdown(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new SimpleMenuDemo().init();
    }
}
