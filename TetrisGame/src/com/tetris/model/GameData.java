package com.tetris.model;

import java.awt.*;
import java.util.Random;

/**
 * 存放游戏的数据
 *
 * @author WangDebao
 * @create 2020-08-24 09:26
 */
public class GameData {

    public final String[] StatusText = {"开始","暂停","继续","重来"};
    /**
     * 记录游戏状态
     * 0 表示 准备游戏
     * 1 表示 游戏中
     * 2 表示 游戏暂停
     * 3 表示 游戏继续
     */
    private int GameStatus;


    /**
     * 表示游戏分数
     */
    private int score = 0;


    /**
     * 方块的偏移量
     */
    private int x;
    private int y;

    /**
     * 定义一个数组存放格子
     */
    public int[][] existedBlocks;

    /**
     * 存放删除格数的数组
     */
    public int[] deleteNum;

    /**
     * 代表一个俄罗斯方块，该对象里面有一个Point数组储存了方块的位置信息
     */
    Blocks blocks;

    /**
     * 方块随机出现，定义随机数
     */
    Random random;

    /**
     * 每个方块的形状，选定每个方块的中心，将中心坐标设置为0，其他的方块以中心块为参考
     */
    public final static Blocks[] BLOCKS = new Blocks[]{
            new Blocks(new int[]{-1, 0, 1, 1}, new int[]{0, 0, 0, 1}),
            new Blocks(new int[]{-1, 0, 1, 2}, new int[]{0, 0, 0, 0}),
            new Blocks(new int[]{-1, -1, 0, 1}, new int[]{0, 1, 0, 0}),
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 1}),
            new Blocks(new int[]{0, 0, 1, 1}, new int[]{0, 1, 0, 1}),
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{1, 0, 1, 0}),
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 0}),

    };

    /**
     * 设置方块颜色的透明度
     */
    private static int transparency = 120;

    /**
     * 每个方块的颜色
     */
    public final static Color[] COLORS = new Color[]{
            new Color(255, 0, 0, transparency),
            new Color(0, 255, 0, transparency),
            new Color(0, 0, 255, transparency),
            new Color(255, 255, 0, transparency),
            new Color(255, 0, 255, transparency),
            new Color(0, 255, 255, transparency),
            new Color(178, 255, 170, transparency)
    };

    /**
     * 当前方块
     */
    private int current = 0;
    /**
     * 下一个方块
     */
    private int next;

    public GameData() {
        init();

    }

    public void init(){
        existedBlocks = new int[10][20];
        random = new Random();
        next = random.nextInt(7);
        initBlocks();
    }

    public int getScore() {
        return score;
    }

    public int getNext() {
        return next;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Blocks getBlocks() {
        return blocks;
    }

    public void setBlocks(Blocks blocks) {
        this.blocks = blocks;
    }

    public int getGameStatus() {
        return GameStatus;
    }

    public void setGameStatus(int gameStatus) {
        GameStatus = gameStatus;
    }

    public int getCurrent() {
        return current;
    }

    /**
     * 实现鼠标点击按钮移动方块，并对方块是否越界做了判断，使得方块在游戏区中正常显示
     *
     * @param isHor 移动的方向，true为horizontal false为Vertical
     * @param step  移动的步长
     * @return false表示方块可以继续移动，true表示当前方块停止移动，新方块产生
     */
    public boolean move(boolean isHor, int step) {
//        boolean flag = false;
        if (isHor) {
            for (Point point : blocks.getPoints()) {
                if (point.x + x + step < 0 || point.x + this.x + step > 9 || existedBlocks[point.x + this.x + step][point.y + this.y] != 0) {
                    return false;
                }
            }
            this.x += step;
        } else {
            for (Point point : blocks.getPoints()) {
                // 这里+2的原因：因为数组是int[10][20],而游戏区的高是0-18，所以要让这个数组和游戏区大小匹配，加上2之后数组的坐标从2-20开始
                if (point.y + y + step > 17 || existedBlocks[point.x + x][point.y + y + step] != 0) {
                    saveBlocks();
                    if (isDelete()) {
                        deleteLine();
                        checkScore();  // 检查分数是否要增加
                    }
                    if (isDie()) {
                        //TODO 消除行
//                        Time.sleep();
                        setGameStatus(3);
                    }
                    initBlocks();  // 初始化方块
                    return true;
                }
            }
            this.y += step;
        }
        return false;
    }

    /**
     * 初始化方块的位置信息
     */
    private void initBlocks() {
        x = 4;
        y = 0;
        current = next;  // 当前绘制的方块
        blocks = new Blocks(BLOCKS[current]);
        next = random.nextInt(7); //下一个绘制的方块
        deleteNum = new int[20];
    }

    /**
     * 功能：控制方块旋转
     * 每次旋转：逆时针90度
     */
    public void rota() {
        /**
         * 判断旋转后，方块是否会超出游戏区
         */
        for (Point point : blocks.getPoints()) {
            int _x = -point.y + x;
            int _y = point.x + y;
            // 判断旋转后是否越界
            if (_x < 0 || _x > 9) {
                return;
            }
            if (_y > 17) {
                return;
            }
            if(current == 4){
                return;
            }
        }
        /**
         * 前面判断了异常情况，现在来判断正常情况，方块逆时针旋转需满足一下公式：x = -y ; y = x
         * 遍历每个块的坐标
         */
        for (Point point : blocks.getPoints()) {
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }

    /**
     * 保存方块组
     * 当方块停止(在最底层或者紧贴着其他方块时)运动时，调用该方法，将停止的方块的坐标信息记录在existedBlocks数组中
     */
    public void saveBlocks() {
        for (Point point : getBlocks().getPoints()) {
            existedBlocks[point.x + getX()][point.y + getY()] = 1 + current;
        }
    }

    /**
     * 作用：判断该行是否要删除
     */
    public boolean isDelete() {

        boolean isDelete = false;

        for (int i = 19; i >= 2; i--) {
            boolean havaEmpty = false;
            for (int j = 0; j < 10; j++) {
                if (existedBlocks[j][i] == 0) {  // 遍历每一行，看是否有空格
                    havaEmpty = true;
                    break;
                }
            }
            if (!havaEmpty) {  //如果没有空格,就说明可以删除
                isDelete = true;
                deleteNum[i - 1] = deleteNum[i] + 1;
            } else {// deleteNum[6] = deleteNum[7]+1   1
                deleteNum[i - 1] = deleteNum[i];
            }
        }
        return isDelete;
    }

    /**
     * 功能：消除行
     * 消除行的原理：deleteNum[i]决定消除哪行，"删除行上一行"的y值覆盖"当前删除行"的y值
     * <p>
     * 例如：如果第16行要消除，那么deleteNum[15]的值就为1，在执行以下语句时
     * existedBlocks[j][15+deleteNum[15]] = existedBlocks[j][15];
     * 效果：第16的行的数组值被第15行数组值覆盖了。那么原来的行就被消除了
     */
    public void deleteLine() {
        for (int i = 19; i >= 2; i--) {
            for (int j = 0; j < 10; j++) {
                existedBlocks[j][i + deleteNum[i]] = existedBlocks[j][i];  // 执行覆盖
            }
        }

    }

    /**
     * 判断游戏是否结束
     *
     * @return
     */
    private boolean isDie() {
        for (int i = 0; i < 10; i++) {
            if (existedBlocks[i][2] != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 统计分数
     */
    public void checkScore(){
        score = score+deleteNum[3]*10;
    }
}
