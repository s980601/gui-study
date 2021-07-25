package com.jerry.lesson01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exam1 {
    public static void main(String[] args) {
        Frame frame=new Frame("我的布局练习");
        frame.setLayout(new GridLayout(2,1));

        Button button1=new Button("button1");
        MyActonListener myActonListener=new MyActonListener();
        button1.addActionListener(myActonListener);
        
        Button button2=new Button("button2");
        Button button3=new Button("button3");
        Button button4=new Button("button4");
        Button button5=new Button("button5");
        Button button6=new Button("button6");
        Button button7=new Button("button7");
        Button button8=new Button("button8");
        Button button9=new Button("button9");
        Button button10=new Button("buttona");

        Panel panel1=new Panel(new BorderLayout());
        Panel panel2=new Panel(new BorderLayout());
        Panel panel3=new Panel(new GridLayout(2,1));
        Panel panel4=new Panel(new GridLayout(2,2));

        panel3.add(button2);
        panel3.add(button3);

        panel4.add(button6);
        panel4.add(button7);
        panel4.add(button8);
        panel4.add(button9);



        panel1.add(button4,BorderLayout.EAST);
        panel1.add(button1,BorderLayout.WEST);
        panel1.add(panel3,BorderLayout.CENTER);



        panel2.add(button10,BorderLayout.EAST);
        panel2.add(button5,BorderLayout.WEST);
        panel2.add(panel4,BorderLayout.CENTER);

        frame.add(panel1);
        frame.add(panel2);

        frame.setBounds(100,100,400,300);
        frame.setVisible(true);
    }
}

class MyActonListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}