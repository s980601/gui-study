package com.jerry.snake;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏面板
 */
public class GamePanel extends JPanel {
    private Snake snake;
    private boolean isStart;

    public GamePanel() {
        snake=new Snake();
        isStart=false;
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
}
