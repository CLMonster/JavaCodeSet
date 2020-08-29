package SwingTest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class JFileChooserDemo {
    JFrame jf = new JFrame("测试JFileChooser");

    JMenuBar jMenuBar = new JMenuBar();
    JMenu fileJMenu = new JMenu("文件");

    // 在创建菜单项的同时，添加一个Action对象(Action是ActionListener的一个子接口，是一个事件监听器)，目的：自动注册监听，处理点击后的行为
    JMenuItem openItem = new JMenuItem(new AbstractAction("打开") { //name作为该组件的名字
        @Override
        public void actionPerformed(ActionEvent e) {
            // 弹出保存文件对话框
            JFileChooser jFileChooser = new JFileChooser(".");
            jFileChooser.showOpenDialog(jf);
            File selectedFile = jFileChooser.getSelectedFile();
            try {
                image = ImageIO.read(selectedFile);
                myCanvas.repaint();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    });


    JMenuItem saveOtherItem = new JMenuItem(new AbstractAction("另存为") { //name作为该组件的名字
        @Override
        public void actionPerformed(ActionEvent e) {
            // 显示文件选择器
            JFileChooser jFileChooser = new JFileChooser(".");
            jFileChooser.showSaveDialog(jf);

            // 获取选择的文件
            File selectedFile = jFileChooser.getSelectedFile();
            try {
                ImageIO.write(image, "JPEG", selectedFile);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    });

    BufferedImage image;

    // Swing提供的组件都是用了图像缓冲技术
    private class MyCanvas extends JPanel{
        @Override
        public void paint(Graphics g) {

            g.drawImage(image, 0, 0, null);
        }
    }

    MyCanvas myCanvas = new MyCanvas();

    /**
     * 组装视图
     */
    public void init(){

        // 组装菜单栏
        fileJMenu.add(openItem);
        fileJMenu.add(saveOtherItem);
        jMenuBar.add(fileJMenu);
        jf.setJMenuBar(jMenuBar);

        // 将画布添加到JFrame中
        JScrollPane jScrollPane = new JScrollPane(myCanvas);
        jf.add(myCanvas);


        // 主窗口显示与关闭
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFileChooserDemo().init();
    }
}
