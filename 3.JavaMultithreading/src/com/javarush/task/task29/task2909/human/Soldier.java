package com.javarush.task.task29.task2909.human;

/**
 * Created by XPMUser on 10/4/18.
 */
public class Soldier extends Human{
    protected boolean isSoldier;

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }
    public void fight() {
    }
}
