package com.jerry.snake;

import java.awt.*;
import java.util.Random;

public class Snake {
    public static final int DEFAULT_LEN=3; //默认长度3
    public static final int HEAD_UP=0;
    public static final int HEAD_DOWN=1;
    public static final int HEAD_LEFT=2;
    public static final int HEAD_RIGHT=3;


    private int length;//蛇的长度
    private Point []postion;//蛇的位置
    private int direction; //头的朝向


    public Snake(int length) {
        this.length = length;
        direction=HEAD_RIGHT;
        postion=new Point[Data.DEFAULT_WIDTH/25*Data.DEFAULT_HEIGHT/25];
//        int x=getRandomNumberInRange(0,Data.DEFAULT_WIDTH/Data.DEFAULT_BODY_SIZE-1);
//        int y=getRandomNumberInRange(0,Data.DEFAULT_HEIGHT/Data.DEFAULT_BODY_SIZE-1);
//        postion[0].setLocation(x*Data.DEFAULT_BODY_SIZE,y*Data.DEFAULT_BODY_SIZE);
        int x=Data.DEFAULT_LEFT+ 250;
        int y=Data.DEFAULT_TOP+ 25;
        for (int i=0;i<length;i++)
        {
            postion[i]=new Point(x,y);
            x-=25;
        }
    }

    public void paint(Component c, Graphics g)
    {
        switch (direction)
        {
            case HEAD_UP:
                Data.up.paintIcon(c,g,postion[0].x,postion[0].y);
                break;
            case HEAD_DOWN:
                Data.down.paintIcon(c,g,postion[0].x,postion[0].y);
                break;
            case HEAD_LEFT:
                Data.left.paintIcon(c,g,postion[0].x,postion[0].y);
                break;
            case HEAD_RIGHT:
                Data.right.paintIcon(c,g,postion[0].x,postion[0].y);
                break;
        }
        for (int i=1;i<length;i++)
        {
            System.out.println("snake paint");
            Data.body.paintIcon(c,g,postion[i].x,postion[i].y);
        }
    }

    public Snake() {
        this(DEFAULT_LEN);
    }

    //两边包含
    private  int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
