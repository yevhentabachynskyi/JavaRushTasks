package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        String str;
       ConsoleHelper.writeMessage("Enter dish...(" + Dish.allDishesToString() + ")");
        while (true) {
            str =  ConsoleHelper.readString();
            if ("exit".equals(str)) {
                break;
            }

            try {
                dishes.add(Dish.valueOf(str));
            }
            catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(str + " is not detected");
            }
        }
        return dishes;
    }
}