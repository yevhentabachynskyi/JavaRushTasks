package com.javarush.task.task15.task1522;

/**
 * Created by XPMUser on 3/13/18.
 */
public class Moon implements Planet {


    private Moon() {
    }
   private static Moon instance;
    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }

        return instance;
    }
    }



