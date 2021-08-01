package com.jerry.snake;


import java.awt.*;
import java.util.Random;

public class Food {
    private Point point;
    private Random random ;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Food() {
        random = new Random();
        point=getRandomPosition();

    }

    private Point getRandomPosition(){
        int x=getRandomNumberInRange(Data.DEFAULT_LEFT/Data.DEFAULT_BODY_SIZE,Data.DEFAULT_WIDTH/Data.DEFAULT_BODY_SIZE-1)*Data.DEFAULT_BODY_SIZE;
        int y=getRandomNumberInRange(Data.DEFAULT_TOP/Data.DEFAULT_BODY_SIZE,Data.DEFAULT_HEIGHT/Data.DEFAULT_BODY_SIZE-1)*Data.DEFAULT_BODY_SIZE;
        return new Point(x,y);
    }

    public void makeNewFood()
    {
        point=getRandomPosition();
    }


    public void paint(Component c, Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillOval(point.x,point.y,Data.DEFAULT_BODY_SIZE,Data.DEFAULT_BODY_SIZE);
    }

    //两边包含
    private  int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }


        return random.nextInt((max - min) + 1) + min;
    }
}
