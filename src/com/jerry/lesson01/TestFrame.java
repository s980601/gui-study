package com.jerry.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 第一个gui界面
 */
public class TestFrame {
    public static void main(String[] args) {

        //frame,jdk,看源码
        Frame frame=new Frame("我的第一个java图形界面窗口");

        //panel
        Panel panel=new Panel();
        panel.setBounds(100,100,100,100);
        panel.setBackground(new Color(144, 45, 45));
        frame.setLayout(null);
        frame.add(panel);

        //设置可见
        frame.setVisible(true);

        //设置大小
        frame.setSize(400,400);

        //设置位置
        frame.setLocation(200,200);

        //设置背景色
//        frame.setBackground(Color.GREEN);
        frame.setBackground(new Color(85,150,68));

        //监听关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //关闭应用
                System.exit(0);
            }
        });

    }
}
