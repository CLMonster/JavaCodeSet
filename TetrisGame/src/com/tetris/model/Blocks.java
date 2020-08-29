package com.tetris.model;

import java.awt.*;

/**
 * 表示Tetris方块，记录方块的位置信息，使用Point类记录方块的位置，每一个方块的位置都是以最左上方的那个点的坐标来确定的。
 * @author WangDebao
 * @create 2020-08-24 10:55
 */
public class Blocks {
    private Point[] points;

    public Blocks(int[] x,int[] y){
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(x[i],y[i]);
        }

    }

    public Blocks(Blocks blocks){
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(blocks.points[i].x,blocks.points[i].y);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
