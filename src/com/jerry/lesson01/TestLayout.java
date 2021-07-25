package com.jerry.lesson01;

import java.awt.*;

public class TestLayout {
    public static void main(String[] args) {
        Frame frame=new Frame("我的布局练习");
        Panel panel1=new Panel(new GridLayout(2,1));


        Panel panel2=new Panel(new GridLayout(2,2));

        frame.setBounds(100,100,600,300);

        Button button1=new Button("button1");
        Button button2=new Button("button2");
        Button button3=new Button("button3");
        Button button4=new Button("button4");
        Button button5=new Button("button5");
        Button button6=new Button("button6");
        Button button7=new Button("button7");
        Button button8=new Button("button8");
        Button button9=new Button("button9");
        Button button10=new Button("button10");
        frame.setLayout(new GridLayout(2,3));

        panel1.add(button2);
        panel1.add(button3);

        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);

        frame.add(button1);
        frame.add(panel1);
        frame.add(button4);
        frame.add(button5);
        frame.add(panel2);
        frame.add(button10);

        frame.setVisible(true);
    }
}
