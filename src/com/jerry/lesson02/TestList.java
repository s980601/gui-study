package com.jerry.lesson02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TestList {
    public static void main(String[] args) {
        new ListFrame().init();
    }
}

class ListFrame extends JFrame
{
//    private  Vector<String> contents;
    private DefaultListModel model;
    public void init() {

        setBounds(100,100,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        contents=new Vector();
        model = new DefaultListModel();
        JList list=new JList(model);
//        list.setSize(100,200);
//        list.setBackground(Color.RED);
        model.addElement("游泳比赛");
        model.addElement("排球比赛");
        model.addElement("乒乓比赛");
        model.addElement("游泳比赛");
        model.addElement("排球比赛");
        model.addElement("乒乓比赛");
        model.addElement("游泳比赛");
        model.addElement("排球比赛");
        model.addElement("乒乓比赛");

        JButton button=new JButton("添加List内容");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button=(JButton)e.getSource();
                ListFrame frame=(ListFrame) button.getRootPane().getParent();

                model.addElement("乒乓比赛");

//                frame.repaint();
            }
        });


        JScrollPane pane=new JScrollPane(list);

        Container container=getContentPane();
//        container.setLayout(null);
        container.add(pane,BorderLayout.CENTER);
        container.add(button,BorderLayout.SOUTH);
        setVisible(true);  //这句话要放在最后执行，不然会造成控件初次不显示问题

    }
}
