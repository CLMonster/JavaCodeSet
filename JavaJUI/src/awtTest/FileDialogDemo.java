package awtTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogDemo {

    public static void main(String[] args) {

        Frame frame = new Frame();

        // 创建两个FileDialog
        FileDialog openDia = new FileDialog(frame, "选择要打开的文件", FileDialog.LOAD);
        FileDialog saveDia = new FileDialog(frame, "选择要保存的路径", FileDialog.SAVE);

        // 创建两个Button
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        // Button点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDia.setVisible(true);  // 代码会阻塞在这里
                // 获取文件路径
                String directory = openDia.getDirectory();
                String file = openDia.getFile();
                System.out.println("打开的路径为：" + directory);
                System.out.println("打开的文件名：" + file);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDia.setVisible(true);  // 代码会阻塞在这里
                // 获取文件路径
                String directory = openDia.getDirectory();
                String file = openDia.getFile();
                System.out.println("保存的路径为：" + directory);
                System.out.println("保存的文件名：" + file);
            }
        });



        // 将Button添加到frame中
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2, BorderLayout.CENTER);

        // 设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);

    }
}
