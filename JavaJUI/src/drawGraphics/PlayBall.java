package drawGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayBall {
    private Frame frame = new Frame("弹球游戏");

    // 球桌的大小
    private final int TABLE_WITH = 300;
    private final int TABLE_HEIGHT = 400;

    // 球拍的大小
    private final int RACKET_WITH = 60;
    private final int RACKET_HEIGHT = 20;

    // 小球的大小(直径)
    private final int BALL_SIZE = 16;

    // 小球的坐标和速度
    private int ball_X = 120;
    private int ball_Y = 10;
    private int ballSpeed_X = 10;
    private int ballSpeed_Y = 10;

    // 球拍的坐标和速度
    private int racket_X = 120;
    private final int racker_Y = 340;
    private int racketSpeed_X = 10;

    // 定义游戏是否结束
    private boolean isOver = false;

    // 声明一个定时器
    private Timer timer;

    // 自定义一个类，继承Canvas，充当画布
    private class MyCanvas extends Component {
        @Override
        public void paint(Graphics g) {
            // TODO 绘制内容
            if (isOver) {
                // 游戏结束，显示游戏结束四个字
                g.setColor(Color.RED);
                g.setFont(new Font("Times", Font.BOLD, 25));
                g.drawString("游戏结束！", 75, 180);

            } else {
                // 游戏中
                // 绘制小球
                g.setColor(Color.RED);
                g.fillOval(ball_X, ball_Y, BALL_SIZE, BALL_SIZE);
                // 绘制球拍
                g.setColor(Color.pink);
                g.fillRect(racket_X, racker_Y, RACKET_WITH, RACKET_HEIGHT);
            }

        }
    }

    // 创建画布
    private MyCanvas drwaArea = new MyCanvas();


    public void init() {
        // 组装视图，游戏逻辑的控制

        // 完成球拍坐标的变化
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                    if (racket_X >= 0) {
                        racket_X -= 10;
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (racket_X <= (TABLE_WITH - RACKET_WITH)) {
                        racket_X += 10;
                    }
                }
                drwaArea.repaint();
            }
        };

        // 给Frame和drawArea注册监听器
        frame.addKeyListener(keyListener);
        drwaArea.addKeyListener(keyListener);

        // 小球坐标的控制
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (ball_X <= 0 || ball_X >= (TABLE_WITH - BALL_SIZE)) {
                    ballSpeed_X = -ballSpeed_X;
                }
                if (ball_Y <= 0 || (ball_Y > (racker_Y - BALL_SIZE) && ball_X >= racket_X && ball_X <= (racket_X + RACKET_WITH))) {
                    ballSpeed_Y = -ballSpeed_Y;
                }

                if (ball_Y > racker_Y - BALL_SIZE && (ball_X < racket_X || ball_X > racket_X + RACKET_WITH)){
                    // 当前小球超出球拍的范围，游戏结束

                    // 停止计时器
                    timer.stop();
                    // 修改游戏是否结束的标记
                    isOver = true;
                    // 重绘界面
                    drwaArea.repaint();
                }

                ball_X += ballSpeed_X;
                ball_Y += ballSpeed_Y;
                drwaArea.repaint();
            }
        };

        timer = new Timer(100, task);
        timer.start();

        drwaArea.setPreferredSize(new Dimension(TABLE_WITH,TABLE_HEIGHT));

        frame.add(drwaArea);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PlayBall().init();
    }
}
