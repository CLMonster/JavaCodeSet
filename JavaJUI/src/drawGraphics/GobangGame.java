package drawGraphics;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GobangGame {
    Frame frame = new Frame("五子棋游戏");

    // 声明4个bufferedImage对象,加载棋盘图片
    BufferedImage board;
    BufferedImage black;
    BufferedImage white;
    BufferedImage select;

    // 棋盘的宽和高
    private final int BOARD_WHITH = 500;
    private final int BOARD_HEIGHT = 500;

    // 声明棋盘的横向和纵向容纳多少棋子取决于棋盘，分别是15
    private final int BOARD_SIZE = 15;

    // 每个棋子占用棋盘的比率
    final int RATE = BOARD_WHITH / BOARD_SIZE;

    //记录棋子对于X和Y轴的偏移量
    final int OFFSET_X = 5;
    final int OFFSET_Y = 5;

    // 声明一个二维数组记录棋子，0为空，1为白棋，2为黑棋
    int[][] chessNum = new int[BOARD_SIZE][BOARD_SIZE];

    // 声明红色选择框的坐标
    int selected_X = -1;
    int selected_Y = -1;

    // 记录下棋的颜色
    int chessType = 2;

    // 创建画布
    private class ChessBoard extends Canvas {
        @Override
        public void paint(Graphics g) {

            // 绘制棋盘
            g.drawImage(board, 0, 0, null);
            // 绘制选择框
            if (selected_X > 0 && selected_Y >0) {
                g.drawImage(select, selected_X + OFFSET_X, selected_Y + OFFSET_Y, null);
            }
            // 绘制棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    // 绘制黑棋
                    if (chessNum[i][j] == 2){
                        g.drawImage(black, j*RATE+OFFSET_X, i*RATE+OFFSET_Y, null);
                    }
                    // 绘制白棋
                    if (chessNum[i][j] == 1){
                        g.drawImage(white, j*RATE+OFFSET_X, i*RATE+OFFSET_Y, null);
                    }

                }
            }
        }
    }

    ChessBoard chessBoard = new ChessBoard();

    // 一个Panel，三个Button
    Panel panel = new Panel();
    Button whiteBtn = new Button("白棋");
    Button blackBtn = new Button("黑棋");
    Button deleteBtn = new Button("删除");


    public void init() {

        // 组装视图，编写逻辑

        whiteBtn.addActionListener(e -> {
            chessType = 1;
            refreshColor(Color.WHITE, Color.GRAY, Color.GRAY);

        });

        blackBtn.addActionListener(e -> {
            chessType = 2;
            refreshColor(Color.GRAY, Color.WHITE, Color.GRAY);

        });

        deleteBtn.addActionListener(e -> {
            chessType = 0;
            refreshColor(Color.GRAY, Color.GRAY, Color.WHITE);

        });

        chessBoard.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });


        // 组装Button和panel
        panel.add(whiteBtn);
        panel.add(blackBtn);
        panel.add(deleteBtn);
        frame.add(panel,BorderLayout.SOUTH);

        chessBoard.setPreferredSize(new Dimension(BOARD_WHITH,BOARD_HEIGHT));
        frame.add(chessBoard);
        frame.pack();
        frame.setVisible(true);



    }


    private void refreshColor(Color whiteBtn, Color blackBtn, Color deleteBtn){
        this.whiteBtn.setBackground(whiteBtn);
        this.blackBtn.setBackground(blackBtn);
        this.deleteBtn.setBackground(deleteBtn);
    }

    public static void main(String[] args) {
        new GobangGame().init();
    }
}
