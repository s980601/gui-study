package com.jerry.lesson02;

import javax.swing.*;
import java.awt.*;

public class TestPanel {
    public static void main(String[] args) {
        new PanelFrame().init();
    }
}
class PanelFrame extends JFrame
{
    public void init()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(10,10,500,500);
        setVisible(true);
        Container container=getContentPane();
        container.setLayout(new GridLayout(2,2,10,10));

        JPanel panel1=new JPanel(new GridLayout(2,1));
        panel1.add(new Button("1"));
        panel1.add(new Button("1"));

        JPanel panel2=new JPanel(new GridLayout(3,2));
        panel2.add(new Button("1"));
        panel2.add(new Button("1"));
        panel2.add(new Button("1"));
        panel2.add(new Button("1"));
        panel2.add(new Button("1"));
        panel2.add(new Button("1"));

        JPanel panel3=new JPanel(new GridLayout(2,2));
        panel3.add(new Button("1"));
        panel3.add(new Button("1"));
        panel3.add(new Button("1"));
        panel3.add(new Button("1"));

        JPanel panel4=new JPanel(new GridLayout(4,1));
        panel4.add(new Button("1"));
        panel4.add(new Button("1"));
        panel4.add(new Button("1"));
        panel4.add(new Button("1"));



        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);
    }
}
