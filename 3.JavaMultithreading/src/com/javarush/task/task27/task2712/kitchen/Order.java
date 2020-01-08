package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPMUser on 1/21/19.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
    public int getTotalCookingTime(){
        int result = 0;
        for (int i = 0; i < dishes.size(); i++) {
            result += dishes.get(i).getDuration();
        }
        return result;
    }
    public boolean isEmpty(){
        if (dishes.isEmpty())
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        if (dishes.size() == 0)
            return "";
        else
            return String.format("Your order: %s of %s", dishes, tablet);
        }
    }

