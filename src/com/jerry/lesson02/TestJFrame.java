package com.jerry.lesson02;

import com.jerry.snake.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class TestJFrame {
    public static void main(String[] args) {
        new MyJFrame().init();
    }
}

class MyJFrame extends JFrame
{
    public void init()
    {
        setBounds(100,100,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
//        container.setBackground(Color.YELLOW);
//        JTextField textField=new JTextField();
//        textField.setText("我的第一个swing程序");
//        container.setLayout(null);
//        this.add(textField);
        JLabel label=new JLabel("我的第一个swing程序");
//        System.out.println("path:"+TestJFrame.class.getResource("").getPath());
//        URL url=TestJFrame.class.getResource("lifabin.jpg");
//        ImageIcon imageIcon=new ImageIcon(url);

//        label.setIcon(imageIcon);
        label.setIcon(Data.up);

//        label.setHorizontalAlignment(SwingConstants.CENTER);

//        label.setBounds(100,100,200,40);

        JButton button=new JButton("点击我");
//        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBounds(150,50,100,40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog();
            }
        });

//        container.setLayout(null);
        container.add(label,BorderLayout.CENTER);
        container.add(button,BorderLayout.SOUTH);

        //测试JTextArea加滚动
//        JTextArea jTextArea=new JTextArea(20,100);
//        jTextArea.setText("中国队男子双人十米跳水惜败于英国");
//        JScrollPane panel=new JScrollPane(jTextArea);
//        container.add(panel);

        setVisible(true);
    }
}

class MyDialog extends JDialog
{
    public MyDialog() {
//        super();
        setVisible(true);
        setBounds(10,10,150,150);
    }

}
