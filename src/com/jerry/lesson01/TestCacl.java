package com.jerry.lesson01;

import java.awt.*;
import java.awt.event.*;

/**
 * 计算器例子
 */
public class TestCacl {
    public static void main(String[] args) {
        new Calculator().getFrame();
    }
}

class Calculator extends Frame
{
    TextField num1,num2,result;

    public void getFrame()
    {
        num1=new TextField(10);
        num2=new TextField(10);
        result=new TextField(20);
        Label label=new Label("+");
        Button button=new Button("=");
        button.addActionListener(new MyActionListener());
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(result);
        pack(); //包裹内部控件
        setTitle("风起云涌的计算器");
        setResizable(false);
        setVisible(true);
        addWindowListener(new MyWindowAdapter());
    }

    private class MyWindowAdapter extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class MyActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int value1=Integer.parseInt(num1.getText());
            int value2=Integer.parseInt(num2.getText());
            result.setText(Integer.toString(value1+value2));
            num1.setText("");
            num2.setText("");
        }
    }
}
