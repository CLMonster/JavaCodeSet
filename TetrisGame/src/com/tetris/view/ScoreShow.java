package com.tetris.view;

import com.tetris.model.GameData;

import javax.swing.*;
import java.awt.*;

/**
 *
 * 创建一个展示分数的区域
 * @author WangDebao
 * @create 2020-08-26 11:16
 */
public class ScoreShow extends JPanel {

    GameData gameData;

    public ScoreShow(){

    }


    public ScoreShow(GameData gameData){
        this.gameData = gameData;
        // 设置画布透明
        setOpaque(false);
        //设置大小
        setBounds(233, 30, 90, 215);
    }
    @Override
    protected void paintComponent(Graphics g) {
        // 绘制分数
        g.setColor(Color.BLACK);
        g.setFont(new Font("黑体", Font.BOLD, 20));
        g.drawString("" + gameData.getScore(), 30, 55);

        // 绘制下一个方块提示
        g.setColor(GameData.COLORS[gameData.getNext()]);
        for (Point blocks : GameData.BLOCKS[gameData.getNext()].getPoints()) {
            g.fillRect(blocks.x * 20+27,blocks.y * 20+150, 20, 20);
            g.drawImage(new ImageIcon("mask0.png").getImage(), blocks.x * 20+27,blocks.y * 20+150, 20, 20,
                    null);
        }
    }
}
