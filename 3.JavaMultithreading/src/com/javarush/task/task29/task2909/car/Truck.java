package com.javarush.task.task29.task2909.car;

/**
 * Created by XPMUser on 10/9/18.
 */
public class Truck extends Car {
    private int numberOfPassengers;
    public Truck (int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public Truck(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
