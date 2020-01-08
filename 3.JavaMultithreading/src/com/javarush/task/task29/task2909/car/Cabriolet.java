package com.javarush.task.task29.task2909.car;

/**
 * Created by XPMUser on 10/9/18.
 */
public class Cabriolet extends Car {
    private int numberOfPassengers;
    public Cabriolet(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public Cabriolet(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }

}
