package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setHeight(2);
        setWidth(2);

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);

        graphics.drawOval(getX(), getY(), 2, 2);
        graphics.fillOval(getX(), getY(), 2, 2);
    }
}
