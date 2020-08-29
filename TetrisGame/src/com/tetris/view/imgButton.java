package com.tetris.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 设置按钮效果，游戏的页面上有一些按钮(控制方块移动的、开始按钮)
 */
public abstract class imgButton extends JButton {


    public imgButton(ImageIcon img){
        // 设置按钮背景透明
//        setContentAreaFilled(false); //对于mac来说，有没有效果一样
        // 设置按钮图标
        setIcon(img);
        // 设置无边框
        setBorder(null);

        // 添加按钮监听器
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onclick();
            }
        });

        // 取消截获按钮
        setFocusable(false);
    }

    public abstract void onclick();
}
