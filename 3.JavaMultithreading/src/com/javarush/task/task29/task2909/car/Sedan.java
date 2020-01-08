package com.javarush.task.task29.task2909.car;

/**
 * Created by XPMUser on 10/9/18.
 */
public class Sedan extends Car {
    private final int MAX_SEDAN_SPEED = 0;
    private int numberOfPassengers;
    public Sedan(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public Sedan(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
       final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }

}
