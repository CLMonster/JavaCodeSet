package awtTest;

import java.awt.*;

public class GridBagLayoutDemo {

    public static void main(String[] args) {

        // 1.创建一个frame
        Frame frame = new Frame();

        // 2.创建一个GridBagLayout
        GridBagLayout gbl = new GridBagLayout();

        // 3.将frame的布局管理器改为GridBagLayout
        frame.setLayout(gbl);

        // 4.创建GridBagConstraints对象
        GridBagConstraints gbc = new GridBagConstraints();

        // 5.创建一个容量为10的button数组
        Button[] buttons = new Button[10];

        // 6.初始化button
        for (int i = 0; i < 10; i++) {
            buttons[i] = new Button("按钮" + (i + 1));
        }

        // 7.frame中添加前三个button
        gbc.fill = GridBagConstraints.BOTH;  // 当有空白区域时，设置组件自动扩大
        gbc.weightx = 1;  // 横向扩展比例为1

        addComonent(frame,buttons[0],gbl,gbc);
        addComonent(frame,buttons[1],gbl,gbc);
        addComonent(frame,buttons[2],gbl,gbc);

        // 8.添加第四个button,作为第一行的最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addComonent(frame, buttons[3],gbl,gbc);

        // 9.在第二行添加 button5，独占一行
        gbc.gridwidth = GridBagConstraints.REMAINDER;  // 当前组件是最后一个组件
        gbc.weighty = 1;  // 纵向1
        addComonent(frame, buttons[4],gbl,gbc);

        // 10. 添加button6 横向纵向占两格
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        addComonent(frame,buttons[5],gbl,gbc);

        // 11. 添加button7,横向和纵向都占一个网格
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        addComonent(frame, buttons[6],gbl,gbc);

        // 12. 添加button8，横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;  // 添加横向最后一个组件
        addComonent(frame, buttons[7],gbl,gbc);

        // 13.添加button9，button10，纵向都占1格
        gbc.gridheight = 1;
        addComonent(frame, buttons[8],gbl,gbc);
        addComonent(frame, buttons[9],gbl,gbc);

        // 14.设置frame 最佳大小，可见
        frame.pack();
        frame.setVisible(true);
    }

    private static void addComonent(Container container,Component c,GridBagLayout gridBagLayout,GridBagConstraints gridBagConstraints) {
        gridBagLayout.setConstraints(c,gridBagConstraints);
        container.add(c);
    }
}
