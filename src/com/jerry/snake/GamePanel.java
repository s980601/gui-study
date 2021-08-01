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
    private Food food;
    private boolean isStart; //开始停止
    private boolean isFail;  //失败
    private int score; //分数
    private Timer timer;

    public GamePanel() {
        snake=new Snake();
        food=new Food();
        isStart=false;
        isFail=false;
        setFocusable(true);
        addKeyListener(this);
        timer=new Timer(Data.DEFAULT_SPEED,this);
        timer.start();
    }

    public void reStart()
    {
        isStart=true;
        score=0;
        snake.reset();
        food.makeNewFood();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //清屏
        //绘制静态面板
        setBackground(Color.WHITE);
        //标题栏
        Data.header.paintIcon(this,g,25,11);
        //显示长度、分数
        drawScore(g);
        //游戏区绘制
        g.setColor(Color.BLACK);
        g.fillRect(Data.DEFAULT_LEFT,Data.DEFAULT_TOP,Data.DEFAULT_WIDTH,Data.DEFAULT_HEIGHT);
//        Data.body.paintIcon(this,g,225,50);
        snake.paint(this,g);
        food.paint(this,g);

        if(!isStart)
        {
            drawStartTip(g);
        }
        if(isFail)
        {
            drawFailTip(g);
        }
    }

    private void drawScore(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("长度:"+snake.getLength(),750,30);
        g.drawString("分数:"+score,750,55);
    }

    private void drawStartTip(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,40));
        g.drawString("按下空格开始游戏",300,300);
    }

    private void drawFailTip(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑",Font.BOLD,40));
        g.drawString("失败，按下空格重新开始",300,300);
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
            if(isFail)
            {
                //重新开始
                isFail=false;
                reStart();
            }
            else
            {
                isStart=!isStart;
            }

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
        if(isStart&& isFail==false)
        {
            if(!snake.move())
            {
                //移动失败
                isFail=true;
            }
            else
            {
                if(snake.isFindFood(food))
                {
                    snake.growUp();
                    food.makeNewFood();
                    score++;
                }
            }

            //
            repaint();
        }
    }
}
