package EventHandling;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopMenuDemo {

    // 用到的组件
    private Frame frame = new Frame("测试PopMenu");
    private TextArea ta = new TextArea("我是中华儿女！",6,36);
    private PopupMenu popupMenu = new PopupMenu();
    private Menu comment = new Menu("注释");
    private Menu cancelComment = new Menu("取消注释");
    private Menu copy = new Menu("复制");
    private Menu save = new Menu("保存");

    private Panel panel = new Panel();

    public void init(){

        // 创建监听器
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("您点击了：" + e.getActionCommand() + "\n");
            }
        };

        // 注册监听器
        comment.addActionListener(actionListener);
        cancelComment.addActionListener(actionListener);
        copy.addActionListener(actionListener);
        save.addActionListener(actionListener);

        // 将Menu添加到PopMenu
        popupMenu.add(comment);
        popupMenu.add(cancelComment);
        popupMenu.add(copy);
        popupMenu.add(save);

        // 设置panel的大小
        panel.setPreferredSize(new Dimension(300,150));

        // 当鼠标在panel上右击的时候，打开PopupMenu
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                System.out.println(popupTrigger);
                if (e.isPopupTrigger()){
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                System.out.println(popupTrigger);
                if (popupTrigger){
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }
        });


        // 将PopMenu添加到panel中
        panel.add(popupMenu);
        frame.add(popupMenu);
        // 将AreaText和Panel添加到frame中
        frame.add(ta,BorderLayout.NORTH);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new PopMenuDemo().init();
    }
}
