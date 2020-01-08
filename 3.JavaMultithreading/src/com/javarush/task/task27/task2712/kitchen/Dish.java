package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by XPMUser on 1/21/19.
 */
public enum Dish {

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int  duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
        return Dish.Fish.name()+", "+Dish.Steak.name()+", "+Dish.Soup.name()+", "+Dish.Juice.name()+", "+Dish.Water.name();
    }
    }
