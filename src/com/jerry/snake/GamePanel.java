package com.jerry.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 游戏面板
 */
public class GamePanel extends JPanel implements KeyListener , ActionListener {
    private Snake snake;
    private boolean isStart;
    private Timer timer;

    public GamePanel() {
        snake=new Snake();
        isStart=false;
        setFocusable(true);
        addKeyListener(this);
        timer=new Timer(100,this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //清屏
        //绘制静态面板
        setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);
        g.fillRect(Data.DEFAULT_LEFT,Data.DEFAULT_TOP,Data.DEFAULT_WIDTH,Data.DEFAULT_HEIGHT);
//        Data.body.paintIcon(this,g,225,50);
        snake.paint(this,g);

        if(!isStart)
        {
            drawStartTip(g);
        }
    }

    private void drawStartTip(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,40));
        g.drawString("按下空格开始游戏",300,300);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 按键时间
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE)
        {
            isStart=!isStart;
            repaint();
        }
        else if(keyCode==KeyEvent.VK_UP)
        {
            if(isStart)
            {
                snake.setDirection(Snake.HEAD_UP);
                repaint();
            }
        }
        else if(keyCode==KeyEvent.VK_DOWN)
        {
            if(isStart)
            {
                snake.setDirection(Snake.HEAD_DOWN);
                repaint();
            }
        }
        else if(keyCode==KeyEvent.VK_LEFT)
        {
            if(isStart)
            {
                snake.setDirection(Snake.HEAD_LEFT);
                repaint();
            }
        }
        else if(keyCode==KeyEvent.VK_RIGHT)
        {
            if(isStart)
            {
                snake.setDirection(Snake.HEAD_RIGHT);
                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * 定时器事件
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart)
        {
            snake.move();
            repaint();
        }
    }
}
