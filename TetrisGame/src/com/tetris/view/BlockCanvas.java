package com.tetris.view;

import com.tetris.model.GameData;

import javax.swing.*;
import java.awt.*;

/**
 * 该类用于显示Tetris，这个区域也是游戏的主区域
 */
public class BlockCanvas extends JPanel {
    /**
     * view层的数据
     */
    GameData gameData;

    /**
     * 用传入View层的数据绘制方块
     *
     * @param gameData 方块的数据信息
     */
    public BlockCanvas(GameData gameData) {
        this.gameData = gameData;
        // 设置画布透明
        setOpaque(false);
        // 设置大小
        setBounds(MainWin.GAME_ROOTX, MainWin.GAME_ROOTY, 200, 360);


    }

    /**
     * 绘制俄罗斯方块，
     *
     * @param g 画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.setColor(GameData.COLORS[gameData.getCurrent()]);
        for (Point blocks : gameData.getBlocks().getPoints()) {
            g.fillRect((gameData.getX() + blocks.x) * 20, (gameData.getY() + blocks.y) * 20, 20, 20);
            g.drawImage(new ImageIcon("mask0.png").getImage(), (gameData.getX() + blocks.x) * 20, (gameData.getY() + blocks.y) * 20, 20, 20,
            null);
        }
        //绘制已经停止的方块
        for (int i = 19; i >= 2; i--) {
            for (int j = 0; j < 10; j++) {
                if (gameData.existedBlocks[j][i] != 0) {
                    g.setColor(GameData.COLORS[gameData.existedBlocks[j][i] - 1]);
                    g.fillRect(j * 20, (i) * 20, 20, 20);
                    g.drawImage(new ImageIcon("mask0.png").getImage(), j * 20, (i) * 20, 20, 20, null);
                }
            }

        }
    }

}
