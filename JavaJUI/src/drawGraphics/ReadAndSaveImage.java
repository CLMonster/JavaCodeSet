package drawGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndSaveImage {

    Frame frame = new Frame("图片查看器");
    MenuBar menuBarFile = new MenuBar();
    Menu menu = new Menu("文件");
    MenuItem openMenuItem = new MenuItem("打开");
    MenuItem saveMenuItem = new MenuItem("另存为");

    // 声明bufferedImage对象，记录本地存取到内存中的图片
    BufferedImage image;

    // 自定义画布
    private class MyCanvas extends Canvas{

        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);  // 从0，0点开始画图
        }
    }

    MyCanvas drawArea = new MyCanvas();

    public void init() {
        openMenuItem.addActionListener(e -> {
            FileDialog fileDialog = new FileDialog(frame,"打开图片",FileDialog.LOAD);
            fileDialog.setVisible(true);
            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();
            try {
                image = ImageIO.read(new File(directory, file));
                drawArea.repaint();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        });

        saveMenuItem.addActionListener(e -> {
            FileDialog fileDialog = new FileDialog(frame, "图片另存为", FileDialog.SAVE);
            fileDialog.setVisible(true);
            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();

            try {
                ImageIO.write(image, "JPEG", new File(directory, file));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });

        menu.add(openMenuItem);
        menu.add(saveMenuItem);
        menuBarFile.add(menu);

        frame.setMenuBar(menuBarFile);
        frame.add(drawArea);
        setFrame();

    }


    private void setFrame() {

        frame.setBounds(200, 200, 740, 508);
//        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        new ReadAndSaveImage().init();
    }


}
