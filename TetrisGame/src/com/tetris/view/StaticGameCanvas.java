package com.tetris.view;

/**
 * 程序窗口静态显示
 */

import com.tetris.controller.Operation;

import javax.swing.*;
import java.awt.*;

public class StaticGameCanvas extends JPanel {


    imgButton left;
    imgButton right;
    imgButton down;
    imgButton rota;
    JButton   stst;
    imgButton sett;
    imgButton logi;


    StaticGameCanvas(Operation operation){
        setOpaque(false);  // 设置画布透明
        setBounds(0, 0, MainWin.WIN_WIDTH, MainWin.WIN_HEIGHR);  // 设置画布的大小
        setLayout(null); // 画布自由布局

        // 初始化按钮
        left =  operation.getLeft();
        right = operation.getRight();
        down =  operation.getDown();
        rota =  operation.getRota();
        stst =  operation.getStst();
        sett =  operation.getSett();
        logi =  operation.getLogi();

        left.setBounds(233,255,45,45);
        right.setBounds(278,255,45,45);
        down.setBounds(233,300,45,45);
        rota.setBounds(278,300,45,45);
        stst.setBounds(233,356,90,50);
        sett.setBounds(260,418,48,48);
        logi.setBounds(260,488,48,48);
        // 添加按钮
        add(left);
        add(right);
        add(down);
        add(rota);
        add(stst);
        add(sett);
        add(logi);

    }


    /**
     * 当绘制GameCanvas组件时，就会自动调用该函数
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        // 调用
        super.paintComponent(g);
        // 设置方块区背景颜色透明
        g.setColor(new Color(0,0,0,20));
//        g.setColor(new Color(150, 150, 150, 70));
        // 游戏主屏区
        g.fillRect(MainWin.GAME_ROOTX, MainWin.GAME_ROOTY, 200, 360);
        // 排名区
        g.fillRect(15, 405, 200, 130);
        // 右边排版阴影
        g.fillRect(232, 30, 90, 373);
        g.setColor(new Color(2, 2, 2, 20));
        // 得分区
        g.fillRect(233, 30, 90, 70);
        // 提示区
        g.fillRect(233, 105, 90, 140);
        // 移动区(鼠标玩法)
        g.fillRect(233, 255, 90, 90);

        // 给游戏主屏区绘制边框
        g.setColor(Color.WHITE);
        ((Graphics2D) g).setStroke(new BasicStroke(3L));  // 将边框变宽
        g.drawRect(13, 28, 203, 363);
        g.drawRect(13, 403, 203, 133);

        // 文字
        g.setColor(new Color(2, 2, 2, 100));
        g.setFont(new Font("黑体", Font.PLAIN, 20));
        g.drawString("得分", 240, 55);
        g.drawString("下一个", 236, 140);
        g.drawString("荣誉榜", 25, 435);

    }
}
