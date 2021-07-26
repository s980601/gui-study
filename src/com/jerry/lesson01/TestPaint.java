package com.jerry.lesson01;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestPaint {
    public static void main(String[] args) {
        new PaintFrame().loadFrame();
    }
}

class PaintFrame extends Frame
{
    ArrayList<Point> pointList;
    public void loadFrame()
    {
        pointList=new ArrayList<>();
        setBounds(100,100,400,400);
        addMouseListener(new MyMouseAdapter());
        setVisible(true);
    }

    public void addPoint(Point point)
    {
        pointList.add(point);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//        g.setColor(Color.BLUE);
//        g.fillOval(50,50,100,100);
        g.setColor(Color.RED);
        Iterator iterator=pointList.iterator();
        while (iterator.hasNext())
        {
            Point point=(Point) iterator.next();
            g.fillOval(point.x,point.y,10,10);
        }
    }
    private class MyMouseAdapter extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e) {
//            super.mousePressed(e);
            PaintFrame frame=(PaintFrame) e.getSource();
            frame.addPoint(new Point(e.getX(),e.getY()));
            frame.repaint();

        }
    }
}
