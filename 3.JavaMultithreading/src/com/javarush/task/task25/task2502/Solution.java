package com.javarush.task.task25.task2502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new LinkedList<>();
           for (String s: loadWheelNamesFromDB())
           if (s.equals(Wheel.FRONT_LEFT.toString()) || s.equals(Wheel.FRONT_RIGHT.toString()) || s.equals(Wheel.BACK_LEFT.toString()) || s.equals(Wheel. BACK_RIGHT.toString()))
            wheels.add(Wheel.valueOf(s));
            else throw new IllegalArgumentException();
            if (wheels.size() == 0 || wheels.size() < 4 || wheels.size() > 4)
                throw new IllegalArgumentException();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
