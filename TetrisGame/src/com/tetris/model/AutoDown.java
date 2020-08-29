package com.tetris.model;

import com.tetris.view.MainWin;

/**
 *
 * 创建一个线程，不断的运行，将方块的y不断减1，并重新绘制，达到方块自由下落的效果
 * @author WangDebao
 * @create 2020-08-24 16:20
 */
public class AutoDown extends Thread{
    private GameData gameData;
    private MainWin  mainWin;

    public AutoDown(GameData gameData, MainWin mainWin){
        this.gameData = gameData;
        this.mainWin = mainWin;
    }

    @Override
    public void run() {
        while (true){
            try {

            if (gameData.getGameStatus() == 1){
                boolean isC = gameData.move(false, 1);
                if (isC){
                    mainWin.getScoreShow().repaint();  // 重绘分数和提示区
                }
                    sleep(500);
                    mainWin.getBlockCanvas().repaint(); // 重绘游戏方块区
                    mainWin.getGameCanvas().repaint();
            }else if (gameData.getGameStatus() ==3 ){
//                    gameData.init();
                System.out.println("游戏结束");
                mainWin.getOperation().getStst().setText(gameData.StatusText[gameData.getGameStatus()]);
                gameData.setGameStatus(4);

            }else{
                // 让cpu高效一点
                sleep(150);
            }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
