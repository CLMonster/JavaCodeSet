package com.tetris.view;

import com.tetris.controller.Operation;
import com.tetris.model.AutoDown;
import com.tetris.model.GameData;

import javax.swing.*;
import java.awt.*;


/**
 * 绘制游戏的主界面
 */

public class MainWin extends JFrame {

    ScoreShow scoreShow;



    // 记录游戏窗口数据信息
    static final int WIN_WIDTH = 360; // 整个程序窗口宽度
    static final int WIN_HEIGHR = 570; // 整个程序窗口高度
    static final int GAME_ROOTX = 15; // Tetris主窗口的横坐标
    static final int GAME_ROOTY = 30; // Tetris主窗口的纵坐标
    static final int opacity = 100;   // 格子透明度
    static final int WEIYI = 40;      // 由于数组尺寸冗余，做出的绘图区位移

    // 定义游戏的画布(背景绘制)，使用LayeredPane来分层显示背景和其他的组件
    Container mainPane;
    /**
     *定义Tetris的区域
     */
    BlockCanvas blockCanvas;

    // 定义：与View层和controller进行关联
    private Operation operation;
    private GameData gameData;

    // Tetris自动下落
    private AutoDown autoDown;

    /**
     * 游戏区的静态背景
     */
    private StaticGameCanvas gameCanvas;

    /**
     * 对游戏窗口进行初始化
     * @param operation
     * @param gameData
     */
    public MainWin(Operation operation, GameData gameData){
        this.operation = operation;
        this.gameData = gameData;

        mainPane = getLayeredPane();
        // 设置窗口
        setWinSize();
        // 设置背景
        setBg();
        // 绘制整个游戏的静态背景
        gameCanvas = new StaticGameCanvas(operation);
        mainPane.add(gameCanvas);  //将静态背景区域放到最底层，被其他组件覆盖显示
        // 添加俄罗斯方块游戏区域
        setblockCanvas();
        // 显示分数
        setScoreShow();
        // 获得焦点
        setFocusable(true);

        // 重新绘制窗口，理解不了的bug，不然会被覆盖
//        this.repaint();
    }



    /**
     * 提供空参的构造器
     */
    public MainWin() {
    }

    public ScoreShow getScoreShow() {
        return scoreShow;
    }

    public Operation getOperation() {
        return operation;
    }

    public StaticGameCanvas getGameCanvas() {
        return gameCanvas;
    }

    /**
     * 将Tetris区域添加到游戏中
     */
    private void setblockCanvas() {
        blockCanvas = new BlockCanvas(gameData);
        mainPane.add(blockCanvas);
    }

    /**
     * 设置窗口的背景
     */
    private void setBg(){
        ImageIcon imgic = new ImageIcon("background.jpg");
        JLabel jl = new JLabel(imgic);
        jl.setBounds(0,0,WIN_WIDTH,WIN_HEIGHR);

        // JLayeredPane 为 JFC/Swing 容器添加了深度，允许组件在需要时互相重叠。
        // Integer 对象指定容器中每个组件的深度，其中编号较高的组件位于其他组件上
        getContentPane().add(jl);  // 添加背景图片
    }

    /**
     * 设置窗口的可见
     */
    private void setWinSize(){
        this.setBounds(200, 200, WIN_WIDTH, WIN_HEIGHR);  //设置窗口的位置和大小
        this.setResizable(false);  // 窗口不可以被拖动
        this.setVisible(true);  // 设置窗口可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置关闭按钮有效
    }

    /**
     * 获取游戏区
     */
    public BlockCanvas getBlockCanvas(){
        return blockCanvas;
    }

    /**
     * 设置图层顺序
     */
    public void setLayerOrd(){
        mainPane.setComponentZOrder(gameCanvas,1);
        mainPane.setComponentZOrder(blockCanvas,0);
        mainPane.setComponentZOrder(scoreShow,0);
    }

    /**
     * 设置分数提示
     */
    private void setScoreShow() {
        scoreShow = new ScoreShow(gameData);
        mainPane.add(scoreShow);
    }


}
