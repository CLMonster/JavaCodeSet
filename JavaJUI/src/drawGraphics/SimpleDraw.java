package drawGraphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleDraw {

    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    private Frame frame = new Frame("这里测试绘图");

    private Button btnRect = new Button("绘制矩形");
    private Button btnOval = new Button("绘制椭圆");

    // 定义一个变量记录当前要绘制椭圆还是矩形
    private String shape = "";

    // 创建一个Canvas类，绘制画布

    private class MyCanvos extends Component {
        @Override
        public void paint(Graphics g) {
            if (shape.equals(RECT_SHAPE)) {
                // 绘制图形
                g.setColor(Color.BLACK);  // 设置画笔的颜色为黑色
                g.drawRect(100, 100, 200, 150);  // 画一个矩形，设置矩形的位置和大小

            }else if(shape.equals(OVAL_SHAPE)){
                g.setColor(Color.RED);  // 设置画笔的颜色为红色
                g.drawOval(100, 100, 200, 150);  // 画一个圆形，设置矩形的位置和大小
            }

        }
    }

    // 创建一个自定义的画布对象
    private MyCanvos drawArea = new MyCanvos();

    public void init(){

        // 组装视图
        btnOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 绘制椭圆
                shape = OVAL_SHAPE;
                // 刷新画布
                drawArea.repaint();
            }
        });

        btnRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 绘制矩形
                shape = RECT_SHAPE;
                // 刷新画布
                drawArea.repaint();
            }
        });

        // 创建Panel 承载Button
        Panel panel = new Panel();
        panel.add(btnOval);
        panel.add(btnRect);


        // drawArea的大小
        drawArea.setPreferredSize(new Dimension(400,400));

        frame.add(panel,BorderLayout.SOUTH);
        frame.add(drawArea);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }

}
