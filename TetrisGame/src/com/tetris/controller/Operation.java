package com.tetris.controller;

import com.tetris.model.GameData;
import com.tetris.view.MainWin;
import com.tetris.view.imgButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 *
 * @author WangDebao
 * @create 2020-08-24 09:21
 */

public class Operation {
    MainWin mainWin;
    GameData gameData;

    private CheckButton left;
    private CheckButton right;
    private CheckButton down ;
    private CheckButton rota ;
    private JButton stst;
    private imgButton sett;
    private imgButton logi ;


    public Operation(){
        /**
         * 编写按钮点击操作
         */
        left =  new CheckButton(new ImageIcon("left.png")){

            @Override
            public void DClick() {
                gameData.move(true, -1);
                mainWin.getBlockCanvas().repaint();
            }
        };
        right = new CheckButton(new ImageIcon("right.png")){

            @Override
            public void DClick() {
                gameData.move(true, 1);
                mainWin.getBlockCanvas().repaint();
            }
        };

        down = new CheckButton(new ImageIcon("down.png")){

            @Override
            public void DClick() {
                boolean isC = gameData.move(false, 1);
                if (isC)
                    mainWin.getScoreShow().repaint();

                mainWin.getBlockCanvas().repaint();
            }
        };
        rota = new CheckButton(new ImageIcon("rotate.png")){

            @Override
            public void DClick() {
                gameData.rota();
                mainWin.getBlockCanvas().repaint();
            }
        };

        stst = new JButton("开始");
        stst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameData.getGameStatus() ==1){
                    gameData.setGameStatus(2);
                }else if(gameData.getGameStatus() ==4){
                    gameData.init();
                    gameData.setGameStatus(1);
                }else{
                    gameData.setGameStatus(1);
                }
                stst.setText(gameData.StatusText[gameData.getGameStatus()]);

            }
        });
        setBtnTrans();

        sett = new imgButton(new ImageIcon("setting.png")){

            @Override
            public void onclick() {

            }
        };
        logi = new imgButton(new ImageIcon("signin.png")){

            @Override
            public void onclick() {

            }
        };

    }

    public imgButton getLeft() {
        return left;
    }

    public void setLeft(CheckButton left) {
        this.left = left;
    }

    public imgButton getRight() {
        return right;
    }

    public void setRight(CheckButton right) {
        this.right = right;
    }

    public imgButton getDown() {
        return down;
    }

    public void setDown(CheckButton down) {
        this.down = down;
    }

    public imgButton getRota() {
        return rota;
    }

    public void setRota(CheckButton rota) {
        this.rota = rota;
    }

    public JButton getStst() {
        return stst;
    }

    public void setStst(JButton stst) {
        this.stst = stst;
    }

    public imgButton getSett() {
        return sett;
    }

    public void setSett(imgButton sett) {
        this.sett = sett;
    }

    public imgButton getLogi() {
        return logi;
    }

    public void setLogi(imgButton logi) {
        this.logi = logi;
    }

    /**
     * controller层与view层关联
     * @param mainWin
     */
    public void setWin(MainWin mainWin){
        this.mainWin = mainWin;
        mainWin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down.onclick();
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    left.onclick();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    right.onclick();
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    rota.onclick();
                }

            }
        });

    }

    /**
     * controller层与model层关联
     * @param gameData
     */
    public void setData(GameData gameData){
        this.gameData = gameData;

    }

    /**
     * 设置按钮
     */
    public void setBtnTrans(){
        // 设置开始按钮的边框
        stst.setBorder((BorderFactory.createLineBorder(Color.BLACK)));
        stst.setFont(new Font("华文新魏", Font.PLAIN, 25));
        stst.setForeground(Color.white);
        stst.setFocusable(false);
//        stst.setContentAreaFilled(false);
    }

    /**
     * 在游戏中时才可以移动方块
     */
    abstract class CheckButton extends imgButton{

        public CheckButton(ImageIcon img) {
            super(img);
        }

        public void onclick(){
            if (gameData.getGameStatus() == 1){
                DClick();
            }
        }
        abstract void DClick();

    }
}

