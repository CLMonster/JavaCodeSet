package drawGraphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class HandDraw {

    private Frame frame = new Frame("简单手绘程序");

    // 画布的大小
    private final int AREA_WITH = 400;
    private final int AREA_HEIGHT = 500;

    // 定义一个右键菜单，用于设置画笔的颜色
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem blueItem = new MenuItem("蓝色");

    // 定义一个变量保存当前画笔的颜色
    private Color forceColor = Color.BLACK;

    // 创建一个BufferedImage位图对象
    BufferedImage image = new BufferedImage(AREA_WITH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    // 通过位图获取关联的Graphics对象，获得画笔
    Graphics g = image.getGraphics();

    // 自定义一个类继承Canvas,画布
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    private MyCanvas drawArea = new MyCanvas();

    // 记录鼠标拖动过程中上一次所处的坐标
    private int pre_X = -1;
    private int pre_Y = -1;


    public void init() {
        // 组装视图，逻辑控制

        // 给三个按钮项注册监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand) {
                    case "红色":
                        forceColor = Color.RED;
                        break;
                    case "绿色":
                        forceColor = Color.GREEN;
                        break;
                    case "蓝色":
                        forceColor = Color.BLUE;
                        break;
                }
            }
        };
        redItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        blueItem.addActionListener(listener);

        // 将每一个项添加到PopupMenu中，再将PopMenu放到画布里
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        drawArea.add(colorMenu);

        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean isFalg = e.isPopupTrigger();
//                System.out.println(isFalg);
                if (isFalg){
                    colorMenu.show(drawArea, e.getX(), e.getY());
                }

                // 重置pre_X,pre_Y
                pre_X = -1;
                pre_Y = -1;
            }
        });

        // 设置画布的颜色，用画笔画一个白色的矩形充满画布
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, AREA_WITH, AREA_HEIGHT);

        // 通过监听鼠标移动，完成线条的绘制
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            // 该方法当鼠标按下并进行拖动时，会被调用
            @Override
            public void mouseDragged(MouseEvent e) {
                if(pre_X > 0 && pre_Y > 0){
                    g.setColor(forceColor);
                    g.drawLine(pre_X, pre_Y, e.getX(), e.getY());
                }

                // 修正pre_X和pre_Y的值
                pre_X = e.getX();
                pre_Y = e.getY();

                drawArea.repaint();

            }
        });
        drawArea.setPreferredSize(new Dimension(AREA_WITH,AREA_HEIGHT));

        frame.add(drawArea);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new HandDraw().init();
    }

}
