package com.tetris.controller;

import com.tetris.model.AutoDown;
import com.tetris.model.GameData;
import com.tetris.view.MainWin;

/**
 * 控制View层和数据层
 *
 * @author WangDebao
 * @create 2020-08-24 09:50
 */
public class Main {

    public static void main(String[] args) {
        // 实例化操作和数据
        Operation operation = new Operation();
        GameData gameData = new GameData();
        // 将数据、操作与窗口关联
        MainWin mainWin = new MainWin(operation, gameData);
        // 将窗口与操作区关联
        operation.setWin(mainWin);
        // 将数据区与操作层关联
        operation.setData(gameData);

        // 方块自动下落
        AutoDown autoDown = new AutoDown(gameData, mainWin);
        autoDown.start();

//        MainWin mainWin = new MainWin();

    }

}
